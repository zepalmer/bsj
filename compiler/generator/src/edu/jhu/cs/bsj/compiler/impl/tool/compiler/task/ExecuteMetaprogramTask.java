package edu.jhu.cs.bsj.compiler.impl.tool.compiler.task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.tools.Diagnostic.Kind;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramLocalMode;
import edu.jhu.cs.bsj.compiler.ast.MetaprogramPackageMode;
import edu.jhu.cs.bsj.compiler.ast.NodePermission;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramDetectedErrorException;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramExecutionFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.BlockNode;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.CatchNode;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnhancedForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.ForLoopNode;
import edu.jhu.cs.bsj.compiler.ast.node.InitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.LocalVariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.ExplicitMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.util.BsjNodeFactoryDecorator;
import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactoryImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.MetaprogramExecutionStack;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.AbstractCreateEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScript;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.PatchState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.TranslationState;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.pkg.LoadCompilationUnitPackageEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.CountingDiagnosticProxyListener;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaprogramExceptionDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaprogramExecutionFailureDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.BsjUserDiagnosticTranslatingListener;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.ContextImpl;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.Metaprogram;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.PermissionPolicyManager;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.CompilerUtilities;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetacompilationContext;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetaprogramProfile;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.extraction.MetaprogramExtractor;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.data.InjectionInfo;
import edu.jhu.cs.bsj.compiler.impl.utils.BijectiveMap;
import edu.jhu.cs.bsj.compiler.impl.utils.ConcatenatingIterable;
import edu.jhu.cs.bsj.compiler.impl.utils.HashBijectiveMap;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.utils.TwoElementImmutableSet;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.compiler.tool.data.BsjThreadLocalData;

/**
 * This metacompilation task attempts to execute a single metaprogram. If a metaprogram is available for execution, it
 * will be executed and this task will re-enqueue itself. Otherwise, this task will create a serialization task for each
 * compilation unit in the package hierarchy.
 * 
 * @author Zachary Palmer
 */
public class ExecuteMetaprogramTask extends AbstractBsjCompilerTask
{
    public ExecuteMetaprogramTask()
    {
        super(TaskPriority.EXECUTE);
    }

    @Override
    public void execute(MetacompilationContext context) throws IOException
    {
        CountingDiagnosticProxyListener<BsjSourceLocation> listener = new CountingDiagnosticProxyListener<BsjSourceLocation>(
                context.getDiagnosticListener());
        MetaprogramProfile<?, ?> profile = context.getDependencyManager().getNextMetaprogram(listener);
        if (listener.getCount(Kind.ERROR) > 0)
        {
            return;
        }

        if (profile == null)
        {
            finishMetaprogramExecutionPhase(context);
        } else
        {
            execute(profile, context);
        }
    }

    private void finishMetaprogramExecutionPhase(MetacompilationContext context)
    {
        if (LOGGER.isTraceEnabled())
        {
            LOGGER.trace("No metaprograms left to run.  Performing final patch.");
        }
        context.registerTask(new ApplyFinalPatchTask());
    }

