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
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramAttributeConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramAttributeConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaprogramAttributeConflictDiagnosticImpl;

/*
 * {@inheritDoc}
 */

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramAttributeConflictExceptionImpl extends MetaprogramAttributeConflictException
{
    private static final long serialVersionUID = 1L;
    
    public MetaprogramAttributeConflictExceptionImpl(
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            String attributeName,
            String firstAccess,
            String secondAccess)
    {
        super(firstAnchor, secondAnchor, conflictNode, attributeName, firstAccess, secondAccess);
    }
    @Override
    public MetaprogramAttributeConflictDiagnostic getDiagnostic(BsjSourceLocation source)
    {
        return new MetaprogramAttributeConflictDiagnosticImpl(source, this);
    }
    
}
