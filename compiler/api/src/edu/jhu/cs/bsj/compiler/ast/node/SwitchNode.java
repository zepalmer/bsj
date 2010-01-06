package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node to represent switch statements, as in:
 * <pre>
 * switch (<i>expr</i>) {
 *     case <i>value</i>:
 *     ...
 * }
 * </pre>
 */
public interface SwitchNode extends StatementNode
{
    /**
     * Gets expression over which to switch.
     * @return Expression over which to switch.
     */
    public ExpressionNode getExpression();

    /**
     * Changes expression over which to switch.
     * @param expression Expression over which to switch.
     */
    public void setExpression(ExpressionNode expression);

    /**
     * Gets the cases in this switch.
     * @return The cases in this switch.
     */
    public ListNode<? extends CaseNode> getCases();

    /**
     * Changes the cases in this switch.
     * @param cases The cases in this switch.
     */
    public void setCases(ListNode<? extends CaseNode> cases);

}