    private <A extends MetaprogramAnchorNode<B>, B extends Node> void execute(MetaprogramProfile<A, B> profile,
            final MetacompilationContext context)
    {
        if (LOGGER.isTraceEnabled())
        {
            LOGGER.trace("Executing metaprogram " + profile.getMetaprogram().getID());
        }

        // *** Prepare the AST for this metaprogram by applying the deltas from all of its dependencies
        final BsjNodeProxyFactory proxyFactory = new BsjNodeProxyFactoryImpl(context.getNodeManager());
        List<EditScript> dependentEditScripts = context.getDependencyManager().getMetaprogramEditScriptDependencies(
                profile);
        PatchState patchState = CompilerUtilities.patchTree(dependentEditScripts, context.getDependencyManager(),
                context.getToolkit().getNodeFactory(), proxyFactory, context.getIdMap(),
                context.getNodeManager().getMetaprogramExecutionStack(),
                context.getNodeManager().getCompilationUnitLoader(), context.getDiagnosticListener());

        // *** Any explicit metaprogram anchors introduced by patching should be stripped to prevent other metaprograms
        // from reflecting in them.
        // TODO: we should be able to improve the performance of this bit by attributing to the delta of an injecting
        // metaprogram the removal of the metaprogram nodes from the explicit anchors -- then, we just have to deal with
        // the non-injected metaprograms (whose anchors are stripped by the extraction process, right?)
        for (long uid : patchState.getCreatedUids())
        {
            Node createdNode = patchState.getNodeMap().get(uid);
            if (createdNode instanceof ExplicitMetaprogramAnchorNode<?>)
            {
                ExplicitMetaprogramAnchorNode<?> explicitAnchor = (ExplicitMetaprogramAnchorNode<?>) createdNode;
                explicitAnchor.setMetaprogram(null);
            }
        }

        // *** Create the proxies for this metaprogram execution
        // TODO: should only do this to an anchor when it was not purely injected by another metaprogram
        final A anchor;
        if (patchState.getCreatedUids().contains(profile.getAnchor().getUid()))
        {
            // In this case, the anchor was fabricated for a pure metaprogram injection. We have created a node to
            // represent this anchor in the process of patching the delta; go get it.
            // we know this @SuppressWarnings to be safe because of the nature of delta application
            @SuppressWarnings("unchecked")
            final A anchorTemp = (A) patchState.getNode(profile.getAnchor().getUid());
            anchor = anchorTemp;
        } else
        {
            // In this case, the anchor was loaded either due to another metaprogram or due to initial loading. We can
            // just proxy it and we'll be fine.
            // we know these @SuppressWarnings to be safe because of the nature of the proxy factory.
            @SuppressWarnings("unchecked")
            final A anchorTemp = (A) proxyFactory.makeMetaprogramAnchorNode(profile.getAnchor());
            anchor = anchorTemp;
        }
        PackageNode rootPackage = proxyFactory.makePackageNode(context.getRootPackage());
        ContextNodeFactory contextNodeFactory = new ContextNodeFactory(context.getToolkit().getNodeFactory());
        Context<A, B> metaprogramContext = new ContextImpl<A, B>(anchor, null, contextNodeFactory,
                new BsjUserDiagnosticTranslatingListener(context.getDiagnosticListener()),
                context.getToolkit().getCompilationUnitLoadingInfoFactory().makeLoadingInfo(
                        context.getDiagnosticListener()), context.getToolkit().getTypecheckerFactory());

        // *** Log metaprogram execution
        if (LOGGER.isTraceEnabled())
        {
            CompilationUnitNode compilationUnitNode = proxyFactory.makeCompilationUnitNode(anchor.getNearestAncestorOfType(
                    CompilationUnitNode.class));
            if (compilationUnitNode == null)
            {
                LOGGER.trace("Metaprogram anchor is detached!");
            } else
            {
                LOGGER.trace("Metaprogram's source unit currently looks like this:\n"
                        + compilationUnitNode.executeOperation(context.getToolkit().getSerializer(), null));
            }
        }

        // *** Set up the permission policy manager and dependency manager for this metaprogram
        PermissionPolicyManager policyManager = createPermissionPolicyManager(profile.getMetaprogram().getID(),
                profile.getLocation(), anchor, profile.getLocalMode(), profile.getPackageMode(), rootPackage);
        List<EditScriptElement> editScriptElements = new ArrayList<EditScriptElement>();
        MetaprogramExecutionStack.Element executionStackElement = new MetaprogramExecutionStack.Element(
                context.getDependencyManager(), policyManager, profile, editScriptElements, proxyFactory);
        context.getNodeManager().getMetaprogramExecutionStack().push(executionStackElement);
        BsjThreadLocalData.getInstance().push(BsjThreadLocalData.Element.CONTEXT, metaprogramContext);
        BsjThreadLocalData.getInstance().push(BsjThreadLocalData.Element.NODE_FACTORY, metaprogramContext.getFactory());

        // *** Now that we are recording, set up the default replacement node.
        // We can suppress the warning here due to the behavior of the proxy factory.
        @SuppressWarnings("unchecked")
        B defaultReplacement = (B) proxyFactory.makeNode(anchor.getDefaultReplacement(metaprogramContext.getFactory()));
        metaprogramContext.setReplacement(defaultReplacement);

        // *** Run the metaprogram
        BsjDiagnostic diagnostic = doExecute(metaprogramContext, profile.getMetaprogram(), profile.getLocation());

        // *** Have the metaprogram replace itself with its replacement node
        // TODO: what kind of policy should we put into place for this? can a read-only metaprogram replace itself?
        B replacement = metaprogramContext.getReplacement();
        if (replacement != null)
        {
            MetaprogramExecutionStack.Element replacementElement = new MetaprogramExecutionStack.Element(
                    context.getDependencyManager(), null, profile, editScriptElements, proxyFactory);
            context.getNodeManager().getMetaprogramExecutionStack().push(replacementElement);
            anchor.getParent().replace(anchor, replacement);
            context.getNodeManager().getMetaprogramExecutionStack().pop(replacementElement);
        }

        // *** Release the managers
        context.getNodeManager().getMetaprogramExecutionStack().pop(executionStackElement);
        BsjThreadLocalData.getInstance().pop(BsjThreadLocalData.Element.CONTEXT);
        BsjThreadLocalData.getInstance().pop(BsjThreadLocalData.Element.NODE_FACTORY);

        // *** Get the edit script
        EditScript originalEditScript = new EditScriptImpl(profile.getLocation(), editScriptElements);

        // *** Translate the edit script to canonical space
        // TODO: create some lazy data structures (union map, lambda translation map, etc.) to improve performance
        // Start with the proxies that we created.
        BijectiveMap<Long, Long> translationMapping = new HashBijectiveMap<Long, Long>(proxyFactory.getProxyIdMapping());
        // Include the nodes we created to represent nodes created by another metaprogram
        for (EditScript dependentEditScript : dependentEditScripts)
        {
            for (EditScriptElement dependentElement : dependentEditScript.getElements())
            {
                if (dependentElement instanceof AbstractCreateEditScriptElementImpl)
                {
                    long ourNodeId = patchState.getNodeMap().get(dependentElement.getTargetId()).getUid();
                    long originalNodeId = dependentElement.getTargetId();
                    // We should never proxy something that we applied as part of a delta. If that happens, bail out.
                    if (translationMapping.containsValue(originalNodeId))
                    {
                        throw new IllegalStateException("Node " + originalNodeId + " was both proxied as "
                                + translationMapping.invert().get(originalNodeId) + " and created as " + ourNodeId
                                + " due to edit script element " + dependentElement);
                    }
                    translationMapping.put(ourNodeId, originalNodeId);
                }
            }
        }
        TranslationState translationState = new TranslationState(translationMapping);
        EditScript translatedEditScript = originalEditScript.translate(translationState);

        // *** Find metaprograms which were injected by this metaprogram by analyzing the delta for anchors.
        for (Node root : contextNodeFactory.getRelevantInjectedNodes())
        {
            // If the node is detached, we can safely ignore it.
            if (root.getRootPackage() != null)
            {
                if (LOGGER.isTraceEnabled())
                {
                    if (root instanceof MetaAnnotationNode)
                    {
                        LOGGER.trace("Found a meta-annotation " + root.toSourceCode() + " injected by metaprogram "
                                + profile.getMetaprogram().getID());
                    } else
                    {
                        LOGGER.trace("Found a metaprogram injected by metaprogram " + profile.getMetaprogram().getID());
                    }
                }
                MetaprogramExtractor extractor = new MetaprogramExtractor(context, root, new InjectionInfo(profile,
                        true), null);
                try
                {
                    extractor.extract();
                } catch (IOException e)
                {
                    throw new NotImplementedYetException(e);
                }
            }
        }

        // *** Log the edit script
        if (LOGGER.isTraceEnabled())
        {
            logEditScript(profile, translatedEditScript);
        }

        // *** Respond to error as necessary
        if (diagnostic != null)
        {
            context.getDiagnosticListener().report(diagnostic);
        }

        // *** Notify the dependency manager that execution has finished
        context.getDependencyManager().notifyExecuted(profile, translatedEditScript);
        if (LOGGER.isTraceEnabled())
        {
            LOGGER.trace("Metaprogram " + profile.getMetaprogram().getID() + " execution complete.");
            CompilationUnitNode compilationUnitNode = (replacement == null ? anchor : replacement).getNearestAncestorOfType(CompilationUnitNode.class);
            if (compilationUnitNode == null)
            {
                LOGGER.trace("Metaprogram is detached!");
            } else
            {
                LOGGER.trace("Metaprogram's source unit currently looks like this:\n"
                        + compilationUnitNode.executeOperation(context.getToolkit().getSerializer(), null));
            }
        }

        // *** Re-enqueue this task so we can execute the next metaprogram when the time comes
        context.registerTask(this);
    }

