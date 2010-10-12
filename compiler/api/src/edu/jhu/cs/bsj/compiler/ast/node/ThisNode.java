package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

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
     * @throws ClassCastException If the value of this property is a special node.
     */
    public UnparameterizedTypeNode getType()throws ClassCastException;
    
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
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ThisNode deepCopy(BsjNodeFactory factory);
    
}
