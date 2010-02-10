package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;

/**
 * Represents a list of {@link MetaprogramImportNode}s.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramImportListNode extends ListNode<MetaprogramImportNode>
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramImportListNode deepCopy(BsjNodeFactory factory);
}