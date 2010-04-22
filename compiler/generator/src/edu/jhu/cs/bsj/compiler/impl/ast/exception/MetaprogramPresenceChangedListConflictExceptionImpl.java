package edu.jhu.cs.bsj.compiler.impl.ast.exception;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramPresenceChangedListConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramPresenceChangedListConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaprogramPresenceChangedListConflictDiagnosticImpl;

/*
 * {@inheritDoc}
 */

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramPresenceChangedListConflictExceptionImpl extends MetaprogramPresenceChangedListConflictException
{
    private static final long serialVersionUID = 1L;
    
    public MetaprogramPresenceChangedListConflictExceptionImpl(
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            Node element)
    {
        super(firstAnchor, secondAnchor, conflictNode, element);
    }
    @Override
    public MetaprogramPresenceChangedListConflictDiagnostic getDiagnostic(BsjSourceLocation source)
    {
        return new MetaprogramPresenceChangedListConflictDiagnosticImpl(source, this);
    }
    
}
