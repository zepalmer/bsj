package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * A node representing the modifiers applied to another node.  Modifiers may include flags (such as <tt>final</tt>
 * or <tt>strictfp</tt>) and annotations (such as <tt>@Override</tt>).  Subclasses of this node dictate precisely
 * which flags are permitted for their parent nodes.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ModifiersNode extends Node
{
    /**
     * Gets the annotations modifying the subject.
     * @return The annotations modifying the subject.
     */
    public ListNode<AnnotationNode> getAnnotations();

    /**
     * Changes the annotations modifying the subject.
     * @param annotations The annotations modifying the subject.
     */
    public void setAnnotations(ListNode<AnnotationNode> annotations);

}
