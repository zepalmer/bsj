package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

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
     */
    public ExpressionNode getExpression();
    
    /**
     * Changes the Throwable to throw.
     * @param expression The Throwable to throw.
     */
    public void setExpression(ExpressionNode expression);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ThrowNode deepCopy(BsjNodeFactory factory);
}
