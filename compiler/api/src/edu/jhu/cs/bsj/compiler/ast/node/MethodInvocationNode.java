package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
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
     */
    public PrimaryExpressionNode getExpression();
    
    /**
     * Changes the expression against which to invoke the method.
     * @param expression The expression against which to invoke the method.
     */
    public void setExpression(PrimaryExpressionNode expression);
    
    /**
     * Gets the name of the method to invoke.
     * @return The name of the method to invoke.
     */
    public IdentifierNode getIdentifier();
    
    /**
     * Changes the name of the method to invoke.
     * @param identifier The name of the method to invoke.
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
    public ReferenceTypeListNode getTypeArguments();
    
    /**
     * Changes the type arguments for the method.
     * @param typeArguments The type arguments for the method.
     */
    public void setTypeArguments(ReferenceTypeListNode typeArguments);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MethodInvocationNode deepCopy(BsjNodeFactory factory);
    
}
