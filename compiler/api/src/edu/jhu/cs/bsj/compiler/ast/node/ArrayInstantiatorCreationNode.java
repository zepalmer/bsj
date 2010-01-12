package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents the creation of an array with instantiator, as in
 * <pre>
 * new <i>type</i> [<i>expression</i>]... []...
 * </pre>
 */
public interface ArrayInstantiatorCreationNode extends ArrayCreationNode
{
    /**
     * Gets the dimension expressions for this array.
     * @return The dimension expressions for this array.
     */
    public ListNode<? extends ExpressionNode> getDimExpressions();

    /**
     * Changes the dimension expressions for this array.
     * @param dimExpressions The dimension expressions for this array.
     */
    public void setDimExpressions(ListNode<? extends ExpressionNode> dimExpressions);

}
