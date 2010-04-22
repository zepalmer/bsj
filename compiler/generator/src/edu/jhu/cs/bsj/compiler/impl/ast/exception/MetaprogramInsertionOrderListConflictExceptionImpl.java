package edu.jhu.cs.bsj.compiler.impl.ast.exception;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramInsertionOrderListConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramInsertionOrderListConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaprogramInsertionOrderListConflictDiagnosticImpl;

/*
 * {@inheritDoc}
 */

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramInsertionOrderListConflictExceptionImpl extends MetaprogramInsertionOrderListConflictException
{
    private static final long serialVersionUID = 1L;
    
    public MetaprogramInsertionOrderListConflictExceptionImpl(
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            boolean after,
            Node element,
            Node firstInsert,
            Node secondInsert)
    {
        super(firstAnchor, secondAnchor, conflictNode, after, element, firstInsert, secondInsert);
    }
    @Override
    public MetaprogramInsertionOrderListConflictDiagnostic getDiagnostic(BsjSourceLocation source)
    {
        return new MetaprogramInsertionOrderListConflictDiagnosticImpl(source, this);
    }
    
}
