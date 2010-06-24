package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramChangedReferenceNodeListConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
/**
 * Indicates that the first metaprogram used the specified reference node for some operation and the
 * second metaprogram either added or removed that reference node.
 * <p/>
 * This diagnostic addresses the following logical cases:
 * <ul>
 *     <li>&#x2553;e&#x2192;e'&#x2556;<sup>m</sup> &#x2227; &#x2553;e&#x2208;*&#x2556;<sup>n</sup></li>
 *     <li>&#x2553;e'&#x2190;e&#x2556;<sup>m</sup> &#x2227; &#x2553;e&#x2208;*&#x2556;<sup>n</sup></li>
 *     <li>&#x2559;e&#x2192;e'&#x255C;<sup>m</sup> &#x2227; &#x2553;e&#x2208;*&#x2556;<sup>n</sup></li>
 *     <li>&#x2559;e'&#x2190;e&#x255C;<sup>m</sup> &#x2227; &#x2553;e&#x2208;*&#x2556;<sup>n</sup></li>
 * </ul>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramChangedReferenceNodeListConflictDiagnostic extends MetaprogramListConflictDiagnostic<MetaprogramChangedReferenceNodeListConflictException>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaprogram.failure.conflict.list.changed.reference";
    
    /**
     * Retrieves the reference node.
     * @return The reference node.
     */
    public Node getElement();
    
}
