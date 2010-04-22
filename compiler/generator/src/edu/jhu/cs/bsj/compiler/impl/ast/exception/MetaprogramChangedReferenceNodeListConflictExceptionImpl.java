package edu.jhu.cs.bsj.compiler.impl.ast.exception;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramChangedReferenceNodeListConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramChangedReferenceNodeListConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaprogramChangedReferenceNodeListConflictDiagnosticImpl;

/*
 * {@inheritDoc}
 */

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramChangedReferenceNodeListConflictExceptionImpl extends MetaprogramChangedReferenceNodeListConflictException
{
    private static final long serialVersionUID = 1L;
    
    public MetaprogramChangedReferenceNodeListConflictExceptionImpl(
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            Node element)
    {
        super(firstAnchor, secondAnchor, conflictNode, element);
    }
    @Override
    public MetaprogramChangedReferenceNodeListConflictDiagnostic getDiagnostic(BsjSourceLocation source)
    {
        return new MetaprogramChangedReferenceNodeListConflictDiagnosticImpl(source, this);
    }
    
}
