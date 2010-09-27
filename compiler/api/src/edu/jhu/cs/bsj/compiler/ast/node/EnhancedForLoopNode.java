package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * A node representing a for-each loop, as in:
 * <pre>
 * for (<i>variable</i> : <i>expression</i>)
 *     <i>body</i>
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface EnhancedForLoopNode extends Node, StatementNode
{
    /**
     * Gets the iterator variable.
     * @return The iterator variable.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public VariableNode getVariable() throws ClassCastException;
    
    /**
     * Gets the union object for the iterator variable.
     * @return A union object representing The iterator variable.
     */
    public NodeUnion<? extends VariableNode> getUnionForVariable();
    
    /**
     * Changes the iterator variable.
     * @param variable The iterator variable.
     */
    public void setVariable(VariableNode variable);
    
    /**
     * Changes the iterator variable.
     * @param variable The iterator variable.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForVariable(NodeUnion<? extends VariableNode> variable) throws NullPointerException;
    
    /**
     * Gets the loop's iterable expression.
     * @return The loop's iterable expression.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getExpression() throws ClassCastException;
    
    /**
     * Gets the union object for the loop's iterable expression.
     * @return A union object representing The loop's iterable expression.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForExpression();
    
    /**
     * Changes the loop's iterable expression.
     * @param expression The loop's iterable expression.
     */
    public void setExpression(ExpressionNode expression);
    
    /**
     * Changes the loop's iterable expression.
     * @param expression The loop's iterable expression.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForExpression(NodeUnion<? extends ExpressionNode> expression) throws NullPointerException;
    
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
    public EnhancedForLoopNode deepCopy(BsjNodeFactory factory);
    
}
