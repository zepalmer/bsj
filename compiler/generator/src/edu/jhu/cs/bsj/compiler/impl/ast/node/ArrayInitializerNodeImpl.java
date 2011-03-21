package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableInitializerListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ArrayInitializerNodeSetInitializersPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.ArrayInitializerNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ArrayInitializerNodeImpl extends NodeImpl implements ArrayInitializerNode
{
    /** The initializers for the array. */
    private NodeUnion<? extends VariableInitializerListNode> initializers;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<ArrayInitializerNodeProperties> populatedProperties;
    
    /** General constructor. */
    public ArrayInitializerNodeImpl(
            NodeUnion<? extends VariableInitializerListNode> initializers,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetInitializers(initializers);
    }
    
    /** Proxy constructor. */
    public ArrayInitializerNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, ArrayInitializerNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(ArrayInitializerNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected ArrayInitializerNode getBackingNode()
    {
        return (ArrayInitializerNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the initializers value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkInitializersWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ArrayInitializerNodeProperties.INITIALIZERS))
            return;
        this.populatedProperties.add(ArrayInitializerNodeProperties.INITIALIZERS);
        NodeUnion<? extends VariableInitializerListNode> union = this.getBackingNode().getUnionForInitializers();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeVariableInitializerListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.initializers = union;
    }
    
    /**
     * Gets the initializers for the array.  This property's value is assumed to be a normal node.
     * @return The initializers for the array.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public VariableInitializerListNode getInitializers()
    {
        checkInitializersWrapped();
        if (this.initializers == null)
        {
            return null;
        } else
        {
            return this.initializers.getNormalNode();
        }
    }
    
    /**
     * Gets the initializers for the array.
     * @return The initializers for the array.
     */
    public NodeUnion<? extends VariableInitializerListNode> getUnionForInitializers()
    {
        checkInitializersWrapped();
        if (this.initializers == null)
        {
            this.initializers = new NormalNodeUnion<VariableInitializerListNode>(null);
        }
        return this.initializers;
    }
    
    /**
     * Changes the initializers for the array.
     * @param initializers The initializers for the array.
     */
    public void setInitializers(VariableInitializerListNode initializers)
    {
        checkInitializersWrapped();
        this.setUnionForInitializers(new NormalNodeUnion<VariableInitializerListNode>(initializers));
    }
    
    /**
     * Changes the initializers for the array.
     * @param initializers The initializers for the array.
     */
    public void setUnionForInitializers(NodeUnion<? extends VariableInitializerListNode> initializers)
    {
        checkInitializersWrapped();
        this.getManager().assertMutatable(this);
        this.doSetInitializers(initializers);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ArrayInitializerNodeSetInitializersPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), initializers.getNodeValue() == null ? null : initializers.getNodeValue().getUid()));
    }
    
    private void doSetInitializers(NodeUnion<? extends VariableInitializerListNode> initializers)
    {
        if (initializers == null)
        {
            initializers = new NormalNodeUnion<VariableInitializerListNode>(null);
        }
        if (this.initializers != null)
        {
            setAsChild(this.initializers.getNodeValue(), false);
        }
        this.initializers = initializers;
        setAsChild(initializers.getNodeValue(), true);
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
        if (this.getUnionForInitializers().getNodeValue() != null)
        {
            this.getUnionForInitializers().getNodeValue().receive(visitor);
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
        if (this.getUnionForInitializers().getNodeValue() != null)
        {
            this.getUnionForInitializers().getNodeValue().receiveTyped(visitor);
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
        visitor.visitArrayInitializerNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitVariableInitializerNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitVariableInitializerNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitArrayInitializerNodeStop(this, true);
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
        list.add(getUnionForInitializers());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForInitializers().getNodeValue()});
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
        sb.append("initializers=");
        sb.append(this.getUnionForInitializers().getNodeValue() == null? "null" : this.getUnionForInitializers().getNodeValue().getClass().getSimpleName());
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
        return operation.executeArrayInitializerNode(this, p);
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
        return operation.executeArrayInitializerNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ArrayInitializerNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends VariableInitializerListNode> initializersCopy;
        switch (getUnionForInitializers().getType())
        {
            case NORMAL:
                if (getUnionForInitializers().getNormalNode() == null)
                {
                    initializersCopy = factory.<VariableInitializerListNode>makeNormalNodeUnion(null);
                } else
                {
                    initializersCopy = factory.makeNormalNodeUnion(getUnionForInitializers().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForInitializers().getSpliceNode() == null)
                {
                    initializersCopy = factory.<VariableInitializerListNode>makeSpliceNodeUnion(null);
                } else
                {
                    initializersCopy = factory.makeSpliceNodeUnion(getUnionForInitializers().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForInitializers().getType());
        }
        return factory.makeArrayInitializerNodeWithUnions(
                initializersCopy,
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
        
        if (before.equals(this.getUnionForInitializers().getNodeValue()))
        {
            setInitializers((VariableInitializerListNode)after);
            return true;
        }
        return false;
    }
    
}
