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
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramErrorException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * Indicates that two metaprograms are in conflict due to some access.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class MetaprogramConflictDiagnosticImpl<T extends MetaprogramErrorException> extends MetaprogramDetectedErrorDiagnosticImpl<T> implements MetaprogramConflictDiagnostic<T>
{
    /** The anchor of the first metaprogram that conflicted. */
    private MetaprogramAnchorNode<?> firstAnchor;
    
    /** The anchor of the second metaprogram that conflicted. */
    private MetaprogramAnchorNode<?> secondAnchor;
    
    /** The node over which the metaprograms conflicted. */
    private Node conflictNode;
    
    public MetaprogramConflictDiagnosticImpl(
            BsjSourceLocation source,
            String code,
            javax.tools.Diagnostic.Kind kind,
            T exception,
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode)
    {
        super(source, code, kind, exception);
        this.firstAnchor = firstAnchor;
        this.secondAnchor = secondAnchor;
        this.conflictNode = conflictNode;
    }
    
    /**
     * {@inheritDoc}
     */
    public MetaprogramAnchorNode<?> getFirstAnchor()
    {
        return this.firstAnchor;
    }
    
    /**
     * {@inheritDoc}
     */
    public MetaprogramAnchorNode<?> getSecondAnchor()
    {
        return this.secondAnchor;
    }
    
    /**
     * {@inheritDoc}
     */
    public Node getConflictNode()
    {
        return this.conflictNode;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.firstAnchor);
        args.getSecond().put("firstAnchor", args.getFirst().size());
        args.getFirst().add(this.secondAnchor);
        args.getSecond().put("secondAnchor", args.getFirst().size());
        args.getFirst().add(this.conflictNode);
        args.getSecond().put("conflictNode", args.getFirst().size());
        return args;
    }
    
}
