package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramErrorException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
/**
 * Indicates that two metaprograms are in conflict due to some access.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramConflictDiagnostic<T extends MetaprogramErrorException> extends MetaprogramDetectedErrorDiagnostic<T>
{
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
