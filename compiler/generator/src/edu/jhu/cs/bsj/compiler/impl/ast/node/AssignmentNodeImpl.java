package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.AssignmentNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.AssignmentNodeSetExpressionPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.AssignmentNodeSetOperatorPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.AssignmentNodeSetVariablePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.AssignmentNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class AssignmentNodeImpl extends NodeImpl implements AssignmentNode
{
    /** The variable to which to assign a value. */
    private NodeUnion<? extends ExpressionNode> variable;
    
    /** The assignment operator indicating the operation to perform. */
    private AssignmentOperator operator;
    
    /** The expression to use. */
    private NodeUnion<? extends ExpressionNode> expression;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<AssignmentNodeProperties> populatedProperties;
    
    /** General constructor. */
    public AssignmentNodeImpl(
            NodeUnion<? extends ExpressionNode> variable,
            AssignmentOperator operator,
            NodeUnion<? extends ExpressionNode> expression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetVariable(variable);
        doSetOperator(operator);
        doSetExpression(expression);
    }
    
    /** Proxy constructor. */
    public AssignmentNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, AssignmentNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(AssignmentNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected AssignmentNode getBackingNode()
    {
        return (AssignmentNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the variable value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkVariableWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                AssignmentNodeProperties.VARIABLE))
            return;
        this.populatedProperties.add(AssignmentNodeProperties.VARIABLE);
        NodeUnion<? extends ExpressionNode> union = this.getBackingNode().getUnionForVariable();
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
        this.variable = union;
    }
    
    /**
     * Ensures that the operator value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkOperatorWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                AssignmentNodeProperties.OPERATOR))
            return;
        this.populatedProperties.add(AssignmentNodeProperties.OPERATOR);
        this.operator = this.getBackingNode().getOperator();
    }
    
    /**
     * Ensures that the expression value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkExpressionWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                AssignmentNodeProperties.EXPRESSION))
            return;
        this.populatedProperties.add(AssignmentNodeProperties.EXPRESSION);
        NodeUnion<? extends ExpressionNode> union = this.getBackingNode().getUnionForExpression();
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
        this.expression = union;
    }
    
    /**
     * Gets the variable to which to assign a value.  This property's value is assumed to be a normal node.
     * @return The variable to which to assign a value.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ExpressionNode getVariable()
    {
        checkVariableWrapped();
        if (this.variable == null)
        {
            return null;
        } else
        {
            return this.variable.getNormalNode();
        }
    }
    
    /**
     * Gets the variable to which to assign a value.
     * @return The variable to which to assign a value.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForVariable()
    {
        checkVariableWrapped();
        if (this.variable == null)
        {
            this.variable = new NormalNodeUnion<ExpressionNode>(null);
        }
        return this.variable;
    }
    
    /**
     * Changes the variable to which to assign a value.
     * @param variable The variable to which to assign a value.
     */
    public void setVariable(ExpressionNode variable)
    {
        checkVariableWrapped();
        this.setUnionForVariable(new NormalNodeUnion<ExpressionNode>(variable));
    }
    
    /**
     * Changes the variable to which to assign a value.
     * @param variable The variable to which to assign a value.
     */
    public void setUnionForVariable(NodeUnion<? extends ExpressionNode> variable)
    {
        checkVariableWrapped();
        this.getManager().assertMutatable(this);
        this.doSetVariable(variable);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new AssignmentNodeSetVariablePropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), variable.getNodeValue() == null ? null : variable.getNodeValue().getUid()));
    }
    
    private void doSetVariable(NodeUnion<? extends ExpressionNode> variable)
    {
        if (variable == null)
        {
            variable = new NormalNodeUnion<ExpressionNode>(null);
        }
        if (this.variable != null)
        {
            setAsChild(this.variable.getNodeValue(), false);
        }
        this.variable = variable;
        setAsChild(variable.getNodeValue(), true);
    }
    
    /**
     * Gets the assignment operator indicating the operation to perform.
     * @return The assignment operator indicating the operation to perform.
     */
    public AssignmentOperator getOperator()
    {
        checkOperatorWrapped();
        return this.operator;
    }
    
    /**
     * Changes the assignment operator indicating the operation to perform.
     * @param operator The assignment operator indicating the operation to perform.
     */
    public void setOperator(AssignmentOperator operator)
    {
        checkOperatorWrapped();
        this.getManager().assertMutatable(this);
        this.doSetOperator(operator);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new AssignmentNodeSetOperatorPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), operator));
    }
    
    private void doSetOperator(AssignmentOperator operator)
    {
        this.operator = operator;
    }
    
    /**
     * Gets the expression to use.  This property's value is assumed to be a normal node.
     * @return The expression to use.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ExpressionNode getExpression()
    {
        checkExpressionWrapped();
        if (this.expression == null)
        {
            return null;
        } else
        {
            return this.expression.getNormalNode();
        }
    }
    
    /**
     * Gets the expression to use.
     * @return The expression to use.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForExpression()
    {
        checkExpressionWrapped();
        if (this.expression == null)
        {
            this.expression = new NormalNodeUnion<ExpressionNode>(null);
        }
        return this.expression;
    }
    
    /**
     * Changes the expression to use.
     * @param expression The expression to use.
     */
    public void setExpression(ExpressionNode expression)
    {
        checkExpressionWrapped();
        this.setUnionForExpression(new NormalNodeUnion<ExpressionNode>(expression));
    }
    
    /**
     * Changes the expression to use.
     * @param expression The expression to use.
     */
    public void setUnionForExpression(NodeUnion<? extends ExpressionNode> expression)
    {
        checkExpressionWrapped();
        this.getManager().assertMutatable(this);
        this.doSetExpression(expression);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new AssignmentNodeSetExpressionPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), expression.getNodeValue() == null ? null : expression.getNodeValue().getUid()));
    }
    
    private void doSetExpression(NodeUnion<? extends ExpressionNode> expression)
    {
        if (expression == null)
        {
            expression = new NormalNodeUnion<ExpressionNode>(null);
        }
        if (this.expression != null)
        {
            setAsChild(this.expression.getNodeValue(), false);
        }
        this.expression = expression;
        setAsChild(expression.getNodeValue(), true);
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
        if (this.getUnionForVariable().getNodeValue() != null)
        {
            this.getUnionForVariable().getNodeValue().receive(visitor);
        }
        if (this.getUnionForExpression().getNodeValue() != null)
        {
            this.getUnionForExpression().getNodeValue().receive(visitor);
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
        if (this.getUnionForVariable().getNodeValue() != null)
        {
            this.getUnionForVariable().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForExpression().getNodeValue() != null)
        {
            this.getUnionForExpression().getNodeValue().receiveTyped(visitor);
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
        visitor.visitAssignmentNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStatementExpressionNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitStatementExpressionNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitAssignmentNodeStop(this, true);
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
        list.add(getUnionForVariable());
        list.add(getOperator());
        list.add(getUnionForExpression());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForVariable().getNodeValue(), getUnionForExpression().getNodeValue()});
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
        sb.append("variable=");
        sb.append(this.getUnionForVariable().getNodeValue() == null? "null" : this.getUnionForVariable().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("operator=");
        sb.append(String.valueOf(this.getOperator()) + ":" + (this.getOperator() != null ? this.getOperator().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("expression=");
        sb.append(this.getUnionForExpression().getNodeValue() == null? "null" : this.getUnionForExpression().getNodeValue().getClass().getSimpleName());
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
        return operation.executeAssignmentNode(this, p);
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
        return operation.executeAssignmentNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AssignmentNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends ExpressionNode> variableCopy;
        switch (getUnionForVariable().getType())
        {
            case NORMAL:
                if (getUnionForVariable().getNormalNode() == null)
                {
                    variableCopy = factory.<ExpressionNode>makeNormalNodeUnion(null);
                } else
                {
                    variableCopy = factory.makeNormalNodeUnion(getUnionForVariable().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForVariable().getSpliceNode() == null)
                {
                    variableCopy = factory.<ExpressionNode>makeSpliceNodeUnion(null);
                } else
                {
                    variableCopy = factory.makeSpliceNodeUnion(getUnionForVariable().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForVariable().getType());
        }
        NodeUnion<? extends ExpressionNode> expressionCopy;
        switch (getUnionForExpression().getType())
        {
            case NORMAL:
                if (getUnionForExpression().getNormalNode() == null)
                {
                    expressionCopy = factory.<ExpressionNode>makeNormalNodeUnion(null);
                } else
                {
                    expressionCopy = factory.makeNormalNodeUnion(getUnionForExpression().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForExpression().getSpliceNode() == null)
                {
                    expressionCopy = factory.<ExpressionNode>makeSpliceNodeUnion(null);
                } else
                {
                    expressionCopy = factory.makeSpliceNodeUnion(getUnionForExpression().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForExpression().getType());
        }
        return factory.makeAssignmentNodeWithUnions(
                variableCopy,
                getOperator(),
                expressionCopy,
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
        
        if (before.equals(this.getUnionForVariable().getNodeValue()))
        {
            setVariable((ExpressionNode)after);
            return true;
        }
        if (before.equals(this.getUnionForExpression().getNodeValue()))
        {
            setExpression((ExpressionNode)after);
            return true;
        }
        return false;
    }
    
}
