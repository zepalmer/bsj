package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

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
     */
    public ExpressionNode getExpression();
    
    /**
     * Changes the expression to return.
     * @param expression The expression to return.
     */
    public void setExpression(ExpressionNode expression);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ReturnNode deepCopy(BsjNodeFactory factory);
    
}
