package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents an annotation expression, as in
 * <pre>
 * <i>ident</i>=<i>expr</i>
 * </pre>
 */
public interface AnnotationValueNode extends Node
{
    /**
     * Gets the identifier.
     * @return The identifier.
     */
    public IdentifierNode getIdentifier();

    /**
     * Changes the identifier.
     * @param identifier The identifier.
     */
    public void setIdentifier(IdentifierNode identifier);

    /**
     * Gets the expression.
     * @return The expression.
     */
    public ExpressionNode getValue();

    /**
     * Changes the expression.
     * @param value The expression.
     */
    public void setValue(ExpressionNode value);

}
