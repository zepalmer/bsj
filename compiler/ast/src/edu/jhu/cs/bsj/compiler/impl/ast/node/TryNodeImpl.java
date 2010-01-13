package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.CatchNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.TryNode;

public class TryNodeImpl extends NodeImpl implements TryNode
{
    /** The block in which to try. */
    private BlockStatementNode block;

    /** The catch conditions. */
    private ListNode<CatchNode> catches;

    /** The finally block. */
    private BlockStatementNode finallyBlock;

    /** General constructor. */
    public TryNodeImpl(
            BlockStatementNode block,
            ListNode<CatchNode> catches,
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
        if (this.block instanceof NodeImpl)
        {
            ((NodeImpl)this.block).setParent(null);
        }
        this.block = block;
        if (this.block instanceof NodeImpl)
        {
            ((NodeImpl)this.block).setParent(this);
        }
    }

    /**
     * Gets the catch conditions.
     * @return The catch conditions.
     */
    public ListNode<CatchNode> getCatches()
    {
        return this.catches;
    }

    /**
     * Changes the catch conditions.
     * @param catches The catch conditions.
     */
    public void setCatches(ListNode<CatchNode> catches)
    {
        if (this.catches instanceof NodeImpl)
        {
            ((NodeImpl)this.catches).setParent(null);
        }
        this.catches = catches;
        if (this.catches instanceof NodeImpl)
        {
            ((NodeImpl)this.catches).setParent(this);
        }
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
        if (this.finallyBlock instanceof NodeImpl)
        {
            ((NodeImpl)this.finallyBlock).setParent(null);
        }
        this.finallyBlock = finallyBlock;
        if (this.finallyBlock instanceof NodeImpl)
        {
            ((NodeImpl)this.finallyBlock).setParent(this);
        }
    }

    /**
     * Handles the visitation of this node's children for the provided visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        super.receiveToChildren(visitor);
        this.block.receive(visitor);
        this.catches.receive(visitor);
        this.finallyBlock.receive(visitor);
    }
}
