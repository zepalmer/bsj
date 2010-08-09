package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;

/**
 * This tagging interface describes nodes which may be meta-annotated.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaAnnotatableNode extends Node
{
    /**
     * Gets the meta-annotations associated with this node.
     * @return The meta-annotations associated with this node.
     */
    public MetaAnnotationListNode getMetaAnnotations();
    
    /**
     * Changes the meta-annotations associated with this node.
     * @param metaAnnotations The meta-annotations associated with this node.
     */
    public void setMetaAnnotations(MetaAnnotationListNode metaAnnotations);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaAnnotatableNode deepCopy(BsjNodeFactory factory);
    
}
