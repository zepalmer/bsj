package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * A node representing an expression statement.  This allows expressions to be used as statements, as in
 * <pre>
 * foo();
 * </pre>
 * or
 * <pre>
 * x++;
 * </pre>
 * Note that not every expression can be used in Java as a statement.  For instance, <tt>~0</tt> and <tt>5+3</tt>
 * are not valid statements.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ExpressionStatementNode extends Node, StatementNode
{
    /**
     * Gets this statement's expression.
     * @return This statement's expression.
     */
    public StatementExpressionNode getExpression();

    /**
     * Changes this statement's expression.
     * @param expression This statement's expression.
     */
    public void setExpression(StatementExpressionNode expression);

}
