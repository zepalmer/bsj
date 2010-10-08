/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

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
