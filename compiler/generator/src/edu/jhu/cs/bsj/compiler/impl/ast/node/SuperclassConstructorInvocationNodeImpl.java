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
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PrimaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.SuperclassConstructorInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ReferenceTypeListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.SuperclassConstructorInvocationNodeSetQualifyingExpressionPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.SuperclassConstructorInvocationNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class SuperclassConstructorInvocationNodeImpl extends ConstructorInvocationNodeImpl implements SuperclassConstructorInvocationNode
{
    /** The qualifying expression for the enclosing object. */
    private NodeUnion<? extends PrimaryExpressionNode> qualifyingExpression;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<SuperclassConstructorInvocationNodeProperties> populatedProperties;
    
    /** General constructor. */
    public SuperclassConstructorInvocationNodeImpl(
            NodeUnion<? extends PrimaryExpressionNode> qualifyingExpression,
            NodeUnion<? extends ExpressionListNode> arguments,
            NodeUnion<? extends ReferenceTypeListNode> typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(arguments, typeArguments, startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetQualifyingExpression(qualifyingExpression);
    }
    
    /** Proxy constructor. */
    public SuperclassConstructorInvocationNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, SuperclassConstructorInvocationNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(SuperclassConstructorInvocationNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected SuperclassConstructorInvocationNode getBackingNode()
    {
        return (SuperclassConstructorInvocationNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the qualifyingExpression value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkQualifyingExpressionWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                SuperclassConstructorInvocationNodeProperties.QUALIFYING_EXPRESSION))
            return;
        this.populatedProperties.add(SuperclassConstructorInvocationNodeProperties.QUALIFYING_EXPRESSION);
        NodeUnion<? extends PrimaryExpressionNode> union = this.getBackingNode().getUnionForQualifyingExpression();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makePrimaryExpressionNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.qualifyingExpression = union;
    }
    
    /**
     * Gets the qualifying expression for the enclosing object.  This property's value is assumed to be a normal node.
     * @return The qualifying expression for the enclosing object.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public PrimaryExpressionNode getQualifyingExpression()
    {
        checkQualifyingExpressionWrapped();
        if (this.qualifyingExpression == null)
        {
            return null;
        } else
        {
            return this.qualifyingExpression.getNormalNode();
        }
    }
    
    /**
     * Gets the qualifying expression for the enclosing object.
     * @return The qualifying expression for the enclosing object.
     */
    public NodeUnion<? extends PrimaryExpressionNode> getUnionForQualifyingExpression()
    {
        checkQualifyingExpressionWrapped();
        if (this.qualifyingExpression == null)
        {
            this.qualifyingExpression = new NormalNodeUnion<PrimaryExpressionNode>(null);
        }
        return this.qualifyingExpression;
    }
    
    /**
     * Changes the qualifying expression for the enclosing object.
     * @param qualifyingExpression The qualifying expression for the enclosing object.
     */
    public void setQualifyingExpression(PrimaryExpressionNode qualifyingExpression)
    {
        checkQualifyingExpressionWrapped();
        this.setUnionForQualifyingExpression(new NormalNodeUnion<PrimaryExpressionNode>(qualifyingExpression));
    }
    
    /**
     * Changes the qualifying expression for the enclosing object.
     * @param qualifyingExpression The qualifying expression for the enclosing object.
     */
    public void setUnionForQualifyingExpression(NodeUnion<? extends PrimaryExpressionNode> qualifyingExpression)
    {
        checkQualifyingExpressionWrapped();
        this.getManager().assertMutatable(this);
        this.doSetQualifyingExpression(qualifyingExpression);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new SuperclassConstructorInvocationNodeSetQualifyingExpressionPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), qualifyingExpression.getNodeValue() == null ? null : qualifyingExpression.getNodeValue().getUid()));
    }
    
    private void doSetQualifyingExpression(NodeUnion<? extends PrimaryExpressionNode> qualifyingExpression)
    {
        if (qualifyingExpression == null)
        {
            qualifyingExpression = new NormalNodeUnion<PrimaryExpressionNode>(null);
        }
        if (this.qualifyingExpression != null)
        {
            setAsChild(this.qualifyingExpression.getNodeValue(), false);
        }
        this.qualifyingExpression = qualifyingExpression;
        setAsChild(qualifyingExpression.getNodeValue(), true);
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
        if (this.getUnionForQualifyingExpression().getNodeValue() != null)
        {
            this.getUnionForQualifyingExpression().getNodeValue().receive(visitor);
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
        if (this.getUnionForQualifyingExpression().getNodeValue() != null)
        {
            this.getUnionForQualifyingExpression().getNodeValue().receiveTyped(visitor);
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
        visitor.visitSuperclassConstructorInvocationNodeStart(this, true);
        visitor.visitConstructorInvocationNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitConstructorInvocationNodeStop(this);
        visitor.visitSuperclassConstructorInvocationNodeStop(this, true);
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
        list.add(getUnionForQualifyingExpression());
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
        map.put("qualifyingExpression", getUnionForQualifyingExpression());
        return map;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForQualifyingExpression().getNodeValue(), getUnionForArguments().getNodeValue(), getUnionForTypeArguments().getNodeValue()});
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
        sb.append("qualifyingExpression=");
        sb.append(this.getUnionForQualifyingExpression().getNodeValue() == null? "null" : this.getUnionForQualifyingExpression().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("arguments=");
        sb.append(this.getUnionForArguments().getNodeValue() == null? "null" : this.getUnionForArguments().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("typeArguments=");
        sb.append(this.getUnionForTypeArguments().getNodeValue() == null? "null" : this.getUnionForTypeArguments().getNodeValue().getClass().getSimpleName());
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
        return operation.executeSuperclassConstructorInvocationNode(this, p);
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
        return operation.executeSuperclassConstructorInvocationNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public SuperclassConstructorInvocationNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends PrimaryExpressionNode> qualifyingExpressionCopy;
        switch (getUnionForQualifyingExpression().getType())
        {
            case NORMAL:
                if (getUnionForQualifyingExpression().getNormalNode() == null)
                {
                    qualifyingExpressionCopy = factory.<PrimaryExpressionNode>makeNormalNodeUnion(null);
                } else
                {
                    qualifyingExpressionCopy = factory.makeNormalNodeUnion(getUnionForQualifyingExpression().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForQualifyingExpression().getSpliceNode() == null)
                {
                    qualifyingExpressionCopy = factory.<PrimaryExpressionNode>makeSpliceNodeUnion(null);
                } else
                {
                    qualifyingExpressionCopy = factory.makeSpliceNodeUnion(getUnionForQualifyingExpression().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForQualifyingExpression().getType());
        }
        NodeUnion<? extends ExpressionListNode> argumentsCopy;
        switch (getUnionForArguments().getType())
        {
            case NORMAL:
                if (getUnionForArguments().getNormalNode() == null)
                {
                    argumentsCopy = factory.<ExpressionListNode>makeNormalNodeUnion(null);
                } else
                {
                    argumentsCopy = factory.makeNormalNodeUnion(getUnionForArguments().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForArguments().getSpliceNode() == null)
                {
                    argumentsCopy = factory.<ExpressionListNode>makeSpliceNodeUnion(null);
                } else
                {
                    argumentsCopy = factory.makeSpliceNodeUnion(getUnionForArguments().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForArguments().getType());
        }
        NodeUnion<? extends ReferenceTypeListNode> typeArgumentsCopy;
        switch (getUnionForTypeArguments().getType())
        {
            case NORMAL:
                if (getUnionForTypeArguments().getNormalNode() == null)
                {
                    typeArgumentsCopy = factory.<ReferenceTypeListNode>makeNormalNodeUnion(null);
                } else
                {
                    typeArgumentsCopy = factory.makeNormalNodeUnion(getUnionForTypeArguments().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForTypeArguments().getSpliceNode() == null)
                {
                    typeArgumentsCopy = factory.<ReferenceTypeListNode>makeSpliceNodeUnion(null);
                } else
                {
                    typeArgumentsCopy = factory.makeSpliceNodeUnion(getUnionForTypeArguments().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForTypeArguments().getType());
        }
        return factory.makeSuperclassConstructorInvocationNodeWithUnions(
                qualifyingExpressionCopy,
                argumentsCopy,
                typeArgumentsCopy,
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
        
        if (before.equals(this.getUnionForQualifyingExpression().getNodeValue()))
        {
            setQualifyingExpression((PrimaryExpressionNode)after);
            return true;
        }
        if (before.equals(this.getUnionForArguments().getNodeValue()))
        {
            setArguments((ExpressionListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForTypeArguments().getNodeValue()))
        {
            setTypeArguments((ReferenceTypeListNode)after);
            return true;
        }
        return false;
    }
    
}
