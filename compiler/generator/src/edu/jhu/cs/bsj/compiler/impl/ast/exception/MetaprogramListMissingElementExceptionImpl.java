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
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramListMissingElementException;
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
            NodeUnion<?> element)
    {
        super(anchor, metaprogram, element);
    }
    @Override
    public MetaprogramListMissingElementDiagnostic getDiagnostic(BsjSourceLocation source)
    {
        return new MetaprogramListMissingElementDiagnosticImpl(source, this);
    }
    
}
