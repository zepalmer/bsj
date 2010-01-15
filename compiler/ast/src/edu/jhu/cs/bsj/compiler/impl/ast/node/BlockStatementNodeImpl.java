package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;

public class BlockStatementNodeImpl extends NodeImpl implements BlockStatementNode
{
    /** The statements contained in this block statement. */
    private ListNode<StatementNode> statements;

    /** General constructor. */
    public BlockStatementNodeImpl(
            ListNode<StatementNode> statements)
    {
        super();
        this.statements = statements;
    }

    /**
     * Gets the statements contained in this block statement.
     * @return The statements contained in this block statement.
     */
    public ListNode<StatementNode> getStatements()
    {
        return this.statements;
    }

    /**
     * Changes the statements contained in this block statement.
     * @param statements The statements contained in this block statement.
     */
    public void setStatements(ListNode<StatementNode> statements)
    {
        if (this.statements instanceof NodeImpl)
        {
            ((NodeImpl)this.statements).setParent(null);
        }
        this.statements = statements;
        if (this.statements instanceof NodeImpl)
        {
            ((NodeImpl)this.statements).setParent(this);
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
        this.statements.receive(visitor);
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
        list.add(this.statements);
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
        sb.append("statements=");
        sb.append(this.statements == null? "null" : this.statements.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
