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
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.NormalAnnotationNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationElementListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.NormalAnnotationNodeSetArgumentsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.NormalAnnotationNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class NormalAnnotationNodeImpl extends AnnotationNodeImpl implements NormalAnnotationNode
{
    /** The arguments. */
    private NodeUnion<? extends AnnotationElementListNode> arguments;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<NormalAnnotationNodeProperties> populatedProperties;
    
    /** General constructor. */
    public NormalAnnotationNodeImpl(
            NodeUnion<? extends AnnotationElementListNode> arguments,
            NodeUnion<? extends UnparameterizedTypeNode> annotationType,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(annotationType, startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetArguments(arguments);
    }
    
    /** Proxy constructor. */
    public NormalAnnotationNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, NormalAnnotationNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(NormalAnnotationNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected NormalAnnotationNode getBackingNode()
    {
        return (NormalAnnotationNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the arguments value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkArgumentsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                NormalAnnotationNodeProperties.ARGUMENTS))
            return;
        this.populatedProperties.add(NormalAnnotationNodeProperties.ARGUMENTS);
        NodeUnion<? extends AnnotationElementListNode> union = this.getBackingNode().getUnionForArguments();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeAnnotationElementListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.arguments = union;
    }
    
    /**
     * Gets the arguments.  This property's value is assumed to be a normal node.
     * @return The arguments.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public AnnotationElementListNode getArguments()
    {
        checkArgumentsWrapped();
        if (this.arguments == null)
        {
            return null;
        } else
        {
            return this.arguments.getNormalNode();
        }
    }
    
    /**
     * Gets the arguments.
     * @return The arguments.
     */
    public NodeUnion<? extends AnnotationElementListNode> getUnionForArguments()
    {
        checkArgumentsWrapped();
        if (this.arguments == null)
        {
            this.arguments = new NormalNodeUnion<AnnotationElementListNode>(null);
        }
        return this.arguments;
    }
    
    /**
     * Changes the arguments.
     * @param arguments The arguments.
     */
    public void setArguments(AnnotationElementListNode arguments)
    {
        checkArgumentsWrapped();
        this.setUnionForArguments(new NormalNodeUnion<AnnotationElementListNode>(arguments));
    }
    
    /**
     * Changes the arguments.
     * @param arguments The arguments.
     */
    public void setUnionForArguments(NodeUnion<? extends AnnotationElementListNode> arguments)
    {
        checkArgumentsWrapped();
        this.getManager().assertMutatable(this);
        this.doSetArguments(arguments);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new NormalAnnotationNodeSetArgumentsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), arguments.getNodeValue() == null ? null : arguments.getNodeValue().getUid()));
    }
    
    private void doSetArguments(NodeUnion<? extends AnnotationElementListNode> arguments)
    {
        if (arguments == null)
        {
            arguments = new NormalNodeUnion<AnnotationElementListNode>(null);
        }
        if (this.arguments != null)
        {
            setAsChild(this.arguments.getNodeValue(), false);
        }
        this.arguments = arguments;
        setAsChild(arguments.getNodeValue(), true);
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
        if (this.getUnionForArguments().getNodeValue() != null)
        {
            this.getUnionForArguments().getNodeValue().receive(visitor);
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
        if (this.getUnionForArguments().getNodeValue() != null)
        {
            this.getUnionForArguments().getNodeValue().receiveTyped(visitor);
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
        visitor.visitNormalAnnotationNodeStart(this, true);
        visitor.visitAnnotationNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitAnnotationNodeStop(this);
        visitor.visitNormalAnnotationNodeStop(this, true);
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
        list.add(getUnionForArguments());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForArguments().getNodeValue(), getUnionForAnnotationType().getNodeValue()});
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
        sb.append("arguments=");
        sb.append(this.getUnionForArguments().getNodeValue() == null? "null" : this.getUnionForArguments().getNodeValue().getClass().getSimpleName());
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
    public <P,R,X extends Exception> R executeOperation(BsjAbortableNodeOperation<P,R,X> operation, P p) throws X
    {
        return operation.executeNormalAnnotationNode(this, p);
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
        return operation.executeNormalAnnotationNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public NormalAnnotationNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends AnnotationElementListNode> argumentsCopy;
        switch (getUnionForArguments().getType())
        {
            case NORMAL:
                if (getUnionForArguments().getNormalNode() == null)
                {
                    argumentsCopy = factory.<AnnotationElementListNode>makeNormalNodeUnion(null);
                } else
                {
                    argumentsCopy = factory.makeNormalNodeUnion(getUnionForArguments().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForArguments().getSpliceNode() == null)
                {
                    argumentsCopy = factory.<AnnotationElementListNode>makeSpliceNodeUnion(null);
                } else
                {
                    argumentsCopy = factory.makeSpliceNodeUnion(getUnionForArguments().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForArguments().getType());
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
        return factory.makeNormalAnnotationNodeWithUnions(
                argumentsCopy,
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
        
        if (before.equals(this.getUnionForArguments().getNodeValue()))
        {
            setArguments((AnnotationElementListNode)after);
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
