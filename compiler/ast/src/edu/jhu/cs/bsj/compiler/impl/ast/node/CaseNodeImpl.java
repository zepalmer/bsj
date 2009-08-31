package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.CaseNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.StatementNode;

public class CaseNodeImpl extends NodeImpl implements CaseNode
{
    /** The expression used in this case label. */
    private ExpressionNode expression;

    /** The statements to execute in this case node. */
    private ListNode<? extends StatementNode> statements;

    /** General constructor. */
    public CaseNodeImpl(
            ExpressionNode expression,
            ListNode<? extends StatementNode> statements)
    {
        super();
        this.expression = expression;
        this.statements = statements;
    }

    /**
     * Gets the expression used in this case label.
     * @return The expression used in this case label.
     */
    public ExpressionNode getExpression()
    {
        return this.expression;
    }

    /**
     * Changes the expression used in this case label.
     * @param expression The expression used in this case label.
     */
    public void setExpression(ExpressionNode expression)
    {
        this.expression = expression;
    }

    /**
     * Gets the statements to execute in this case node.
     * @return The statements to execute in this case node.
     */
    public ListNode<? extends StatementNode> getStatements()
    {
        return this.statements;
    }

    /**
     * Changes the statements to execute in this case node.
     * @param statements The statements to execute in this case node.
     */
    public void setStatements(ListNode<? extends StatementNode> statements)
    {
        this.statements = statements;
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
