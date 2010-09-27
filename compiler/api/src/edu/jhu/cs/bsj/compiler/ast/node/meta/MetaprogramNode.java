package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.BsjSpecificNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;

/**
 * A node for metaprograms, as in
 * <pre>
 * [: <i>statement...</i> :]
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramNode extends Node, BsjSpecificNode
{
    /**
     * Gets the preamble for this metaprogram.
     * @return The preamble for this metaprogram.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public MetaprogramPreambleNode getPreamble() throws ClassCastException;
    
    /**
     * Gets the union object for the preamble for this metaprogram.
     * @return A union object representing The preamble for this metaprogram.
     */
    public NodeUnion<? extends MetaprogramPreambleNode> getUnionForPreamble();
    
    /**
     * Changes the preamble for this metaprogram.
     * @param preamble The preamble for this metaprogram.
     */
    public void setPreamble(MetaprogramPreambleNode preamble);
    
    /**
     * Changes the preamble for this metaprogram.
     * @param preamble The preamble for this metaprogram.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForPreamble(NodeUnion<? extends MetaprogramPreambleNode> preamble) throws NullPointerException;
    
    /**
     * Gets the list of statements in the metaprogram's body.
     * @return The list of statements in the metaprogram's body.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public BlockStatementListNode getBody() throws ClassCastException;
    
    /**
     * Gets the union object for the list of statements in the metaprogram's body.
     * @return A union object representing The list of statements in the metaprogram's body.
     */
    public NodeUnion<? extends BlockStatementListNode> getUnionForBody();
    
    /**
     * Changes the list of statements in the metaprogram's body.
     * @param body The list of statements in the metaprogram's body.
     */
    public void setBody(BlockStatementListNode body);
    
    /**
     * Changes the list of statements in the metaprogram's body.
     * @param body The list of statements in the metaprogram's body.
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
    public MetaprogramNode deepCopy(BsjNodeFactory factory);
    
}
