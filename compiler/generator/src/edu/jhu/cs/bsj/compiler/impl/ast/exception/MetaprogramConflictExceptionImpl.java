package edu.jhu.cs.bsj.compiler.impl.ast.exception;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaprogramConflictDiagnosticImpl;

/*
 * {@inheritDoc}
 */

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramConflictExceptionImpl extends MetaprogramConflictException
{
    private static final long serialVersionUID = 1L;
    
    public MetaprogramConflictExceptionImpl(
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode)
    {
        super(firstAnchor, secondAnchor, conflictNode);
    }
    @Override
    public MetaprogramConflictDiagnostic getDiagnostic(BsjSourceLocation source)
    {
        return new MetaprogramConflictDiagnosticImpl(source, this);
    }
    
}
