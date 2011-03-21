/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramListConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
/**
 * Indicates that two metaprograms are in conflict because they attempted to insert different
 * order-dependent elements into the same position in a list.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramListConflictDiagnostic<N extends Node> extends MetaprogramConflictDiagnostic<MetaprogramListConflictException>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaprogram.failure.conflict.list";
    
    /**
     * Retrieves the list over which the metaprograms conflicted.
     * @return The list over which the metaprograms conflicted.
     */
    public ListNode<N> getList();
    
    /**
     * Retrieves the node which both metaprograms used as a reference point (or null for beginning or end).
     * @return The node which both metaprograms used as a reference point (or null for beginning or end).
     */
    public N getReference();
    
    /**
     * Retrieves true if the nodes added after the reference point; false if they added before.
     * @return True if the nodes added after the reference point; false if they added before.
     */
    public boolean getAfter();
    
    /**
     * Retrieves the node added by the first metaprogram.
     * @return The node added by the first metaprogram.
     */
    public N getElement();
    
}
