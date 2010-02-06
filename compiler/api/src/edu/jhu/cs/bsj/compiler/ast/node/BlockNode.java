package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents a block of statements, as in
 * <pre>
 * {
 *     <i>statement</i>
 *     <i>...</i>
 * }
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BlockNode extends Node, StatementNode
{
    /**
     * Gets the statements contained in this block statement.
     * @return The statements contained in this block statement.
     */
    public BlockStatementListNode getStatements();

    /**
     * Changes the statements contained in this block statement.
     * @param statements The statements contained in this block statement.
     */
    public void setStatements(BlockStatementListNode statements);

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public BlockNode deepCopy(BsjNodeFactory factory);
}
