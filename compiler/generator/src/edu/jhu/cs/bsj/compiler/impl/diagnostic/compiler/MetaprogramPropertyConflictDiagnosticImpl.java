/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramPropertyConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramPropertyConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * Indicates that two metaprograms are in conflict because they performed write operations to the same
 * property of the same node and neither is dependent upon the other.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramPropertyConflictDiagnosticImpl extends MetaprogramConflictDiagnosticImpl<MetaprogramPropertyConflictException> implements MetaprogramPropertyConflictDiagnostic
{
    /** The name of the property in conflict. */
    private String attributeName;
    
    public MetaprogramPropertyConflictDiagnosticImpl(
            BsjSourceLocation source,
            MetaprogramPropertyConflictException exception,
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            String attributeName)
    {
        super(source, MetaprogramPropertyConflictDiagnostic.CODE, Kind.ERROR, exception, firstAnchor, secondAnchor, conflictNode);
        this.attributeName = attributeName;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getAttributeName()
    {
        return this.attributeName;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.attributeName);
        args.getSecond().put("attributeName", args.getFirst().size());
        return args;
    }
    
    public MetaprogramPropertyConflictDiagnosticImpl(BsjSourceLocation source, MetaprogramPropertyConflictException exception)
    {
        this(source, exception, exception.getFirstAnchor(), exception.getSecondAnchor(), exception.getConflictNode(), exception.getAttributeName());
    }
    
}
