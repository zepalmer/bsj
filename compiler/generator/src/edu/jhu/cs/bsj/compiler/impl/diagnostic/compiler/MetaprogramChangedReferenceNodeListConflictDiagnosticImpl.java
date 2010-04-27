package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramChangedReferenceNodeListConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramChangedReferenceNodeListConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * Indicates that the first metaprogram used the specified reference node for some operation and the
 * second metaprogram either added or removed that reference node.
 * <p/>
 * This diagnostic addresses the following logical cases:
 * <ul>
 *     <li>#x2553;e&#x2192;e'&#x2556;<sup>m</sup> &#x2227; &#x2553;e&#x2208;*&#x2556;<sup>n</sup></li>
 *     <li>#x2553;e'&#x2190;e&#x2556;<sup>m</sup> &#x2227; &#x2553;e&#x2208;*&#x2556;<sup>n</sup></li>
 *     <li>#x2559;e&#x2192;e'&#x255C;<sup>m</sup> &#x2227; &#x2553;e&#x2208;*&#x2556;<sup>n</sup></li>
 *     <li>#x2559;e'&#x2190;e&#x255C;<sup>m</sup> &#x2227; &#x2553;e&#x2208;*&#x2556;<sup>n</sup></li>
 * </ul>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramChangedReferenceNodeListConflictDiagnosticImpl extends MetaprogramListConflictDiagnosticImpl<MetaprogramChangedReferenceNodeListConflictException> implements MetaprogramChangedReferenceNodeListConflictDiagnostic
{
    /** The reference node. */
    private Node element;
    
    public MetaprogramChangedReferenceNodeListConflictDiagnosticImpl(
            BsjSourceLocation source,
            MetaprogramChangedReferenceNodeListConflictException exception,
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            Node element)
    {
        super(source, MetaprogramChangedReferenceNodeListConflictDiagnostic.CODE, Kind.ERROR, exception, firstAnchor, secondAnchor, conflictNode);
        this.element = element;
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
        args.getFirst().add(this.element);
        args.getSecond().put("element", args.getFirst().size());
        return args;
    }
    
    public MetaprogramChangedReferenceNodeListConflictDiagnosticImpl(BsjSourceLocation source, MetaprogramChangedReferenceNodeListConflictException exception)
    {
        this(source, exception, exception.getFirstAnchor(), exception.getSecondAnchor(), exception.getConflictNode(), exception.getElement());
    }
    
}
