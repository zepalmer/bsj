package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing member selection, as in:
 * <pre>
 * <i>expr<i> . <i>identifier</i>
 * </pre>
 */
public interface MemberSelectNode extends NameNode
{
    /**
     * Gets the expression from which to select.
     * @return The expression from which to select.
     */
    public NameNode getExpression();

    /**
     * Changes the expression from which to select.
     * @param expression The expression from which to select.
     */
    public void setExpression(NameNode expression);

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
