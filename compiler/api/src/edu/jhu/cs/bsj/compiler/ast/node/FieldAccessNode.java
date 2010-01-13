package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents a field access, as in
 * <pre>
 * <i>expr</i> . <i>field</i>
 * </pre>
 * One example of field access is
 * <pre>
 * new int[1].length
 * </pre>
 */
public interface FieldAccessNode extends Node, RestrictedPrimaryExpressionNode
{
    /**
     * Gets the expression from which the field is being selected.
     * @return The expression from which the field is being selected.
     */
    public PrimaryExpressionNode getExpression();

    /**
     * Changes the expression from which the field is being selected.
     * @param expression The expression from which the field is being selected.
     */
    public void setExpression(PrimaryExpressionNode expression);

    /**
     * Gets the name of the field.
     * @return The name of the field.
     */
    public IdentifierNode getIdentifier();

    /**
     * Changes the name of the field.
     * @param identifier The name of the field.
     */
    public void setIdentifier(IdentifierNode identifier);

}