    private <A extends MetaprogramAnchorNode<B>, B extends Node> void logEditScript(MetaprogramProfile<A, B> profile,
            EditScript editScript)
    {
        LOGGER.trace("Metaprogram " + profile.getMetaprogram().getID() + " captured edit script is:");
        Iterator<EditScriptElement> iterator = editScript.getElements().iterator();
        List<EditScriptElement> loads = new ArrayList<EditScriptElement>();
        while (iterator.hasNext())
        {
            EditScriptElement element = iterator.next();
            loads.clear();
            while (element instanceof LoadCompilationUnitPackageEditScriptElementImpl && iterator.hasNext())
            {
                loads.add(element);
                element = iterator.next();
            }
            if (loads.size() > 5)
            {
                LOGGER.trace("  (" + loads.size() + " compilation unit loads skipped)");
            } else if (loads.size() > 0)
            {
                for (EditScriptElement e : loads)
                {
                    LOGGER.trace("  " + e.toString());
                }
            }
            LOGGER.trace("  " + element.toString());
        }
    }

    /**
     * Creates an appropriate permission policy manager for a metaprogram.
     * 
     * @param metaprogramId The ID of the metaprogram for which this policy is being created.
     * @param metaprogramStartLocation The start location of the metaprogram for which this policy is being created.
     * @param anchor The anchor of the metaprogram for which this policy is being created.
     * @param localMode The local mode of the target metaprogram.
     * @param packageMode The package mode of the target metaprogram.
     * @param rootPackage The root package for the policy manager.
     * @return The policy manager for that metaprogram.
     */
    private PermissionPolicyManager createPermissionPolicyManager(int metaprogramId,
            BsjSourceLocation metaprogramStartLocation, MetaprogramAnchorNode<?> anchor,
            MetaprogramLocalMode localMode, MetaprogramPackageMode packageMode, PackageNode rootPackage)
    {
        if (LOGGER.isTraceEnabled())
        {
            LOGGER.trace("Establishing permissions for metaprogram " + metaprogramId);
        }

        PermissionPolicyManager policyManager = new PermissionPolicyManager(rootPackage,
                "Metaprogram execution policy for " + metaprogramId + "@" + anchor.getStartLocation());

        // If we're detached from the root package, the user can do anything
        if (anchor.getRootPackage() == null)
        {
            policyManager.addThreshold(anchor.getFurthestAncestor(), NodePermission.MUTATE);
            return policyManager;
        }

        // Build local profile rules as per the BSJ language spec
        boolean found = false;
        if (localMode == MetaprogramLocalMode.INSERT || localMode == MetaprogramLocalMode.MUTATE)
        {
            // Figure out which permission corresponds to our mode
            NodePermission permission;
            if (localMode == MetaprogramLocalMode.INSERT)
            {
                permission = NodePermission.INSERT;
            } else if (localMode == MetaprogramLocalMode.MUTATE)
            {
                permission = NodePermission.MUTATE;
            } else
            {
                throw new IllegalStateException("Inconsistent code structure - unknown local mode " + localMode);
            }

            Node node = anchor;
            Node targetNode = null; // this is the node to which permission will be granted
            if (node instanceof MetaAnnotationMetaprogramAnchorNode)
            {
                // * If the metaprogram’s anchor is a meta-annotation (§5), then
                MetaAnnotationMetaprogramAnchorNode anchorNode = (MetaAnnotationMetaprogramAnchorNode) node;

                // Find the node above the meta-annotation list and (possibly) the modifiers node
                node = anchorNode.getParent();
                while (node instanceof MetaAnnotationNode || node instanceof MetaAnnotationListNode
                        || node instanceof ModifiersNode)
                {
                    node = node.getParent();
                }
                // The field "node" should now contain the node that the meta-annotation annotates

                if (node instanceof PackageDeclarationNode)
                {
                    // + If the meta-annotation annotates a package declaration, then the metaprogram is given
                    // permission to that package declaration.
                    targetNode = node;
                } else if (node instanceof TypeDeclarationNode)
                {
                    // + If the meta-annotation annotates a type declaration, then the metaprogram is given permission
                    // to that type declaration.
                    targetNode = node;
                } else if (node instanceof FieldDeclarationNode || node instanceof MethodDeclarationNode
                        || node instanceof ConstructorDeclarationNode || node instanceof InitializerDeclarationNode)
                {
                    // + If the meta-annotation annotates a field, method, constructor declaration, static initializer
                    // or instance initializer, then the metaprogram is given Insert permission to the type declaration
                    // which encloses that node.
                    targetNode = node.getNearestAncestorOfType(TypeDeclarationNode.class);
                } else if (node instanceof LocalVariableDeclarationNode || node instanceof StatementNode)
                {
                    // + If the meta-annotation annotates a local variable declaration or statement, then
                    BlockStatementListNode enclosingBlockStatementList = node.getNearestAncestorOfType(BlockStatementListNode.class);
                    if (enclosingBlockStatementList != null
                            && (enclosingBlockStatementList.getParent() instanceof MethodDeclarationNode || enclosingBlockStatementList.getParent() instanceof ConstructorDeclarationNode))
                    {
                        // . If the local variable declaration or statement is contained within a block of statements
                        // which serves as the body for a method or constructor declaration, then the metaprogram is
                        // given permission to that declaration.
                        targetNode = enclosingBlockStatementList.getParent();
                    } else if (node.getParent() instanceof BlockNode
                            && node.getParent().getParent() instanceof ForInitializerNode
                            && node.getParent().getParent().getParent() instanceof ForLoopNode)
                    {
                        // . If the local variable declaration or statement is contained within the header for a
                        // standard for-loop, then the metaprogram is given permission to the for-loop.
                        targetNode = node.getParent().getParent().getParent();
                    } else
                    {
                        // . Otherwise, the metaprogram is given permission to the block of statements which encloses
                        // the local variable declaration or statement.
                        targetNode = enclosingBlockStatementList.getParent();
                    }
                } else if (node instanceof VariableNode)
                {
                    // + If the meta-annotation annotates a parameter, then
                    VariableNode variableNode = (VariableNode) node;
                    if (variableNode.getParent() instanceof CatchNode)
                    {
                        // . If the parameter is a parameter to a catch block, then the metaprogram is granted
                        // permission to the list of catch blocks.
                        targetNode = variableNode.getParent().getParent();
                    } else if (variableNode.getParent() instanceof EnhancedForLoopNode)
                    {
                        // . If the parameter is a parameter to an enhanced for loop, then the metaprogram is granted
                        // permission to the enhanced for loop.
                        targetNode = variableNode.getParent();
                    } else if (variableNode.getParent() instanceof VariableListNode
                            && (variableNode.getParent().getParent() instanceof MethodDeclarationNode || variableNode.getParent().getParent() instanceof ConstructorDeclarationNode))
                    {
                        // . If the parameter is a parameter in the formal parameter list of a method or constructor
                        // declaration, then the metaprogram is granted permission to that method or constructor
                        // declaration.
                        targetNode = variableNode.getParent().getParent();
                    }
                } else if (node instanceof MetaAnnotationMetaAnnotationValueNode)
                {
                    // + If the metaprogram’s anchor is a meta-annotation which exists as an element value in another
                    // meta-annotation, it is given permission to the parent meta-annotation.
                    targetNode = node.getNearestAncestorOfType(MetaAnnotationNode.class);
                }
            } else
            {
                while (node != null)
                {
                    // * If the metaprogram’s anchor is in the top level of a compilation unit, it is given permission
                    // to that compilation unit.
                    // * If the metaprogram’s anchor is a member of a type declaration, it is given permission to the
                    // type declaration.
                    if (node.getParent() instanceof CompilationUnitNode
                            || node.getParent() instanceof TypeDeclarationNode)
                    {
                        targetNode = node.getParent();
                        break;
                    }
                    // * If the metaprogram’s anchor is a member of a block of statements, then
                    if (node instanceof BlockStatementNode && (node.getParent() instanceof BlockStatementListNode))
                    {
                        BlockStatementListNode listNode = (BlockStatementListNode) (node.getParent());
                        if (listNode.getParent() instanceof BlockNode)
                        {
                            BlockNode block = (BlockNode) (listNode.getParent());
                            // + If the block serves as the body for a method or constructor declaration, then the
                            // metaprogram is given permission to that declaration.
                            if (block.getParent() instanceof MethodDeclarationNode
                                    || block.getParent() instanceof ConstructorDeclarationNode)
                            {
                                targetNode = block.getParent();
                            } else
                            {
                                // + Otherwise, the metaprogram is given Insert permission to the block of statements.
                                targetNode = block;
                            }
                            break;
                        }
                    }
                    node = node.getParent();
                }
            }
            if (targetNode != null)
            {
                if (LOGGER.isTraceEnabled())
                {
                    LOGGER.trace("Granting " + permission + " permission to metaprogram " + metaprogramId + " for "
                            + targetNode.getClass().getSimpleName() + " node at " + targetNode.getStartLocation());
                }
                policyManager.addThreshold(targetNode, permission);
                found = true;
            }
        } else if (localMode == MetaprogramLocalMode.FULL_MUTATE)
        {
            // Find the nearest compilation unit and give it mutate access
            CompilationUnitNode compilationUnitNode = anchor.getNearestAncestorOfType(CompilationUnitNode.class);
            if (compilationUnitNode != null)
            {
                if (LOGGER.isTraceEnabled())
                {
                    LOGGER.trace("Granting " + NodePermission.MUTATE + " permission to metaprogram " + metaprogramId
                            + " for " + compilationUnitNode.getClass().getSimpleName() + " node at "
                            + compilationUnitNode.getStartLocation());
                }
                policyManager.addThreshold(compilationUnitNode, NodePermission.MUTATE);
                found = true;
            }
        }

        if (!found)
        {
            // Then we never found a suitable parent.
            throw new IllegalStateException("Provided anchor at " + anchor.getStartLocation()
                    + " for which no parent could be found in " + localMode + " mode");
        }

        // Now address package mode. This is a bit easier
        if (packageMode == MetaprogramPackageMode.INSERT)
        {
            if (LOGGER.isTraceEnabled())
            {
                LOGGER.trace("Granting " + NodePermission.INSERT + " permission to metaprogram " + metaprogramId
                        + " for " + rootPackage.getClass().getSimpleName() + " node at "
                        + rootPackage.getStartLocation());
            }
            policyManager.addThreshold(rootPackage, NodePermission.INSERT);
        }

        return policyManager;
    }

