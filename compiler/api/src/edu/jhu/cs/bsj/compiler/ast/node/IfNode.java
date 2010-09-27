package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * A node representing an if-then-else statement, as in:
 * <pre>
 * if (<i>condition</i>) then <i>statement</i> else <i>statement</i>
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface IfNode extends Node, StatementNode
{
    /**
     * Gets the condition.
     * @return The condition.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getCondition() throws ClassCastException;
    
    /**
     * Gets the union object for the condition.
     * @return A union object representing The condition.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForCondition();
    
    /**
     * Changes the condition.
     * @param condition The condition.
     */
    public void setCondition(ExpressionNode condition);
    
    /**
     * Changes the condition.
     * @param condition The condition.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForCondition(NodeUnion<? extends ExpressionNode> condition) throws NullPointerException;
    
    /**
     * Gets the then branch's statement.
     * @return The then branch's statement.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public StatementNode getThenStatement() throws ClassCastException;
    
    /**
     * Gets the union object for the then branch's statement.
     * @return A union object representing The then branch's statement.
     */
    public NodeUnion<? extends StatementNode> getUnionForThenStatement();
    
    /**
     * Changes the then branch's statement.
     * @param thenStatement The then branch's statement.
     */
    public void setThenStatement(StatementNode thenStatement);
    
    /**
     * Changes the then branch's statement.
     * @param thenStatement The then branch's statement.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForThenStatement(NodeUnion<? extends StatementNode> thenStatement) throws NullPointerException;
    
    /**
     * Gets the else branch's statement.
     * @return The else branch's statement.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public StatementNode getElseStatement() throws ClassCastException;
    
    /**
     * Gets the union object for the else branch's statement.
     * @return A union object representing The else branch's statement.
     */
    public NodeUnion<? extends StatementNode> getUnionForElseStatement();
    
    /**
     * Changes the else branch's statement.
     * @param elseStatement The else branch's statement.
     */
    public void setElseStatement(StatementNode elseStatement);
    
    /**
     * Changes the else branch's statement.
     * @param elseStatement The else branch's statement.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForElseStatement(NodeUnion<? extends StatementNode> elseStatement) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public IfNode deepCopy(BsjNodeFactory factory);
    
}
