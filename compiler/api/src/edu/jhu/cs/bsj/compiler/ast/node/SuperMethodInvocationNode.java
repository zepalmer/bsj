package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing a method invocation from <tt>super</tt>, such as in the expression
 * <pre>
 * <tt>super.toString()</tt>
 * </pre>
 * In some cases, it is possible for <tt>super</tt> to be qualified with a type, such as in the following
 * convoluted example:
 * <pre>
 * public class A {
 *     public void foo() {
 *         System.out.println(0);
 *     }
 * }
 * public class B extends A {
 *     public void foo() {
 *         System.out.println(1);
 *     }
 *     public class C {
 *         public void foo() {
 *             B.super.foo();
 *         }
 *     }
 * }
 * </pre>
 * Calling the <tt>foo</tt> method on the <tt>B.C</tt> class would print <tt>0</tt> rather than <tt>1</tt> because
 * <tt>super</tt> is qualified with the enclosing class <tt>B</tt>.  Therefore, the method is invoked from the
 * enclosing instance's superclass (<tt>A</tt>) rather than the inner class's superclass (<tt>Object</tt>).  If a
 * type qualification is not necessary (and it usually won't be), <tt>type</tt> should be <tt>null</tt>.
 */
public interface SuperMethodInvocationNode extends Node, RestrictedPrimaryExpressionNode
{
    /**
     * Gets the qualifying type.
     * @return The qualifying type.
     */
    public RawTypeNode getType();

    /**
     * Changes the qualifying type.
     * @param type The qualifying type.
     */
    public void setType(RawTypeNode type);

    /**
     * Gets the identifier of the method being invoked.
     * @return The identifier of the method being invoked.
     */
    public IdentifierNode getIdentifier();

    /**
     * Changes the identifier of the method being invoked.
     * @param identifier The identifier of the method being invoked.
     */
    public void setIdentifier(IdentifierNode identifier);

    /**
     * Gets the arguments to pass to the method.
     * @return The arguments to pass to the method.
     */
    public ListNode<ExpressionNode> getArguments();

    /**
     * Changes the arguments to pass to the method.
     * @param arguments The arguments to pass to the method.
     */
    public void setArguments(ListNode<ExpressionNode> arguments);

    /**
     * Gets the type arguments for the method.
     * @return The type arguments for the method.
     */
    public ListNode<TypeNode> getTypeArguments();

    /**
     * Changes the type arguments for the method.
     * @param typeArguments The type arguments for the method.
     */
    public void setTypeArguments(ListNode<TypeNode> typeArguments);

}
