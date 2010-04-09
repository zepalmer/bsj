package edu.jhu.cs.bsj.compiler.impl.ast.exception;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MultipleParentNodeException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MultipleParentNodeDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MultipleParentNodeDiagnosticImpl;

/*
 * {@inheritDoc}
 */

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MultipleParentNodeExceptionImpl extends MultipleParentNodeException
{
    private static final long serialVersionUID = 1L;
    
    public MultipleParentNodeExceptionImpl(
            Node parent,
            Node child)
    {
        super(parent, child);
    }
    @Override
    public MultipleParentNodeDiagnostic getDiagnostic(BsjSourceLocation source)
    {
        return new MultipleParentNodeDiagnosticImpl(source, this);
    }
    
}
