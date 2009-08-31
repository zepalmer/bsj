package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing a for-loop, as in:
 * <pre>
 * for (<i>initializers</i>; <i>condition</i>; <i>updaters</i>)
 *     <i>body</i>
 * </pre>
 */
public interface ForLoopNode extends StatementNode
{
    /**
     * Gets the iterator variable.
     * @return The iterator variable.
     */
    public ListNode<? extends StatementNode> getInitializer();

    /**
     * Changes the iterator variable.
     * @param initializer The iterator variable.
     */
    public void setInitializer(ListNode<? extends StatementNode> initializer);

    /**
     * Gets the loop's update operation.
     * @return The loop's update operation.
     */
    public ListNode<? extends ExpressionStatementNode> getUpdate();

    /**
     * Changes the loop's update operation.
     * @param update The loop's update operation.
     */
    public void setUpdate(ListNode<? extends ExpressionStatementNode> update);

    /**
     * Gets the loop's termination condition.
     * @return The loop's termination condition.
     */
    public ExpressionNode getCondition();

    /**
     * Changes the loop's termination condition.
     * @param condition The loop's termination condition.
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
