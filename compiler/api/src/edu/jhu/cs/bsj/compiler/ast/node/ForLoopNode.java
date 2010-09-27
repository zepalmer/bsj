package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.StatementExpressionListNode;

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
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ForInitializerNode getInitializer() throws ClassCastException;
    
    /**
     * Gets the union object for the initializer used for this for loop.
     * @return A union object representing The initializer used for this for loop.
     */
    public NodeUnion<? extends ForInitializerNode> getUnionForInitializer();
    
    /**
     * Changes the initializer used for this for loop.
     * @param initializer The initializer used for this for loop.
     */
    public void setInitializer(ForInitializerNode initializer);
    
    /**
     * Changes the initializer used for this for loop.
     * @param initializer The initializer used for this for loop.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForInitializer(NodeUnion<? extends ForInitializerNode> initializer) throws NullPointerException;
    
    /**
     * Gets the loop's termination condition.
     * @return The loop's termination condition.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getCondition() throws ClassCastException;
    
    /**
     * Gets the union object for the loop's termination condition.
     * @return A union object representing The loop's termination condition.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForCondition();
    
    /**
     * Changes the loop's termination condition.
     * @param condition The loop's termination condition.
     */
    public void setCondition(ExpressionNode condition);
    
    /**
     * Changes the loop's termination condition.
     * @param condition The loop's termination condition.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForCondition(NodeUnion<? extends ExpressionNode> condition) throws NullPointerException;
    
    /**
     * Gets the loop's update operation.
     * @return The loop's update operation.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public StatementExpressionListNode getUpdate() throws ClassCastException;
    
    /**
     * Gets the union object for the loop's update operation.
     * @return A union object representing The loop's update operation.
     */
    public NodeUnion<? extends StatementExpressionListNode> getUnionForUpdate();
    
    /**
     * Changes the loop's update operation.
     * @param update The loop's update operation.
     */
    public void setUpdate(StatementExpressionListNode update);
    
    /**
     * Changes the loop's update operation.
     * @param update The loop's update operation.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForUpdate(NodeUnion<? extends StatementExpressionListNode> update) throws NullPointerException;
    
    /**
     * Gets the loop's statement.
     * @return The loop's statement.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public StatementNode getStatement() throws ClassCastException;
    
    /**
     * Gets the union object for the loop's statement.
     * @return A union object representing The loop's statement.
     */
    public NodeUnion<? extends StatementNode> getUnionForStatement();
    
    /**
     * Changes the loop's statement.
     * @param statement The loop's statement.
     */
    public void setStatement(StatementNode statement);
    
    /**
     * Changes the loop's statement.
     * @param statement The loop's statement.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForStatement(NodeUnion<? extends StatementNode> statement) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ForLoopNode deepCopy(BsjNodeFactory factory);
    
}
