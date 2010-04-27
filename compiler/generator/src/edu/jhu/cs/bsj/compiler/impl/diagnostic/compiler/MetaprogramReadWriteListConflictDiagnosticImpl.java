package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramReadWriteListConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramReadWriteListConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * Indicates that one metaprogram read a node before or after a given reference node while another
 * metaprogram changed that value.
 * (#x2559;e&#x2192;e1&#x255C;<sup>m</sup> &#x2227; #x2553;e&#x2192;e2&#x2556;<sup>n</sup> or
 * #x2559;e&#x2190;e1&#x255C;<sup>m</sup> &#x2227; #x2553;e&#x2190;e2&#x2556;<sup>n</sup>)  The
 * <code>after</code> field is <code>true</code> if the insertion and read both came after the element
 * and <code>false</code> if before.  If <code>element</code> is <code>null</code>, it indicates the
 * front or back of the list.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramReadWriteListConflictDiagnosticImpl extends MetaprogramListConflictDiagnosticImpl<MetaprogramReadWriteListConflictException> implements MetaprogramReadWriteListConflictDiagnostic
{
    /** Whether or not the insertion was after the reference node. */
    private boolean after;
    
    /** The reference node. */
    private Node element;
    
    public MetaprogramReadWriteListConflictDiagnosticImpl(
            BsjSourceLocation source,
            MetaprogramReadWriteListConflictException exception,
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            boolean after,
            Node element)
    {
        super(source, MetaprogramReadWriteListConflictDiagnostic.CODE, Kind.ERROR, exception, firstAnchor, secondAnchor, conflictNode);
        this.after = after;
        this.element = element;
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
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.after);
        args.getSecond().put("after", args.getFirst().size());
        args.getFirst().add(this.element);
        args.getSecond().put("element", args.getFirst().size());
        return args;
    }
    
    public MetaprogramReadWriteListConflictDiagnosticImpl(BsjSourceLocation source, MetaprogramReadWriteListConflictException exception)
    {
        this(source, exception, exception.getFirstAnchor(), exception.getSecondAnchor(), exception.getConflictNode(), exception.getAfter(), exception.getElement());
    }
    
}