    /**
     * Performs actual metaprogram execution. This method calls the metaprogram's execute method and responds to runtime
     * exceptions by returning an appropriate diagnostic.
     * 
     * @param context The context to use when executing the metaprogram.
     * @param metaprogram The metaprogram to execute.
     * @param sourceLocation The source location to report in diagnostics.
     * @return A diagnostic if one should be reported or <code>null</code> if everything went fine.
     */
    private <A extends MetaprogramAnchorNode<B>, B extends Node> BsjDiagnostic doExecute(Context<A, B> context,
            Metaprogram<A, B> metaprogram, BsjSourceLocation sourceLocation)
    {
        if (context == null)
        {
            throw new IllegalStateException("Attempted to execute metaprogram profile with null context!");
        }
        if (metaprogram == null)
        {
            throw new IllegalStateException("Attempted to execute metaprogram profile with null metaprogram!");
        }

        try
        {
            metaprogram.execute(context);
        } catch (MetaprogramDetectedErrorException mdee)
        {
            return mdee.getDiagnostic(sourceLocation);
        } catch (MetaprogramExecutionFailureException mefe)
        {
            return new MetaprogramExecutionFailureDiagnosticImpl(sourceLocation, mefe);
        } catch (Exception e)
        {
            // The metaprogram threw something unexpected (like NullPointerException); handle it.
            // TODO: shouldn't we be catching Throwable?
            return new MetaprogramExceptionDiagnosticImpl(sourceLocation, e);
        }
        // TODO: have some mechanism for discovering that the metaprogram caught the exception we tried to throw
        // for instance, internal BSJ code can raise the exception through a method rather than with the "throw" keyword
        // and this method could set something in the node manager, metaprogram execution stack, etc. for us to find
        // here

        return null;
    }

