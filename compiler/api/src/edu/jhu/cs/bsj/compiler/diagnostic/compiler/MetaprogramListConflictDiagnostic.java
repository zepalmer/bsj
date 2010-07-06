package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramListConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;
/**
 * Indicates that two metaprograms are in conflict because of the manner in which they accessed the same
 * {@link ListNode}.
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
    public Set<? extends ListKnowledge<?>> getConflicts();
    
}
