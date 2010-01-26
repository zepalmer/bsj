package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * A node for metaprograms, as in
 * <pre>
 * [: <i>statement...</i> :]
 * </pre>
 * The replacement field on this node is used to indicate the node with which this node will be replaced once the
 * execution of this metaprogram terminates.  This is initially defaulted to a no-op.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramNode<T extends Node> extends Node
{
    /**
     * Gets the replacement node for this metaprogram.
     * @return The replacement node for this metaprogram.
     */
    public T getReplacement();

    /**
     * Gets the list of statements in the metaprogram's body.
     * @return The list of statements in the metaprogram's body.
     */
    public ListNode<BlockStatementNode> getBody();

    /**
     * Changes the list of statements in the metaprogram's body.
     * @param body The list of statements in the metaprogram's body.
     */
    public void setBody(ListNode<BlockStatementNode> body);

}
