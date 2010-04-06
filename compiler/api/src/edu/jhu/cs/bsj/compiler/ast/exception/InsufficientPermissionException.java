package edu.jhu.cs.bsj.compiler.ast.exception;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NodePermission;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InsufficientPermissionDiagnostic;

/**
 * Indicates that a metaprogram attempted to access a node in a fashion which is not permitted.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class InsufficientPermissionException extends MetaprogramDetectedErrorException
{
    private static final long serialVersionUID = 1L;
    
    /** The node that was accessed. */
    private Node node;
    
    /** The permission required to access the node. */
    private NodePermission requiredPermission;
    
    /** The permission that the metaprogram actually had. */
    private NodePermission availablePermission;
    
    public InsufficientPermissionException(
            Node node,
            NodePermission requiredPermission,
            NodePermission availablePermission)
    {
        super();
        this.node = node;
        this.requiredPermission = requiredPermission;
        this.availablePermission = availablePermission;
    }
    
    /**
     * Retrieves the node that was accessed.
     * @return The node that was accessed.
     */
    public Node getNode()
    {
        return this.node;
    }
    
    /**
     * Retrieves the permission required to access the node.
     * @return The permission required to access the node.
     */
    public NodePermission getRequiredPermission()
    {
        return this.requiredPermission;
    }
    
    /**
     * Retrieves the permission that the metaprogram actually had.
     * @return The permission that the metaprogram actually had.
     */
    public NodePermission getAvailablePermission()
    {
        return this.availablePermission;
    }
    
    /**
     * Creates a {@link BsjDiagnostic} corresponding to this exception type.
     * @param location The source location to report as the cause for the diagnostic.
     * @return A suitable diagnostic.
     */
    public abstract InsufficientPermissionDiagnostic getDiagnostic(BsjSourceLocation location);
}
