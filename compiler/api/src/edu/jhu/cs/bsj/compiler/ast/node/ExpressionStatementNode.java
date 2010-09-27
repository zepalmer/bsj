package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * A node representing an expression statement.  This allows expressions to be used as statements, as in
 * <pre>
 * foo();
 * </pre>
 * or
 * <pre>
 * x++;
 * </pre>
 * Note that not every expression can be used in Java as a statement.  For instance, <tt>~0</tt> and <tt>5+3</tt>
 * are not valid statements.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ExpressionStatementNode extends Node, StatementNode
{
    /**
     * Gets this statement's expression.
     * @return This statement's expression.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public StatementExpressionNode getExpression() throws ClassCastException;
    
    /**
     * Gets the union object for this statement's expression.
     * @return A union object representing This statement's expression.
     */
    public NodeUnion<? extends StatementExpressionNode> getUnionForExpression();
    
    /**
     * Changes this statement's expression.
     * @param expression This statement's expression.
     */
    public void setExpression(StatementExpressionNode expression);
    
    /**
     * Changes this statement's expression.
     * @param expression This statement's expression.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForExpression(NodeUnion<? extends StatementExpressionNode> expression) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ExpressionStatementNode deepCopy(BsjNodeFactory factory);
    
}
