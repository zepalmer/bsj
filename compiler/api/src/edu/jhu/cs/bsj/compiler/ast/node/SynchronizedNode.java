package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;

/**
 * A node to represent synchronization statements, as in:
 * <pre>
 * synchronized (<i>expr</i>) {
 *     ...
 * }
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface SynchronizedNode extends Node, StatementNode
{
    /**
     * Gets the synchronization expression.
     * @return The synchronization expression.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getExpression()throws ClassCastException;
    
    /**
     * Gets the union object for the synchronization expression.
     * @return A union object representing The synchronization expression.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForExpression();
    
    /**
     * Changes the synchronization expression.
     * @param expression The synchronization expression.
     */
    public void setExpression(ExpressionNode expression);
    
    /**
     * Changes the synchronization expression.
     * @param expression The synchronization expression.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForExpression(NodeUnion<? extends ExpressionNode> expression) throws NullPointerException;
    
    /**
     * Gets the block statements to synchronize.
     * @return The block statements to synchronize.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public BlockStatementListNode getBody()throws ClassCastException;
    
    /**
     * Gets the union object for the block statements to synchronize.
     * @return A union object representing The block statements to synchronize.
     */
    public NodeUnion<? extends BlockStatementListNode> getUnionForBody();
    
    /**
     * Changes the block statements to synchronize.
     * @param body The block statements to synchronize.
     */
    public void setBody(BlockStatementListNode body);
    
    /**
     * Changes the block statements to synchronize.
     * @param body The block statements to synchronize.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForBody(NodeUnion<? extends BlockStatementListNode> body) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public SynchronizedNode deepCopy(BsjNodeFactory factory);
    
}