    /**
     * This factory decorator keeps a list of explicit metaprogram anchors and meta-annotation nodes in order to
     * facilitate detection of injected metaprograms.
     */
    private static class ContextNodeFactory extends BsjNodeFactoryDecorator
    {
        private List<ExplicitMetaprogramAnchorNode<?>> explicitAnchors;
        private List<MetaAnnotationNode> metaAnnotationNodes;

        public ContextNodeFactory(BsjNodeFactory factory)
        {
            super(factory);
            this.explicitAnchors = new ArrayList<ExplicitMetaprogramAnchorNode<?>>();
            this.metaAnnotationNodes = new ArrayList<MetaAnnotationNode>();
        }

        @Override
        protected void before()
        {
        }

        @Override
        protected void after(Node node)
        {
            if (node instanceof ExplicitMetaprogramAnchorNode<?>)
            {
                this.explicitAnchors.add((ExplicitMetaprogramAnchorNode<?>) node);
            } else if (node instanceof MetaAnnotationNode)
            {
                this.metaAnnotationNodes.add((MetaAnnotationNode) node);
            }
        }

        public Iterable<Node> getRelevantInjectedNodes()
        {
            return new ConcatenatingIterable<Node>(new TwoElementImmutableSet<Iterable<? extends Node>>(
                    this.explicitAnchors, this.metaAnnotationNodes));
        }
    }
}
