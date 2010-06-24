package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramChangedValueNodeListConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramChangedValueNodeListConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * Indicates that the first metaprogram either read or wrote a value for some operation and the
 * second metaprogram either added or removed that value node.
 * <p/>
 * This diagnostic addresses the following logical cases:
 * <ul>
 *     <li>&#x2553;e&#x2192;e'&#x2556;<sup>m</sup> &#x2227; &#x2553;e'&#x2208;*&#x2556;<sup>n</sup></li>
 *     <li>&#x2553;e'&#x2190;e&#x2556;<sup>m</sup> &#x2227; &#x2553;e'&#x2208;*&#x2556;<sup>n</sup></li>
 *     <li>&#x2559;e&#x2192;e'&#x255C;<sup>m</sup> &#x2227; &#x2553;e'&#x2208;*&#x2556;<sup>n</sup></li>
 *     <li>&#x2559;e'&#x2190;e&#x255C;<sup>m</sup> &#x2227; &#x2553;e'&#x2208;*&#x2556;<sup>n</sup></li>
 * </ul>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramChangedValueNodeListConflictDiagnosticImpl extends MetaprogramListConflictDiagnosticImpl<MetaprogramChangedValueNodeListConflictException> implements MetaprogramChangedValueNodeListConflictDiagnostic
{
    /** The reference node. */
    private Node element;
    
    /** The affected value. */
    private Node value;
    
    public MetaprogramChangedValueNodeListConflictDiagnosticImpl(
            BsjSourceLocation source,
            MetaprogramChangedValueNodeListConflictException exception,
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            Node element,
            Node value)
    {
        super(source, MetaprogramChangedValueNodeListConflictDiagnostic.CODE, Kind.ERROR, exception, firstAnchor, secondAnchor, conflictNode);
        this.element = element;
        this.value = value;
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
    public Node getValue()
    {
        return this.value;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.element);
        args.getSecond().put("element", args.getFirst().size());
        args.getFirst().add(this.value);
        args.getSecond().put("value", args.getFirst().size());
        return args;
    }
    
    public MetaprogramChangedValueNodeListConflictDiagnosticImpl(BsjSourceLocation source, MetaprogramChangedValueNodeListConflictException exception)
    {
        this(source, exception, exception.getFirstAnchor(), exception.getSecondAnchor(), exception.getConflictNode(), exception.getElement(), exception.getValue());
    }
    
}
