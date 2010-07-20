package edu.jhu.cs.bsj.compiler.impl.ast.exception;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramListMissingElementException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramListMissingElementDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaprogramListMissingElementDiagnosticImpl;

/*
 * {@inheritDoc}
 */

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramListMissingElementExceptionImpl extends MetaprogramListMissingElementException
{
    private static final long serialVersionUID = 1L;
    
    public MetaprogramListMissingElementExceptionImpl(
            MetaprogramAnchorNode<?> anchor,
            BsjSourceLocation metaprogram,
            Node element)
    {
        super(anchor, metaprogram, element);
    }
    @Override
    public MetaprogramListMissingElementDiagnostic getDiagnostic(BsjSourceLocation source)
    {
        return new MetaprogramListMissingElementDiagnosticImpl(source, this);
    }
    
}
