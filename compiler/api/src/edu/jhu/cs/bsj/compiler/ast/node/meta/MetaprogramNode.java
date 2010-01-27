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
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramNode extends Node
{
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
