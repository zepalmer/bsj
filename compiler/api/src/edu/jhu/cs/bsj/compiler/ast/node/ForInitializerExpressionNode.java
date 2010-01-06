package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents a for loop initializer which contains expressions.  For example, in
 * <pre>for (i=0,j=0;i<n || j<m;i++,j++)</pre>
 * this node represents
 * <pre>i=0,j=0</pre>
 */
public interface ForInitializerExpressionNode extends ForInitializerNode
{
    /**
     * Gets the expressions used in this initializer.
     * @return The expressions used in this initializer.
     */
    public ListNode<? extends ExpressionNode> getExpressions();

    /**
     * Changes the expressions used in this initializer.
     * @param expressions The expressions used in this initializer.
     */
    public void setExpressions(ListNode<? extends ExpressionNode> expressions);

}
