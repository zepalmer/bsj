package edu.jhu.cs.bsj.compiler.impl.tool.compiler;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramDetectedErrorException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.ExplicitMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.MetaprogramExecutionStack;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScript;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.CompilationUnitLoader;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency.DependencyManager;
import edu.jhu.cs.bsj.compiler.impl.utils.function.MappedFunction;

/**
 * A centralized location for static resources used by the compiler.
 * 
 * @author Zachary Palmer
 */
public final class CompilerUtilities
{
    /** The name of the package to use for generated metaprogram sources. */
    public static final String METAPROGRAM_PACKAGE_NAME = "edu.jhu.cs.bsj.generated.metaprogram";

    private CompilerUtilities()
    {
    }

    /**
     * Patches a given tree with a set of edit scripts.
     * 
     * @param editScripts The edit scripts to use while patching.
     * @param dependencyManager The dependency manager to use in determining the ordering of metaprograms.
     * @param nodeFactory The node factory to use when creating nodes for the patches.
     * @param proxyFactory The proxy factory to use in the patch population strategy.
     * @param idMap A mapping between the UIDs of nodes in this tree and the UIDs used in the patches.
     * @param executionStack The metaprogram execution stack which dictates the behavior of the AST nodes.
     * @param compilationUnitLoader The compilation unit loader to query for UID maps pertaining to loaded compilation
     *            units.
     * @param diagnosticListener The listener to which diagnostics should be reported.
     * @return The patch state produced by this patching operation.
     */
    public static PatchState patchTree(List<EditScript> editScripts, DependencyManager dependencyManager,
            BsjNodeFactory nodeFactory, final BsjNodeProxyFactory proxyFactory, final Map<Long, Node> idMap,
            MetaprogramExecutionStack executionStack, final CompilationUnitLoader compilationUnitLoader,
            DiagnosticListener<BsjSourceLocation> diagnosticListener)
    {
        MetaprogramExecutionStack.Element executionStackElement = new MetaprogramExecutionStack.Element(
                dependencyManager, null, null, null, proxyFactory);
        executionStack.push(executionStackElement);
        PatchState patchState = new PatchState(dependencyManager, nodeFactory, new PatchState.PopulationStrategy()
        {
            private List<Map<Long, Node>> mappings = new ArrayList<Map<Long, Node>>();
            {
                // TODO: this would be eased by having proxy structures such as a map to union other maps
                this.mappings.add(idMap);
                this.mappings.add(compilationUnitLoader.getUidMap());
            }

            @Override
            public Node populate(long uid)
            {
                for (Map<Long, Node> mapping : this.mappings)
                {
                    if (mapping.containsKey(uid))
                    {
                        return proxyFactory.makeNode(mapping.get(uid));
                    }
                }
                throw new IllegalStateException("Could not look up node for UID " + uid);
            }
        }, new MappedFunction<Long, Long>(proxyFactory.getProxyIdMapping()));
        try
        {
            for (EditScript dependentEditScript : editScripts)
            {
                try
                {
                    dependentEditScript.apply(patchState);
                } catch (MetaprogramDetectedErrorException e)
                {
                    BsjSourceLocation location = dependentEditScript.getLocation();
                    diagnosticListener.report(e.getDiagnostic(location));                    
                }
            }
        } finally
        {
            executionStack.pop(executionStackElement);
        }
        return patchState;
    }

    /**
     * Creates a mapping of the tree at the specified node which maps node IDs to the nodes themselves.
     * 
     * @param node The node to map.
     */
    public static Map<Long, Node> buildTreeIdMap(Node node)
    {
        final Map<Long, Node> map = new HashMap<Long, Node>();
        node.receive(new BsjNodeVisitor()
        {
            @Override
            public void visitStart(Node node)
            {
                map.put(node.getUid(), node);
            }

            @Override
            public void visitStop(Node node)
            {
            }
        });
        return map;
    }

    /**
     * Performs postprocessing on extracted metaprogram anchors. This operation strips the metaprogram information out
     * of explicit anchors to prevent metaprograms from reflecting upon themselves.
     * 
     * @param anchors The anchors to process.
     */
    public static void postprocessExtractedAnchors(Collection<MetaprogramAnchorNode<?>> anchors)
    {
        for (MetaprogramAnchorNode<?> anchor : anchors)
        {
            if (anchor instanceof ExplicitMetaprogramAnchorNode<?>)
            {
                ExplicitMetaprogramAnchorNode<?> explicitAnchor = (ExplicitMetaprogramAnchorNode<?>) anchor;
                explicitAnchor.setMetaprogram(null);
            }
        }
    }
}
