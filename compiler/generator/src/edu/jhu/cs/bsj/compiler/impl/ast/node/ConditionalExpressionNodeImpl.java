package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ConditionalExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ConditionalExpressionNodeImpl extends NodeImpl implements ConditionalExpressionNode
{
    /** The condition of the expression. */
    private ExpressionNode condition;
    
    /** The value of this expression when the condition is true. */
    private ExpressionNode trueExpression;
    
    /** The value of this expression when the condition is false. */
    private ExpressionNode falseExpression;
    
    private static enum LocalAttribute implements edu.jhu.cs.bsj.compiler.impl.ast.Attribute
    {
        /** Attribute for the condition property. */
        CONDITION,
        /** Attribute for the trueExpression property. */
        TRUE_EXPRESSION,
        /** Attribute for the falseExpression property. */
        FALSE_EXPRESSION,
    }
    
    /** General constructor. */
    public ConditionalExpressionNodeImpl(
            ExpressionNode condition,
            ExpressionNode trueExpression,
            ExpressionNode falseExpression,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setCondition(condition, false);
        setTrueExpression(trueExpression, false);
        setFalseExpression(falseExpression, false);
    }
    
    /**
     * Gets the condition of the expression.
     * @return The condition of the expression.
     */
    public ExpressionNode getCondition()
    {
        recordAccess(LocalAttribute.CONDITION, Attribute.AccessType.READ);
        return this.condition;
    }
    
    /**
     * Changes the condition of the expression.
     * @param condition The condition of the expression.
     */
    public void setCondition(ExpressionNode condition)
    {
            setCondition(condition, true);
    }
    
    private void setCondition(ExpressionNode condition, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.CONDITION, Attribute.AccessType.WRITE);
        }
        if (this.condition instanceof NodeImpl)
        {
            ((NodeImpl)this.condition).setParent(null);
        }
        this.condition = condition;
        if (this.condition instanceof NodeImpl)
        {
            ((NodeImpl)this.condition).setParent(this);
        }
    }
    
    /**
     * Gets the value of this expression when the condition is true.
     * @return The value of this expression when the condition is true.
     */
    public ExpressionNode getTrueExpression()
    {
        recordAccess(LocalAttribute.TRUE_EXPRESSION, Attribute.AccessType.READ);
        return this.trueExpression;
    }
    
    /**
     * Changes the value of this expression when the condition is true.
     * @param trueExpression The value of this expression when the condition is true.
     */
    public void setTrueExpression(ExpressionNode trueExpression)
    {
            setTrueExpression(trueExpression, true);
    }
    
    private void setTrueExpression(ExpressionNode trueExpression, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.TRUE_EXPRESSION, Attribute.AccessType.WRITE);
        }
        if (this.trueExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.trueExpression).setParent(null);
        }
        this.trueExpression = trueExpression;
        if (this.trueExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.trueExpression).setParent(this);
        }
    }
    
    /**
     * Gets the value of this expression when the condition is false.
     * @return The value of this expression when the condition is false.
     */
    public ExpressionNode getFalseExpression()
    {
        recordAccess(LocalAttribute.FALSE_EXPRESSION, Attribute.AccessType.READ);
        return this.falseExpression;
    }
    
    /**
     * Changes the value of this expression when the condition is false.
     * @param falseExpression The value of this expression when the condition is false.
     */
    public void setFalseExpression(ExpressionNode falseExpression)
    {
            setFalseExpression(falseExpression, true);
    }
    
    private void setFalseExpression(ExpressionNode falseExpression, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            recordAccess(LocalAttribute.FALSE_EXPRESSION, Attribute.AccessType.WRITE);
        }
        if (this.falseExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.falseExpression).setParent(null);
        }
        this.falseExpression = falseExpression;
        if (this.falseExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.falseExpression).setParent(this);
        }
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
        if (this.condition != null)
        {
            this.condition.receive(visitor);
        }
        if (this.trueExpression != null)
        {
            this.trueExpression.receive(visitor);
        }
        if (this.falseExpression != null)
        {
            this.falseExpression.receive(visitor);
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
        if (this.condition != null)
        {
            this.condition.receiveTyped(visitor);
        }
        if (this.trueExpression != null)
        {
            this.trueExpression.receiveTyped(visitor);
        }
        if (this.falseExpression != null)
        {
            this.falseExpression.receiveTyped(visitor);
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
        list.add(getCondition());
        list.add(getTrueExpression());
        list.add(getFalseExpression());
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
        sb.append("condition=");
        sb.append(this.getCondition() == null? "null" : this.getCondition().getClass().getSimpleName());
        sb.append(',');
        sb.append("trueExpression=");
        sb.append(this.getTrueExpression() == null? "null" : this.getTrueExpression().getClass().getSimpleName());
        sb.append(',');
        sb.append("falseExpression=");
        sb.append(this.getFalseExpression() == null? "null" : this.getFalseExpression().getClass().getSimpleName());
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
        return operation.executeConditionalExpressionNode(this, p);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ConditionalExpressionNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeConditionalExpressionNode(
                getCondition()==null?null:getCondition().deepCopy(factory),
                getTrueExpression()==null?null:getTrueExpression().deepCopy(factory),
                getFalseExpression()==null?null:getFalseExpression().deepCopy(factory),
                getStartLocation() == null ? null : (BsjSourceLocation)(getStartLocation().clone()),
                getStopLocation() == null ? null : (BsjSourceLocation)(getStopLocation().clone()));
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
        
        if (before.equals(this.getCondition()) && (after instanceof ExpressionNode))
        {
            setCondition((ExpressionNode)after);
            return true;
        }
        if (before.equals(this.getTrueExpression()) && (after instanceof ExpressionNode))
        {
            setTrueExpression((ExpressionNode)after);
            return true;
        }
        if (before.equals(this.getFalseExpression()) && (after instanceof ExpressionNode))
        {
            setFalseExpression((ExpressionNode)after);
            return true;
        }
        return false;
    }
    
}
