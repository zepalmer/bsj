package edu.jhu.cs.bsj.compiler.ast.exception;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramConflictDiagnostic;

/**
 * Indicates that two metaprograms are in conflict due to some access.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class MetaprogramConflictException extends MetaprogramDetectedErrorException
{
    private static final long serialVersionUID = 1L;
    
    /** The anchor of the first metaprogram that conflicted. */
    private MetaprogramAnchorNode<?> firstAnchor;
    
    /** The anchor of the second metaprogram that conflicted. */
    private MetaprogramAnchorNode<?> secondAnchor;
    
    /** The node over which the metaprograms conflicted. */
    private Node conflictNode;
    
    public MetaprogramConflictException(
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode)
    {
        super();
        this.firstAnchor = firstAnchor;
        this.secondAnchor = secondAnchor;
        this.conflictNode = conflictNode;
    }
    
    /**
     * Retrieves the anchor of the first metaprogram that conflicted.
     * @return The anchor of the first metaprogram that conflicted.
     */
    public MetaprogramAnchorNode<?> getFirstAnchor()
    {
        return this.firstAnchor;
    }
    
    /**
     * Retrieves the anchor of the second metaprogram that conflicted.
     * @return The anchor of the second metaprogram that conflicted.
     */
    public MetaprogramAnchorNode<?> getSecondAnchor()
    {
        return this.secondAnchor;
    }
    
    /**
     * Retrieves the node over which the metaprograms conflicted.
     * @return The node over which the metaprograms conflicted.
     */
    public Node getConflictNode()
    {
        return this.conflictNode;
    }
    
    /**
     * Creates a {@link BsjDiagnostic} corresponding to this exception type.
     * @param location The source location to report as the cause for the diagnostic.
     * @return A suitable diagnostic.
     */
    public abstract MetaprogramConflictDiagnostic<?> getDiagnostic(BsjSourceLocation location);
}
