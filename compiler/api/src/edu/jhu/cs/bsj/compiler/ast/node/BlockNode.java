package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;

/**
 * Represents a block of statements, as in
 * <pre>
 * {
 *     <i>statement</i>
 *     <i>...</i>
 * }
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BlockNode extends Node, StatementNode
{
    /**
     * Gets the statements contained in this block statement.
     * @return The statements contained in this block statement.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public BlockStatementListNode getStatements() throws ClassCastException;
    
    /**
     * Gets the union object for the statements contained in this block statement.
     * @return A union object representing The statements contained in this block statement.
     */
    public NodeUnion<? extends BlockStatementListNode> getUnionForStatements();
    
    /**
     * Changes the statements contained in this block statement.
     * @param statements The statements contained in this block statement.
     */
    public void setStatements(BlockStatementListNode statements);
    
    /**
     * Changes the statements contained in this block statement.
     * @param statements The statements contained in this block statement.
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
    public BlockNode deepCopy(BsjNodeFactory factory);
    
}
