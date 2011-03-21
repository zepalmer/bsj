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
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationArrayValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationValueListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.AnnotationArrayValueNodeSetValuesPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.AnnotationArrayValueNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class AnnotationArrayValueNodeImpl extends NodeImpl implements AnnotationArrayValueNode
{
    /** The array values. */
    private NodeUnion<? extends AnnotationValueListNode> values;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<AnnotationArrayValueNodeProperties> populatedProperties;
    
    /** General constructor. */
    public AnnotationArrayValueNodeImpl(
            NodeUnion<? extends AnnotationValueListNode> values,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetValues(values);
    }
    
    /** Proxy constructor. */
    public AnnotationArrayValueNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, AnnotationArrayValueNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(AnnotationArrayValueNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected AnnotationArrayValueNode getBackingNode()
    {
        return (AnnotationArrayValueNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the values value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkValuesWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                AnnotationArrayValueNodeProperties.VALUES))
            return;
        this.populatedProperties.add(AnnotationArrayValueNodeProperties.VALUES);
        NodeUnion<? extends AnnotationValueListNode> union = this.getBackingNode().getUnionForValues();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeAnnotationValueListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.values = union;
    }
    
    /**
     * Gets the array values.  This property's value is assumed to be a normal node.
     * @return The array values.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public AnnotationValueListNode getValues()
    {
        checkValuesWrapped();
        if (this.values == null)
        {
            return null;
        } else
        {
            return this.values.getNormalNode();
        }
    }
    
    /**
     * Gets the array values.
     * @return The array values.
     */
    public NodeUnion<? extends AnnotationValueListNode> getUnionForValues()
    {
        checkValuesWrapped();
        if (this.values == null)
        {
            this.values = new NormalNodeUnion<AnnotationValueListNode>(null);
        }
        return this.values;
    }
    
    /**
     * Changes the array values.
     * @param values The array values.
     */
    public void setValues(AnnotationValueListNode values)
    {
        checkValuesWrapped();
        this.setUnionForValues(new NormalNodeUnion<AnnotationValueListNode>(values));
    }
    
    /**
     * Changes the array values.
     * @param values The array values.
     */
    public void setUnionForValues(NodeUnion<? extends AnnotationValueListNode> values)
    {
        checkValuesWrapped();
        this.getManager().assertMutatable(this);
        this.doSetValues(values);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new AnnotationArrayValueNodeSetValuesPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), values.getNodeValue() == null ? null : values.getNodeValue().getUid()));
    }
    
    private void doSetValues(NodeUnion<? extends AnnotationValueListNode> values)
    {
        if (values == null)
        {
            values = new NormalNodeUnion<AnnotationValueListNode>(null);
        }
        if (this.values != null)
        {
            setAsChild(this.values.getNodeValue(), false);
        }
        this.values = values;
        setAsChild(values.getNodeValue(), true);
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
        if (this.getUnionForValues().getNodeValue() != null)
        {
            this.getUnionForValues().getNodeValue().receive(visitor);
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
        if (this.getUnionForValues().getNodeValue() != null)
        {
            this.getUnionForValues().getNodeValue().receiveTyped(visitor);
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
        visitor.visitAnnotationArrayValueNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitAnnotationValueNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitAnnotationValueNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitAnnotationArrayValueNodeStop(this, true);
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
        list.add(getUnionForValues());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForValues().getNodeValue()});
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
        sb.append("values=");
        sb.append(this.getUnionForValues().getNodeValue() == null? "null" : this.getUnionForValues().getNodeValue().getClass().getSimpleName());
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
        return operation.executeAnnotationArrayValueNode(this, p);
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
        return operation.executeAnnotationArrayValueNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnnotationArrayValueNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends AnnotationValueListNode> valuesCopy;
        switch (getUnionForValues().getType())
        {
            case NORMAL:
                if (getUnionForValues().getNormalNode() == null)
                {
                    valuesCopy = factory.<AnnotationValueListNode>makeNormalNodeUnion(null);
                } else
                {
                    valuesCopy = factory.makeNormalNodeUnion(getUnionForValues().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForValues().getSpliceNode() == null)
                {
                    valuesCopy = factory.<AnnotationValueListNode>makeSpliceNodeUnion(null);
                } else
                {
                    valuesCopy = factory.makeSpliceNodeUnion(getUnionForValues().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForValues().getType());
        }
        return factory.makeAnnotationArrayValueNodeWithUnions(
                valuesCopy,
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
        
        if (before.equals(this.getUnionForValues().getNodeValue()))
        {
            setValues((AnnotationValueListNode)after);
            return true;
        }
        return false;
    }
    
}
