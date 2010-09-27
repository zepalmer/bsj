package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

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
     * @throws ClassCastException If the value of this property is a special node.
     */
    public UnparameterizedTypeNode getType() throws ClassCastException;
    
    /**
     * Gets the union object for the qualifying type.
     * @return A union object representing The qualifying type.
     */
    public NodeUnion<? extends UnparameterizedTypeNode> getUnionForType();
    
    /**
     * Changes the qualifying type.
     * @param type The qualifying type.
     */
    public void setType(UnparameterizedTypeNode type);
    
    /**
     * Changes the qualifying type.
     * @param type The qualifying type.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForType(NodeUnion<? extends UnparameterizedTypeNode> type) throws NullPointerException;
    
    /**
     * Gets the identifier of the field being accessed.
     * @return The identifier of the field being accessed.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public IdentifierNode getIdentifier() throws ClassCastException;
    
    /**
     * Gets the union object for the identifier of the field being accessed.
     * @return A union object representing The identifier of the field being accessed.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForIdentifier();
    
    /**
     * Changes the identifier of the field being accessed.
     * @param identifier The identifier of the field being accessed.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Changes the identifier of the field being accessed.
     * @param identifier The identifier of the field being accessed.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public SuperFieldAccessNode deepCopy(BsjNodeFactory factory);
    
}
