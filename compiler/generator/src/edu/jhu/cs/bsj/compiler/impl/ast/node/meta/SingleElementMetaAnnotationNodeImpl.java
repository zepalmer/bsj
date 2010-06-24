package edu.jhu.cs.bsj.compiler.impl.ast.node.meta;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.SingleElementMetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class SingleElementMetaAnnotationNodeImpl extends MetaAnnotationNodeImpl implements SingleElementMetaAnnotationNode
{
    /** The value of the "value" element. */
    private MetaAnnotationValueNode value;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new HashMap<LocalAttribute,ReadWriteAttribute>();
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(SingleElementMetaAnnotationNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the value property. */
        VALUE,
    }
    
    /** General constructor. */
    public SingleElementMetaAnnotationNodeImpl(
            MetaAnnotationValueNode value,
            UnparameterizedTypeNode annotationType,
            MetaAnnotationMetaprogramAnchorNode metaprogramAnchor,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(annotationType, metaprogramAnchor, startLocation, stopLocation, manager, binary);
        setValue(value, false);
    }
    
    /**
     * Gets the value of the "value" element.
     * @return The value of the "value" element.
     */
    public MetaAnnotationValueNode getValue()
    {
        getAttribute(LocalAttribute.VALUE).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.value;
    }
    
    /**
     * Changes the value of the "value" element.
     * @param value The value of the "value" element.
     */
    public void setValue(MetaAnnotationValueNode value)
    {
            setValue(value, true);
    }
    
    private void setValue(MetaAnnotationValueNode value, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.VALUE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(value, false);
        this.value = value;
        setAsChild(value, true);
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
        if (this.value != null)
        {
            this.value.receive(visitor);
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
        if (this.value != null)
        {
            this.value.receiveTyped(visitor);
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
        visitor.visitSingleElementMetaAnnotationNodeStart(this, true);
        visitor.visitMetaAnnotationNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitMetaAnnotationNodeStop(this);
        visitor.visitSingleElementMetaAnnotationNodeStop(this, true);
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
        list.add(getValue());
        return list;
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
        sb.append(this.getValue() == null? "null" : this.getValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("annotationType=");
        sb.append(this.getAnnotationType() == null? "null" : this.getAnnotationType().getClass().getSimpleName());
        sb.append(',');
        sb.append("metaprogramAnchor=");
        sb.append(this.getMetaprogramAnchor() == null? "null" : this.getMetaprogramAnchor().getClass().getSimpleName());
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
        return operation.executeSingleElementMetaAnnotationNode(this, p);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public SingleElementMetaAnnotationNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeSingleElementMetaAnnotationNode(
                getValue()==null?null:getValue().deepCopy(factory),
                getAnnotationType()==null?null:getAnnotationType().deepCopy(factory),
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
        
        if (before.equals(this.getValue()) && (after instanceof MetaAnnotationValueNode))
        {
            setValue((MetaAnnotationValueNode)after);
            return true;
        }
        if (before.equals(this.getAnnotationType()) && (after instanceof UnparameterizedTypeNode))
        {
            setAnnotationType((UnparameterizedTypeNode)after);
            return true;
        }
        return false;
    }
    
}
