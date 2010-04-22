package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramPredicateListConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
/**
 * Indicates that the first metaprogram used the provided predicate to search the list for values while
 * the second metaprogram either inserted or removed the given element (which matches the predicate)
 * from the list.  (&#x2559;P&#x255C;<sup>m</sup> &#x2227; &#x2553;e&#x2208;*&#x2556;<sup>n</sup>)
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramPredicateListConflictDiagnostic extends MetaprogramListConflictDiagnostic<MetaprogramPredicateListConflictException>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaprogram.failure.conflict.list.predicate";
    
    /**
     * Retrieves the node filter which was in conflict.
     * @return The node filter which was in conflict.
     */
    public NodeFilter<?> getPredicate();
    
    /**
     * Retrieves the node which matched the filter.
     * @return The node which matched the filter.
     */
    public Node getElement();
    
}
