package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ReferenceTypeListNode;

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
     * Gets the identifier of the method being invoked.
     * @return The identifier of the method being invoked.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public IdentifierNode getIdentifier()throws ClassCastException;
    
    /**
     * Gets the union object for the identifier of the method being invoked.
     * @return A union object representing The identifier of the method being invoked.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForIdentifier();
    
    /**
     * Changes the identifier of the method being invoked.
     * @param identifier The identifier of the method being invoked.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Changes the identifier of the method being invoked.
     * @param identifier The identifier of the method being invoked.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier) throws NullPointerException;
    
    /**
     * Gets the arguments to pass to the method.
     * @return The arguments to pass to the method.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionListNode getArguments()throws ClassCastException;
    
    /**
     * Gets the union object for the arguments to pass to the method.
     * @return A union object representing The arguments to pass to the method.
     */
    public NodeUnion<? extends ExpressionListNode> getUnionForArguments();
    
    /**
     * Changes the arguments to pass to the method.
     * @param arguments The arguments to pass to the method.
     */
    public void setArguments(ExpressionListNode arguments);
    
    /**
     * Changes the arguments to pass to the method.
     * @param arguments The arguments to pass to the method.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForArguments(NodeUnion<? extends ExpressionListNode> arguments) throws NullPointerException;
    
    /**
     * Gets the type arguments for the method.
     * @return The type arguments for the method.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ReferenceTypeListNode getTypeArguments()throws ClassCastException;
    
    /**
     * Gets the union object for the type arguments for the method.
     * @return A union object representing The type arguments for the method.
     */
    public NodeUnion<? extends ReferenceTypeListNode> getUnionForTypeArguments();
    
    /**
     * Changes the type arguments for the method.
     * @param typeArguments The type arguments for the method.
     */
    public void setTypeArguments(ReferenceTypeListNode typeArguments);
    
    /**
     * Changes the type arguments for the method.
     * @param typeArguments The type arguments for the method.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForTypeArguments(NodeUnion<? extends ReferenceTypeListNode> typeArguments) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public SuperMethodInvocationNode deepCopy(BsjNodeFactory factory);
    
}
