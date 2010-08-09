package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
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
     */
    public BlockStatementListNode getBody();
    
    /**
     * Changes the block statements to try.
     * @param body The block statements to try.
     */
    public void setBody(BlockStatementListNode body);
    
    /**
     * Gets the catch conditions.
     * @return The catch conditions.
     */
    public CatchListNode getCatches();
    
    /**
     * Changes the catch conditions.
     * @param catches The catch conditions.
     */
    public void setCatches(CatchListNode catches);
    
    /**
     * Gets the finally block.
     * @return The finally block.
     */
    public BlockStatementListNode getFinallyBlock();
    
    /**
     * Changes the finally block.
     * @param finallyBlock The finally block.
     */
    public void setFinallyBlock(BlockStatementListNode finallyBlock);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public TryNode deepCopy(BsjNodeFactory factory);
    
}
