package edu.jhu.cs.bsj.compiler.impl.tool.compiler.extraction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaAnnotationInstantiationFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjTypedNodeNoOpVisitor;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetaprogramProfile;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.data.CanonicalNodeInfo;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.data.InjectionInfo;

/**
 * This class is used as a module which extracts metaprograms from a given root AST node and registers them with the a
 * metacompilation context.
 * 
 * @author Zachary Palmer
 */
public class MetaprogramExtractor
{
    private static final Logger LOGGER = Logger.getLogger(MetaprogramExtractor.class);

    /** The metacompilation context to use. */
    private MetacompilationContext context;
    /** The root AST node to explore. */
    private Node root;
    /** The information about metaprogram injection to be used during this process. */
    private InjectionInfo injectionInfo;
    /** The information about node canonicalization to be used during this process. */
    private CanonicalNodeInfo canonicalNodeInfo;

    public MetaprogramExtractor(MetacompilationContext context, Node root, InjectionInfo injectionInfo,
            CanonicalNodeInfo canonicalNodeInfo)
    {
        super();
        this.context = context;
        this.root = root;
        this.injectionInfo = injectionInfo;
        this.canonicalNodeInfo = canonicalNodeInfo;
    }

    public MetacompilationContext getContext()
    {
        return context;
    }

    public Node getRoot()
    {
        return root;
    }

    public InjectionInfo getInjectionInfo()
    {
        return injectionInfo;
    }

    public CanonicalNodeInfo getCanonicalNodeInfo()
    {
        return canonicalNodeInfo;
    }

    /**
     * Performs the extraction operation.
     * 
     * @return The target metaprogram anchors for which profiles were registered. These are not necessarily the
     *         canonical anchors; they will not be unless the canonical anchor was present in the provided tree.
     * @throws If an I/O error occurs.
     */
    public Collection<MetaprogramAnchorNode<?>> extract() throws IOException
    {
        List<MetaprogramAnchorNode<?>> ret = new ArrayList<MetaprogramAnchorNode<?>>();

        instantiateMetaAnnotationObjects();

        AnchorExtractor anchorExtractor = new AnchorExtractor(this.root, this.context.getToolkit(),
                this.context.getDiagnosticListener(), this.injectionInfo, this.canonicalNodeInfo,
                this.context.getExplicitMetaprogramCompilationCache());
        Collection<AnchorHandler<?, ?>> handlers = anchorExtractor.produceHandlers();
        for (AnchorHandler<?, ?> anchorHandler : handlers)
        {
            MetaprogramProfile<?, ?> profile = anchorHandler.handle();
            if (profile != null)
            {
                if (LOGGER.isTraceEnabled())
                {
                    LOGGER.trace("Metaprogram " + profile.getMetaprogram().getID() + " created with deps "
                            + profile.getDependencies() + " and targets " + profile.getTargetNames());
                }
                this.context.getDependencyManager().registerMetaprogramProfile(profile,
                        this.injectionInfo.getParentProfile(), this.context.getDiagnosticListener());
                ret.add(anchorHandler.getTargetAnchor());
            }
        }

        return ret;
    }

    protected void instantiateMetaAnnotationObjects()
    {
        this.root.receiveTyped(new BsjTypedNodeNoOpVisitor()
        {
            @Override
            public void visitMetaAnnotationNodeStop(MetaAnnotationNode node)
            {
                try
                {
                    node.instantiateMetaAnnotationObject(context.getDiagnosticListener());
                } catch (MetaAnnotationInstantiationFailureException e)
                {
                    // TODO: if this happens, the metacompilation manager needs to know that we failed
                    // Do we need to do anything special or does the error in the diagnostic listener handle that?
                }
            }
        });
    }
}
