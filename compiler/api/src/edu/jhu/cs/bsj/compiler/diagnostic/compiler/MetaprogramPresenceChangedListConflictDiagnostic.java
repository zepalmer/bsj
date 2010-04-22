package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramPresenceChangedListConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
/**
 * Indicates that the first metaprogram changed whether or not an element was in the list while the
 * second metaprogram either made a similar change or observed that the element was in the list.
 * <p/>
 * This diagnostic addresses the following logical cases:
 * <ul>
 *     <li>&#x2553;e&#x2208;*&#x2556;<sup>m</sup> &#x2227; &#x2553;e&#x2208;*&#x2556;<sup>n</sup></li>
 *     <li>&#x2553;e&#x2208;*&#x2556;<sup>m</sup> &#x2227; &#x2559;e&#x2208;*&#x255C;<sup>n</sup></li>
 * </ul>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramPresenceChangedListConflictDiagnostic extends MetaprogramListConflictDiagnostic<MetaprogramPresenceChangedListConflictException>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaprogram.failure.conflict.list.changed.presence";
    
    /**
     * Retrieves the element in question.
     * @return The element in question.
     */
    public Node getElement();
    
}
