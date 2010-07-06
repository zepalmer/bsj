package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramListConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ConflictKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramListConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * Indicates that two metaprograms are in conflict because of the manner in which they accessed the same
 * {@link ListNode}.  Note that this diagnostic has the ability to represent multiple failures
 * detected in a closure.  As a result, the anchors provided are merely advisory and represent one
 * of the possible conflicts contained within.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramListConflictDiagnosticImpl extends MetaprogramConflictDiagnosticImpl<MetaprogramListConflictException> implements MetaprogramListConflictDiagnostic
{
    /** The conflicts which were detected. */
    private Set<? extends ConflictKnowledge<?>> conflicts;
    
    public MetaprogramListConflictDiagnosticImpl(
            BsjSourceLocation source,
            MetaprogramListConflictException exception,
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            Set<? extends ConflictKnowledge<?>> conflicts)
    {
        super(source, MetaprogramListConflictDiagnostic.CODE, Kind.ERROR, exception, firstAnchor, secondAnchor, conflictNode);
        this.conflicts = conflicts;
    }
    
    /**
     * {@inheritDoc}
     */
    public Set<? extends ConflictKnowledge<?>> getConflicts()
    {
        return this.conflicts;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.conflicts);
        args.getSecond().put("conflicts", args.getFirst().size());
        args.getFirst().add("    " + DiagnosticMessageUtilities.getConflictsDescription(conflicts,locale).replaceAll("\n", "\n    ").replaceAll("\n +$", "\n"));
        args.getSecond().put("conflictKnowledge", args.getFirst().size());
        return args;
    }
    
    public MetaprogramListConflictDiagnosticImpl(BsjSourceLocation source, MetaprogramListConflictException exception)
    {
        this(source, exception, exception.getFirstAnchor(), exception.getSecondAnchor(), exception.getConflictNode(), exception.getConflicts());
    }
    
}
