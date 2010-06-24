package edu.jhu.cs.bsj.compiler.ast.exception;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramChangedReferenceNodeListConflictDiagnostic;

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
public abstract class MetaprogramChangedReferenceNodeListConflictException extends MetaprogramListConflictException
{
    private static final long serialVersionUID = 1L;
    
    /** The reference node. */
    private Node element;
    
    public MetaprogramChangedReferenceNodeListConflictException(
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            Node element)
    {
        super(firstAnchor, secondAnchor, conflictNode);
        this.element = element;
    }
    
    /**
     * Retrieves the reference node.
     * @return The reference node.
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
    public abstract MetaprogramChangedReferenceNodeListConflictDiagnostic getDiagnostic(BsjSourceLocation location);
}
