package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramListConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ConflictKnowledge;
/**
 * Indicates that two metaprograms are in conflict because of the manner in which they accessed the same
 * {@link ListNode}.  Note that this diagnostic has the ability to represent multiple failures
 * detected in a closure.  As a result, the anchors provided are merely advisory and represent one
 * of the possible conflicts contained within.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramListConflictDiagnostic extends MetaprogramConflictDiagnostic<MetaprogramListConflictException>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaprogram.failure.conflict.list";
    
    /**
     * Retrieves the conflicts which were detected.
     * @return The conflicts which were detected.
     */
    public Set<? extends ConflictKnowledge<?>> getConflicts();
    
}
