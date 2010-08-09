package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.BsjSpecificNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * A value in a meta-annotation which is another meta-annotation.  This node is used for complex
 * meta-annotations, such as
 * <pre>@@Foo(a=@@Bar)</pre>
 * In the above snippet, this node would represent the
 * <pre>@@Bar</pre>
 * portion.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaAnnotationMetaAnnotationValueNode extends Node, MetaAnnotationValueNode, BsjSpecificNode
{
    /**
     * Gets the annotation.
     * @return The annotation.
     */
    public MetaAnnotationNode getAnnotation();
    
    /**
     * Changes the annotation.
     * @param annotation The annotation.
     */
    public void setAnnotation(MetaAnnotationNode annotation);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaAnnotationMetaAnnotationValueNode deepCopy(BsjNodeFactory factory);
    
}
