package edu.jhu.cs.bsj.compiler.ast.exception;

import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramListConflictDiagnostic;

/**
 * Indicates that two metaprograms are in conflict because of the manner in which they accessed the same
 * {@link ListNode}.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class MetaprogramListConflictException extends MetaprogramConflictException
{
    private static final long serialVersionUID = 1L;
    
    /** The conflicts which were detected. */
    private Set<? extends ListKnowledge<?>> conflicts;
    
    public MetaprogramListConflictException(
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            Set<? extends ListKnowledge<?>> conflicts)
    {
        super(firstAnchor, secondAnchor, conflictNode);
        this.conflicts = conflicts;
    }
    
    /**
     * Retrieves the conflicts which were detected.
     * @return The conflicts which were detected.
     */
    public Set<? extends ListKnowledge<?>> getConflicts()
    {
        return this.conflicts;
    }
    
    /**
     * Creates a {@link BsjDiagnostic} corresponding to this exception type.
     * @param location The source location to report as the cause for the diagnostic.
     * @return A suitable diagnostic.
     */
    public abstract MetaprogramListConflictDiagnostic getDiagnostic(BsjSourceLocation location);
}
