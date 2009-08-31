package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents the invocation of the <tt>instanceof</tt> operator, as in:
 * <pre>
 * <i>expression</i> instanceof <i>type</i>
 * </pre>
 */
public interface InstanceOfNode extends ExpressionNode
{
    /**
     * Gets the expression being evaluated.
     * @return The expression being evaluated.
     */
    public ExpressionNode getExpression();

    /**
     * Changes the expression being evaluated.
     * @param expression The expression being evaluated.
     */
    public void setExpression(ExpressionNode expression);

    /**
     * Gets the type being checked.
     * @return The type being checked.
     */
    public TypeNode getType();

    /**
     * Changes the type being checked.
     * @param type The type being checked.
     */
    public void setType(TypeNode type);

}
