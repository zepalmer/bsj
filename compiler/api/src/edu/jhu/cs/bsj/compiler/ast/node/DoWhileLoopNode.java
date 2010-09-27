package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * A node representing a do-while loop, as in:
 * <pre>
 * do <i>body</i> while (<i>condition</i>);
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface DoWhileLoopNode extends Node, StatementNode
{
    /**
     * Gets the loop's condition.
     * @return The loop's condition.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getCondition() throws ClassCastException;
    
    /**
     * Gets the union object for the loop's condition.
     * @return A union object representing The loop's condition.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForCondition();
    
    /**
     * Changes the loop's condition.
     * @param condition The loop's condition.
     */
    public void setCondition(ExpressionNode condition);
    
    /**
     * Changes the loop's condition.
     * @param condition The loop's condition.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForCondition(NodeUnion<? extends ExpressionNode> condition) throws NullPointerException;
    
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
    public DoWhileLoopNode deepCopy(BsjNodeFactory factory);
    
}
