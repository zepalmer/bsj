package edu.jhu.cs.bsj.compiler.impl.ast;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import javax.tools.DiagnosticListener;

import org.apache.log4j.Logger;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.NodePermission;
import edu.jhu.cs.bsj.compiler.ast.exception.InsufficientPermissionException;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaAnnotationInstantiationFailureException;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.InvokableNameBindingNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.SimpleNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNameBindingNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNameBindingNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.AccessType;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.conflict.MetaprogramOrderingRecord;
import edu.jhu.cs.bsj.compiler.impl.ast.exception.InsufficientPermissionExceptionImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.exception.MetaprogramAttributeConflictExceptionImpl;
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
public class BsjNodeManager implements MetaprogramOrderingRecord
{
    /** A logger for this object. */
    private Logger LOGGER = Logger.getLogger(this.getClass());

    /**
     * The meta-annotation object instantiator used by this manager.
     */
    private MetaAnnotationObjectInstantiator instantiator;
    /**
     * The callback mechanism used specifically for package node management.
     */
    private PackageNodeManager packageNodeManager;
    /**
     * The current dependency manager.
     */
    private DependencyManager dependencyManager;
    /**
     * A module containing logic for compilation unit loading.
     */
    private CompilationUnitLoader compilationUnitLoader;

    /**
     * The stack of running metaprograms. This is specifically in place to permit code to temporarily suspend the
     * running metaprograms' effects (by pushing <code>null</code> onto the stack).
     */
    private Stack<MetaprogramProfile<?, ?>> metaprogramStack;
    /**
     * The stack of permission policy managers for nodes. If this manager is <code>null</code>, any mutation is
     * permitted.
     */
    private Stack<PermissionPolicyManager> permissionPolicyStack;

    /**
     * The toolkit over which this node manager is operating.
     */
    private BsjToolkit toolkit;

    /**
     * Creates a new node manager.
     */
    public BsjNodeManager(BsjToolkit toolkit)
    {
        this.metaprogramStack = new Stack<MetaprogramProfile<?, ?>>();
        this.permissionPolicyStack = new Stack<PermissionPolicyManager>();
        this.packageNodeManager = new PackageNodeManager(toolkit);
        this.instantiator = new MetaAnnotationObjectInstantiator(toolkit);
        this.compilationUnitLoader = new CompilationUnitLoader(toolkit, this);

        this.toolkit = toolkit;

        this.packageNodeManager.addListener(new PackageNodeListener()
        {

            @Override
            public void subpackageAdded(PackageNode packageNode, PackageNode subPackageNode)
            {
                BsjNodeManager.this.notifyChange(packageNode);
            }

            @Override
            public void compilationUnitInjected(CompilationUnitNode compilationUnitNode)
            {
                BsjNodeManager.this.notifyChange(compilationUnitNode.getParent());
            }

            @Override
            public void compilationUnitAdded(PackageNode packageNode, CompilationUnitNode compilationUnitNode,
                    boolean purelyInjected)
            {
                BsjNodeManager.this.notifyChange(packageNode);
            }
        });
    }

    // *** Permission policy management methods

    public PermissionPolicyManager getPermissionPolicyManager()
    {
        if (this.permissionPolicyStack.isEmpty())
        {
            return null;
        } else
        {
            return permissionPolicyStack.peek();
        }
    }

    public void pushPermissionPolicyManager(PermissionPolicyManager permissionPolicyManager)
    {
        this.permissionPolicyStack.push(permissionPolicyManager);
        if (LOGGER.isTraceEnabled())
        {
            LOGGER.trace("Permission policy push - stack = " + this.permissionPolicyStack.toString());
        }
    }

    public void popPermissionPolicyManager()
    {
        this.permissionPolicyStack.pop();
        if (LOGGER.isTraceEnabled())
        {
            LOGGER.trace("Permission policy pop - stack = " + this.permissionPolicyStack.toString());
        }
    }

    // *** Dependency management methods

