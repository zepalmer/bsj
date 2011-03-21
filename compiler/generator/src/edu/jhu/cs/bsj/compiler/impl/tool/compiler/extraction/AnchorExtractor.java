package edu.jhu.cs.bsj.compiler.impl.tool.compiler.extraction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.tools.DiagnosticListener;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.ExplicitMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjTypedNodeNoOpVisitor;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.data.CanonicalNodeInfo;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.data.InjectionInfo;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;
import edu.jhu.cs.bsj.compiler.metaprogram.BsjMetaAnnotationMetaprogram;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;

/**
 * A module used by the {@link MetaprogramExtractor} to identify anchor nodes which need to be processed.
 * 
 * @author Zachary Palmer
 */
public class AnchorExtractor
{
    /** The logger for this class. */
    private static final Logger LOGGER = Logger.getLogger(AnchorExtractor.class);

    /** The root of anchor extraction. */
    private Node root;
    /** The toolkit to provide to anchor handlers. */
    private BsjToolkit toolkit;
    /** The diagnostic listener to provide to anchor handlers. */
    private DiagnosticListener<BsjSourceLocation> diagnosticListener;
    /** The information about metaprogram injection to be used during this process. */
    private InjectionInfo injectionInfo;
    /** The information about node canonicalization to be used during this process. */
    private CanonicalNodeInfo canonicalNodeInfo;
    /** The compilation cache for this handler to use. */
    private ExplicitMetaprogramCompilationCache compilationCache;

    public AnchorExtractor(Node root, BsjToolkit toolkit, DiagnosticListener<BsjSourceLocation> diagnosticListener,
            InjectionInfo injectionInfo, CanonicalNodeInfo canonicalNodeInfo,
            ExplicitMetaprogramCompilationCache compilationCache)
    {
        super();
        this.root = root;
        this.toolkit = toolkit;
        this.diagnosticListener = diagnosticListener;
        this.injectionInfo = injectionInfo;
        this.canonicalNodeInfo = canonicalNodeInfo;
        this.compilationCache = compilationCache;
    }

    /**
     * Discovers anchors in the provided root and produces handling mechanisms for them.
     */
    public Collection<AnchorHandler<?, ?>> produceHandlers()
    {
        Collection<AnchorHandler<?, ?>> ret = new ArrayList<AnchorHandler<?, ?>>();

        MetaprogramAnchorLocator locator = new MetaprogramAnchorLocator();
        this.root.receiveTyped(locator);
        List<MetaprogramAnchorNode<?>> anchors = locator.getMetaprogramAnchors();

        // Handle each anchor in turn
        for (MetaprogramAnchorNode<?> anchor : anchors)
        {
            AnchorHandler<?, ?> handler = handleAnchor(anchor);
            if (handler != null)
                ret.add(handler);
        }

        return ret;
    }

    private <R extends Node> AnchorHandler<?, ?> handleAnchor(MetaprogramAnchorNode<R> targetAnchor)
    {
        // First, canonicalize our anchor. This is necessary to prevent all sorts of accidental rewrapping of proxied
        // nodes.
        final MetaprogramAnchorNode<R> anchor;
        if (this.canonicalNodeInfo == null)
        {
            anchor = targetAnchor;
        } else
        {
            // This is known to be safe due to the nature of the canonical mapping. For it to be semantically valid,
            // it must map UIDs from proxy nodes to canonical nodes of the same type.
            @SuppressWarnings("unchecked")
            MetaprogramAnchorNode<R> canonicalAnchor = (MetaprogramAnchorNode<R>) this.canonicalNodeInfo.getUidLookupMap().get(
                    this.canonicalNodeInfo.getCanonicalMapping().get(targetAnchor.getUid()));
            anchor = canonicalAnchor;
        }

        // Now figure out what to do with that anchor.
        final AnchorHandler<?, ?> handler;
        if (anchor instanceof ExplicitMetaprogramAnchorNode<?>)
        {
            ExplicitMetaprogramAnchorNode<R> explicitAnchor = (ExplicitMetaprogramAnchorNode<R>) anchor;
            if (LOGGER.isTraceEnabled())
            {
                LOGGER.trace("Found explicit metaprogram at " + explicitAnchor.getStartLocation());
            }
            handler = new ExplicitMetaprogramAnchorHandler<R>(
                    this.toolkit, this.diagnosticListener, (ExplicitMetaprogramAnchorNode<R>)targetAnchor, explicitAnchor,
                    this.injectionInfo, this.compilationCache);
        } else if (anchor instanceof MetaAnnotationMetaprogramAnchorNode)
        {
            // TODO: consider: maybe apply this logic to all anchors?
            // This would suggest that we make ExplicitMetaprogramAnchorNode.setMetaprogram inaccessible?
            MetaAnnotationMetaprogramAnchorNode metaAnnotationAnchor = (MetaAnnotationMetaprogramAnchorNode) anchor;
            MetaAnnotationNode metaAnnotation = metaAnnotationAnchor.getNearestAncestorOfType(MetaAnnotationNode.class);
            if (metaAnnotation != null)
            {
                BsjMetaAnnotation annotationObject = metaAnnotation.getMetaAnnotationObject();
                if (annotationObject instanceof BsjMetaAnnotationMetaprogram)
                {
                    // register a task to build a metaprogram profile from this object
                    BsjMetaAnnotationMetaprogram metaprogramObject = (BsjMetaAnnotationMetaprogram) annotationObject;
                    handler = new MetaAnnotationMetaprogramAnchorHandler(
                            this.toolkit, this.diagnosticListener,
                            (MetaAnnotationMetaprogramAnchorNode) targetAnchor, metaAnnotationAnchor, this.injectionInfo,
                            metaprogramObject.getMetaprogram());
                    if (LOGGER.isTraceEnabled())
                    {
                        LOGGER.trace("Found meta-annotation metaprogram for "
                                + metaAnnotation.getAnnotationType().getName().getNameString() + " at "
                                + metaAnnotationAnchor.getStartLocation());
                    }
                } else
                {
                    // this meta-annotation has a non-metaprogram object - the anchor is just a placeholder,
                    // so we do nothing
                    if (LOGGER.isTraceEnabled())
                    {
                        LOGGER.trace("Skipping meta-annotation without metaprogram for "
                                + metaAnnotation.getAnnotationType().getName().getNameString() + " at "
                                + metaAnnotationAnchor.getStartLocation());
                    }
                    handler = null;
                }
            } else
            {
                // how did we even find this guy?
                handler = null;
            }
        } else
        {
            throw new IllegalStateException("Unrecognized metaprogram anchor type: " + anchor.getClass());
        }
        return handler;
    }

    /**
     * Utilitiy class for finding metaprogram anchors within an AST.
     * 
     * @author Zachary Palmer
     */
    static class MetaprogramAnchorLocator extends BsjTypedNodeNoOpVisitor
    {
        private List<MetaprogramAnchorNode<?>> metaprogramAnchors = new ArrayList<MetaprogramAnchorNode<?>>();

        private int metaprogramLevels = 0;

        @Override
        public void visitMetaprogramAnchorNodeStart(MetaprogramAnchorNode<?> node)
        {
            this.metaprogramLevels++;
        }

        @Override
        public void visitMetaprogramAnchorNodeStop(MetaprogramAnchorNode<?> node)
        {
            this.metaprogramLevels--;
            if (this.metaprogramLevels == 0)
            {
                this.metaprogramAnchors.add(node);
            }
        }

        public List<MetaprogramAnchorNode<?>> getMetaprogramAnchors()
        {
            return metaprogramAnchors;
        }
    }
}
