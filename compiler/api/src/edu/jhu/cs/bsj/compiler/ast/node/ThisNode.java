package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * A node representing the code snippet <tt>this</tt> in terms of a value, such as in the expression
 * <pre>
 * Object o = this;
 * </pre>
 * In some cases (especially in inner classes), <tt>this</tt> may be qualified with a type, such as in
 * <pre>
 * public class A {
 *     int x = 0;
 *     class B {
 *         int x = 0;
 *         public void foo() {
 *             A.this.x++;
 *         }
 *     }
 * }
 * </pre>
 * In that case, the <tt>type</tt> field contains the name of the qualified <tt>this</tt>.  Usually, <tt>this</tt>
 * is unqualified and the <tt>type</tt> field is <tt>null</tt>.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ThisNode extends Node, RestrictedPrimaryExpressionNode
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

}
