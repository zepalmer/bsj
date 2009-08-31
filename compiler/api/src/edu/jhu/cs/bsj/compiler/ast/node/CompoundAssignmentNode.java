package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents a compound assignment node.  A compound assignment node is one which performs an assignment operation
 * which implicitly uses the value of the variable to which a value is being assigned, as in:
 * <pre>
 * <i>variable compoundOp expression</i>
 * </pre>
 * where <i>compoundOp</i> is one of <tt>+=</tt>, <tt>&=</tt>, etc.
 */
public interface CompoundAssignmentNode extends ExpressionNode
{
    /**
     * Gets the expression to assign.
     * @return The expression to assign.
     */
    public ExpressionNode getExpression();

    /**
     * Changes the expression to assign.
     * @param expression The expression to assign.
     */
    public void setExpression(ExpressionNode expression);

    /**
     * Gets the variable to which assignment is occurring.
     * @return The variable to which assignment is occurring.
     */
    public NameNode getVariable();

    /**
     * Changes the variable to which assignment is occurring.
     * @param variable The variable to which assignment is occurring.
     */
    public void setVariable(NameNode variable);

}
