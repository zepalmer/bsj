package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;

/**
 * A node representing a catch block, as in
 * <pre>
 * catch (<i>type identifier</i>) {
 *     <i>statement</i>
 *     ...
 * }
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface CatchNode extends Node
{
    /**
     * Gets the block statements to try.
     * @return The block statements to try.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public BlockStatementListNode getBody()throws ClassCastException;
    
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
     * Gets this catch block's exception variable.
     * @return This catch block's exception variable.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public VariableNode getParameter()throws ClassCastException;
    
    /**
     * Gets the union object for this catch block's exception variable.
     * @return A union object representing This catch block's exception variable.
     */
    public NodeUnion<? extends VariableNode> getUnionForParameter();
    
    /**
     * Changes this catch block's exception variable.
     * @param parameter This catch block's exception variable.
     */
    public void setParameter(VariableNode parameter);
    
    /**
     * Changes this catch block's exception variable.
     * @param parameter This catch block's exception variable.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForParameter(NodeUnion<? extends VariableNode> parameter) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public CatchNode deepCopy(BsjNodeFactory factory);
    
}
