package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.CompilationUnitNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.SimpleNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.pkg.AddCompilationUnitPackageEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.pkg.AddImplicitSubpackagePackageEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.pkg.AddSubpackagePackageEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.pkg.LoadCompilationUnitPackageEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.exception.DuplicatePackageMemberExceptionImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.PackageNodeProperties;
import edu.jhu.cs.bsj.compiler.impl.utils.CollectionUtilities;
import edu.jhu.cs.bsj.compiler.impl.utils.CompoundIterator;
import edu.jhu.cs.bsj.compiler.impl.utils.filter.TrueNodeFilter;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoadingInfo;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class PackageNodeImpl extends NodeImpl implements PackageNode
{
    /** The simple name of this package. */
    private NodeUnion<? extends IdentifierNode> name;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<PackageNodeProperties> populatedProperties;
    
    /** General constructor. */
    public PackageNodeImpl(
            NodeUnion<? extends IdentifierNode> name,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetName(name);
    }
    
    /** Proxy constructor. */
    public PackageNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, PackageNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(PackageNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected PackageNode getBackingNode()
    {
        return (PackageNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the name value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkNameWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                PackageNodeProperties.NAME))
            return;
        this.populatedProperties.add(PackageNodeProperties.NAME);
        NodeUnion<? extends IdentifierNode> union = this.getBackingNode().getUnionForName();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeIdentifierNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.name = union;
    }
    
    /**
     * Gets the simple name of this package.  This property's value is assumed to be a normal node.
     * @return The simple name of this package.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public IdentifierNode getName()
    {
        checkNameWrapped();
        if (this.name == null)
        {
            return null;
        } else
        {
            return this.name.getNormalNode();
        }
    }
    
    /**
     * Gets the simple name of this package.
     * @return The simple name of this package.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForName()
    {
        checkNameWrapped();
        if (this.name == null)
        {
            this.name = new NormalNodeUnion<IdentifierNode>(null);
        }
        return this.name;
    }
    
    private void doSetName(NodeUnion<? extends IdentifierNode> name)
    {
        if (name == null)
        {
            name = new NormalNodeUnion<IdentifierNode>(null);
        }
        if (this.name != null)
        {
            setAsChild(this.name.getNodeValue(), false);
        }
        this.name = name;
        setAsChild(name.getNodeValue(), true);
    }
    
    /**
     * Handles the visitation of this node's children for the provided visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        super.receiveToChildren(visitor);
        if (this.getUnionForName().getNodeValue() != null)
        {
            this.getUnionForName().getNodeValue().receive(visitor);
        }
        Iterator<? extends Node> extras = getHiddenVisitorChildren();
        if (extras != null)
        {
            while (extras.hasNext())
            {
                extras.next().receive(visitor);
            }
        }
    }
    
    /**
     * Handles the visitation of this node's children for the provided typed visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveTypedToChildren(BsjTypedNodeVisitor visitor)
    {
        super.receiveTypedToChildren(visitor);
        if (this.getUnionForName().getNodeValue() != null)
        {
            this.getUnionForName().getNodeValue().receiveTyped(visitor);
        }
        Iterator<? extends Node> extras = getHiddenVisitorChildren();
        if (extras != null)
        {
            while (extras.hasNext())
            {
                extras.next().receiveTyped(visitor);
            }
        }
    }
    
    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitPackageNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitPackageNodeStop(this, true);
        visitor.visitStopEnd(this);
    }
    
    /**
     * Produces a mutable list of this node's children.  Modifying this list will have no
     * effect on this node.
     * @return A list of this node's children.
     */
    @Override
    public List<Object> getChildObjects()
    {
        List<Object> list = super.getChildObjects();
        list.add(getUnionForName());
        return list;
    }
    
    /**
     * Produces a mutable map of this node's children.  Modifying this map will have no
     * effect on this node.
     * @return A mapping of the node's children.
     */
    @Override
    public Map<String,Object> getChildMap()
    {
        Map<String,Object> map = super.getChildMap();
        map.put("name", getUnionForName());
        return map;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForName().getNodeValue()});
    }
    
    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append('#');
        sb.append(this.getUid());
        sb.append('[');
        sb.append("name=");
        sb.append(this.getUnionForName().getNodeValue() == null? "null" : this.getUnionForName().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("startLocation=");
        sb.append(String.valueOf(this.getStartLocation()) + ":" + (this.getStartLocation() != null ? this.getStartLocation().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("stopLocation=");
        sb.append(String.valueOf(this.getStopLocation()) + ":" + (this.getStopLocation() != null ? this.getStopLocation().getClass().getSimpleName() : "null"));
        sb.append(']');
        return sb.toString();
    }
    
    /**
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P,R,X extends Exception> R executeOperation(BsjAbortableNodeOperation<P,R,X> operation, P p) throws X
    {
        return operation.executePackageNode(this, p);
    }
    
    /**
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p1 The parameter to pass to the operation.
     * @param p2 The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P1,P2,R,X extends Exception> R executeOperation(BsjAbortableNodeOperation2Arguments<P1,P2,R,X> operation, P1 p1, P2 p2) throws X
    {
        return operation.executePackageNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public PackageNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends IdentifierNode> nameCopy;
        switch (getUnionForName().getType())
        {
            case NORMAL:
                if (getUnionForName().getNormalNode() == null)
                {
                    nameCopy = factory.<IdentifierNode>makeNormalNodeUnion(null);
                } else
                {
                    nameCopy = factory.makeNormalNodeUnion(getUnionForName().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForName().getSpliceNode() == null)
                {
                    nameCopy = factory.<IdentifierNode>makeSpliceNodeUnion(null);
                } else
                {
                    nameCopy = factory.makeSpliceNodeUnion(getUnionForName().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForName().getType());
        }
        return factory.makePackageNodeWithUnions(
                nameCopy,
                getStartLocation(),
                getStopLocation());
    }
    /**
     * Performs replacement for this node.
     * @param before The node to replace.
     * @param after The node to replace the <tt>before</tt> node.
     * @return <code>true</code> if the replacement was successful; <code>false</code> if the
     *         specified <tt>before</tt> node is not a child of this node.
     */
    public boolean replace(Node before, Node after)
    {
        if (before==null)
            throw new IllegalArgumentException("Cannot replace node with before value of null.");
        
        return false;
    }
    
    /** The subpackages we are currently maintaining. */
    private Map<String, PackageNode> packageNodes = new HashMap<String, PackageNode>();
    /**
     * The compilation units which were added via loading. Values are <code>null</code> when a load was performed but
     * did not succeed.
     */
    private Map<String, CompilationUnitNode> loadedCompilationUnits = new HashMap<String, CompilationUnitNode>();
    /** The compilation units which were added via addition. */
    private Map<String, CompilationUnitNode> storedCompilationUnits = new HashMap<String, CompilationUnitNode>();

    // TODO: create a somewhat more performant version of lazy population than this beast
    private boolean isPopulated = false;

    private void checkPopulated()
    {
        if (this.isPopulated || getBackingNode() == null)
        {
            this.isPopulated = true;
            return;
        }
        // This approach is not pretty, but it relies on the true invariant that all nodes in this tree were prouced
        // by the BsjNodeFactoryImpl that we know.  It also allows us to avoid exposing to the user through the API
        // the information about which specific subpackages are present and whether a given compilation unit is loaded
        // or stored. 
        PackageNodeImpl impl = (PackageNodeImpl) (this.getBackingNode());
        for (Map.Entry<String, CompilationUnitNode> entry : impl.loadedCompilationUnits.entrySet())
        {
            this.loadedCompilationUnits.put(entry.getKey(), getProxyFactory().makeCompilationUnitNode(entry.getValue()));
        }
        for (Map.Entry<String, CompilationUnitNode> entry : impl.storedCompilationUnits.entrySet())
        {
            this.storedCompilationUnits.put(entry.getKey(), getProxyFactory().makeCompilationUnitNode(entry.getValue()));
        }
        for (Map.Entry<String, PackageNode> entry : impl.packageNodes.entrySet())
        {
            this.packageNodes.put(entry.getKey(), getProxyFactory().makePackageNode(entry.getValue()));
        }
        this.isPopulated = true;
    }

    /**
     * {@inheritDoc}
     */
    public void addPackage(PackageNode packageNode)
    {
        checkPopulated();
        if (this.packageNodes.containsKey(packageNode.getName().getIdentifier()))
        {
            throw new DuplicatePackageMemberExceptionImpl(this, packageNode, packageNode.getName().getIdentifier());
        }
        getManager().assertInsertable(this);
        setAsChild(packageNode, true);
        this.packageNodes.put(packageNode.getName().getIdentifier(), packageNode);
        if (getManager().isRecordingEdits())
        {
            getManager().recordEdit(new AddSubpackagePackageEditScriptElementImpl(
                    getManager().getCurrentMetaprogramId(), getUid(), packageNode.getUid()));
        }
        getManager().notifyChange(this);
    }
   
    /**
     * {@inheritDoc}
     */
    public PackageNode getSubpackage(String name)
    {
        if (name.length() == 0)
            return this;
        checkPopulated();
        String[] nameComponents = name.split("\\.");
        PackageNodeImpl p = this;
        for (String component : nameComponents)
        {
            // True invariant: all recursive children of this node must be created by the BsjNodeFactoryImpl
            p = (PackageNodeImpl)p.getSimpleSubpackage(component);
            if (p == null)
            {
                break;
            }
        }
        return p;
    }
    
    private PackageNode getSimpleSubpackage(String name)
    {
        checkPopulated();
        PackageNode packageNode = this.packageNodes.get(name);
        if (packageNode == null)
        {
            BsjNodeFactory factory = this.getManager().getPackageNodeManager().getFactory();
            packageNode = factory.makePackageNode(factory.makeIdentifierNode(name));
            setAsChild(packageNode, true);
            this.packageNodes.put(name, packageNode);
            if (getManager().isRecordingEdits())
            {
                getManager().recordEdit(new AddImplicitSubpackagePackageEditScriptElementImpl(
                        getManager().getCurrentMetaprogramId(), getUid(), packageNode.getUid(), name));
            }
            getManager().notifyChange(this);
        }
        return packageNode;
    }
    
    public PackageNode getSubpackage(List<String> name)
    {
        checkPopulated();
        PackageNodeImpl p = this;
        for (String nameComponent : name)
        {
            if (nameComponent.contains("."))
                throw new IllegalArgumentException("name component " + nameComponent + " is not simple");
            // True invariant: all recursive children of this node must be created by the BsjNodeFactoryImpl
            p = (PackageNodeImpl)p.getSimpleSubpackage(nameComponent);
            if (p == null)
            {
                break;
            }            
        }
        return p;
    }

    /**
     * {@inheritDoc}
     */
    public PackageNode getSubpackage(NameNode name)
    {
        checkPopulated();
        if (name instanceof QualifiedNameNode)
        {
            QualifiedNameNode qualifiedNameNode = (QualifiedNameNode) name;
            PackageNode packageNode = getSubpackage(qualifiedNameNode.getBase());
            return packageNode.getSubpackage(name.getIdentifier().getIdentifier());
        } else if (name instanceof SimpleNameNode)
        {
            return getSubpackage(name.getIdentifier().getIdentifier());
        } else
        {
            throw new IllegalStateException("Unrecognized name node type " + name.getClass().getName());
        }
    }

    /**
     * {@inheritDoc}
     */
    public void addCompilationUnit(CompilationUnitNode compilationUnit)
    {
        checkPopulated();
        if (compilationUnit == null)
            throw new NullPointerException("Cannot add null compilation unit to a package");
        if (this.loadedCompilationUnits.containsKey(compilationUnit.getName())
                || this.storedCompilationUnits.containsKey(compilationUnit.getName()))
        {
            throw new DuplicatePackageMemberExceptionImpl(this, compilationUnit, compilationUnit.getName());
        }
        getManager().assertInsertable(this);
        setAsChild(compilationUnit, true);
        this.storedCompilationUnits.put(compilationUnit.getName(), compilationUnit);
        if (getManager().isRecordingEdits())
        {
            getManager().recordEdit(new AddCompilationUnitPackageEditScriptElementImpl(
                    getManager().getCurrentMetaprogramId(), getUid(), compilationUnit.getUid()));
        }
        getManager().notifyChange(this);
    }

    public boolean loadCompilationUnit(String name, CompilationUnitLoadingInfo info)
    {
        checkPopulated();
        CompilationUnitNode node;
        if (this.loadedCompilationUnits.containsKey(name))
        {
            node = this.loadedCompilationUnits.get(name);
        } else
        {
            node = getManager().getCompilationUnitLoader().load(this.getFullyQualifiedName(), name, info);
            if (this.getManager().getProxyFactory() != null)
            {
                node = this.getManager().getProxyFactory().makeCompilationUnitNode(node);
            }
            if (this.storedCompilationUnits.containsKey(name))
            {
                throw new DuplicatePackageMemberExceptionImpl(this, node, name);
            }
            this.loadedCompilationUnits.put(name, node);
            if (node != null)
            {
                setAsChild(node, true);
                getManager().getPackageNodeManager().fireCompilationUnitAdded(this, node,
                        this.getManager().getProxyFactory() == null ? null : this.getManager().getProxyFactory().getProxyIdMapping());
                getManager().notifyChange(this);
            }
        }
        if (getManager().isRecordingEdits())
        {
            getManager().recordEdit(new LoadCompilationUnitPackageEditScriptElementImpl(
                    getManager().getCurrentMetaprogramId(), getUid(), (node == null ? null : node.getUid()), name));
        }
        return node != null;
    }

    public void loadAllCompilationUnits(CompilationUnitLoadingInfo info)
    {
        for (String name : getManager().getCompilationUnitLoader().listCompilationUnitNames(this, false))
        {
            this.loadCompilationUnit(name, info);
        }
    }

    /**
     * {@inheritDoc}
     */
    public CompilationUnitNode getCompilationUnit(String name)
    {
        checkPopulated();
        CompilationUnitNode node;
        if (this.loadedCompilationUnits.containsKey(name))
        {
            node = this.loadedCompilationUnits.get(name);
        } else
        {
            node = this.storedCompilationUnits.get(name);
        }
        return node;
    }
    
    public Map<String, CompilationUnitNode> filterCompilationUnits(NodeFilter<? super CompilationUnitNode> filter)
    {
        checkPopulated();
        Map<String, CompilationUnitNode> ret = new HashMap<String, CompilationUnitNode>();
        for (Map<String, CompilationUnitNode> map : CollectionUtilities.listOf(this.loadedCompilationUnits, this.storedCompilationUnits))
        {
            for (Map.Entry<String, CompilationUnitNode> entry : map.entrySet())
            {
                if (entry.getValue() != null && filter.filter(entry.getValue()))
                {
                    ret.put(entry.getKey(), entry.getValue());
                }
            }
        }
        return ret;
    }

    /**
     * {@inheritDoc}
     */
    public Iterator<CompilationUnitNode> getCompilationUnitIterator()
    {
        checkPopulated();
        return filterCompilationUnits(TrueNodeFilter.<CompilationUnitNode>instance()).values().iterator();
    }

    /**
     * {@inheritDoc}
     */
    public Iterator<CompilationUnitNode> getRecursiveCompilationUnitIterator()
    {
        checkPopulated();
        List<Iterator<? extends CompilationUnitNode>> iterators = new ArrayList<Iterator<? extends CompilationUnitNode>>();
        iterators.add(getCompilationUnitIterator());
        for (PackageNode p : packageNodes.values())
        {
            iterators.add(p.getRecursiveCompilationUnitIterator());
        }
        return new CompoundIterator<CompilationUnitNode>(iterators.iterator());
    }

    /**
     * Used to allow visitation over the children of this package.
     * 
     * @return An iterator which iterates over the compilation units in this package and all of its subpackages.
     */
    protected Iterator<? extends Node> getHiddenVisitorChildren()
    {
        checkPopulated();
        List<Iterator<? extends Node>> iterators = new ArrayList<Iterator<? extends Node>>();
        iterators.add(super.getHiddenVisitorChildren());
        iterators.add(getRecursiveCompilationUnitIterator());
        return new CompoundIterator<Node>(iterators.iterator());
    }

    /**
     * {@inheritDoc}
     */
    public NamedTypeDeclarationNode<?> getTopLevelTypeDeclaration(String name, CompilationUnitLoadingInfo info)
    {
        checkPopulated();
        this.loadCompilationUnit(name, info);
        CompilationUnitNode compilationUnitNode = this.getCompilationUnit(name);
        if (compilationUnitNode != null)
        {
            NamedTypeDeclarationNode<?> namedTypeDeclarationNode = tryCompilationUnitNode(compilationUnitNode, name);
            if (namedTypeDeclarationNode != null)
            {
                return namedTypeDeclarationNode;
            }
        }

        // If we couldn't find it in its own compilation unit node, let's go find it by searching the package
        this.loadAllCompilationUnits(info);
        Iterator<CompilationUnitNode> it = getCompilationUnitIterator();
        while (it.hasNext())
        {
            NamedTypeDeclarationNode<?> namedTypeDeclarationNode = tryCompilationUnitNode(it.next(), name);
            if (namedTypeDeclarationNode != null)
            {
                return namedTypeDeclarationNode;
            }
        }

        return null;
    }

    // TODO: consider generalizing this to a public function of CompilationUnitNode
    /**
     * Searches the specified child for a top-level type declaration of the specified name.
     * 
     * @param compilationUnitNode The child in question.
     * @param name The name of the type declaration.
     * @return The resulting top-level type declaration.
     */
    private static NamedTypeDeclarationNode<?> tryCompilationUnitNode(CompilationUnitNode compilationUnitNode,
            String name)
    {
        for (TypeDeclarationNode typeDeclarationNode : compilationUnitNode.getTypeDecls())
        {
            if (typeDeclarationNode instanceof NamedTypeDeclarationNode<?>)
            {
                NamedTypeDeclarationNode<?> namedTypeDeclarationNode = (NamedTypeDeclarationNode<?>) typeDeclarationNode;
                if (namedTypeDeclarationNode.getIdentifier().getIdentifier().equals(name))
                {
                    return namedTypeDeclarationNode;
                }
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public String getFullyQualifiedName()
    {
        StringBuilder sb = new StringBuilder();
        PackageNode node = this;
        while (true)
        {
            if (node.getName() == null)
            {
                return sb.toString();
            }
            if (sb.length() > 0)
            {
                sb.insert(0, '.');
            }
            sb.insert(0, node.getName().getIdentifier());
            if (node.getParent() instanceof PackageNode)
            {
                node = (PackageNode) node.getParent();
            } else
            {
                return null;
            }
        }
    }

    /**
     * This function provides a recursive iterator over all subpackages of this node.  This is necessary for the
     * {@link edu.jhu.cs.bsj.compiler.impl.tool.compiler.task.BuildIdMapTask}.  This method only exists on the backing
     * class implementation and not on the interface because this information should not be provided to metaprogrammers
     * through the API.
     */
    public Iterator<PackageNode> getRecursivePackageIterator()
    {
        checkPopulated();
        List<Iterator<? extends PackageNode>> iterators = new ArrayList<Iterator<? extends PackageNode>>();
        iterators.add(this.packageNodes.values().iterator());
        for (PackageNode p : packageNodes.values())
        {
            iterators.add(((PackageNodeImpl)p).getRecursivePackageIterator());
        }
        return new CompoundIterator<PackageNode>(iterators.iterator());
    }
    
}
