/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.ast.exception;

import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramPackageConflictDiagnostic;

/**
 * Indicates that two metaprograms are in conflict because of the manner in which they accessed the same
 * {@link ListNode}.  Note that this diagnostic has the ability to represent multiple failures
 * detected in a closure.  As a result, the anchors provided are merely advisory and represent one
 * of the possible conflicts contained within.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class MetaprogramPackageConflictException extends MetaprogramConflictException
{
    private static final long serialVersionUID = 1L;
    
    /** The conflicts which were detected. */
    private Set<? extends edu.jhu.cs.bsj.compiler.ast.conflict.knowledge.ConflictKnowledge> conflicts;
    
    public MetaprogramPackageConflictException(
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            Set<? extends edu.jhu.cs.bsj.compiler.ast.conflict.knowledge.ConflictKnowledge> conflicts)
    {
        super(firstAnchor, secondAnchor, conflictNode);
        this.conflicts = conflicts;
    }
    
    /**
     * Retrieves the conflicts which were detected.
     * @return The conflicts which were detected.
     */
    public Set<? extends edu.jhu.cs.bsj.compiler.ast.conflict.knowledge.ConflictKnowledge> getConflicts()
    {
        return this.conflicts;
    }
    
    /**
     * Creates a {@link BsjDiagnostic} corresponding to this exception type.
     * @param location The source location to report as the cause for the diagnostic.
     * @return A suitable diagnostic.
     */
    public abstract MetaprogramPackageConflictDiagnostic getDiagnostic(BsjSourceLocation location);
}
