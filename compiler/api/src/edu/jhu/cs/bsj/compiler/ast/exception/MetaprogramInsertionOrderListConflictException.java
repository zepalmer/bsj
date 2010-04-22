package edu.jhu.cs.bsj.compiler.ast.exception;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramInsertionOrderListConflictDiagnostic;

/**
 * Indicates that two metaprograms both tried to insert values before or after the same element in the
 * list.  (#x2553;e&#x2192;e1&#x2556;<sup>m</sup> &#x2227; #x2553;e&#x2192;e2&#x2556;<sup>n</sup> or
 * #x2553;e&#x2190;e1&#x2556;<sup>m</sup> &#x2227; #x2553;e&#x2190;e2&#x2556;<sup>n</sup>)  The
 * <code>after</code> field is <code>true</code> if the insertion came after the element and
 * <code>false</code> if the insertion came before the element.  If <code>element</code> is
 * <code>null</code>, it indicates the front or back of the list.
 * <p/>
 * This diagnostic is only generated for order-dependent elements.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class MetaprogramInsertionOrderListConflictException extends MetaprogramListConflictException
{
    private static final long serialVersionUID = 1L;
    
    /** Whether or not the insertion was after the reference node. */
    private boolean after;
    
    /** The reference node. */
    private Node element;
    
    /** The first node inserted. */
    private Node firstInsert;
    
    /** The second node inserted. */
    private Node secondInsert;
    
    public MetaprogramInsertionOrderListConflictException(
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            boolean after,
            Node element,
            Node firstInsert,
            Node secondInsert)
    {
        super(firstAnchor, secondAnchor, conflictNode);
        this.after = after;
        this.element = element;
        this.firstInsert = firstInsert;
        this.secondInsert = secondInsert;
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
     * Retrieves the first node inserted.
     * @return The first node inserted.
     */
    public Node getFirstInsert()
    {
        return this.firstInsert;
    }
    
    /**
     * Retrieves the second node inserted.
     * @return The second node inserted.
     */
    public Node getSecondInsert()
    {
        return this.secondInsert;
    }
    
    /**
     * Creates a {@link BsjDiagnostic} corresponding to this exception type.
     * @param location The source location to report as the cause for the diagnostic.
     * @return A suitable diagnostic.
     */
    public abstract MetaprogramInsertionOrderListConflictDiagnostic getDiagnostic(BsjSourceLocation location);
}
