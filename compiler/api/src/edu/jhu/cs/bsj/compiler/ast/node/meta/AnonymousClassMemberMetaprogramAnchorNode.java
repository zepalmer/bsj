package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassMemberNode;
import edu.jhu.cs.bsj.compiler.ast.node.BsjSpecificNode;

/**
 * A node representing a metaprogram found in an anonymous class body.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AnonymousClassMemberMetaprogramAnchorNode extends ExplicitMetaprogramAnchorNode<AnonymousClassMemberNode>, AnonymousClassMemberNode, BsjSpecificNode
{
    /**
     * Gets the type of node which can replace this anchor.
     * @return The type of node which can replace this anchor.
     */
    public Class<AnonymousClassMemberNode> getReplacementType();
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnonymousClassMemberMetaprogramAnchorNode deepCopy(BsjNodeFactory factory);
    
}
