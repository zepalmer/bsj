package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.CaseNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.SwitchNode;

public class SwitchNodeImpl extends StatementNodeImpl implements SwitchNode
{
    /** The cases in this switch. */
    private ListNode<? extends CaseNode> cases;

    /** Expression over which to switch. */
    private ExpressionNode expression;

    /** General constructor. */
    public SwitchNodeImpl(
            ListNode<? extends CaseNode> cases,
            ExpressionNode expression)
    {
        super();
        this.cases = cases;
        this.expression = expression;
    }

    /**
     * Gets the cases in this switch.
     * @return The cases in this switch.
     */
    public ListNode<? extends CaseNode> getCases()
    {
        return this.cases;
    }

    /**
     * Changes the cases in this switch.
     * @param cases The cases in this switch.
     */
    public void setCases(ListNode<? extends CaseNode> cases)
    {
        this.cases = cases;
    }

    /**
     * Gets expression over which to switch.
     * @return Expression over which to switch.
     */
    public ExpressionNode getExpression()
    {
        return this.expression;
    }

    /**
     * Changes expression over which to switch.
     * @param expression Expression over which to switch.
     */
    public void setExpression(ExpressionNode expression)
    {
        this.expression = expression;
    }

    /**
     * Performs visitation for this node's children.
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        
    }
}
