package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramPredicateListConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramPredicateListConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * Indicates that the first metaprogram used the provided predicate to search the list for values while
 * the second metaprogram either inserted or removed the given element (which matches the predicate)
 * from the list.  (&#x2559;P&#x255C;<sup>m</sup> &#x2227; &#x2553;e&#x2208;*&#x2556;<sup>n</sup>)
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramPredicateListConflictDiagnosticImpl extends MetaprogramListConflictDiagnosticImpl<MetaprogramPredicateListConflictException> implements MetaprogramPredicateListConflictDiagnostic
{
    /** The node filter which was in conflict. */
    private NodeFilter<?> predicate;
    
    /** The node which matched the filter. */
    private Node element;
    
    public MetaprogramPredicateListConflictDiagnosticImpl(
            BsjSourceLocation source,
            MetaprogramPredicateListConflictException exception,
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            NodeFilter<?> predicate,
            Node element)
    {
        super(source, MetaprogramPredicateListConflictDiagnostic.CODE, Kind.ERROR, exception, firstAnchor, secondAnchor, conflictNode);
        this.predicate = predicate;
        this.element = element;
    }
    
    /**
     * {@inheritDoc}
     */
    public NodeFilter<?> getPredicate()
    {
        return this.predicate;
    }
    
    /**
     * {@inheritDoc}
     */
    public Node getElement()
    {
        return this.element;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.predicate);
        args.getSecond().put("predicate", args.getFirst().size());
        args.getFirst().add(this.element);
        args.getSecond().put("element", args.getFirst().size());
        return args;
    }
    
    public MetaprogramPredicateListConflictDiagnosticImpl(BsjSourceLocation source, MetaprogramPredicateListConflictException exception)
    {
        this(source, exception, exception.getFirstAnchor(), exception.getSecondAnchor(), exception.getConflictNode(), exception.getPredicate(), exception.getElement());
    }
    
}
