package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A node to represent synchronization statements, as in:
 * <pre>
 * synchronized (<i>expr</i>) {
 *     ...
 * }
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
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
    public BlockNode getBlock();

    /**
     * Changes the block of statements to synchronize.
     * @param block The block of statements to synchronize.
     */
    public void setBlock(BlockNode block);

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public SynchronizedNode deepCopy(BsjNodeFactory factory);
}
