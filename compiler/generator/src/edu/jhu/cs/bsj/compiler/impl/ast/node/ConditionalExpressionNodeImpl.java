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
import edu.jhu.cs.bsj.compiler.ast.node.ConditionalExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ConditionalExpressionNodeSetConditionPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ConditionalExpressionNodeSetFalseExpressionPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ConditionalExpressionNodeSetTrueExpressionPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.ConditionalExpressionNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ConditionalExpressionNodeImpl extends NodeImpl implements ConditionalExpressionNode
{
    /** The condition of the expression. */
    private NodeUnion<? extends ExpressionNode> condition;
    
    /** The value of this expression when the condition is true. */
    private NodeUnion<? extends ExpressionNode> trueExpression;
    
    /** The value of this expression when the condition is false. */
    private NodeUnion<? extends ExpressionNode> falseExpression;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<ConditionalExpressionNodeProperties> populatedProperties;
    
    /** General constructor. */
    public ConditionalExpressionNodeImpl(
            NodeUnion<? extends ExpressionNode> condition,
            NodeUnion<? extends ExpressionNode> trueExpression,
            NodeUnion<? extends ExpressionNode> falseExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetCondition(condition);
        doSetTrueExpression(trueExpression);
        doSetFalseExpression(falseExpression);
    }
    
    /** Proxy constructor. */
    public ConditionalExpressionNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, ConditionalExpressionNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(ConditionalExpressionNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected ConditionalExpressionNode getBackingNode()
    {
        return (ConditionalExpressionNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the condition value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkConditionWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ConditionalExpressionNodeProperties.CONDITION))
            return;
        this.populatedProperties.add(ConditionalExpressionNodeProperties.CONDITION);
        NodeUnion<? extends ExpressionNode> union = this.getBackingNode().getUnionForCondition();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeExpressionNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.condition = union;
    }
    
    /**
     * Ensures that the trueExpression value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkTrueExpressionWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ConditionalExpressionNodeProperties.TRUE_EXPRESSION))
            return;
        this.populatedProperties.add(ConditionalExpressionNodeProperties.TRUE_EXPRESSION);
        NodeUnion<? extends ExpressionNode> union = this.getBackingNode().getUnionForTrueExpression();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeExpressionNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.trueExpression = union;
    }
    
    /**
     * Ensures that the falseExpression value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkFalseExpressionWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ConditionalExpressionNodeProperties.FALSE_EXPRESSION))
            return;
        this.populatedProperties.add(ConditionalExpressionNodeProperties.FALSE_EXPRESSION);
        NodeUnion<? extends ExpressionNode> union = this.getBackingNode().getUnionForFalseExpression();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeExpressionNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.falseExpression = union;
    }
    
    /**
     * Gets the condition of the expression.  This property's value is assumed to be a normal node.
     * @return The condition of the expression.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ExpressionNode getCondition()
    {
        checkConditionWrapped();
        if (this.condition == null)
        {
            return null;
        } else
        {
            return this.condition.getNormalNode();
        }
    }
    
    /**
     * Gets the condition of the expression.
     * @return The condition of the expression.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForCondition()
    {
        checkConditionWrapped();
        if (this.condition == null)
        {
            this.condition = new NormalNodeUnion<ExpressionNode>(null);
        }
        return this.condition;
    }
    
    /**
     * Changes the condition of the expression.
     * @param condition The condition of the expression.
     */
    public void setCondition(ExpressionNode condition)
    {
        checkConditionWrapped();
        this.setUnionForCondition(new NormalNodeUnion<ExpressionNode>(condition));
    }
    
    /**
     * Changes the condition of the expression.
     * @param condition The condition of the expression.
     */
    public void setUnionForCondition(NodeUnion<? extends ExpressionNode> condition)
    {
        checkConditionWrapped();
        this.getManager().assertMutatable(this);
        this.doSetCondition(condition);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ConditionalExpressionNodeSetConditionPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), condition.getNodeValue() == null ? null : condition.getNodeValue().getUid()));
    }
    
    private void doSetCondition(NodeUnion<? extends ExpressionNode> condition)
    {
        if (condition == null)
        {
            condition = new NormalNodeUnion<ExpressionNode>(null);
        }
        if (this.condition != null)
        {
            setAsChild(this.condition.getNodeValue(), false);
        }
        this.condition = condition;
        setAsChild(condition.getNodeValue(), true);
    }
    
    /**
     * Gets the value of this expression when the condition is true.  This property's value is assumed to be a normal node.
     * @return The value of this expression when the condition is true.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ExpressionNode getTrueExpression()
    {
        checkTrueExpressionWrapped();
        if (this.trueExpression == null)
        {
            return null;
        } else
        {
            return this.trueExpression.getNormalNode();
        }
    }
    
    /**
     * Gets the value of this expression when the condition is true.
     * @return The value of this expression when the condition is true.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForTrueExpression()
    {
        checkTrueExpressionWrapped();
        if (this.trueExpression == null)
        {
            this.trueExpression = new NormalNodeUnion<ExpressionNode>(null);
        }
        return this.trueExpression;
    }
    
    /**
     * Changes the value of this expression when the condition is true.
     * @param trueExpression The value of this expression when the condition is true.
     */
    public void setTrueExpression(ExpressionNode trueExpression)
    {
        checkTrueExpressionWrapped();
        this.setUnionForTrueExpression(new NormalNodeUnion<ExpressionNode>(trueExpression));
    }
    
    /**
     * Changes the value of this expression when the condition is true.
     * @param trueExpression The value of this expression when the condition is true.
     */
    public void setUnionForTrueExpression(NodeUnion<? extends ExpressionNode> trueExpression)
    {
        checkTrueExpressionWrapped();
        this.getManager().assertMutatable(this);
        this.doSetTrueExpression(trueExpression);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ConditionalExpressionNodeSetTrueExpressionPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), trueExpression.getNodeValue() == null ? null : trueExpression.getNodeValue().getUid()));
    }
    
    private void doSetTrueExpression(NodeUnion<? extends ExpressionNode> trueExpression)
    {
        if (trueExpression == null)
        {
            trueExpression = new NormalNodeUnion<ExpressionNode>(null);
        }
        if (this.trueExpression != null)
        {
            setAsChild(this.trueExpression.getNodeValue(), false);
        }
        this.trueExpression = trueExpression;
        setAsChild(trueExpression.getNodeValue(), true);
    }
    
    /**
     * Gets the value of this expression when the condition is false.  This property's value is assumed to be a normal node.
     * @return The value of this expression when the condition is false.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ExpressionNode getFalseExpression()
    {
        checkFalseExpressionWrapped();
        if (this.falseExpression == null)
        {
            return null;
        } else
        {
            return this.falseExpression.getNormalNode();
        }
    }
    
    /**
     * Gets the value of this expression when the condition is false.
     * @return The value of this expression when the condition is false.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForFalseExpression()
    {
        checkFalseExpressionWrapped();
        if (this.falseExpression == null)
        {
            this.falseExpression = new NormalNodeUnion<ExpressionNode>(null);
        }
        return this.falseExpression;
    }
    
    /**
     * Changes the value of this expression when the condition is false.
     * @param falseExpression The value of this expression when the condition is false.
     */
    public void setFalseExpression(ExpressionNode falseExpression)
    {
        checkFalseExpressionWrapped();
        this.setUnionForFalseExpression(new NormalNodeUnion<ExpressionNode>(falseExpression));
    }
    
    /**
     * Changes the value of this expression when the condition is false.
     * @param falseExpression The value of this expression when the condition is false.
     */
    public void setUnionForFalseExpression(NodeUnion<? extends ExpressionNode> falseExpression)
    {
        checkFalseExpressionWrapped();
        this.getManager().assertMutatable(this);
        this.doSetFalseExpression(falseExpression);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ConditionalExpressionNodeSetFalseExpressionPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), falseExpression.getNodeValue() == null ? null : falseExpression.getNodeValue().getUid()));
    }
    
    private void doSetFalseExpression(NodeUnion<? extends ExpressionNode> falseExpression)
    {
        if (falseExpression == null)
        {
            falseExpression = new NormalNodeUnion<ExpressionNode>(null);
        }
        if (this.falseExpression != null)
        {
            setAsChild(this.falseExpression.getNodeValue(), false);
        }
        this.falseExpression = falseExpression;
        setAsChild(falseExpression.getNodeValue(), true);
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
        if (this.getUnionForCondition().getNodeValue() != null)
        {
            this.getUnionForCondition().getNodeValue().receive(visitor);
        }
        if (this.getUnionForTrueExpression().getNodeValue() != null)
        {
            this.getUnionForTrueExpression().getNodeValue().receive(visitor);
        }
        if (this.getUnionForFalseExpression().getNodeValue() != null)
        {
            this.getUnionForFalseExpression().getNodeValue().receive(visitor);
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
        if (this.getUnionForCondition().getNodeValue() != null)
        {
            this.getUnionForCondition().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForTrueExpression().getNodeValue() != null)
        {
            this.getUnionForTrueExpression().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForFalseExpression().getNodeValue() != null)
        {
            this.getUnionForFalseExpression().getNodeValue().receiveTyped(visitor);
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
        visitor.visitConditionalExpressionNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitNonAssignmentExpressionNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNonAssignmentExpressionNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitConditionalExpressionNodeStop(this, true);
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
        list.add(getUnionForCondition());
        list.add(getUnionForTrueExpression());
        list.add(getUnionForFalseExpression());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForCondition().getNodeValue(), getUnionForTrueExpression().getNodeValue(), getUnionForFalseExpression().getNodeValue()});
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
        sb.append("condition=");
        sb.append(this.getUnionForCondition().getNodeValue() == null? "null" : this.getUnionForCondition().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("trueExpression=");
        sb.append(this.getUnionForTrueExpression().getNodeValue() == null? "null" : this.getUnionForTrueExpression().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("falseExpression=");
        sb.append(this.getUnionForFalseExpression().getNodeValue() == null? "null" : this.getUnionForFalseExpression().getNodeValue().getClass().getSimpleName());
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
        return operation.executeConditionalExpressionNode(this, p);
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
        return operation.executeConditionalExpressionNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ConditionalExpressionNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends ExpressionNode> conditionCopy;
        switch (getUnionForCondition().getType())
        {
            case NORMAL:
                if (getUnionForCondition().getNormalNode() == null)
                {
                    conditionCopy = factory.<ExpressionNode>makeNormalNodeUnion(null);
                } else
                {
                    conditionCopy = factory.makeNormalNodeUnion(getUnionForCondition().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForCondition().getSpliceNode() == null)
                {
                    conditionCopy = factory.<ExpressionNode>makeSpliceNodeUnion(null);
                } else
                {
                    conditionCopy = factory.makeSpliceNodeUnion(getUnionForCondition().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForCondition().getType());
        }
        NodeUnion<? extends ExpressionNode> trueExpressionCopy;
        switch (getUnionForTrueExpression().getType())
        {
            case NORMAL:
                if (getUnionForTrueExpression().getNormalNode() == null)
                {
                    trueExpressionCopy = factory.<ExpressionNode>makeNormalNodeUnion(null);
                } else
                {
                    trueExpressionCopy = factory.makeNormalNodeUnion(getUnionForTrueExpression().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForTrueExpression().getSpliceNode() == null)
                {
                    trueExpressionCopy = factory.<ExpressionNode>makeSpliceNodeUnion(null);
                } else
                {
                    trueExpressionCopy = factory.makeSpliceNodeUnion(getUnionForTrueExpression().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForTrueExpression().getType());
        }
        NodeUnion<? extends ExpressionNode> falseExpressionCopy;
        switch (getUnionForFalseExpression().getType())
        {
            case NORMAL:
                if (getUnionForFalseExpression().getNormalNode() == null)
                {
                    falseExpressionCopy = factory.<ExpressionNode>makeNormalNodeUnion(null);
                } else
                {
                    falseExpressionCopy = factory.makeNormalNodeUnion(getUnionForFalseExpression().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForFalseExpression().getSpliceNode() == null)
                {
                    falseExpressionCopy = factory.<ExpressionNode>makeSpliceNodeUnion(null);
                } else
                {
                    falseExpressionCopy = factory.makeSpliceNodeUnion(getUnionForFalseExpression().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForFalseExpression().getType());
        }
        return factory.makeConditionalExpressionNodeWithUnions(
                conditionCopy,
                trueExpressionCopy,
                falseExpressionCopy,
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
        
        if (before.equals(this.getUnionForCondition().getNodeValue()))
        {
            setCondition((ExpressionNode)after);
            return true;
        }
        if (before.equals(this.getUnionForTrueExpression().getNodeValue()))
        {
            setTrueExpression((ExpressionNode)after);
            return true;
        }
        if (before.equals(this.getUnionForFalseExpression().getNodeValue()))
        {
            setFalseExpression((ExpressionNode)after);
            return true;
        }
        return false;
    }
    
}
