/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.ast.exception;

import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramPackageConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramPackageConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler.MetaprogramPackageConflictDiagnosticImpl;

/*
 * {@inheritDoc}
 */

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramPackageConflictExceptionImpl extends MetaprogramPackageConflictException
{
    private static final long serialVersionUID = 1L;
    
    public MetaprogramPackageConflictExceptionImpl(
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            Set<? extends edu.jhu.cs.bsj.compiler.ast.conflict.knowledge.ConflictKnowledge> conflicts)
    {
        super(firstAnchor, secondAnchor, conflictNode, conflicts);
    }
    @Override
    public MetaprogramPackageConflictDiagnostic getDiagnostic(BsjSourceLocation source)
    {
        return new MetaprogramPackageConflictDiagnosticImpl(source, this);
    }
    
}
