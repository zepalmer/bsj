package edu.jhu.cs.bsj.compiler.impl.ast;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.tools.DiagnosticListener;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.NodePermission;
import edu.jhu.cs.bsj.compiler.ast.exception.InsufficientPermissionException;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaAnnotationInstantiationFailureException;
import edu.jhu.cs.bsj.compiler.ast.node.InvokableNameBindingNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.SimpleNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNameBindingNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNameBindingNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.exception.InsufficientPermissionExceptionImpl;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.NoOperationDiagnosticListener;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.CompilationUnitLoader;
import edu.jhu.cs.bsj.compiler.impl.metaprogram.PermissionPolicyManager;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.MetaprogramProfile;
import edu.jhu.cs.bsj.compiler.impl.tool.compiler.dependency.DependencyManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.TypecheckerManager;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.ErasedMethodSignature;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.namespace.map.NamespaceMap;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.lang.element.BsjExecutableElement;
import edu.jhu.cs.bsj.compiler.lang.element.BsjTypeLikeElement;
import edu.jhu.cs.bsj.compiler.lang.element.BsjVariableElement;
import edu.jhu.cs.bsj.compiler.metaannotation.BsjMetaAnnotation;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoadingInfo;
import edu.jhu.cs.bsj.compiler.tool.BsjToolkit;

/**
 * The node manager is used to provide a common, central interface for all nodes created by a given factory. Nodes call
 * against the manager to discover information such as the current modification policy or to report information such as
 * the modification of properties.
 * 
 * @author Zachary Palmer
 */
public class BsjNodeManager
{
    /*
     * TODO: clean up. It is possible to imagine this class as a delegating proxy for a number of interfaces:
     * PackageNodeManager, MetaAnnotationObjectInstantiator, and a few other interfaces yet to be established.
     * (Currently, the aforementioned are classes; an interface abstraction would need to be introduced.) Upon doing so,
     * the individual modules could be varied by instantiating different BsjNodeManagers and giving them some components
     * in common and leaving others distinct. This would be cleaner than the current approach because it would reduce
     * coupling; this current level of coupling, for instance, makes parallel execution of metaprograms impossible.
     */

    /**
     * The meta-annotation object instantiator used by this manager.
     */
    private MetaAnnotationObjectInstantiator instantiator;
    /**
     * The callback mechanism used specifically for package node management.
     */
    private PackageNodeManager packageNodeManager;
    /**
     * A module containing logic for compilation unit loading.
     */
    private CompilationUnitLoader compilationUnitLoader;
    /**
     * The module for tracking metaprogram execution state.
     */
    private MetaprogramExecutionStack metaprogramExecutionStack;

    /**
     * The toolkit over which this node manager is operating.
     */
    private BsjToolkit toolkit;

    /**
     * Creates a new node manager.
     */
    public BsjNodeManager(BsjToolkit toolkit)
    {
        this.packageNodeManager = new PackageNodeManager(toolkit);
        this.instantiator = new MetaAnnotationObjectInstantiator(toolkit);
        this.compilationUnitLoader = new CompilationUnitLoader(toolkit, this);
        this.metaprogramExecutionStack = new MetaprogramExecutionStack();

        this.toolkit = toolkit;
    }

    // *** Submodule access methods

    public PackageNodeManager getPackageNodeManager()
    {
        return packageNodeManager;
    }

    public CompilationUnitLoader getCompilationUnitLoader()
    {
        return compilationUnitLoader;
    }

    public MetaprogramExecutionStack getMetaprogramExecutionStack()
    {
        return metaprogramExecutionStack;
    }
    
    // *** Execution stack delegation methods
    
    public DependencyManager getDependencyManager()
    {
        return this.metaprogramExecutionStack.getDependencyManager();
    }

    public PermissionPolicyManager getPermissionPolicyManager()
    {
        return this.metaprogramExecutionStack.getPermissionPolicyManager();
    }
    
