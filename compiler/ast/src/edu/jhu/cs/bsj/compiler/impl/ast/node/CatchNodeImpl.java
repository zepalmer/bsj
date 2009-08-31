package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.CatchNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;

public class CatchNodeImpl extends NodeImpl implements CatchNode
{
    /** The block to execute when this catch occurs. */
    private BlockStatementNode block;

    /** This catch block's exception variable. */
    private VariableNode parameter;

    /** General constructor. */
    public CatchNodeImpl(
            BlockStatementNode block,
            VariableNode parameter)
    {
        super();
        this.block = block;
        this.parameter = parameter;
    }

    /**
     * Gets the block to execute when this catch occurs.
     * @return The block to execute when this catch occurs.
     */
    public BlockStatementNode getBlock()
    {
        return this.block;
    }

    /**
     * Changes the block to execute when this catch occurs.
     * @param block The block to execute when this catch occurs.
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
     * Gets this catch block's exception variable.
     * @return This catch block's exception variable.
     */
    public VariableNode getParameter()
    {
        return this.parameter;
    }

    /**
     * Changes this catch block's exception variable.
     * @param parameter This catch block's exception variable.
     */
    public void setParameter(VariableNode parameter)
    {
        if (this.parameter instanceof NodeImpl)
        {
            ((NodeImpl)this.parameter).setParent(null);
        }
        this.parameter = parameter;
        if (this.parameter instanceof NodeImpl)
        {
            ((NodeImpl)this.parameter).setParent(this);
        }
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
