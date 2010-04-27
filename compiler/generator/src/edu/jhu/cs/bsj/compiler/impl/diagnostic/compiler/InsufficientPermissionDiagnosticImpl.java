package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NodePermission;
import edu.jhu.cs.bsj.compiler.ast.exception.InsufficientPermissionException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InsufficientPermissionDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * Indicates that a metaprogram attempted to access a node in a fashion which is not permitted.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InsufficientPermissionDiagnosticImpl extends MetaprogramDetectedErrorDiagnosticImpl<InsufficientPermissionException> implements InsufficientPermissionDiagnostic
{
    /** The node that was accessed. */
    private Node node;
    
    /** The permission required to access the node. */
    private NodePermission requiredPermission;
    
    /** The permission that the metaprogram actually had. */
    private NodePermission availablePermission;
    
    public InsufficientPermissionDiagnosticImpl(
            BsjSourceLocation source,
            InsufficientPermissionException exception,
            Node node,
            NodePermission requiredPermission,
            NodePermission availablePermission)
    {
        super(source, InsufficientPermissionDiagnostic.CODE, Kind.ERROR, exception);
        this.node = node;
        this.requiredPermission = requiredPermission;
        this.availablePermission = availablePermission;
    }
    
    /**
     * {@inheritDoc}
     */
    public Node getNode()
    {
        return this.node;
    }
    
    /**
     * {@inheritDoc}
     */
    public NodePermission getRequiredPermission()
    {
        return this.requiredPermission;
    }
    
    /**
     * {@inheritDoc}
     */
    public NodePermission getAvailablePermission()
    {
        return this.availablePermission;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.node);
        args.getSecond().put("node", args.getFirst().size());
        args.getFirst().add(this.requiredPermission);
        args.getSecond().put("requiredPermission", args.getFirst().size());
        args.getFirst().add(this.availablePermission);
        args.getSecond().put("availablePermission", args.getFirst().size());
        return args;
    }
    
    public InsufficientPermissionDiagnosticImpl(BsjSourceLocation source, InsufficientPermissionException exception)
    {
        this(source, exception, exception.getNode(), exception.getRequiredPermission(), exception.getAvailablePermission());
    }
    
}
