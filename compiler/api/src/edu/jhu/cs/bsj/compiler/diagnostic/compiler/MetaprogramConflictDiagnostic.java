package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
/**
 * Indicates that two metaprograms are in conflict because of the manner in which they accessed the same
 * attribute of a given node.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramConflictDiagnostic extends MetaprogramDetectedErrorDiagnostic<MetaprogramConflictException>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaprogram.failure.accessConflict";
    
    /**
     * Retrieves the anchor of the first metaprogram that conflicted.
     * @return The anchor of the first metaprogram that conflicted.
     */
    public MetaprogramAnchorNode<?> getFirstAnchor();
    
    /**
     * Retrieves the anchor of the second metaprogram that conflicted.
     * @return The anchor of the second metaprogram that conflicted.
     */
    public MetaprogramAnchorNode<?> getSecondAnchor();
    
    /**
     * Retrieves the node over which the metaprograms conflicted.
     * @return The node over which the metaprograms conflicted.
     */
    public Node getConflictNode();
    
}
