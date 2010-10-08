/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.NodePermission;
import edu.jhu.cs.bsj.compiler.ast.exception.InsufficientPermissionException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
/**
 * Indicates that a metaprogram attempted to access a node in a fashion which is not permitted.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InsufficientPermissionDiagnostic extends MetaprogramDetectedErrorDiagnostic<InsufficientPermissionException>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaprogram.failure.permission";
    
    /**
     * Retrieves the node that was accessed.
     * @return The node that was accessed.
     */
    public Node getNode();
    
    /**
     * Retrieves the permission required to access the node.
     * @return The permission required to access the node.
     */
    public NodePermission getRequiredPermission();
    
    /**
     * Retrieves the permission that the metaprogram actually had.
     * @return The permission that the metaprogram actually had.
     */
    public NodePermission getAvailablePermission();
    
}
