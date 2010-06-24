package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramReadWriteListConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
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
public interface MetaprogramReadWriteListConflictDiagnostic extends MetaprogramListConflictDiagnostic<MetaprogramReadWriteListConflictException>
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
    
}
