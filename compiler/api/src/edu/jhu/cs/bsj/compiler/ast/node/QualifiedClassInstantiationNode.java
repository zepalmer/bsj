package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeArgumentListNode;

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
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface QualifiedClassInstantiationNode extends ClassInstantiationNode
{
    /**
     * Gets the expression enclosing the non-static inner class.
     * @return The expression enclosing the non-static inner class.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getEnclosingExpression() throws ClassCastException;
    
    /**
     * Gets the union object for the expression enclosing the non-static inner class.
     * @return A union object representing The expression enclosing the non-static inner class.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForEnclosingExpression();
    
    /**
     * Changes the expression enclosing the non-static inner class.
     * @param enclosingExpression The expression enclosing the non-static inner class.
     */
    public void setEnclosingExpression(ExpressionNode enclosingExpression);
    
    /**
     * Changes the expression enclosing the non-static inner class.
     * @param enclosingExpression The expression enclosing the non-static inner class.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForEnclosingExpression(NodeUnion<? extends ExpressionNode> enclosingExpression) throws NullPointerException;
    
    /**
     * Gets the name of the class being instantiated.
     * @return The name of the class being instantiated.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public IdentifierNode getIdentifier() throws ClassCastException;
    
    /**
     * Gets the union object for the name of the class being instantiated.
     * @return A union object representing The name of the class being instantiated.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForIdentifier();
    
    /**
     * Changes the name of the class being instantiated.
     * @param identifier The name of the class being instantiated.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Changes the name of the class being instantiated.
     * @param identifier The name of the class being instantiated.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier) throws NullPointerException;
    
    /**
     * Gets the type arguments to apply to the class being instantiated.
     * @return The type arguments to apply to the class being instantiated.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public TypeArgumentListNode getTypeArguments() throws ClassCastException;
    
    /**
     * Gets the union object for the type arguments to apply to the class being instantiated.
     * @return A union object representing The type arguments to apply to the class being instantiated.
     */
    public NodeUnion<? extends TypeArgumentListNode> getUnionForTypeArguments();
    
    /**
     * Changes the type arguments to apply to the class being instantiated.
     * @param typeArguments The type arguments to apply to the class being instantiated.
     */
    public void setTypeArguments(TypeArgumentListNode typeArguments);
    
    /**
     * Changes the type arguments to apply to the class being instantiated.
     * @param typeArguments The type arguments to apply to the class being instantiated.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForTypeArguments(NodeUnion<? extends TypeArgumentListNode> typeArguments) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public QualifiedClassInstantiationNode deepCopy(BsjNodeFactory factory);
    
}
