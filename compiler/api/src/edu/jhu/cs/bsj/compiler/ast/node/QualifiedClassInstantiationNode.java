package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing the qualified instantiation of a class, as in:
 * <pre>
 * <i>expr</i>.new <i>type</i>(<i>arg...</i>)
 * </pre>
 * For example, consider the following code:
 * <pre>
 * public class Example
 * {
 *     class A
 *     {
 *         class B
 *         {
 *         }
 *     }
 *     &nbsp;
 *     public void foo()
 *     {
 *         A a = new A();
 *         A.B b = a.new B(); // qualified instantiation
 *     }
 * }
 * </pre>
 */
public interface QualifiedClassInstantiationNode extends ClassInstantiationNode
{
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

    /**
     * Gets the name of the class being instantiated.
     * @return The name of the class being instantiated.
     */
    public IdentifierNode getIdentifier();

    /**
     * Changes the name of the class being instantiated.
     * @param identifier The name of the class being instantiated.
     */
    public void setIdentifier(IdentifierNode identifier);

    /**
     * Gets the type arguments to apply to the class being instantiated.
     * @return The type arguments to apply to the class being instantiated.
     */
    public ListNode<? extends TypeNode> getTypeArguments();

    /**
     * Changes the type arguments to apply to the class being instantiated.
     * @param typeArguments The type arguments to apply to the class being instantiated.
     */
    public void setTypeArguments(ListNode<? extends TypeNode> typeArguments);

}
