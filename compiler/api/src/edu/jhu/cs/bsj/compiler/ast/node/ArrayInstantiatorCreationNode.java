package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents the creation of an array with instantiator, as in
 * <pre>
 * new <i>type</i> [<i>expression</i>]... []...
 * </pre>
 * Levels for this array creator refer to square braces without initializers,
 * for example <code>new int[2][][]</code> would have two levels.
 */
public interface ArrayInstantiatorCreationNode extends ArrayCreationNode
{
    /**
     * Gets the dimension expressions for this array.
     * @return The dimension expressions for this array.
     */
    public ListNode<ExpressionNode> getDimExpressions();

    /**
     * Changes the dimension expressions for this array.
     * @param dimExpressions The dimension expressions for this array.
     */
    public void setDimExpressions(ListNode<ExpressionNode> dimExpressions);

}
