package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramConflictDiagnostic;


/**
 * Indicates that two metaprograms are in conflict because of the manner in which they accessed the same
 * attribute of a given node.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramConflictDiagnosticImpl extends MetaprogramDetectedErrorDiagnosticImpl<MetaprogramConflictException> implements MetaprogramConflictDiagnostic
{
    /** The anchor of the first metaprogram that conflicted. */
    private MetaprogramAnchorNode<?> firstAnchor;
    
    /** The anchor of the second metaprogram that conflicted. */
    private MetaprogramAnchorNode<?> secondAnchor;
    
    /** The node over which the metaprograms conflicted. */
    private Node conflictNode;
    
    public MetaprogramConflictDiagnosticImpl(
            BsjSourceLocation source,
            MetaprogramConflictException exception,
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode)
    {
        super(source, MetaprogramConflictDiagnostic.CODE, Kind.ERROR, exception);
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
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = super.getMessageArgs(locale);
        args.add(this.firstAnchor);
        args.add(this.secondAnchor);
        args.add(this.conflictNode);
        return args;
    }
    
    public MetaprogramConflictDiagnosticImpl(BsjSourceLocation source, MetaprogramConflictException exception)
    {
        this(source, exception, exception.getFirstAnchor(), exception.getSecondAnchor(), exception.getConflictNode());
    }
    
}
