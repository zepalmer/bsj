package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents a block of statements, as in
 * <pre>
 * {
 *     <i>statement</i>
 *     <i>...</i>
 * }
 * </pre>
 */
public interface BlockStatementNode extends Node, StatementNode
{
    /**
     * Gets the statements contained in this block statement.
     * @return The statements contained in this block statement.
     */
    public ListNode<StatementNode> getStatements();

    /**
     * Changes the statements contained in this block statement.
     * @param statements The statements contained in this block statement.
     */
    public void setStatements(ListNode<StatementNode> statements);

}
