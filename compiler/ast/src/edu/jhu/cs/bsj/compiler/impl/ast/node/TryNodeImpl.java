package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.CatchNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.TryNode;

public class TryNodeImpl extends StatementNodeImpl implements TryNode
{
    /** The block in which to try. */
    private BlockStatementNode block;

    /** The catch conditions. */
    private ListNode<? extends CatchNode> catches;

    /** The finally block. */
    private BlockStatementNode finallyBlock;

    /** General constructor. */
    public TryNodeImpl(
            BlockStatementNode block,
            ListNode<? extends CatchNode> catches,
            BlockStatementNode finallyBlock)
    {
        super();
        this.block = block;
        this.catches = catches;
        this.finallyBlock = finallyBlock;
    }

    /**
     * Gets the block in which to try.
     * @return The block in which to try.
     */
    public BlockStatementNode getBlock()
    {
        return this.block;
    }

    /**
     * Changes the block in which to try.
     * @param block The block in which to try.
     */
    public void setBlock(BlockStatementNode block)
    {
        this.block = block;
    }

    /**
     * Gets the catch conditions.
     * @return The catch conditions.
     */
    public ListNode<? extends CatchNode> getCatches()
    {
        return this.catches;
    }

    /**
     * Changes the catch conditions.
     * @param catches The catch conditions.
     */
    public void setCatches(ListNode<? extends CatchNode> catches)
    {
        this.catches = catches;
    }

    /**
     * Gets the finally block.
     * @return The finally block.
     */
    public BlockStatementNode getFinallyBlock()
    {
        return this.finallyBlock;
    }

    /**
     * Changes the finally block.
     * @param finallyBlock The finally block.
     */
    public void setFinallyBlock(BlockStatementNode finallyBlock)
    {
        this.finallyBlock = finallyBlock;
    }

    /**
     * Performs visitation for this node's children.
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        
    }
}
