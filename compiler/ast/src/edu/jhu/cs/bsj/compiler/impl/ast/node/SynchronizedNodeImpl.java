package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.SynchronizedNode;

public class SynchronizedNodeImpl extends NodeImpl implements SynchronizedNode
{
    /** The synchronization expression. */
    private ExpressionNode expression;

    /** The block of statements to synchronize. */
    private BlockStatementNode block;

    /** General constructor. */
    public SynchronizedNodeImpl(
            ExpressionNode expression,
            BlockStatementNode block)
    {
        super();
        this.expression = expression;
        this.block = block;
    }

    /**
     * Gets the synchronization expression.
     * @return The synchronization expression.
     */
    public ExpressionNode getExpression()
    {
        return this.expression;
    }

    /**
     * Changes the synchronization expression.
     * @param expression The synchronization expression.
     */
    public void setExpression(ExpressionNode expression)
    {
        if (this.expression instanceof NodeImpl)
        {
            ((NodeImpl)this.expression).setParent(null);
        }
        this.expression = expression;
        if (this.expression instanceof NodeImpl)
        {
            ((NodeImpl)this.expression).setParent(this);
        }
    }

    /**
     * Gets the block of statements to synchronize.
     * @return The block of statements to synchronize.
     */
    public BlockStatementNode getBlock()
    {
        return this.block;
    }

    /**
     * Changes the block of statements to synchronize.
     * @param block The block of statements to synchronize.
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
        this.expression.receive(visitor);
        this.block.receive(visitor);
    }

    /**
     * Produces a mutable list of this node's children.  Modifying this list will have no
     * effect on this node.
     * @return A list of this node's children.
     */
    @Override
    public List<Object> getChildObjects()
    {
        List<Object> list = super.getChildObjects();
        list.add(this.expression);
        list.add(this.block);
        return list;
    }
}
