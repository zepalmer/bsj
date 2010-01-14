package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node for typecast expressions, as in:
 * <pre>
 * (<i>type</i>) <i>expr</i>
 * </pre>
 */
public interface TypeCastNode extends Node, NonAssignmentExpressionNode
{
    /**
     * Gets the expression to cast.
     * @return The expression to cast.
     */
    public ExpressionNode getExpression();

    /**
     * Changes the expression to cast.
     * @param expression The expression to cast.
     */
    public void setExpression(ExpressionNode expression);

    /**
     * Gets the type to which to cast.
     * @return The type to which to cast.
     */
    public TypeNode getType();

    /**
     * Changes the type to which to cast.
     * @param type The type to which to cast.
     */
    public void setType(TypeNode type);

}
