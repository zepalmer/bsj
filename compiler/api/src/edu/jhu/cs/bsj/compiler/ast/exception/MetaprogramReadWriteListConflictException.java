package edu.jhu.cs.bsj.compiler.ast.exception;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramReadWriteListConflictDiagnostic;

/**
 * Indicates that one metaprogram read a node before or after a given reference node while another
 * metaprogram changed that value.
 * (&#x2559;e&#x2192;e1&#x255C;<sup>m</sup> &#x2227; &#x2553;e&#x2192;e2&#x2556;<sup>n</sup> or
 * &#x2559;e&#x2190;e1&#x255C;<sup>m</sup> &#x2227; &#x2553;e&#x2190;e2&#x2556;<sup>n</sup>)  The
 * <code>after</code> field is <code>true</code> if the insertion and read both came after the element
 * and <code>false</code> if before.  If <code>element</code> is <code>null</code>, it indicates the
 * front or back of the list.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class MetaprogramReadWriteListConflictException extends MetaprogramListConflictException
{
    private static final long serialVersionUID = 1L;
    
    /** Whether or not the insertion was after the reference node. */
    private boolean after;
    
    /** The reference node. */
    private Node element;
    
    public MetaprogramReadWriteListConflictException(
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            boolean after,
            Node element)
    {
        super(firstAnchor, secondAnchor, conflictNode);
        this.after = after;
        this.element = element;
    }
    
    /**
     * Retrieves whether or not the insertion was after the reference node.
     * @return Whether or not the insertion was after the reference node.
     */
    public boolean getAfter()
    {
        return this.after;
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
    public abstract MetaprogramReadWriteListConflictDiagnostic getDiagnostic(BsjSourceLocation location);
}
