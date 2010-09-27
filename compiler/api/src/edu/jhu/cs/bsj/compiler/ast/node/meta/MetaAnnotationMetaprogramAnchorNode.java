package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.BsjSpecificNode;

/**
 * A node representing a metaprogram attached to a meta-annotation.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaAnnotationMetaprogramAnchorNode extends MetaprogramAnchorNode<MetaAnnotationMetaprogramAnchorNode>, BsjSpecificNode
{
    /**
     * Gets the type of node which can replace this anchor.
     * @return The type of node which can replace this anchor.
     */
    public Class<MetaAnnotationMetaprogramAnchorNode> getReplacementType();
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaAnnotationMetaprogramAnchorNode deepCopy(BsjNodeFactory factory);
    
}
