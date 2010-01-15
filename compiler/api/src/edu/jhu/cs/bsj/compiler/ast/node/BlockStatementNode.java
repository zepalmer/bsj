package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * Represents a block of statements, as in
 * <pre>
 * {
 *     <i>statement</i>
 *     <i>...</i>
 * }
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
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
