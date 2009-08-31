package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing the instantiation of a class, as in:
 * <pre>
 * new <i>type</i>(<i>arg...</i>)
 * </pre>
 */
public interface ClassInstantiationNode extends ExpressionNode
{
    /**
     * Gets the type arguments of the instantiation.
     * @return The type arguments of the instantiation.
     */
    public ListNode<? extends TypeNode> getTypeArguments();

    /**
     * Changes the type arguments of the instantiation.
     * @param typeArguments The type arguments of the instantiation.
     */
    public void setTypeArguments(ListNode<? extends TypeNode> typeArguments);

    /**
     * Gets the identifier of the class.
     * @return The identifier of the class.
     */
    public NameNode getIdentifier();

    /**
     * Changes the identifier of the class.
     * @param identifier The identifier of the class.
     */
    public void setIdentifier(NameNode identifier);

    /**
     * Gets the arguments to the constructor.
     * @return The arguments to the constructor.
     */
    public ListNode<? extends ExpressionNode> getArguments();

    /**
     * Changes the arguments to the constructor.
     * @param arguments The arguments to the constructor.
     */
    public void setArguments(ListNode<? extends ExpressionNode> arguments);

    /**
     * Gets the body of the anonymous class.
     * @return The body of the anonymous class.
     */
    public ClassDeclarationNode getClassBody();

    /**
     * Changes the body of the anonymous class.
     * @param classBody The body of the anonymous class.
     */
    public void setClassBody(ClassDeclarationNode classBody);

    /**
     * Gets the expression enclosing the non-static inner class.
     * @return The expression enclosing the non-static inner class.
     */
    public ExpressionNode getEnclosingExpression();

    /**
     * Changes the expression enclosing the non-static inner class.
     * @param enclosingExpression The expression enclosing the non-static inner class.
     */
    public void setEnclosingExpression(ExpressionNode enclosingExpression);

}
