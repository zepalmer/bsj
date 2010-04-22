package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramPresenceChangedListConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramPresenceChangedListConflictDiagnostic;


/**
 * Indicates that the first metaprogram changed whether or not an element was in the list while the
 * second metaprogram either made a similar change or observed that the element was in the list.
 * <p/>
 * This diagnostic addresses the following logical cases:
 * <ul>
 *     <li>&#x2553;e&#x2208;*&#x2556;<sup>m</sup> &#x2227; &#x2553;e&#x2208;*&#x2556;<sup>n</sup></li>
 *     <li>&#x2553;e&#x2208;*&#x2556;<sup>m</sup> &#x2227; &#x2559;e&#x2208;*&#x255C;<sup>n</sup></li>
 * </ul>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramPresenceChangedListConflictDiagnosticImpl extends MetaprogramListConflictDiagnosticImpl<MetaprogramPresenceChangedListConflictException> implements MetaprogramPresenceChangedListConflictDiagnostic
{
    /** The element in question. */
    private Node element;
    
    public MetaprogramPresenceChangedListConflictDiagnosticImpl(
            BsjSourceLocation source,
            MetaprogramPresenceChangedListConflictException exception,
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            Node element)
    {
        super(source, MetaprogramPresenceChangedListConflictDiagnostic.CODE, Kind.ERROR, exception, firstAnchor, secondAnchor, conflictNode);
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
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = super.getMessageArgs(locale);
        args.add(this.element);
        return args;
    }
    
    public MetaprogramPresenceChangedListConflictDiagnosticImpl(BsjSourceLocation source, MetaprogramPresenceChangedListConflictException exception)
    {
        this(source, exception, exception.getFirstAnchor(), exception.getSecondAnchor(), exception.getConflictNode(), exception.getElement());
    }
    
}
