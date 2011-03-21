/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.ast.exception;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramListConflictDiagnostic;

/**
 * Indicates that two metaprograms are in conflict because they attempted to insert different
 * order-dependent elements into the same position in a list.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class MetaprogramListConflictException extends MetaprogramConflictException
{
    private static final long serialVersionUID = 1L;
    
    /** The list over which the metaprograms conflicted. */
    private ListNode<? extends Node> list;
    
    /** The node which both metaprograms used as a reference point (or null for beginning or end). */
    private Node reference;
    
    /** True if the nodes added after the reference point; false if they added before. */
    private boolean after;
    
    /** The node added by the first metaprogram. */
    private Node element;
    
    public MetaprogramListConflictException(
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            ListNode<? extends Node> list,
            Node reference,
            boolean after,
            Node element)
    {
        super(firstAnchor, secondAnchor, conflictNode);
        this.list = list;
        this.reference = reference;
        this.after = after;
        this.element = element;
    }
    
    /**
     * Retrieves the list over which the metaprograms conflicted.
     * @return The list over which the metaprograms conflicted.
     */
    public ListNode<? extends Node> getList()
    {
        return this.list;
    }
    
    /**
     * Retrieves the node which both metaprograms used as a reference point (or null for beginning or end).
     * @return The node which both metaprograms used as a reference point (or null for beginning or end).
     */
    public Node getReference()
    {
        return this.reference;
    }
    
    /**
     * Retrieves true if the nodes added after the reference point; false if they added before.
     * @return True if the nodes added after the reference point; false if they added before.
     */
    public boolean getAfter()
    {
        return this.after;
    }
    
    /**
     * Retrieves the node added by the first metaprogram.
     * @return The node added by the first metaprogram.
     */
    public Node getElement()
    {
        return this.element;
    }
    
    /**
     * Creates a {@link BsjDiagnostic} corresponding to this exception type.
     * @param location The source location to report as the cause for the diagnostic.
     * @return A suitable diagnostic.
     */
    public abstract MetaprogramListConflictDiagnostic<?> getDiagnostic(BsjSourceLocation location);
}
