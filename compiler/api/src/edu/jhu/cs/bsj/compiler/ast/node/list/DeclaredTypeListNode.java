package edu.jhu.cs.bsj.compiler.ast.node.list;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;

/**
 * Represents a list of {@link DeclaredTypeNode}s.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface DeclaredTypeListNode extends ListNode<DeclaredTypeNode>
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public DeclaredTypeListNode deepCopy(BsjNodeFactory factory);
    
}
