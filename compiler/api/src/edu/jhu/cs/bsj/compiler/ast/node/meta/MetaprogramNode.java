package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementListNode;
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
     * Gets the preamble statements for this metaprogram.
     * @return The preamble statements for this metaprogram.
     */
    public MetaprogramPreambleListNode getPreamble();

    /**
     * Changes the preamble statements for this metaprogram.
     * @param preamble The preamble statements for this metaprogram.
     */
    public void setPreamble(MetaprogramPreambleListNode preamble);

    /**
     * Gets the list of statements in the metaprogram's body.
     * @return The list of statements in the metaprogram's body.
     */
    public BlockStatementListNode getBody();

    /**
     * Changes the list of statements in the metaprogram's body.
     * @param body The list of statements in the metaprogram's body.
     */
    public void setBody(BlockStatementListNode body);

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramNode deepCopy(BsjNodeFactory factory);
}
