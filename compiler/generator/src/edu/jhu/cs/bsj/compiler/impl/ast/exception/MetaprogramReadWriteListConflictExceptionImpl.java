package edu.jhu.cs.bsj.compiler.impl.ast.exception;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramReadWriteListConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramReadWriteListConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaprogramReadWriteListConflictDiagnosticImpl;

/*
 * {@inheritDoc}
 */

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramReadWriteListConflictExceptionImpl extends MetaprogramReadWriteListConflictException
{
    private static final long serialVersionUID = 1L;
    
    public MetaprogramReadWriteListConflictExceptionImpl(
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            boolean after,
            Node element)
    {
        super(firstAnchor, secondAnchor, conflictNode, after, element);
    }
    @Override
    public MetaprogramReadWriteListConflictDiagnostic getDiagnostic(BsjSourceLocation source)
    {
        return new MetaprogramReadWriteListConflictDiagnosticImpl(source, this);
    }
    
}