    public MetaprogramProfile<?, ?> getCurrentMetaprogram()
    {
        return this.metaprogramExecutionStack.getCurrentMetaprogram();
    }
    
    public boolean isRecordingEdits()
    {
        return this.metaprogramExecutionStack.isRecordingEdits();
    }
    
    public void recordEdit(EditScriptElement element)
    {
        this.metaprogramExecutionStack.recordEdit(element);
    }
    
    public BsjNodeProxyFactory getProxyFactory()
    {
        return this.metaprogramExecutionStack.getProxyFactory();
    }

    // *** Other methods

    public Integer getCurrentMetaprogramId()
    {
        MetaprogramProfile<?, ?> metaprogram = this.metaprogramExecutionStack.getCurrentMetaprogram();
        return metaprogram == null ? null : metaprogram.getMetaprogram().getID();
    }

    /**
     * Determines the currently available permission to the specified node.
     * 
     * @param node The node in question.
     * @return The current permission to that node.
     */
    public NodePermission getPermission(Node node)
    {
        if (node.isBinary())
        {
            return NodePermission.READ;
        } else if (this.getPermissionPolicyManager() == null)
        {
            return NodePermission.MUTATE;
        } else
        {
            return this.getPermissionPolicyManager().getPermission(node);
        }
    }

    /**
     * Asserts that permission to the specified node includes the ability to read.
     * 
     * @param node The node in question.
     * @throws InsufficientPermissionException If the node is not readable.
     */
    public void assertReadable(Node node) throws InsufficientPermissionException
    {
        NodePermission permission = getPermission(node);
        if (!permission.isReadable())
        {
            throw new InsufficientPermissionExceptionImpl(node, NodePermission.READ, permission);
        }
    }

    /**
     * Asserts that permission to the specified node includes the ability to insert.
     * 
     * @param node The node in question.
     * @throws InsufficientPermissionException If the node is not insertable.
     */
    public void assertInsertable(Node node) throws InsufficientPermissionException
    {
        NodePermission permission = getPermission(node);
        if (!permission.isInsertable())
        {
            throw new InsufficientPermissionExceptionImpl(node, NodePermission.INSERT, permission);
        }
    }

    /**
     * Asserts that permission to the specified node includes the ability to mutate.
     * 
     * @param node The node in question.
     * @throws InsufficientPermissionException If the node is not mutatable.
     */
    public void assertMutatable(Node node) throws InsufficientPermissionException
    {
        NodePermission permission = getPermission(node);
        if (!permission.isMutatable())
        {
            throw new InsufficientPermissionExceptionImpl(node, NodePermission.MUTATE, permission);
        }
    }

    /**
     * Retrieves a metaprogram anchor by metaprogram ID. This method should only be called for the purposes of creating
     * diagnostics.
     * 
     * @param id The ID to use.
     * @return The metaprogram anchor for that ID.
     */
    public MetaprogramAnchorNode<?> getAnchorByID(int id)
    {
        MetaprogramProfile<?, ?> profile = this.getDependencyManager().getMetaprogramProfileByID(id);
        return profile == null ? null : profile.getAnchor();
    }

    /**
     * Determines whether or not two metaprograms are ordered.
     * 
     * @param id1 The first metaprogram's ID.
     * @param id2 The second metaprogram's ID.
     * @return <code>true</code> if the metaprograms are ordered; <code>false</code> if they are not.
     */
    public boolean checkOrdering(int id1, int id2)
    {
        return this.getDependencyManager().checkOrdering(id1, id2);
    }

    /**
     * Determines whether or not the metaprogram with the specified ID is ordered with respect to the current
     * metaprogram.
     * 
     * @param id The ID of the metaprogram to check.
     * @return <code>true</code> if the metaprograms are ordered; <code>false</code> if they do not.
     */
    public boolean hasOrdering(int id)
    {
        if (this.getDependencyManager() == null || getCurrentMetaprogramId() == null)
            return true;

        return checkOrdering(id, getCurrentMetaprogramId());
    }

