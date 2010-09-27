package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.BsjSpecificNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceMemberNode;

/**
 * A node representing a metaprogram found in an intereface body.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InterfaceMemberMetaprogramAnchorNode extends ExplicitMetaprogramAnchorNode<InterfaceMemberNode>, InterfaceMemberNode, BsjSpecificNode
{
    /**
     * Gets the type of node which can replace this anchor.
     * @return The type of node which can replace this anchor.
     */
    public Class<InterfaceMemberNode> getReplacementType();
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public InterfaceMemberMetaprogramAnchorNode deepCopy(BsjNodeFactory factory);
    
}
