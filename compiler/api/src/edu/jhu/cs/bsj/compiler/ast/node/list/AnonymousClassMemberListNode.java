package edu.jhu.cs.bsj.compiler.ast.node.list;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassMemberNode;

/**
 * Represents a list of {@link AnonymousClassMemberNode}s.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AnonymousClassMemberListNode extends ListNode<AnonymousClassMemberNode>
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnonymousClassMemberListNode deepCopy(BsjNodeFactory factory);
    
}
