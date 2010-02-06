package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A node to represent a try-catch block, as in:
 * <pre>
 * try <i>block</i>
 * catch (<i>type name</i>) <i>block</i>
 * </pre>
 * or
 * <pre>
 * try <i>block</i>
 * catch (<i>type name</i>) <i>block</i>
 * catch (<i>type name</i>) <i>block</i>
 * finally <i>block</i>
 * </pre>
 * If no catch block exists, the <tt>catches</tt> list node will contain no children.  If no finally block exists,
 * <tt>finallyBlock</tt> will be <tt>null</tt>.  <tt>catches</tt> is not permitted to be <tt>null</tt>.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface TryNode extends Node, StatementNode
{
    /**
     * Gets the block in which to try.
     * @return The block in which to try.
     */
    public BlockNode getBlock();

    /**
     * Changes the block in which to try.
     * @param block The block in which to try.
     */
    public void setBlock(BlockNode block);

    /**
     * Gets the catch conditions.
     * @return The catch conditions.
     */
    public CatchListNode getCatches();

    /**
     * Changes the catch conditions.
     * @param catches The catch conditions.
     */
    public void setCatches(CatchListNode catches);

    /**
     * Gets the finally block.
     * @return The finally block.
     */
    public BlockNode getFinallyBlock();

    /**
     * Changes the finally block.
     * @param finallyBlock The finally block.
     */
    public void setFinallyBlock(BlockNode finallyBlock);

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public TryNode deepCopy(BsjNodeFactory factory);
}
