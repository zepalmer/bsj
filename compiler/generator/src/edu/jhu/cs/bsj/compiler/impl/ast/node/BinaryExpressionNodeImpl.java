package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BinaryOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.BinaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.BinaryExpressionNodeSetLeftOperandPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.BinaryExpressionNodeSetOperatorPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.BinaryExpressionNodeSetRightOperandPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.BinaryExpressionNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class BinaryExpressionNodeImpl extends NodeImpl implements BinaryExpressionNode
{
    /** The left operand of the expression. */
    private NodeUnion<? extends ExpressionNode> leftOperand;
    
    /** The right operand of the expression. */
    private NodeUnion<? extends ExpressionNode> rightOperand;
    
    /** The binary operator to apply. */
    private BinaryOperator operator;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<BinaryExpressionNodeProperties> populatedProperties;
    
    /** General constructor. */
    public BinaryExpressionNodeImpl(
            NodeUnion<? extends ExpressionNode> leftOperand,
            NodeUnion<? extends ExpressionNode> rightOperand,
            BinaryOperator operator,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetLeftOperand(leftOperand);
        doSetRightOperand(rightOperand);
        doSetOperator(operator);
    }
    
    /** Proxy constructor. */
    public BinaryExpressionNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, BinaryExpressionNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(BinaryExpressionNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected BinaryExpressionNode getBackingNode()
    {
        return (BinaryExpressionNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the leftOperand value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkLeftOperandWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                BinaryExpressionNodeProperties.LEFT_OPERAND))
            return;
        this.populatedProperties.add(BinaryExpressionNodeProperties.LEFT_OPERAND);
        NodeUnion<? extends ExpressionNode> union = this.getBackingNode().getUnionForLeftOperand();
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
        this.leftOperand = union;
    }
    
    /**
     * Ensures that the rightOperand value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkRightOperandWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                BinaryExpressionNodeProperties.RIGHT_OPERAND))
            return;
        this.populatedProperties.add(BinaryExpressionNodeProperties.RIGHT_OPERAND);
        NodeUnion<? extends ExpressionNode> union = this.getBackingNode().getUnionForRightOperand();
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
        this.rightOperand = union;
    }
    
    /**
     * Ensures that the operator value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkOperatorWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                BinaryExpressionNodeProperties.OPERATOR))
            return;
        this.populatedProperties.add(BinaryExpressionNodeProperties.OPERATOR);
        this.operator = this.getBackingNode().getOperator();
    }
    
    /**
     * Gets the left operand of the expression.  This property's value is assumed to be a normal node.
     * @return The left operand of the expression.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ExpressionNode getLeftOperand()
    {
        checkLeftOperandWrapped();
        if (this.leftOperand == null)
        {
            return null;
        } else
        {
            return this.leftOperand.getNormalNode();
        }
    }
    
    /**
     * Gets the left operand of the expression.
     * @return The left operand of the expression.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForLeftOperand()
    {
        checkLeftOperandWrapped();
        if (this.leftOperand == null)
        {
            this.leftOperand = new NormalNodeUnion<ExpressionNode>(null);
        }
        return this.leftOperand;
    }
    
    /**
     * Changes the left operand of the expression.
     * @param leftOperand The left operand of the expression.
     */
    public void setLeftOperand(ExpressionNode leftOperand)
    {
        checkLeftOperandWrapped();
        this.setUnionForLeftOperand(new NormalNodeUnion<ExpressionNode>(leftOperand));
    }
    
    /**
     * Changes the left operand of the expression.
     * @param leftOperand The left operand of the expression.
     */
    public void setUnionForLeftOperand(NodeUnion<? extends ExpressionNode> leftOperand)
    {
        checkLeftOperandWrapped();
        this.getManager().assertMutatable(this);
        this.doSetLeftOperand(leftOperand);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new BinaryExpressionNodeSetLeftOperandPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), leftOperand.getNodeValue() == null ? null : leftOperand.getNodeValue().getUid()));
    }
    
    private void doSetLeftOperand(NodeUnion<? extends ExpressionNode> leftOperand)
    {
        if (leftOperand == null)
        {
            leftOperand = new NormalNodeUnion<ExpressionNode>(null);
        }
        if (this.leftOperand != null)
        {
            setAsChild(this.leftOperand.getNodeValue(), false);
        }
        this.leftOperand = leftOperand;
        setAsChild(leftOperand.getNodeValue(), true);
    }
    
    /**
     * Gets the right operand of the expression.  This property's value is assumed to be a normal node.
     * @return The right operand of the expression.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ExpressionNode getRightOperand()
    {
        checkRightOperandWrapped();
        if (this.rightOperand == null)
        {
            return null;
        } else
        {
            return this.rightOperand.getNormalNode();
        }
    }
    
    /**
     * Gets the right operand of the expression.
     * @return The right operand of the expression.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForRightOperand()
    {
        checkRightOperandWrapped();
        if (this.rightOperand == null)
        {
            this.rightOperand = new NormalNodeUnion<ExpressionNode>(null);
        }
        return this.rightOperand;
    }
    
    /**
     * Changes the right operand of the expression.
     * @param rightOperand The right operand of the expression.
     */
    public void setRightOperand(ExpressionNode rightOperand)
    {
        checkRightOperandWrapped();
        this.setUnionForRightOperand(new NormalNodeUnion<ExpressionNode>(rightOperand));
    }
    
    /**
     * Changes the right operand of the expression.
     * @param rightOperand The right operand of the expression.
     */
    public void setUnionForRightOperand(NodeUnion<? extends ExpressionNode> rightOperand)
    {
        checkRightOperandWrapped();
        this.getManager().assertMutatable(this);
        this.doSetRightOperand(rightOperand);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new BinaryExpressionNodeSetRightOperandPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), rightOperand.getNodeValue() == null ? null : rightOperand.getNodeValue().getUid()));
    }
    
    private void doSetRightOperand(NodeUnion<? extends ExpressionNode> rightOperand)
    {
        if (rightOperand == null)
        {
            rightOperand = new NormalNodeUnion<ExpressionNode>(null);
        }
        if (this.rightOperand != null)
        {
            setAsChild(this.rightOperand.getNodeValue(), false);
        }
        this.rightOperand = rightOperand;
        setAsChild(rightOperand.getNodeValue(), true);
    }
    
    /**
     * Gets the binary operator to apply.
     * @return The binary operator to apply.
     */
    public BinaryOperator getOperator()
    {
        checkOperatorWrapped();
        return this.operator;
    }
    
    /**
     * Changes the binary operator to apply.
     * @param operator The binary operator to apply.
     */
    public void setOperator(BinaryOperator operator)
    {
        checkOperatorWrapped();
        this.getManager().assertMutatable(this);
        this.doSetOperator(operator);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new BinaryExpressionNodeSetOperatorPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), operator));
    }
    
    private void doSetOperator(BinaryOperator operator)
    {
        this.operator = operator;
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
        if (this.getUnionForLeftOperand().getNodeValue() != null)
        {
            this.getUnionForLeftOperand().getNodeValue().receive(visitor);
        }
        if (this.getUnionForRightOperand().getNodeValue() != null)
        {
            this.getUnionForRightOperand().getNodeValue().receive(visitor);
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
        if (this.getUnionForLeftOperand().getNodeValue() != null)
        {
            this.getUnionForLeftOperand().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForRightOperand().getNodeValue() != null)
        {
            this.getUnionForRightOperand().getNodeValue().receiveTyped(visitor);
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
        visitor.visitBinaryExpressionNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitNonAssignmentExpressionNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNonAssignmentExpressionNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitBinaryExpressionNodeStop(this, true);
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
        list.add(getUnionForLeftOperand());
        list.add(getUnionForRightOperand());
        list.add(getOperator());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForLeftOperand().getNodeValue(), getUnionForRightOperand().getNodeValue()});
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
        sb.append("leftOperand=");
        sb.append(this.getUnionForLeftOperand().getNodeValue() == null? "null" : this.getUnionForLeftOperand().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("rightOperand=");
        sb.append(this.getUnionForRightOperand().getNodeValue() == null? "null" : this.getUnionForRightOperand().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("operator=");
        sb.append(String.valueOf(this.getOperator()) + ":" + (this.getOperator() != null ? this.getOperator().getClass().getSimpleName() : "null"));
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
        return operation.executeBinaryExpressionNode(this, p);
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
        return operation.executeBinaryExpressionNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public BinaryExpressionNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends ExpressionNode> leftOperandCopy;
        switch (getUnionForLeftOperand().getType())
        {
            case NORMAL:
                if (getUnionForLeftOperand().getNormalNode() == null)
                {
                    leftOperandCopy = factory.<ExpressionNode>makeNormalNodeUnion(null);
                } else
                {
                    leftOperandCopy = factory.makeNormalNodeUnion(getUnionForLeftOperand().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForLeftOperand().getSpliceNode() == null)
                {
                    leftOperandCopy = factory.<ExpressionNode>makeSpliceNodeUnion(null);
                } else
                {
                    leftOperandCopy = factory.makeSpliceNodeUnion(getUnionForLeftOperand().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForLeftOperand().getType());
        }
        NodeUnion<? extends ExpressionNode> rightOperandCopy;
        switch (getUnionForRightOperand().getType())
        {
            case NORMAL:
                if (getUnionForRightOperand().getNormalNode() == null)
                {
                    rightOperandCopy = factory.<ExpressionNode>makeNormalNodeUnion(null);
                } else
                {
                    rightOperandCopy = factory.makeNormalNodeUnion(getUnionForRightOperand().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForRightOperand().getSpliceNode() == null)
                {
                    rightOperandCopy = factory.<ExpressionNode>makeSpliceNodeUnion(null);
                } else
                {
                    rightOperandCopy = factory.makeSpliceNodeUnion(getUnionForRightOperand().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForRightOperand().getType());
        }
        return factory.makeBinaryExpressionNodeWithUnions(
                leftOperandCopy,
                rightOperandCopy,
                getOperator(),
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
        
        if (before.equals(this.getUnionForLeftOperand().getNodeValue()))
        {
            setLeftOperand((ExpressionNode)after);
            return true;
        }
        if (before.equals(this.getUnionForRightOperand().getNodeValue()))
        {
            setRightOperand((ExpressionNode)after);
            return true;
        }
        return false;
    }
    
}
