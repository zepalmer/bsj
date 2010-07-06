package edu.jhu.cs.bsj.compiler.impl.ast.exception;

import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramListConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.knowledge.ListKnowledge;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramListConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaprogramListConflictDiagnosticImpl;

/*
 * {@inheritDoc}
 */

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramListConflictExceptionImpl extends MetaprogramListConflictException
{
    private static final long serialVersionUID = 1L;
    
    public MetaprogramListConflictExceptionImpl(
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            Set<? extends ListKnowledge<?>> conflicts)
    {
        super(firstAnchor, secondAnchor, conflictNode, conflicts);
    }
    @Override
    public MetaprogramListConflictDiagnostic getDiagnostic(BsjSourceLocation source)
    {
        return new MetaprogramListConflictDiagnosticImpl(source, this);
    }
    
}
