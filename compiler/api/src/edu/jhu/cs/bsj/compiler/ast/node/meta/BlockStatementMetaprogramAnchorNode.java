package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;

/**
 * A node representing a metaprogram as a block statement.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BlockStatementMetaprogramAnchorNode extends MetaprogramAnchorNode<BlockStatementNode>, BlockStatementNode
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public BlockStatementMetaprogramAnchorNode deepCopy(BsjNodeFactory factory);
}
