package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramInsertionOrderListConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramInsertionOrderListConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * Indicates that two metaprograms both tried to insert values before or after the same element in the
 * list.  (#x2553;e&#x2192;e1&#x2556;<sup>m</sup> &#x2227; #x2553;e&#x2192;e2&#x2556;<sup>n</sup> or
 * #x2553;e&#x2190;e1&#x2556;<sup>m</sup> &#x2227; #x2553;e&#x2190;e2&#x2556;<sup>n</sup>)  The
 * <code>after</code> field is <code>true</code> if the insertion came after the element and
 * <code>false</code> if the insertion came before the element.  If <code>element</code> is
 * <code>null</code>, it indicates the front or back of the list.
 * <p/>
 * This diagnostic is only generated for order-dependent elements.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramInsertionOrderListConflictDiagnosticImpl extends MetaprogramListConflictDiagnosticImpl<MetaprogramInsertionOrderListConflictException> implements MetaprogramInsertionOrderListConflictDiagnostic
{
    /** Whether or not the insertion was after the reference node. */
    private boolean after;
    
    /** The reference node. */
    private Node element;
    
    /** The first node inserted. */
    private Node firstInsert;
    
    /** The second node inserted. */
    private Node secondInsert;
    
    public MetaprogramInsertionOrderListConflictDiagnosticImpl(
            BsjSourceLocation source,
            MetaprogramInsertionOrderListConflictException exception,
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            boolean after,
            Node element,
            Node firstInsert,
            Node secondInsert)
    {
        super(source, MetaprogramInsertionOrderListConflictDiagnostic.CODE, Kind.ERROR, exception, firstAnchor, secondAnchor, conflictNode);
        this.after = after;
        this.element = element;
        this.firstInsert = firstInsert;
        this.secondInsert = secondInsert;
    }
    
    /**
     * {@inheritDoc}
     */
    public boolean getAfter()
    {
        return this.after;
    }
    
    /**
     * {@inheritDoc}
     */
    public Node getElement()
    {
        return this.element;
    }
    
    /**
     * {@inheritDoc}
     */
    public Node getFirstInsert()
    {
        return this.firstInsert;
    }
    
    /**
     * {@inheritDoc}
     */
    public Node getSecondInsert()
    {
        return this.secondInsert;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.after);
        args.getSecond().put("after", args.getFirst().size());
        args.getFirst().add(this.element);
        args.getSecond().put("element", args.getFirst().size());
        args.getFirst().add(this.firstInsert);
        args.getSecond().put("firstInsert", args.getFirst().size());
        args.getFirst().add(this.secondInsert);
        args.getSecond().put("secondInsert", args.getFirst().size());
        return args;
    }
    
    public MetaprogramInsertionOrderListConflictDiagnosticImpl(BsjSourceLocation source, MetaprogramInsertionOrderListConflictException exception)
    {
        this(source, exception, exception.getFirstAnchor(), exception.getSecondAnchor(), exception.getConflictNode(), exception.getAfter(), exception.getElement(), exception.getFirstInsert(), exception.getSecondInsert());
    }
    
}
