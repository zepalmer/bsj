package edu.jhu.cs.bsj.compiler.impl.ast.exception;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NodePermission;
import edu.jhu.cs.bsj.compiler.ast.exception.InsufficientPermissionException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InsufficientPermissionDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.InsufficientPermissionDiagnosticImpl;

/*
 * {@inheritDoc}
 */

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InsufficientPermissionExceptionImpl extends InsufficientPermissionException
{
    private static final long serialVersionUID = 1L;
    
    public InsufficientPermissionExceptionImpl(
            Node node,
            NodePermission requiredPermission,
            NodePermission availablePermission)
    {
        super(node, requiredPermission, availablePermission);
    }
    @Override
    public InsufficientPermissionDiagnostic getDiagnostic(BsjSourceLocation source)
    {
        return new InsufficientPermissionDiagnosticImpl(source, this);
    }
    
}
