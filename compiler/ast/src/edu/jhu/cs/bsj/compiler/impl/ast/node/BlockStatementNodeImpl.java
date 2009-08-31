package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;

public class BlockStatementNodeImpl extends StatementNodeImpl implements BlockStatementNode
{
    /** The statements contained in this block statement. */
    private ListNode<? extends StatementNode> statements;

    /** General constructor. */
    public BlockStatementNodeImpl(
            ListNode<? extends StatementNode> statements)
    {
        super();
        this.statements = statements;
    }

    /**
     * Gets the statements contained in this block statement.
     * @return The statements contained in this block statement.
     */
    public ListNode<? extends StatementNode> getStatements()
    {
        return this.statements;
    }

    /**
     * Changes the statements contained in this block statement.
     * @param statements The statements contained in this block statement.
     */
    public void setStatements(ListNode<? extends StatementNode> statements)
    {
        this.statements = statements;
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
