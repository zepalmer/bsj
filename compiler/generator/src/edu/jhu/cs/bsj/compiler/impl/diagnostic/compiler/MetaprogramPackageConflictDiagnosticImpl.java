/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramPackageConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramPackageConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * Indicates that two metaprograms are in conflict because of the manner in which they accessed the same
 * {@link ListNode}.  Note that this diagnostic has the ability to represent multiple failures
 * detected in a closure.  As a result, the anchors provided are merely advisory and represent one
 * of the possible conflicts contained within.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramPackageConflictDiagnosticImpl extends MetaprogramConflictDiagnosticImpl<MetaprogramPackageConflictException> implements MetaprogramPackageConflictDiagnostic
{
    /** The conflicts which were detected. */
    private Set<? extends edu.jhu.cs.bsj.compiler.ast.conflict.knowledge.ConflictKnowledge> conflicts;
    
    public MetaprogramPackageConflictDiagnosticImpl(
            BsjSourceLocation source,
            MetaprogramPackageConflictException exception,
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            Set<? extends edu.jhu.cs.bsj.compiler.ast.conflict.knowledge.ConflictKnowledge> conflicts)
    {
        super(source, MetaprogramPackageConflictDiagnostic.CODE, Kind.ERROR, exception, firstAnchor, secondAnchor, conflictNode);
        this.conflicts = conflicts;
    }
    
    /**
     * {@inheritDoc}
     */
    public Set<? extends edu.jhu.cs.bsj.compiler.ast.conflict.knowledge.ConflictKnowledge> getConflicts()
    {
        return this.conflicts;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.conflicts);
        args.getSecond().put("conflicts", args.getFirst().size());
        args.getFirst().add("    " + DiagnosticMessageUtilities.getDescriptionForConflicts(conflicts,locale).replaceAll("\n", "\n    ").replaceAll("\n +$", "\n"));
        args.getSecond().put("conflictKnowledge", args.getFirst().size());
        return args;
    }
    
    public MetaprogramPackageConflictDiagnosticImpl(BsjSourceLocation source, MetaprogramPackageConflictException exception)
    {
        this(source, exception, exception.getFirstAnchor(), exception.getSecondAnchor(), exception.getConflictNode(), exception.getConflicts());
    }
    
}
