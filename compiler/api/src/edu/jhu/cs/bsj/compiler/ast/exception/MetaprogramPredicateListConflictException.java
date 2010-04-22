package edu.jhu.cs.bsj.compiler.ast.exception;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramPredicateListConflictDiagnostic;

/**
 * Indicates that the first metaprogram used the provided predicate to search the list for values while
 * the second metaprogram either inserted or removed the given element (which matches the predicate)
 * from the list.  (&#x2559;P&#x255C;<sup>m</sup> &#x2227; &#x2553;e&#x2208;*&#x2556;<sup>n</sup>)
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class MetaprogramPredicateListConflictException extends MetaprogramListConflictException
{
    private static final long serialVersionUID = 1L;
    
    /** The node filter which was in conflict. */
    private NodeFilter<?> predicate;
    
    /** The node which matched the filter. */
    private Node element;
    
    public MetaprogramPredicateListConflictException(
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            NodeFilter<?> predicate,
            Node element)
    {
        super(firstAnchor, secondAnchor, conflictNode);
        this.predicate = predicate;
        this.element = element;
    }
    
    /**
     * Retrieves the node filter which was in conflict.
     * @return The node filter which was in conflict.
     */
    public NodeFilter<?> getPredicate()
    {
        return this.predicate;
    }
    
    /**
     * Retrieves the node which matched the filter.
     * @return The node which matched the filter.
     */
    public Node getElement()
    {
        return this.element;
    }
    
    /**
     * Creates a {@link BsjDiagnostic} corresponding to this exception type.
     * @param location The source location to report as the cause for the diagnostic.
     * @return A suitable diagnostic.
     */
    public abstract MetaprogramPredicateListConflictDiagnostic getDiagnostic(BsjSourceLocation location);
}
