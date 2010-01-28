package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A node representing labeled statements, as in:
 * <pre>
 * <i>identifier</i>: <i>statement</i>
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface LabeledStatementNode extends Node, StatementNode
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

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public LabeledStatementNode deepCopy(BsjNodeFactory factory);
}
