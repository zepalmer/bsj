package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A value in an annotation which is another annotation.  This node is used for complex annotations, such as
 * <pre>@Foo(a=@Bar)</pre>
 * In the above snippet, this node would represent the
 * <pre>@Bar</pre>
 * portion.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AnnotationAnnotationValueNode extends Node, AnnotationValueNode
{
    /**
     * Gets the annotation.
     * @return The annotation.
     */
    public AnnotationNode getAnnotation();
    
    /**
     * Changes the annotation.
     * @param annotation The annotation.
     */
    public void setAnnotation(AnnotationNode annotation);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnnotationAnnotationValueNode deepCopy(BsjNodeFactory factory);
    
}
