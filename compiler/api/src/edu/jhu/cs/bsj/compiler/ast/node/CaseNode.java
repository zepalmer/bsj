package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * A node representing a switch's case block, as in:
 * <pre>
 * case <i>expression</i>:
 *     <i>statement</i>
 *     <i>...</i>
 * </pre>
 * or
 * <pre>
 * default:
 *     <i>statement</i>
 *     <i>...</i>
 * </pre>
 * If the switch label is <tt>default</tt>, <tt>expression</tt> is <tt>null</tt>. 
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
public interface CaseNode extends Node
{
    /**
     * Gets the expression used in this case label.
     * @return The expression used in this case label.
     */
    public ExpressionNode getExpression();

    /**
     * Changes the expression used in this case label.
     * @param expression The expression used in this case label.
     */
    public void setExpression(ExpressionNode expression);

    /**
     * Gets the statements to execute in this case node.
     * @return The statements to execute in this case node.
     */
    public ListNode<StatementNode> getStatements();

    /**
     * Changes the statements to execute in this case node.
     * @param statements The statements to execute in this case node.
     */
    public void setStatements(ListNode<StatementNode> statements);

}
