package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing a catch block, as in
 * <pre>
 * catch (<i>type identifier</i>)
 *     <i>block</i>
 * </pre>
 */
public interface CatchNode extends Node
{
    /**
     * Gets the block to execute when this catch occurs.
     * @return The block to execute when this catch occurs.
     */
    public BlockStatementNode getBlock();

    /**
     * Changes the block to execute when this catch occurs.
     * @param block The block to execute when this catch occurs.
     */
    public void setBlock(BlockStatementNode block);

    /**
     * Gets this catch block's exception variable.
     * @return This catch block's exception variable.
     */
    public VariableNode getParameter();

    /**
     * Changes this catch block's exception variable.
     * @param parameter This catch block's exception variable.
     */
    public void setParameter(VariableNode parameter);

}
