package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

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
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface SuperMethodInvocationNode extends Node, RestrictedPrimaryExpressionNode, StatementExpressionNode
{
    /**
     * Gets the qualifying type.
     * @return The qualifying type.
     */
    public UnparameterizedTypeNode getType();

    /**
     * Changes the qualifying type.
     * @param type The qualifying type.
     */
    public void setType(UnparameterizedTypeNode type);

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
    public ExpressionListNode getArguments();

    /**
     * Changes the arguments to pass to the method.
     * @param arguments The arguments to pass to the method.
     */
    public void setArguments(ExpressionListNode arguments);

    /**
     * Gets the type arguments for the method.
     * @return The type arguments for the method.
     */
    public TypeListNode getTypeArguments();

    /**
     * Changes the type arguments for the method.
     * @param typeArguments The type arguments for the method.
     */
    public void setTypeArguments(TypeListNode typeArguments);

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public SuperMethodInvocationNode deepCopy(BsjNodeFactory factory);
}
