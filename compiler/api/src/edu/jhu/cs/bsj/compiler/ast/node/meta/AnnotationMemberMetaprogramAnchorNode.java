package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationMemberNode;

/**
 * A node representing a metaprogram found in an annotation declaration.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AnnotationMemberMetaprogramAnchorNode extends MetaprogramAnchorNode<AnnotationMemberNode>, AnnotationMemberNode
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnnotationMemberMetaprogramAnchorNode deepCopy(BsjNodeFactory factory);
}
