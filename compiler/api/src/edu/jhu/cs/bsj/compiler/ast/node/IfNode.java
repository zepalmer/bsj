package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * A node representing an if-then-else statement, as in:
 * <pre>
 * if (<i>condition</i>) then <i>statement</i> else <i>statement</i>
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
public interface IfNode extends Node, StatementNode
{
    /**
     * Gets the condition.
     * @return The condition.
     */
    public ExpressionNode getCondition();

    /**
     * Changes the condition.
     * @param condition The condition.
     */
    public void setCondition(ExpressionNode condition);

    /**
     * Gets the then branch's statement.
     * @return The then branch's statement.
     */
    public StatementNode getThenStatement();

    /**
     * Changes the then branch's statement.
     * @param thenStatement The then branch's statement.
     */
    public void setThenStatement(StatementNode thenStatement);

    /**
     * Gets the else branch's statement.
     * @return The else branch's statement.
     */
    public StatementNode getElseStatement();

    /**
     * Changes the else branch's statement.
     * @param elseStatement The else branch's statement.
     */
    public void setElseStatement(StatementNode elseStatement);

}