    /**
     * Instantiates a meta-annotation object for a meta-annotation node. This method is separated from the
     * {@link MetaAnnotationNode} implementation to allow multiple invocations of the same meta-annotation class to
     * share information about the structure of that meta-annotation declaration.
     * 
     * @param node The meta-annotation node for which to instantiate an object.
     * @param listener The diagnostic listener to which to report errors.
     * @return The resulting meta-annotation object.
     * @throws MetaAnnotationInstantiationFailureException If the meta-annotation object cannot be instantiated or
     *             configured correctly.
     */
    public BsjMetaAnnotation instantiateMetaAnnotationObject(MetaAnnotationNode node,
            DiagnosticListener<BsjSourceLocation> listener) throws MetaAnnotationInstantiationFailureException
    {
        return this.instantiator.instantiateMetaAnnotationObject(node, listener);
    }

    /** The current modification counter for this node manager. */
    private long modificationCount;

    /**
     * Notifies this node manager that the given node has experienced some form of change, typically to one of its
     * properties.
     * 
     * @param node The node which changed.
     */
    public void notifyChange(Node node)
    {
        this.modificationCount++;
    }

    /**
     * Retrieves the modification count for this manager.
     * 
     * @return The current modification count.
     */
    public long getModificationCount()
    {
        return this.modificationCount;
    }

    // *** NOTE: the following node methods are written as callbacks to use caching and to make life generally easier
    // due to the awkwardness of code generation.

    public Collection<? extends Node> getDeclarationsInScope(Node node, NameNode name)
    {
        DiagnosticListener<BsjSourceLocation> listener = new NoOperationDiagnosticListener<BsjSourceLocation>();
        CompilationUnitLoadingInfo loader = this.toolkit.getCompilationUnitLoadingInfoFactory().makeLoadingInfo(
                listener);
        if (name instanceof SimpleNameNode)
        {
            SimpleNameNode simpleName = (SimpleNameNode) name;
            NameCategory category = simpleName.getCategory(loader);
            return getDeclarationInScope(node, simpleName, simpleName.getIdentifier().getIdentifier(), category);
        } else if (name instanceof QualifiedNameNode)
        {
            QualifiedNameNode qualifiedName = (QualifiedNameNode) name;
            NameCategory category = qualifiedName.getCategory(loader);
            Collection<? extends Node> bases = getDeclarationsInScope(node, qualifiedName.getBase());
            Set<Node> ret = new HashSet<Node>();
            for (Node base : bases)
            {
                // TODO: fix this - it doesn't work correctly for inner classes because it doesn't operate against
                // the body of the declaration
                ret.addAll(getDeclarationInScope(base, qualifiedName, qualifiedName.getIdentifier().getIdentifier(),
                        category));
            }
            return ret;
        } else
        {
            throw new IllegalStateException("Unknown NameNode subtype " + name.getClass());
        }
    }

    private Collection<? extends Node> getDeclarationInScope(Node node, NameNode nameNode, String name,
            NameCategory category)
    {
        switch (category)
        {
            case TYPE:
                return getTypeDeclarationsInScope(node, name);
            case METHOD:
                return getMethodDeclarationsInScope(node, name);
            case EXPRESSION:
                return getVariableDeclarationsInScope(node, name);
            case PACKAGE:
                if (node instanceof PackageNode)
                {
                    return Collections.singleton(((PackageNode) node).getSubpackage(name));
                } else
                {
                    return Collections.singleton(node.getRootPackage().getSubpackage(name));
                }
            default:
                throw new IllegalArgumentException("Name " + nameNode.getNameString() + " is of category " + category);
        }
    }

