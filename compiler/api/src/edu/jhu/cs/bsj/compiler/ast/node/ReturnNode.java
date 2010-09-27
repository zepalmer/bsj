package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * A node representing a return statement, as in;
 * <pre>return <i>expr</i>;</pre>
 * or
 * <pre>return;</pre>
 * For void return statements, the <tt>expression</tt> is <tt>null</tt>.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ReturnNode extends Node, StatementNode
{
    /**
     * Gets the expression to return.
     * @return The expression to return.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getExpression() throws ClassCastException;
    
    /**
     * Gets the union object for the expression to return.
     * @return A union object representing The expression to return.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForExpression();
    
    /**
     * Changes the expression to return.
     * @param expression The expression to return.
     */
    public void setExpression(ExpressionNode expression);
    
    /**
     * Changes the expression to return.
     * @param expression The expression to return.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForExpression(NodeUnion<? extends ExpressionNode> expression) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ReturnNode deepCopy(BsjNodeFactory factory);
    
}
