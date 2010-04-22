package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramInsertionOrderListConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
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
public interface MetaprogramInsertionOrderListConflictDiagnostic extends MetaprogramListConflictDiagnostic<MetaprogramInsertionOrderListConflictException>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaprogram.failure.conflict.list.insertionOrder";
    
    /**
     * Retrieves whether or not the insertion was after the reference node.
     * @return Whether or not the insertion was after the reference node.
     */
    public boolean getAfter();
    
    /**
     * Retrieves the reference node.
     * @return The reference node.
     */
    public Node getElement();
    
    /**
     * Retrieves the first node inserted.
     * @return The first node inserted.
     */
    public Node getFirstInsert();
    
    /**
     * Retrieves the second node inserted.
     * @return The second node inserted.
     */
    public Node getSecondInsert();
    
}
