package edu.jhu.cs.bsj.compiler.impl.ast.exception;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramChangedValueNodeListConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramChangedValueNodeListConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaprogramChangedValueNodeListConflictDiagnosticImpl;

/*
 * {@inheritDoc}
 */

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramChangedValueNodeListConflictExceptionImpl extends MetaprogramChangedValueNodeListConflictException
{
    private static final long serialVersionUID = 1L;
    
    public MetaprogramChangedValueNodeListConflictExceptionImpl(
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            Node element,
            Node value)
    {
        super(firstAnchor, secondAnchor, conflictNode, element, value);
    }
    @Override
    public MetaprogramChangedValueNodeListConflictDiagnostic getDiagnostic(BsjSourceLocation source)
    {
        return new MetaprogramChangedValueNodeListConflictDiagnosticImpl(source, this);
    }
    
}
