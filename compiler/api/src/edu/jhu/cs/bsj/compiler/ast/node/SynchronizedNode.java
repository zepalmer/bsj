package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node to represent synchronization statements, as in:
 * <pre>
 * synchronized (<i>expr</i>) {
 *     ...
 * }
 * </pre>
 */
public interface SynchronizedNode extends Node, StatementNode
{
    /**
     * Gets the synchronization expression.
     * @return The synchronization expression.
     */
    public ExpressionNode getExpression();

    /**
     * Changes the synchronization expression.
     * @param expression The synchronization expression.
     */
    public void setExpression(ExpressionNode expression);

    /**
     * Gets the block of statements to synchronize.
     * @return The block of statements to synchronize.
     */
    public BlockStatementNode getBlock();

    /**
     * Changes the block of statements to synchronize.
     * @param block The block of statements to synchronize.
     */
    public void setBlock(BlockStatementNode block);

}
