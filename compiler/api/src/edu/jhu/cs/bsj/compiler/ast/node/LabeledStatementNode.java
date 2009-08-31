package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing labeled statements, as in:
 * <pre>
 * <i>identifier</i>: <i>statement</i>
 * </pre>
 */
public interface LabeledStatementNode extends StatementNode
{
    /**
     * Gets the statement's label.
     * @return The statement's label.
     */
    public IdentifierNode getLabel();

    /**
     * Changes the statement's label.
     * @param label The statement's label.
     */
    public void setLabel(IdentifierNode label);

    /**
     * Gets the statement being labeled.
     * @return The statement being labeled.
     */
    public StatementNode getStatement();

    /**
     * Changes the statement being labeled.
     * @param statement The statement being labeled.
     */
    public void setStatement(StatementNode statement);

}
