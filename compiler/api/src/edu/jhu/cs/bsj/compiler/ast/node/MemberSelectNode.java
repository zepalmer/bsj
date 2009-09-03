package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing member selection, as in:
 * <pre>
 * <i>expr<i> . <i>identifier</i>
 * </pre>
 * Member select nodes are used to select members from expressions.  They are not used for chains of identifier
 * names as in package imports.  See {@link QualifiedNameNode}.
 */
public interface MemberSelectNode extends ExpressionNode
{
    /**
     * Gets the expression from which to select.
     * @return The expression from which to select.
     */
    public ExpressionNode getExpression();

    /**
     * Changes the expression from which to select.
     * @param expression The expression from which to select.
     */
    public void setExpression(ExpressionNode expression);

    /**
     * Gets the identifier to select.
     * @return The identifier to select.
     */
    public IdentifierNode getIdentifier();

    /**
     * Changes the identifier to select.
     * @param identifier The identifier to select.
     */
    public void setIdentifier(IdentifierNode identifier);

}
