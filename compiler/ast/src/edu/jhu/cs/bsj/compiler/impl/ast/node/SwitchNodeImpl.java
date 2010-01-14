package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.CaseNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.SwitchNode;

public class SwitchNodeImpl extends NodeImpl implements SwitchNode
{
    /** The expression over which to switch. */
    private ExpressionNode expression;

    /** The cases in this switch. */
    private ListNode<CaseNode> cases;

    /** General constructor. */
    public SwitchNodeImpl(
            ExpressionNode expression,
            ListNode<CaseNode> cases)
    {
        super();
        this.expression = expression;
        this.cases = cases;
    }

    /**
     * Gets the expression over which to switch.
     * @return The expression over which to switch.
     */
    public ExpressionNode getExpression()
    {
        return this.expression;
    }

    /**
     * Changes the expression over which to switch.
     * @param expression The expression over which to switch.
     */
    public void setExpression(ExpressionNode expression)
    {
        if (this.expression instanceof NodeImpl)
        {
            ((NodeImpl)this.expression).setParent(null);
        }
        this.expression = expression;
        if (this.expression instanceof NodeImpl)
        {
            ((NodeImpl)this.expression).setParent(this);
        }
    }

    /**
     * Gets the cases in this switch.
     * @return The cases in this switch.
     */
    public ListNode<CaseNode> getCases()
    {
        return this.cases;
    }

    /**
     * Changes the cases in this switch.
     * @param cases The cases in this switch.
     */
    public void setCases(ListNode<CaseNode> cases)
    {
        if (this.cases instanceof NodeImpl)
        {
            ((NodeImpl)this.cases).setParent(null);
        }
        this.cases = cases;
        if (this.cases instanceof NodeImpl)
        {
            ((NodeImpl)this.cases).setParent(this);
        }
    }

    /**
     * Handles the visitation of this node's children for the provided visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        super.receiveToChildren(visitor);
        this.expression.receive(visitor);
        this.cases.receive(visitor);
    }

    /**
     * Produces a mutable list of this node's children.  Modifying this list will have no
     * effect on this node.
     * @return A list of this node's children.
     */
    @Override
    public List<Object> getChildObjects()
    {
        List<Object> list = super.getChildObjects();
        list.add(this.expression);
        list.add(this.cases);
        return list;
    }
}
