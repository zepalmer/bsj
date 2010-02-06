package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A node representing a for-loop, as in:
 * <pre>
 * for (<i>initializers</i>; <i>condition</i>; <i>updaters</i>)
 *     <i>body</i>
 * </pre>
 * If the loop has no initializers, the <tt>initializer</tt> field is <tt>null</tt>.  If the loop has no
 * updates, the <tt>update</tt> field is a {@link StatementExpressionListNode} with no children.  If the
 * loop has no termination condition, the <tt>condition</tt> field is <tt>null</tt>.  The <tt>update</tt>
 * field should never be <tt>null</tt>.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ForLoopNode extends Node, StatementNode
{
    /**
     * Gets the initializer used for this for loop.
     * @return The initializer used for this for loop.
     */
    public ForInitializerNode getInitializer();

    /**
     * Changes the initializer used for this for loop.
     * @param initializer The initializer used for this for loop.
     */
    public void setInitializer(ForInitializerNode initializer);

    /**
     * Gets the loop's termination condition.
     * @return The loop's termination condition.
     */
    public ExpressionNode getCondition();

    /**
     * Changes the loop's termination condition.
     * @param condition The loop's termination condition.
     */
    public void setCondition(ExpressionNode condition);

    /**
     * Gets the loop's update operation.
     * @return The loop's update operation.
     */
    public StatementExpressionListNode getUpdate();

    /**
     * Changes the loop's update operation.
     * @param update The loop's update operation.
     */
    public void setUpdate(StatementExpressionListNode update);

    /**
     * Gets the loop's statement.
     * @return The loop's statement.
     */
    public StatementNode getStatement();

    /**
     * Changes the loop's statement.
     * @param statement The loop's statement.
     */
    public void setStatement(StatementNode statement);

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ForLoopNode deepCopy(BsjNodeFactory factory);
}
