package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationListNode;

/**
 * A node representing the modifiers applied to another node.  Modifiers may include flags (such as <tt>final</tt>
 * or <tt>strictfp</tt>) and annotations (such as <tt>@Override</tt>).  Subclasses of this node dictate precisely
 * which flags are permitted for their parent nodes.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ModifiersNode extends Node, MetaAnnotatableNode
{
    /**
     * Gets the meta-annotations modifying the subject.
     * @return The meta-annotations modifying the subject.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public MetaAnnotationListNode getMetaAnnotations()throws ClassCastException;
    
    /**
     * Gets the union object for the meta-annotations modifying the subject.
     * @return A union object representing The meta-annotations modifying the subject.
     */
    public NodeUnion<? extends MetaAnnotationListNode> getUnionForMetaAnnotations();
    
    /**
     * Changes the meta-annotations modifying the subject.
     * @param metaAnnotations The meta-annotations modifying the subject.
     */
    public void setMetaAnnotations(MetaAnnotationListNode metaAnnotations);
    
    /**
     * Changes the meta-annotations modifying the subject.
     * @param metaAnnotations The meta-annotations modifying the subject.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForMetaAnnotations(NodeUnion<? extends MetaAnnotationListNode> metaAnnotations) throws NullPointerException;
    
    /**
     * Gets the annotations modifying the subject.
     * @return The annotations modifying the subject.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public AnnotationListNode getAnnotations()throws ClassCastException;
    
    /**
     * Gets the union object for the annotations modifying the subject.
     * @return A union object representing The annotations modifying the subject.
     */
    public NodeUnion<? extends AnnotationListNode> getUnionForAnnotations();
    
    /**
     * Changes the annotations modifying the subject.
     * @param annotations The annotations modifying the subject.
     */
    public void setAnnotations(AnnotationListNode annotations);
    
    /**
     * Changes the annotations modifying the subject.
     * @param annotations The annotations modifying the subject.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForAnnotations(NodeUnion<? extends AnnotationListNode> annotations) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ModifiersNode deepCopy(BsjNodeFactory factory);
    
}
