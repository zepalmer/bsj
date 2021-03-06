package edu.jhu.cs.bsj.compiler.impl.ast.node.meta;

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
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationArrayValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MetaAnnotationArrayValueNodeSetValuesPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.MetaAnnotationArrayValueNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaAnnotationArrayValueNodeImpl extends NodeImpl implements MetaAnnotationArrayValueNode
{
    /** The array values. */
    private NodeUnion<? extends MetaAnnotationValueListNode> values;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<MetaAnnotationArrayValueNodeProperties> populatedProperties;
    
    /** General constructor. */
    public MetaAnnotationArrayValueNodeImpl(
            NodeUnion<? extends MetaAnnotationValueListNode> values,
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
    public MetaAnnotationArrayValueNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, MetaAnnotationArrayValueNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(MetaAnnotationArrayValueNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected MetaAnnotationArrayValueNode getBackingNode()
    {
        return (MetaAnnotationArrayValueNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the values value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkValuesWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MetaAnnotationArrayValueNodeProperties.VALUES))
            return;
        this.populatedProperties.add(MetaAnnotationArrayValueNodeProperties.VALUES);
        NodeUnion<? extends MetaAnnotationValueListNode> union = this.getBackingNode().getUnionForValues();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeMetaAnnotationValueListNode(union.getNormalNode()));
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
    public MetaAnnotationValueListNode getValues()
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
    public NodeUnion<? extends MetaAnnotationValueListNode> getUnionForValues()
    {
        checkValuesWrapped();
        if (this.values == null)
        {
            this.values = new NormalNodeUnion<MetaAnnotationValueListNode>(null);
        }
        return this.values;
    }
    
    /**
     * Changes the array values.
     * @param values The array values.
     */
    public void setValues(MetaAnnotationValueListNode values)
    {
        checkValuesWrapped();
        this.setUnionForValues(new NormalNodeUnion<MetaAnnotationValueListNode>(values));
    }
    
    /**
     * Changes the array values.
     * @param values The array values.
     */
    public void setUnionForValues(NodeUnion<? extends MetaAnnotationValueListNode> values)
    {
        checkValuesWrapped();
        this.getManager().assertMutatable(this);
        this.doSetValues(values);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MetaAnnotationArrayValueNodeSetValuesPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), values.getNodeValue() == null ? null : values.getNodeValue().getUid()));
    }
    
    private void doSetValues(NodeUnion<? extends MetaAnnotationValueListNode> values)
    {
        if (values == null)
        {
            values = new NormalNodeUnion<MetaAnnotationValueListNode>(null);
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
        visitor.visitMetaAnnotationArrayValueNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitMetaAnnotationValueNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitMetaAnnotationValueNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitMetaAnnotationArrayValueNodeStop(this, true);
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
     * Produces a mutable map of this node's children.  Modifying this map will have no
     * effect on this node.
     * @return A mapping of the node's children.
     */
    @Override
    public Map<String,Object> getChildMap()
    {
        Map<String,Object> map = super.getChildMap();
        map.put("values", getUnionForValues());
        return map;
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
        return operation.executeMetaAnnotationArrayValueNode(this, p);
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
        return operation.executeMetaAnnotationArrayValueNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaAnnotationArrayValueNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends MetaAnnotationValueListNode> valuesCopy;
        switch (getUnionForValues().getType())
        {
            case NORMAL:
                if (getUnionForValues().getNormalNode() == null)
                {
                    valuesCopy = factory.<MetaAnnotationValueListNode>makeNormalNodeUnion(null);
                } else
                {
                    valuesCopy = factory.makeNormalNodeUnion(getUnionForValues().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForValues().getSpliceNode() == null)
                {
                    valuesCopy = factory.<MetaAnnotationValueListNode>makeSpliceNodeUnion(null);
                } else
                {
                    valuesCopy = factory.makeSpliceNodeUnion(getUnionForValues().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForValues().getType());
        }
        return factory.makeMetaAnnotationArrayValueNodeWithUnions(
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
            setValues((MetaAnnotationValueListNode)after);
            return true;
        }
        return false;
    }
    
}
