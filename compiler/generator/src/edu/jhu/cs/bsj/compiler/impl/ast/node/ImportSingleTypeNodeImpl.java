package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumSet;
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
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.ImportSingleTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ImportSingleTypeNodeSetNamePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.ImportSingleTypeNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ImportSingleTypeNodeImpl extends NodeImpl implements ImportSingleTypeNode
{
    /** The name of the type to import. */
    private NodeUnion<? extends NameNode> name;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<ImportSingleTypeNodeProperties> populatedProperties;
    
    /** General constructor. */
    public ImportSingleTypeNodeImpl(
            NodeUnion<? extends NameNode> name,
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
    public ImportSingleTypeNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, ImportSingleTypeNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(ImportSingleTypeNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected ImportSingleTypeNode getBackingNode()
    {
        return (ImportSingleTypeNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the name value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkNameWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ImportSingleTypeNodeProperties.NAME))
            return;
        this.populatedProperties.add(ImportSingleTypeNodeProperties.NAME);
        NodeUnion<? extends NameNode> union = this.getBackingNode().getUnionForName();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeNameNode(union.getNormalNode()));
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
     * Gets the name of the type to import.  This property's value is assumed to be a normal node.
     * @return The name of the type to import.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public NameNode getName()
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
     * Gets the name of the type to import.
     * @return The name of the type to import.
     */
    public NodeUnion<? extends NameNode> getUnionForName()
    {
        checkNameWrapped();
        if (this.name == null)
        {
            this.name = new NormalNodeUnion<NameNode>(null);
        }
        return this.name;
    }
    
    /**
     * Changes the name of the type to import.
     * @param name The name of the type to import.
     */
    public void setName(NameNode name)
    {
        checkNameWrapped();
        this.setUnionForName(new NormalNodeUnion<NameNode>(name));
    }
    
    /**
     * Changes the name of the type to import.
     * @param name The name of the type to import.
     */
    public void setUnionForName(NodeUnion<? extends NameNode> name)
    {
        checkNameWrapped();
        this.getManager().assertMutatable(this);
        this.doSetName(name);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ImportSingleTypeNodeSetNamePropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), name.getNodeValue() == null ? null : name.getNodeValue().getUid()));
    }
    
    private void doSetName(NodeUnion<? extends NameNode> name)
    {
        if (name == null)
        {
            name = new NormalNodeUnion<NameNode>(null);
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
        visitor.visitImportSingleTypeNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitImportNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitImportNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitImportSingleTypeNodeStop(this, true);
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
        return operation.executeImportSingleTypeNode(this, p);
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
        return operation.executeImportSingleTypeNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ImportSingleTypeNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends NameNode> nameCopy;
        switch (getUnionForName().getType())
        {
            case NORMAL:
                if (getUnionForName().getNormalNode() == null)
                {
                    nameCopy = factory.<NameNode>makeNormalNodeUnion(null);
                } else
                {
                    nameCopy = factory.makeNormalNodeUnion(getUnionForName().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForName().getSpliceNode() == null)
                {
                    nameCopy = factory.<NameNode>makeSpliceNodeUnion(null);
                } else
                {
                    nameCopy = factory.makeSpliceNodeUnion(getUnionForName().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForName().getType());
        }
        return factory.makeImportSingleTypeNodeWithUnions(
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
        
        if (before.equals(this.getUnionForName().getNodeValue()))
        {
            setName((NameNode)after);
            return true;
        }
        return false;
    }
    
}