    public Collection<? extends TypeNameBindingNode> getTypeDeclarationsInScope(Node node, String name)
    {
        if (node instanceof PackageNode)
        {
            PackageNode packageNode = (PackageNode) node;
            return Collections.singleton(packageNode.getTopLevelTypeDeclaration(
                    name,
                    this.toolkit.getCompilationUnitLoadingInfoFactory().makeLoadingInfo(
                            new NoOperationDiagnosticListener<BsjSourceLocation>())));
        } else
        {
            TypecheckerManager manager = getTypecheckerManager(node);
            NamespaceMap<String, BsjTypeLikeElement> namespace = manager.getNamespaceBuilder().getTypeNamespace(node);
            Collection<BsjTypeLikeElement> elements = namespace.getValues(name);
            Set<TypeNameBindingNode> ret = new HashSet<TypeNameBindingNode>();
            for (BsjTypeLikeElement element : elements)
            {
                ret.add(element.getDeclarationNode());
            }
            return ret;
        }
    }

    public Collection<? extends TypeNameBindingNode> getTypeDeclarationsInScope(Node node, List<String> nameComponents)
    {
        throw new NotImplementedYetException();
//        if (nameComponents.size() == 0)
//            throw new IllegalArgumentException("Must have at least one name component.");
//        Collection<? extends TypeNameBindingNode> ret = getTypeDeclarationsInScope(node, nameComponents.get(0));
//        for (int i=1;i<nameComponents.size();i++)
//        {
//            Collection<? extends TypeNameBindingNode> lastLevel = ret;
//            ret = new ArrayList<TypeNameBindingNode>(lastLevel.size());
//            for (TypeNameBindingNode typeNameBindingNode : lastLevel)
//            {
//                ret.addAll(typeNameBindingNode.getTypeDeclarationsInScope(
//            }
//        }
    }

    public Collection<? extends InvokableNameBindingNode> getMethodDeclarationsInScope(Node node, String name)
    {
        TypecheckerManager manager = getTypecheckerManager(node);
        NamespaceMap<ErasedMethodSignature, BsjExecutableElement> namespace = manager.getNamespaceBuilder().getMethodNamespace(
                node);
        Set<InvokableNameBindingNode> ret = new HashSet<InvokableNameBindingNode>();
        for (ErasedMethodSignature signature : namespace.getKeys())
        {
            if (signature.getName().equals(name))
            {
                for (BsjExecutableElement element : namespace.getValues(signature))
                {
                    Node declarationNode = element.getDeclarationNode();
                    if (declarationNode instanceof InvokableNameBindingNode)
                    {
                        ret.add((InvokableNameBindingNode) declarationNode);
                    }
                }
            }
        }
        return ret;
    }

    public Collection<? extends VariableNameBindingNode> getVariableDeclarationsInScope(Node node, String name)
    {
        TypecheckerManager manager = getTypecheckerManager(node);
        NamespaceMap<String, BsjVariableElement> namespace = manager.getNamespaceBuilder().getVariableNamespace(node);
        Collection<BsjVariableElement> elements = namespace.getValues(name);
        Set<VariableNameBindingNode> ret = new HashSet<VariableNameBindingNode>();
        for (BsjVariableElement element : elements)
        {
            ret.add(element.getDeclarationNode());
        }
        return ret;
    }

    /**
     * Retrieves from this node manager a suitable typechecker manager for the current state of the AST. This value will
     * be invalidated if any changes occur.
     * 
     * @param node The node for which a manager is desired.
     * @return An appropriate manager or <code>null</code> if no such manager can be found.
     */
    protected TypecheckerManager getTypecheckerManager(Node node)
    {
        // TODO: bother to cache the manager for performance

        // TODO: eliminate the need for the root package node to be defined
        // in such a case, no loading would occur and the symbol table would be incomplete
        // this would be a quite desirable ability when working with code fragments

        PackageNode rootPackage = node.getRootPackage();
        if (rootPackage == null)
        {
            throw new NotImplementedYetException("Root package must be non-null");
        }
        DiagnosticListener<BsjSourceLocation> listener = new NoOperationDiagnosticListener<BsjSourceLocation>();
        return new TypecheckerManager(rootPackage, toolkit.getParser(),
                this.toolkit.getCompilationUnitLoadingInfoFactory().makeLoadingInfo(listener), listener);
    }
}
