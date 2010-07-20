package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramListMissingElementException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramListMissingElementDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * Indicates that a list operation occurred on an AST node using a base element which was not contained
 * in the list.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramListMissingElementDiagnosticImpl extends MetaprogramDetectedErrorDiagnosticImpl<MetaprogramListMissingElementException> implements MetaprogramListMissingElementDiagnostic
{
    /** The metaprogram which performed the illegal operation. */
    private MetaprogramAnchorNode<?> anchor;
    
    /** The location of the metaprogram which performed the illegal operation. */
    private BsjSourceLocation metaprogram;
    
    /** The element which was used as a base in the list which did not contain it. */
    private Node element;
    
    public MetaprogramListMissingElementDiagnosticImpl(
            BsjSourceLocation source,
            MetaprogramListMissingElementException exception,
            MetaprogramAnchorNode<?> anchor,
            BsjSourceLocation metaprogram,
            Node element)
    {
        super(source, MetaprogramListMissingElementDiagnostic.CODE, Kind.ERROR, exception);
        this.anchor = anchor;
        this.metaprogram = metaprogram;
        this.element = element;
    }
    
    /**
     * {@inheritDoc}
     */
    public MetaprogramAnchorNode<?> getAnchor()
    {
        return this.anchor;
    }
    
    /**
     * {@inheritDoc}
     */
    public BsjSourceLocation getMetaprogram()
    {
        return this.metaprogram;
    }
    
    /**
     * {@inheritDoc}
     */
    public Node getElement()
    {
        return this.element;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.anchor);
        args.getSecond().put("anchor", args.getFirst().size());
        args.getFirst().add(this.metaprogram);
        args.getSecond().put("metaprogram", args.getFirst().size());
        args.getFirst().add(this.element);
        args.getSecond().put("element", args.getFirst().size());
        return args;
    }
    
    public MetaprogramListMissingElementDiagnosticImpl(BsjSourceLocation source, MetaprogramListMissingElementException exception)
    {
        this(source, exception, exception.getAnchor(), exception.getMetaprogram(), exception.getElement());
    }
    
}
