package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

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

}
