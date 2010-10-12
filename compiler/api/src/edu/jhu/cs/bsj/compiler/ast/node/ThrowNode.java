package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * A node to represent throw statements, as in:
 * <pre>
 * throw <i>expr</i>;
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ThrowNode extends Node, StatementNode
{
    /**
     * Gets the Throwable to throw.
     * @return The Throwable to throw.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getExpression()throws ClassCastException;
    
    /**
     * Gets the union object for the Throwable to throw.
     * @return A union object representing The Throwable to throw.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForExpression();
    
    /**
     * Changes the Throwable to throw.
     * @param expression The Throwable to throw.
     */
    public void setExpression(ExpressionNode expression);
    
    /**
     * Changes the Throwable to throw.
     * @param expression The Throwable to throw.
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
    public ThrowNode deepCopy(BsjNodeFactory factory);
    
}
