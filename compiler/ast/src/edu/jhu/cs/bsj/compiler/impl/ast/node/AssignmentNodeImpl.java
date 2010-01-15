package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.AssignmentOperator;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AssignmentNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;

public class AssignmentNodeImpl extends NodeImpl implements AssignmentNode
{
    /** The variable to which to assign a value. */
    private ExpressionNode variable;

    /** The assignment operator indicating the operation to perform. */
    private AssignmentOperator operator;

    /** The expression to use. */
    private ExpressionNode expression;

    /** General constructor. */
    public AssignmentNodeImpl(
            ExpressionNode variable,
            AssignmentOperator operator,
            ExpressionNode expression)
    {
        super();
        this.variable = variable;
        this.operator = operator;
        this.expression = expression;
    }

    /**
     * Gets the variable to which to assign a value.
     * @return The variable to which to assign a value.
     */
    public ExpressionNode getVariable()
    {
        return this.variable;
    }

    /**
     * Changes the variable to which to assign a value.
     * @param variable The variable to which to assign a value.
     */
    public void setVariable(ExpressionNode variable)
    {
        if (this.variable instanceof NodeImpl)
        {
            ((NodeImpl)this.variable).setParent(null);
        }
        this.variable = variable;
        if (this.variable instanceof NodeImpl)
        {
            ((NodeImpl)this.variable).setParent(this);
        }
    }

    /**
     * Gets the assignment operator indicating the operation to perform.
     * @return The assignment operator indicating the operation to perform.
     */
    public AssignmentOperator getOperator()
    {
        return this.operator;
    }

    /**
     * Changes the assignment operator indicating the operation to perform.
     * @param operator The assignment operator indicating the operation to perform.
     */
    public void setOperator(AssignmentOperator operator)
    {
        this.operator = operator;
    }

    /**
     * Gets the expression to use.
     * @return The expression to use.
     */
    public ExpressionNode getExpression()
    {
        return this.expression;
    }

    /**
     * Changes the expression to use.
     * @param expression The expression to use.
     */
    public void setExpression(ExpressionNode expression)
    {
        if (this.expression instanceof NodeImpl)
        {
            ((NodeImpl)this.expression).setParent(null);
        }
        this.expression = expression;
        if (this.expression instanceof NodeImpl)
        {
            ((NodeImpl)this.expression).setParent(this);
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
        this.variable.receive(visitor);
        this.expression.receive(visitor);
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
        list.add(this.variable);
        list.add(this.operator);
        list.add(this.expression);
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
        sb.append("variable=");
        sb.append(this.variable == null? "null" : this.variable.getClass().getSimpleName());
        sb.append(',');
        sb.append("operator=");
        sb.append(String.valueOf(this.operator) + ":" + this.operator.getClass().getSimpleName());
        sb.append(',');
        sb.append("expression=");
        sb.append(this.expression == null? "null" : this.expression.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
