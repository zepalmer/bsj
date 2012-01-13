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
import edu.jhu.cs.bsj.compiler.ast.node.ClassLiteralNode;
import edu.jhu.cs.bsj.compiler.ast.node.LiteralizableTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ClassLiteralNodeSetValuePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.ClassLiteralNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ClassLiteralNodeImpl extends NodeImpl implements ClassLiteralNode
{
    /** The type for this literal. */
    private NodeUnion<? extends LiteralizableTypeNode> value;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<ClassLiteralNodeProperties> populatedProperties;
    
    /** General constructor. */
    public ClassLiteralNodeImpl(
            NodeUnion<? extends LiteralizableTypeNode> value,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetValue(value);
    }
    
    /** Proxy constructor. */
    public ClassLiteralNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, ClassLiteralNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(ClassLiteralNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected ClassLiteralNode getBackingNode()
    {
        return (ClassLiteralNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the value value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkValueWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ClassLiteralNodeProperties.VALUE))
            return;
        this.populatedProperties.add(ClassLiteralNodeProperties.VALUE);
        NodeUnion<? extends LiteralizableTypeNode> union = this.getBackingNode().getUnionForValue();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeLiteralizableTypeNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.value = union;
    }
    
    /**
     * Gets the type for this literal.  This property's value is assumed to be a normal node.
     * @return The type for this literal.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public LiteralizableTypeNode getValue()
    {
        checkValueWrapped();
        if (this.value == null)
        {
            return null;
        } else
        {
            return this.value.getNormalNode();
        }
    }
    
    /**
     * Gets the type for this literal.
     * @return The type for this literal.
     */
    public NodeUnion<? extends LiteralizableTypeNode> getUnionForValue()
    {
        checkValueWrapped();
        if (this.value == null)
        {
            this.value = new NormalNodeUnion<LiteralizableTypeNode>(null);
        }
        return this.value;
    }
    
    /**
     * Changes the type for this literal.
     * @param value The type for this literal.
     */
    public void setValue(LiteralizableTypeNode value)
    {
        checkValueWrapped();
        this.setUnionForValue(new NormalNodeUnion<LiteralizableTypeNode>(value));
    }
    
    /**
     * Changes the type for this literal.
     * @param value The type for this literal.
     */
    public void setUnionForValue(NodeUnion<? extends LiteralizableTypeNode> value)
    {
        checkValueWrapped();
        this.getManager().assertMutatable(this);
        this.doSetValue(value);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ClassLiteralNodeSetValuePropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), value.getNodeValue() == null ? null : value.getNodeValue().getUid()));
    }
    
    private void doSetValue(NodeUnion<? extends LiteralizableTypeNode> value)
    {
        if (value == null)
        {
            value = new NormalNodeUnion<LiteralizableTypeNode>(null);
        }
        if (this.value != null)
        {
            setAsChild(this.value.getNodeValue(), false);
        }
        this.value = value;
        setAsChild(value.getNodeValue(), true);
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
        if (this.getUnionForValue().getNodeValue() != null)
        {
            this.getUnionForValue().getNodeValue().receive(visitor);
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
        if (this.getUnionForValue().getNodeValue() != null)
        {
            this.getUnionForValue().getNodeValue().receiveTyped(visitor);
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
        visitor.visitClassLiteralNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitLiteralNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitLiteralNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitClassLiteralNodeStop(this, true);
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
        list.add(getUnionForValue());
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
        map.put("value", getUnionForValue());
        return map;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForValue().getNodeValue()});
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
        sb.append("value=");
        sb.append(this.getUnionForValue().getNodeValue() == null? "null" : this.getUnionForValue().getNodeValue().getClass().getSimpleName());
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
        return operation.executeClassLiteralNode(this, p);
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
        return operation.executeClassLiteralNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ClassLiteralNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends LiteralizableTypeNode> valueCopy;
        switch (getUnionForValue().getType())
        {
            case NORMAL:
                if (getUnionForValue().getNormalNode() == null)
                {
                    valueCopy = factory.<LiteralizableTypeNode>makeNormalNodeUnion(null);
                } else
                {
                    valueCopy = factory.makeNormalNodeUnion(getUnionForValue().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForValue().getSpliceNode() == null)
                {
                    valueCopy = factory.<LiteralizableTypeNode>makeSpliceNodeUnion(null);
                } else
                {
                    valueCopy = factory.makeSpliceNodeUnion(getUnionForValue().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForValue().getType());
        }
        return factory.makeClassLiteralNodeWithUnions(
                valueCopy,
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
        
        if (before.equals(this.getUnionForValue().getNodeValue()))
        {
            setValue((LiteralizableTypeNode)after);
            return true;
        }
        return false;
    }
    
}
