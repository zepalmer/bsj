package edu.jhu.cs.bsj.compiler.ast.exception;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramPresenceChangedListConflictDiagnostic;

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
public abstract class MetaprogramPresenceChangedListConflictException extends MetaprogramListConflictException
{
    private static final long serialVersionUID = 1L;
    
    /** The element in question. */
    private Node element;
    
    public MetaprogramPresenceChangedListConflictException(
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            Node element)
    {
        super(firstAnchor, secondAnchor, conflictNode);
        this.element = element;
    }
    
    /**
     * Retrieves the element in question.
     * @return The element in question.
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
    public abstract MetaprogramPresenceChangedListConflictDiagnostic getDiagnostic(BsjSourceLocation location);
}
