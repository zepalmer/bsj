package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * Represents an assert statement, as in
 * <pre>
 *     assert <i>expr</i>;
 * </pre>
 * or
 * <pre>
 *     assert <i>expr</i> : <i>expr</i>;
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AssertStatementNode extends Node, StatementNode
{
    /**
     * Gets the assertion's test expression.
     * @return The assertion's test expression.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getTestExpression() throws ClassCastException;
    
    /**
     * Gets the union object for the assertion's test expression.
     * @return A union object representing The assertion's test expression.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForTestExpression();
    
    /**
     * Changes the assertion's test expression.
     * @param testExpression The assertion's test expression.
     */
    public void setTestExpression(ExpressionNode testExpression);
    
    /**
     * Changes the assertion's test expression.
     * @param testExpression The assertion's test expression.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForTestExpression(NodeUnion<? extends ExpressionNode> testExpression) throws NullPointerException;
    
    /**
     * Gets the assertion's message expression.
     * @return The assertion's message expression.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getMessageExpression() throws ClassCastException;
    
    /**
     * Gets the union object for the assertion's message expression.
     * @return A union object representing The assertion's message expression.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForMessageExpression();
    
    /**
     * Changes the assertion's message expression.
     * @param messageExpression The assertion's message expression.
     */
    public void setMessageExpression(ExpressionNode messageExpression);
    
    /**
     * Changes the assertion's message expression.
     * @param messageExpression The assertion's message expression.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForMessageExpression(NodeUnion<? extends ExpressionNode> messageExpression) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AssertStatementNode deepCopy(BsjNodeFactory factory);
    
}
