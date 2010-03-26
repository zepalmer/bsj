package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;

/**
 * Acts as a base class for meta-annotation nodes.  Subclasses distinguish between the different types of
 * meta-annotation sugar.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaAnnotationNode extends Node
{
    /**
     * Gets the annotation type.
     * @return The annotation type.
     */
    public UnparameterizedTypeNode getAnnotationType();
    
    /**
     * Changes the annotation type.
     * @param annotationType The annotation type.
     */
    public void setAnnotationType(UnparameterizedTypeNode annotationType);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaAnnotationNode deepCopy(BsjNodeFactory factory);
}
