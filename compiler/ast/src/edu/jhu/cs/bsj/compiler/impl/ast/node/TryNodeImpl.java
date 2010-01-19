package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.CatchNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.TryNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
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

    /**
     * Handles the visitation of this node's children for the provided typed visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveTypedToChildren(BsjTypedNodeVisitor visitor)
    {
        super.receiveTypedToChildren(visitor);
        this.block.receiveTyped(visitor);
        this.catches.receiveTyped(visitor);
        this.finallyBlock.receiveTyped(visitor);
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitTryNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStatementNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitStatementNodeStop(this);
        visitor.visitNodeStart(this);
        visitor.visitTryNodeStart(this, true);
        visitor.visitStopEnd(this);
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
        list.add(getBlock());
        list.add(getCatches());
        list.add(getFinallyBlock());
        return list;
    }

    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append('[');
        sb.append("block=");
        sb.append(this.block == null? "null" : this.block.getClass().getSimpleName());
        sb.append(',');
        sb.append("catches=");
        sb.append(this.catches == null? "null" : this.catches.getClass().getSimpleName());
        sb.append(',');
        sb.append("finallyBlock=");
        sb.append(this.finallyBlock == null? "null" : this.finallyBlock.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }

    /**
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p The parameter to pass to the operation.
     * @return The result of the operation.
     */
    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p)
    {
        return operation.executeTryNode(this, p);
    }
}
