package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing a name evaluated as an expression, as in
 * <pre>
 * <i>expr</i>
 * </pre>
 * This is a very common form of expression.  For instance, this node would be present in the <tt>x</tt> portion of
 * all of the following:
 * <ul>
 * <li><tt>x</tt></li>
 * <li><tt>x[0]</tt></li>
 * <li><tt>foo(x)</tt></li>
 * </ul>
 */
public interface NameExpressionNode extends Node, ExpressionNode,  ArrayIndexableNode
{
    /**
     * Gets the name to evaluate for this expression.
     * @return The name to evaluate for this expression.
     */
    public NameNode getName();

    /**
     * Changes the name to evaluate for this expression.
     * @param name The name to evaluate for this expression.
     */
    public void setName(NameNode name);

}
