package edu.jhu.cs.bsj.compiler.impl.ast.exception;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramPredicateListConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramPredicateListConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaprogramPredicateListConflictDiagnosticImpl;

/*
 * {@inheritDoc}
 */

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramPredicateListConflictExceptionImpl extends MetaprogramPredicateListConflictException
{
    private static final long serialVersionUID = 1L;
    
    public MetaprogramPredicateListConflictExceptionImpl(
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            NodeFilter<?> predicate,
            Node element)
    {
        super(firstAnchor, secondAnchor, conflictNode, predicate, element);
    }
    @Override
    public MetaprogramPredicateListConflictDiagnostic getDiagnostic(BsjSourceLocation source)
    {
        return new MetaprogramPredicateListConflictDiagnosticImpl(source, this);
    }
    
}
