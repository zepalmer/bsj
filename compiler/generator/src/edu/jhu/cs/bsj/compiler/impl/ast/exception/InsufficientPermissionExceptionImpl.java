/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

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
