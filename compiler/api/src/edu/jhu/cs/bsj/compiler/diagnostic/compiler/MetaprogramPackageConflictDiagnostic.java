/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramPackageConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
/**
 * Indicates that two metaprograms are in conflict because of the manner in which they accessed the same
 * {@link ListNode}.  Note that this diagnostic has the ability to represent multiple failures
 * detected in a closure.  As a result, the anchors provided are merely advisory and represent one
 * of the possible conflicts contained within.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramPackageConflictDiagnostic extends MetaprogramConflictDiagnostic<MetaprogramPackageConflictException>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaprogram.failure.conflict.package";
    
    /**
     * Retrieves the conflicts which were detected.
     * @return The conflicts which were detected.
     */
    public Set<? extends edu.jhu.cs.bsj.compiler.ast.conflict.knowledge.ConflictKnowledge> getConflicts();
    
}
