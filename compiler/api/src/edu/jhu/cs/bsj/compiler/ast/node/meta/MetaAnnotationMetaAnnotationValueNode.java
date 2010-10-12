package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
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
     * @throws ClassCastException If the value of this property is a special node.
     */
    public MetaAnnotationNode getAnnotation()throws ClassCastException;
    
    /**
     * Gets the union object for the annotation.
     * @return A union object representing The annotation.
     */
    public NodeUnion<? extends MetaAnnotationNode> getUnionForAnnotation();
    
    /**
     * Changes the annotation.
     * @param annotation The annotation.
     */
    public void setAnnotation(MetaAnnotationNode annotation);
    
    /**
     * Changes the annotation.
     * @param annotation The annotation.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForAnnotation(NodeUnion<? extends MetaAnnotationNode> annotation) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaAnnotationMetaAnnotationValueNode deepCopy(BsjNodeFactory factory);
    
}
