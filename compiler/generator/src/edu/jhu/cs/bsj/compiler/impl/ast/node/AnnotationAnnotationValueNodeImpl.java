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
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationAnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.AnnotationAnnotationValueNodeSetAnnotationPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.AnnotationAnnotationValueNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class AnnotationAnnotationValueNodeImpl extends NodeImpl implements AnnotationAnnotationValueNode
{
    /** The annotation. */
    private NodeUnion<? extends AnnotationNode> annotation;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<AnnotationAnnotationValueNodeProperties> populatedProperties;
    
    /** General constructor. */
    public AnnotationAnnotationValueNodeImpl(
            NodeUnion<? extends AnnotationNode> annotation,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetAnnotation(annotation);
    }
    
    /** Proxy constructor. */
    public AnnotationAnnotationValueNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, AnnotationAnnotationValueNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(AnnotationAnnotationValueNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected AnnotationAnnotationValueNode getBackingNode()
    {
        return (AnnotationAnnotationValueNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the annotation value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkAnnotationWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                AnnotationAnnotationValueNodeProperties.ANNOTATION))
            return;
        this.populatedProperties.add(AnnotationAnnotationValueNodeProperties.ANNOTATION);
        NodeUnion<? extends AnnotationNode> union = this.getBackingNode().getUnionForAnnotation();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeAnnotationNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.annotation = union;
    }
    
    /**
     * Gets the annotation.  This property's value is assumed to be a normal node.
     * @return The annotation.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public AnnotationNode getAnnotation()
    {
        checkAnnotationWrapped();
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
    public NodeUnion<? extends AnnotationNode> getUnionForAnnotation()
    {
        checkAnnotationWrapped();
        if (this.annotation == null)
        {
            this.annotation = new NormalNodeUnion<AnnotationNode>(null);
        }
        return this.annotation;
    }
    
    /**
     * Changes the annotation.
     * @param annotation The annotation.
     */
    public void setAnnotation(AnnotationNode annotation)
    {
        checkAnnotationWrapped();
        this.setUnionForAnnotation(new NormalNodeUnion<AnnotationNode>(annotation));
    }
    
    /**
     * Changes the annotation.
     * @param annotation The annotation.
     */
    public void setUnionForAnnotation(NodeUnion<? extends AnnotationNode> annotation)
    {
        checkAnnotationWrapped();
        this.getManager().assertMutatable(this);
        this.doSetAnnotation(annotation);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new AnnotationAnnotationValueNodeSetAnnotationPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), annotation.getNodeValue() == null ? null : annotation.getNodeValue().getUid()));
    }
    
    private void doSetAnnotation(NodeUnion<? extends AnnotationNode> annotation)
    {
        if (annotation == null)
        {
            annotation = new NormalNodeUnion<AnnotationNode>(null);
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
        if (this.getUnionForAnnotation().getNodeValue() != null)
        {
            this.getUnionForAnnotation().getNodeValue().receive(visitor);
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
        if (this.getUnionForAnnotation().getNodeValue() != null)
        {
            this.getUnionForAnnotation().getNodeValue().receiveTyped(visitor);
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
        visitor.visitAnnotationAnnotationValueNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitAnnotationValueNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitAnnotationValueNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitAnnotationAnnotationValueNodeStop(this, true);
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
        list.add(getUnionForAnnotation());
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
        sb.append('#');
        sb.append(this.getUid());
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
    public <P,R,X extends Exception> R executeOperation(BsjAbortableNodeOperation<P,R,X> operation, P p) throws X
    {
        return operation.executeAnnotationAnnotationValueNode(this, p);
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
        return operation.executeAnnotationAnnotationValueNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnnotationAnnotationValueNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends AnnotationNode> annotationCopy;
        switch (getUnionForAnnotation().getType())
        {
            case NORMAL:
                if (getUnionForAnnotation().getNormalNode() == null)
                {
                    annotationCopy = factory.<AnnotationNode>makeNormalNodeUnion(null);
                } else
                {
                    annotationCopy = factory.makeNormalNodeUnion(getUnionForAnnotation().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForAnnotation().getSpliceNode() == null)
                {
                    annotationCopy = factory.<AnnotationNode>makeSpliceNodeUnion(null);
                } else
                {
                    annotationCopy = factory.makeSpliceNodeUnion(getUnionForAnnotation().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForAnnotation().getType());
        }
        return factory.makeAnnotationAnnotationValueNodeWithUnions(
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
        
        if (before.equals(this.getUnionForAnnotation().getNodeValue()))
        {
            setAnnotation((AnnotationNode)after);
            return true;
        }
        return false;
    }
    
}
