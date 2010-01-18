package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * Represents a for loop initializer which contains expressions.  For example, in
 * <pre>for (i=0,j=0;i<n || j<m;i++,j++)</pre>
 * this node represents
 * <pre>i=0,j=0</pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ForInitializerExpressionNode extends Node, ForInitializerNode
{
    /**
     * Gets the expressions used in this initializer.
     * @return The expressions used in this initializer.
     */
    public ListNode<StatementExpressionNode> getExpressions();

    /**
     * Changes the expressions used in this initializer.
     * @param expressions The expressions used in this initializer.
     */
    public void setExpressions(ListNode<StatementExpressionNode> expressions);

}
