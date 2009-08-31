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
        this.label = label;
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
        this.statement = statement;
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
