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
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramListConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * Indicates that two metaprograms are in conflict because of the manner in which they accessed the same
 * {@link ListNode}.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramListConflictDiagnosticImpl extends MetaprogramConflictDiagnosticImpl<MetaprogramListConflictException> implements MetaprogramListConflictDiagnostic
{
    /** The conflicts which were detected. */
    private Set<? extends ListKnowledge<?>> conflicts;
    
    public MetaprogramListConflictDiagnosticImpl(
            BsjSourceLocation source,
            MetaprogramListConflictException exception,
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            Set<? extends ListKnowledge<?>> conflicts)
    {
        super(source, MetaprogramListConflictDiagnostic.CODE, Kind.ERROR, exception, firstAnchor, secondAnchor, conflictNode);
        this.conflicts = conflicts;
    }
    
    /**
     * {@inheritDoc}
     */
    public Set<? extends ListKnowledge<?>> getConflicts()
    {
        return this.conflicts;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.conflicts);
        args.getSecond().put("conflicts", args.getFirst().size());
        return args;
    }
    
    public MetaprogramListConflictDiagnosticImpl(BsjSourceLocation source, MetaprogramListConflictException exception)
    {
        this(source, exception, exception.getFirstAnchor(), exception.getSecondAnchor(), exception.getConflictNode(), exception.getConflicts());
    }
    
}
