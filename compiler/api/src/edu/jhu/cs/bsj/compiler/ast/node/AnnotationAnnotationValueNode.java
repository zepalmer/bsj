package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * A value in an annotation which is another annotation.  This node is used for complex annotations, such as
 * <pre>@Foo(a=@Bar)</pre>
 * In the above snippet, this node would represent the
 * <pre>@Bar</pre>
 * portion.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
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

}
