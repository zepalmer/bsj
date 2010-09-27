package edu.jhu.cs.bsj.compiler.impl.ast.node.meta;

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
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaAnnotationMetaAnnotationValueNodeImpl extends NodeImpl implements MetaAnnotationMetaAnnotationValueNode
{
    /** The annotation. */
    private NodeUnion<? extends MetaAnnotationNode> annotation;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(MetaAnnotationMetaAnnotationValueNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the annotation property. */
        ANNOTATION,
    }
    
    /** General constructor. */
    public MetaAnnotationMetaAnnotationValueNodeImpl(
            NodeUnion<? extends MetaAnnotationNode> annotation,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setUnionForAnnotation(annotation, false);
    }
    
    /**
     * Gets the annotation.  This property's value is assumed to be a normal node.
     * @return The annotation.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public MetaAnnotationNode getAnnotation()
    {
        getAttribute(LocalAttribute.ANNOTATION).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.annotation == null)
        {
            return null;
        } else
        {
            return this.annotation.getNormalNode();
        }
    }
    
    /**
     * Gets the annotation.
     * @return The annotation.
     */
    public NodeUnion<? extends MetaAnnotationNode> getUnionForAnnotation()
    {
        getAttribute(LocalAttribute.ANNOTATION).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.annotation == null)
        {
            this.annotation = new NormalNodeUnion<MetaAnnotationNode>(null);
        }
        return this.annotation;
    }
    
    /**
     * Changes the annotation.
     * @param annotation The annotation.
     */
    public void setAnnotation(MetaAnnotationNode annotation)
    {
            setAnnotation(annotation, true);
            getManager().notifyChange(this);
    }
    
    private void setAnnotation(MetaAnnotationNode annotation, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.ANNOTATION).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.annotation != null)
        {
            setAsChild(this.annotation.getNodeValue(), false);
        }
        this.annotation = new NormalNodeUnion<MetaAnnotationNode>(annotation);
        setAsChild(annotation, true);
    }
    
    /**
     * Changes the annotation.
     * @param annotation The annotation.
     */
    public void setUnionForAnnotation(NodeUnion<? extends MetaAnnotationNode> annotation)
    {
            setUnionForAnnotation(annotation, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForAnnotation(NodeUnion<? extends MetaAnnotationNode> annotation, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.ANNOTATION).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (annotation == null)
        {
            throw new NullPointerException("Node union for property annotation cannot be null.");
        }
        if (this.annotation != null)
        {
            setAsChild(this.annotation.getNodeValue(), false);
        }
        this.annotation = annotation;
        setAsChild(annotation.getNodeValue(), true);
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
        if (this.annotation.getNodeValue() != null)
        {
            this.annotation.getNodeValue().receive(visitor);
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
        if (this.annotation.getNodeValue() != null)
        {
            this.annotation.getNodeValue().receiveTyped(visitor);
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
        visitor.visitMetaAnnotationMetaAnnotationValueNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitMetaAnnotationValueNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitMetaAnnotationValueNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitMetaAnnotationMetaAnnotationValueNodeStop(this, true);
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
        list.add(getAnnotation());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForAnnotation().getNodeValue()});
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
        sb.append("annotation=");
        sb.append(this.getUnionForAnnotation().getNodeValue() == null? "null" : this.getUnionForAnnotation().getNodeValue().getClass().getSimpleName());
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
        return operation.executeMetaAnnotationMetaAnnotationValueNode(this, p);
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
        return operation.executeMetaAnnotationMetaAnnotationValueNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaAnnotationMetaAnnotationValueNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends MetaAnnotationNode> annotationCopy;
        switch (getUnionForAnnotation().getType())
        {
            case NORMAL:
                if (getUnionForAnnotation().getNormalNode() == null)
                {
                    annotationCopy = factory.<MetaAnnotationNode>makeNormalNodeUnion(null);
                } else
                {
                    annotationCopy = factory.makeNormalNodeUnion(getUnionForAnnotation().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForAnnotation().getSpliceNode() == null)
                {
                    annotationCopy = factory.<MetaAnnotationNode>makeSpliceNodeUnion(null);
                } else
                {
                    annotationCopy = factory.makeSpliceNodeUnion(getUnionForAnnotation().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForAnnotation().getType());
        }
        return factory.makeMetaAnnotationMetaAnnotationValueNode(
                annotationCopy,
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
        
        if (before.equals(this.getAnnotation()) && (after instanceof MetaAnnotationNode))
        {
            setAnnotation((MetaAnnotationNode)after);
            return true;
        }
        return false;
    }
    
}
