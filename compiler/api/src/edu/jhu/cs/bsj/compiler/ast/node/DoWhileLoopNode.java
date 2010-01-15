package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * A node representing a do-while loop, as in:
 * <pre>
 * do <i>body</i> while (<i>condition</i>);
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
public interface DoWhileLoopNode extends Node, StatementNode
{
    /**
     * Gets the loop's condition.
     * @return The loop's condition.
     */
    public ExpressionNode getCondition();

    /**
     * Changes the loop's condition.
     * @param condition The loop's condition.
     */
    public void setCondition(ExpressionNode condition);

    /**
     * Gets the loop's statement.
     * @return The loop's statement.
     */
    public StatementNode getStatement();

    /**
     * Changes the loop's statement.
     * @param statement The loop's statement.
     */
    public void setStatement(StatementNode statement);

}
