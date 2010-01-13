package edu.jhu.cs.bsj.compiler.ast.node;

import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.Modifier;

/**
 * A node representing the modifiers applied to another node.  Modifiers may include flags (such as <tt>final</tt>
 * or <tt>strictfp</tt>) and annotations (such as <tt>@Override</tt>).
 */
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

    /**
     * Gets the modifiers set on the subject.
     * @return The modifiers set on the subject.
     */
    public Set<Modifier> getFlags();

    /**
     * Changes the modifiers set on the subject.
     * @param flags The modifiers set on the subject.
     */
    public void setFlags(Set<Modifier> flags);

}
