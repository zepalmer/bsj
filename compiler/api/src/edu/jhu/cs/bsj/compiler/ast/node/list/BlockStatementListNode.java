package edu.jhu.cs.bsj.compiler.ast.node.list;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.BlockStatementNode;

/**
 * Represents a list of {@link BlockStatementNode}s.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BlockStatementListNode extends ListNode<BlockStatementNode>
{
    /**
     * Gets whether or not this list's contents are always order-dependent.
     * @return Whether or not this list's contents are always order-dependent.
     */
    public boolean getAlwaysOrdered();
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public BlockStatementListNode deepCopy(BsjNodeFactory factory);
    
}