    public DependencyManager getDependencyManager()
    {
        return this.dependencyManager;
    }

    public void setDependencyManager(DependencyManager dependencyManager)
    {
        this.dependencyManager = dependencyManager;
    }

    // *** Active metaprogram tracking methods

    public MetaprogramProfile<?, ?> getCurrentMetaprogram()
    {
        if (metaprogramStack.isEmpty())
        {
            return null;
        } else
        {
            return metaprogramStack.peek();
        }
    }

    public void pushCurrentMetaprogram(MetaprogramProfile<?, ?> metaprogram)
    {
        this.metaprogramStack.push(metaprogram);
    }

    public void popCurrentMetaprogram()
    {
        this.metaprogramStack.pop();
    }

    public Integer getCurrentMetaprogramId()
    {
        MetaprogramProfile<?, ?> metaprogram = getCurrentMetaprogram();
        return metaprogram == null ? null : metaprogram.getMetaprogram().getID();
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

    // *** Other methods

    /**
     * Pushes the state of all metaprogram value stacks with a <code>null</code> value. This is used internally by the
     * compiler to perform privileged, unrecorded operations while being called on behalf of a metaprogram.
     */
    public void pushNull()
    {
        this.pushCurrentMetaprogram(null);
        this.pushPermissionPolicyManager(null);
    }

    /**
     * Pops the state of all metaprogram value stacks. This is used internally by the compiler to pop values associated
     * with an execution context (such as that created by {@link #pushNull()}.
     */
    public void popAll()
    {
        this.popCurrentMetaprogram();
        this.popPermissionPolicyManager();
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
     * @param id1 The first metaprogram's ID.
     * @param id2 The second metaprogram's ID.
     * @return <code>true</code> if the metaprograms are ordered; <code>false</code> if they are not.
     */
    public boolean checkOrdering(int id1, int id2)
    {
        return this.getDependencyManager().checkOrdering(id1, id2);
    }

    /**
     * Determines whether or not the metaprogram with the specified ID is ordered with respect to the current metaprogram.
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
     * Asserts that the metaprogram with the specified ID is ordered with respect to the current metaprogram.
     * 
     * @param id The ID of the metaprogram to check.
     * @param node The node that the two metaprograms are modifying.
     * @param attribute The attribute over which we are asserting ordering.
     * @param ourAccess The access performed by the current metaprogram.
     * @param theirAccess The access performed by the metaprogram whose ID was specified.
     * @throws MetaprogramConflictException If the metaprogram with the specified ID is not ordered with respect to the current
     *             metaprogram.
     */
    public <T extends AccessType<T>> void assertOrdering(int id, Node node, Attribute<T> attribute, T ourAccess,
            T theirAccess) throws MetaprogramConflictException
    {
        if (!hasOrdering(id))
        {
            if (LOGGER.isDebugEnabled())
            {
                LOGGER.debug("Attempted to assert ordering between " + id + " and " + getCurrentMetaprogramId()
                        + " over node " + node.getUid() + " and failed.");
            }
            throw new MetaprogramAttributeConflictExceptionImpl(this.getDependencyManager().getMetaprogramProfileByID(
                    id).getAnchor(),
                    this.getDependencyManager().getMetaprogramProfileByID(getCurrentMetaprogramId()).getAnchor(), node,
                    attribute.getName(), ourAccess.toString(), theirAccess.toString());
        }
    }

    /**
     * Creates a new meta-annotation metaprogram anchor. This functionality is provided here to prevent nodes from
     * needing access to a factory. It is intended to be used by the {@link MetaAnnotationNode} when an anchor is
     * required to support its annotation object.
     * 
     * @param node The node for which the anchor is being created.
     * @return A new meta-annotation metaprogram anchor.
     */
    public MetaAnnotationMetaprogramAnchorNode instantiateMetaAnnotationMetaprogramAnchor(Node node)
    {
        return this.instantiator.instantiateMetaAnnotationMetaprogramAnchor(node);
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
