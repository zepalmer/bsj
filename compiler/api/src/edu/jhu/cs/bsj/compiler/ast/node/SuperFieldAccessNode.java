package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A node representing a field selection from <tt>super</tt>, such as in the expression
 * <pre>
 * <tt>super.myvar</tt>
 * </pre>
 * In some cases, it is possible for <tt>super</tt> to be qualified with a type, such as in the following
 * convoluted example:
 * <pre>
 * public class A {
 *     protected int x = 0;
 * }
 * public class B extends A {
 *     protected int x = 1;
 *     public class C {
 *         public void foo() {
 *             System.out.println(B.super.x);
 *         }
 *     }
 * }
 * </pre>
 * Calling the <tt>foo</tt> method on the <tt>B.C</tt> class would print <tt>0</tt> rather than <tt>1</tt> because
 * <tt>super</tt> is qualified with the enclosing class <tt>B</tt>.  Therefore, the field is selected from the
 * enclosing instance's superclass (<tt>A</tt>) rather than the inner class's superclass (<tt>Object</tt>).  If a
 * type qualification is not necessary (and it usually won't be), <tt>type</tt> should be <tt>null</tt>.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface SuperFieldAccessNode extends Node, RestrictedPrimaryExpressionNode
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
     * Gets the identifier of the field being accessed.
     * @return The identifier of the field being accessed.
     */
    public IdentifierNode getIdentifier();
    
    /**
     * Changes the identifier of the field being accessed.
     * @param identifier The identifier of the field being accessed.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public SuperFieldAccessNode deepCopy(BsjNodeFactory factory);
}
