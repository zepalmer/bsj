package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
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
     */
    public ExpressionNode getExpression();
    
    /**
     * Changes the synchronization expression.
     * @param expression The synchronization expression.
     */
    public void setExpression(ExpressionNode expression);
    
    /**
     * Gets the block statements to synchronize.
     * @return The block statements to synchronize.
     */
    public BlockStatementListNode getBody();
    
    /**
     * Changes the block statements to synchronize.
     * @param body The block statements to synchronize.
     */
    public void setBody(BlockStatementListNode body);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public SynchronizedNode deepCopy(BsjNodeFactory factory);
    
}
