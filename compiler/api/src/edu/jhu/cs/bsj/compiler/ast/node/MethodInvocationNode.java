package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ReferenceTypeListNode;

/**
 * A node representing method invocation, as in:
 * <pre>
 * <i>identifier</i>(<i>arg...</i>)
 * </pre>
 * or
 * <pre>
 * <i>expr</i>.&lt;<i>typeArgs</i>&gt;<i>identifier</i>(<i>arg...</i>)
 * </pre>
 * For example, this node might be used when an expression produces an object against which we want to call a
 * method as in
 * <pre>
 * new Object().toString()
 * </pre>
 * or
 * <pre>
 * foo().bar()
 * </pre>
 * If a method is invoked without any qualifying expression or type such as in
 * <pre>
 * foo()
 * </pre>
 * then the <tt>expression</tt> field of the corresponding node is <tt>null</tt>.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MethodInvocationNode extends Node, RestrictedPrimaryExpressionNode, StatementExpressionNode
{
    /**
     * Gets the expression against which to invoke the method.
     * @return The expression against which to invoke the method.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public PrimaryExpressionNode getExpression()throws ClassCastException;
    
    /**
     * Gets the union object for the expression against which to invoke the method.
     * @return A union object representing The expression against which to invoke the method.
     */
    public NodeUnion<? extends PrimaryExpressionNode> getUnionForExpression();
    
    /**
     * Changes the expression against which to invoke the method.
     * @param expression The expression against which to invoke the method.
     */
    public void setExpression(PrimaryExpressionNode expression);
    
    /**
     * Changes the expression against which to invoke the method.
     * @param expression The expression against which to invoke the method.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForExpression(NodeUnion<? extends PrimaryExpressionNode> expression) throws NullPointerException;
    
    /**
     * Gets the name of the method to invoke.
     * @return The name of the method to invoke.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public IdentifierNode getIdentifier()throws ClassCastException;
    
    /**
     * Gets the union object for the name of the method to invoke.
     * @return A union object representing The name of the method to invoke.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForIdentifier();
    
    /**
     * Changes the name of the method to invoke.
     * @param identifier The name of the method to invoke.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Changes the name of the method to invoke.
     * @param identifier The name of the method to invoke.
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
    public MethodInvocationNode deepCopy(BsjNodeFactory factory);
    
}
