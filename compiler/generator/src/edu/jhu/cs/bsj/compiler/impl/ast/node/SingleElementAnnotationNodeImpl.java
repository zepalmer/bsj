package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.SingleElementAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.AttributeName;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class SingleElementAnnotationNodeImpl extends AnnotationNodeImpl implements SingleElementAnnotationNode
{
    /** The value of the "value" element. */
    private NodeUnion<? extends AnnotationValueNode> value;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(SingleElementAnnotationNodeImpl.this, attributeName);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute implements AttributeName
    {
        /** Attribute identifier for the value property. */
        VALUE,
    }
    
    /** General constructor. */
    public SingleElementAnnotationNodeImpl(
            NodeUnion<? extends AnnotationValueNode> value,
            NodeUnion<? extends UnparameterizedTypeNode> annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(annotationType, startLocation, stopLocation, manager, binary);
        setUnionForValue(value, false);
    }
    
    /**
     * Gets the value of the "value" element.  This property's value is assumed to be a normal node.
     * @return The value of the "value" element.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public AnnotationValueNode getValue()
    {
        getAttribute(LocalAttribute.VALUE).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.value == null)
        {
            return null;
        } else
        {
            return this.value.getNormalNode();
        }
    }
    
    /**
     * Gets the value of the "value" element.
     * @return The value of the "value" element.
     */
    public NodeUnion<? extends AnnotationValueNode> getUnionForValue()
    {
        getAttribute(LocalAttribute.VALUE).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.value == null)
        {
            this.value = new NormalNodeUnion<AnnotationValueNode>(null);
        }
        return this.value;
    }
    
    /**
     * Changes the value of the "value" element.
     * @param value The value of the "value" element.
     */
    public void setValue(AnnotationValueNode value)
    {
            setValue(value, true);
            getManager().notifyChange(this);
    }
    
    private void setValue(AnnotationValueNode value, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.VALUE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.value != null)
        {
            setAsChild(this.value.getNodeValue(), false);
        }
        this.value = new NormalNodeUnion<AnnotationValueNode>(value);
        setAsChild(value, true);
    }
    
    /**
     * Changes the value of the "value" element.
     * @param value The value of the "value" element.
     */
    public void setUnionForValue(NodeUnion<? extends AnnotationValueNode> value)
    {
            setUnionForValue(value, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForValue(NodeUnion<? extends AnnotationValueNode> value, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.VALUE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (value == null)
        {
            value = new NormalNodeUnion<AnnotationValueNode>(null);
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
        if (this.value.getNodeValue() != null)
        {
            this.value.getNodeValue().receive(visitor);
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
        if (this.value.getNodeValue() != null)
        {
            this.value.getNodeValue().receiveTyped(visitor);
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
        visitor.visitSingleElementAnnotationNodeStart(this, true);
        visitor.visitAnnotationNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitAnnotationNodeStop(this);
        visitor.visitSingleElementAnnotationNodeStop(this, true);
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
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForValue().getNodeValue(), getUnionForAnnotationType().getNodeValue()});
    }
    
    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append('[');
        sb.append("value=");
        sb.append(this.getUnionForValue().getNodeValue() == null? "null" : this.getUnionForValue().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("annotationType=");
        sb.append(this.getUnionForAnnotationType().getNodeValue() == null? "null" : this.getUnionForAnnotationType().getNodeValue().getClass().getSimpleName());
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
    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p)
    {
        return operation.executeSingleElementAnnotationNode(this, p);
    }
    
    /**
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p1 The parameter to pass to the operation.
     * @param p2 The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P1,P2,R> R executeOperation(BsjNodeOperation2Arguments<P1,P2,R> operation, P1 p1, P2 p2)
    {
        return operation.executeSingleElementAnnotationNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public SingleElementAnnotationNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends AnnotationValueNode> valueCopy;
        switch (getUnionForValue().getType())
        {
            case NORMAL:
                if (getUnionForValue().getNormalNode() == null)
                {
                    valueCopy = factory.<AnnotationValueNode>makeNormalNodeUnion(null);
                } else
                {
                    valueCopy = factory.makeNormalNodeUnion(getUnionForValue().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForValue().getSpliceNode() == null)
                {
                    valueCopy = factory.<AnnotationValueNode>makeSpliceNodeUnion(null);
                } else
                {
                    valueCopy = factory.makeSpliceNodeUnion(getUnionForValue().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForValue().getType());
        }
        NodeUnion<? extends UnparameterizedTypeNode> annotationTypeCopy;
        switch (getUnionForAnnotationType().getType())
        {
            case NORMAL:
                if (getUnionForAnnotationType().getNormalNode() == null)
                {
                    annotationTypeCopy = factory.<UnparameterizedTypeNode>makeNormalNodeUnion(null);
                } else
                {
                    annotationTypeCopy = factory.makeNormalNodeUnion(getUnionForAnnotationType().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForAnnotationType().getSpliceNode() == null)
                {
                    annotationTypeCopy = factory.<UnparameterizedTypeNode>makeSpliceNodeUnion(null);
                } else
                {
                    annotationTypeCopy = factory.makeSpliceNodeUnion(getUnionForAnnotationType().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForAnnotationType().getType());
        }
        return factory.makeSingleElementAnnotationNodeWithUnions(
                valueCopy,
                annotationTypeCopy,
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
            setValue((AnnotationValueNode)after);
            return true;
        }
        if (before.equals(this.getUnionForAnnotationType().getNodeValue()))
        {
            setAnnotationType((UnparameterizedTypeNode)after);
            return true;
        }
        return false;
    }
    
}
