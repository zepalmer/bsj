package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;

/**
 * A node representing a switch's case block, as in:
 * <pre>
 * case <i>expression</i>:
 *     <i>statement</i>
 *     <i>...</i>
 * </pre>
 * or
 * <pre>
 * default:
 *     <i>statement</i>
 *     <i>...</i>
 * </pre>
 * If the switch label is <tt>default</tt>, <tt>expression</tt> is <tt>null</tt>. 
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface CaseNode extends Node
{
    /**
     * Gets the expression used in this case label.
     * @return The expression used in this case label.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getExpression() throws ClassCastException;
    
    /**
     * Gets the union object for the expression used in this case label.
     * @return A union object representing The expression used in this case label.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForExpression();
    
    /**
     * Changes the expression used in this case label.
     * @param expression The expression used in this case label.
     */
    public void setExpression(ExpressionNode expression);
    
    /**
     * Changes the expression used in this case label.
     * @param expression The expression used in this case label.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForExpression(NodeUnion<? extends ExpressionNode> expression) throws NullPointerException;
    
    /**
     * Gets the statements to execute in this case node.
     * @return The statements to execute in this case node.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public BlockStatementListNode getStatements() throws ClassCastException;
    
    /**
     * Gets the union object for the statements to execute in this case node.
     * @return A union object representing The statements to execute in this case node.
     */
    public NodeUnion<? extends BlockStatementListNode> getUnionForStatements();
    
    /**
     * Changes the statements to execute in this case node.
     * @param statements The statements to execute in this case node.
     */
    public void setStatements(BlockStatementListNode statements);
    
    /**
     * Changes the statements to execute in this case node.
     * @param statements The statements to execute in this case node.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForStatements(NodeUnion<? extends BlockStatementListNode> statements) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public CaseNode deepCopy(BsjNodeFactory factory);
    
}
