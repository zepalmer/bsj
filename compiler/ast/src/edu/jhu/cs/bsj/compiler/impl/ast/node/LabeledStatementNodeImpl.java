package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.LabeledStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;

public class LabeledStatementNodeImpl extends StatementNodeImpl implements LabeledStatementNode
{
    /** The statement's label. */
    private IdentifierNode label;

    /** The statement being labeled. */
    private StatementNode statement;

    /** General constructor. */
    public LabeledStatementNodeImpl(
            IdentifierNode label,
            StatementNode statement)
    {
        super();
        this.label = label;
        this.statement = statement;
    }

    /**
     * Gets the statement's label.
     * @return The statement's label.
     */
    public IdentifierNode getLabel()
    {
        return this.label;
    }

    /**
     * Changes the statement's label.
     * @param label The statement's label.
     */
    public void setLabel(IdentifierNode label)
    {
        if (this.label instanceof NodeImpl)
        {
            ((NodeImpl)this.label).setParent(null);
        }
        this.label = label;
        if (this.label instanceof NodeImpl)
        {
            ((NodeImpl)this.label).setParent(this);
        }
    }

    /**
     * Gets the statement being labeled.
     * @return The statement being labeled.
     */
    public StatementNode getStatement()
    {
        return this.statement;
    }

    /**
     * Changes the statement being labeled.
     * @param statement The statement being labeled.
     */
    public void setStatement(StatementNode statement)
    {
        if (this.statement instanceof NodeImpl)
        {
            ((NodeImpl)this.statement).setParent(null);
        }
        this.statement = statement;
        if (this.statement instanceof NodeImpl)
        {
            ((NodeImpl)this.statement).setParent(this);
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
