package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.CatchListNode;

/**
 * A node to represent a try-catch block, as in:
 * <pre>
 * try { <i>statement</i> ... }
 * catch (<i>type name</i>) { <i>statement</i> ... }
 * </pre>
 * or
 * <pre>
 * try <i>block</i>
 * catch (<i>type name</i>) { <i>statement</i> ... }
 * catch (<i>type name</i>) { <i>statement</i> ... }
 * finally { <i>statement</i> ... }
 * </pre>
 * If no catch block exists, the <tt>catches</tt> list node will contain no children.  If no finally block exists,
 * <tt>finally</tt> will contain no children.  At least one of these two lists must be non-empty.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface TryNode extends Node, StatementNode
{
    /**
     * Gets the block statements to try.
     * @return The block statements to try.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public BlockStatementListNode getBody() throws ClassCastException;
    
    /**
     * Gets the union object for the block statements to try.
     * @return A union object representing The block statements to try.
     */
    public NodeUnion<? extends BlockStatementListNode> getUnionForBody();
    
    /**
     * Changes the block statements to try.
     * @param body The block statements to try.
     */
    public void setBody(BlockStatementListNode body);
    
    /**
     * Changes the block statements to try.
     * @param body The block statements to try.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForBody(NodeUnion<? extends BlockStatementListNode> body) throws NullPointerException;
    
    /**
     * Gets the catch conditions.
     * @return The catch conditions.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public CatchListNode getCatches() throws ClassCastException;
    
    /**
     * Gets the union object for the catch conditions.
     * @return A union object representing The catch conditions.
     */
    public NodeUnion<? extends CatchListNode> getUnionForCatches();
    
    /**
     * Changes the catch conditions.
     * @param catches The catch conditions.
     */
    public void setCatches(CatchListNode catches);
    
    /**
     * Changes the catch conditions.
     * @param catches The catch conditions.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForCatches(NodeUnion<? extends CatchListNode> catches) throws NullPointerException;
    
    /**
     * Gets the finally block.
     * @return The finally block.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public BlockStatementListNode getFinallyBlock() throws ClassCastException;
    
    /**
     * Gets the union object for the finally block.
     * @return A union object representing The finally block.
     */
    public NodeUnion<? extends BlockStatementListNode> getUnionForFinallyBlock();
    
    /**
     * Changes the finally block.
     * @param finallyBlock The finally block.
     */
    public void setFinallyBlock(BlockStatementListNode finallyBlock);
    
    /**
     * Changes the finally block.
     * @param finallyBlock The finally block.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForFinallyBlock(NodeUnion<? extends BlockStatementListNode> finallyBlock) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public TryNode deepCopy(BsjNodeFactory factory);
    
}
