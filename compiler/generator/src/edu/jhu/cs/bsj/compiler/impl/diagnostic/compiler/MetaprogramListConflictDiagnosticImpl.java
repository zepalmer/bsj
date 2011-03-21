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
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramListConflictException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramListConflictDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * Indicates that two metaprograms are in conflict because they attempted to insert different
 * order-dependent elements into the same position in a list.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramListConflictDiagnosticImpl<N extends Node> extends MetaprogramConflictDiagnosticImpl<MetaprogramListConflictException> implements MetaprogramListConflictDiagnostic<N>
{
    /** The list over which the metaprograms conflicted. */
    private ListNode<N> list;
    
    /** The node which both metaprograms used as a reference point (or null for beginning or end). */
    private N reference;
    
    /** True if the nodes added after the reference point; false if they added before. */
    private boolean after;
    
    /** The node added by the first metaprogram. */
    private N element;
    
    public MetaprogramListConflictDiagnosticImpl(
            BsjSourceLocation source,
            MetaprogramListConflictException exception,
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            ListNode<N> list,
            N reference,
            boolean after,
            N element)
    {
        super(source, MetaprogramListConflictDiagnostic.CODE, Kind.ERROR, exception, firstAnchor, secondAnchor, conflictNode);
        this.list = list;
        this.reference = reference;
        this.after = after;
        this.element = element;
    }
    
    /**
     * {@inheritDoc}
     */
    public ListNode<N> getList()
    {
        return this.list;
    }
    
    /**
     * {@inheritDoc}
     */
    public N getReference()
    {
        return this.reference;
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
    public N getElement()
    {
        return this.element;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.list);
        args.getSecond().put("list", args.getFirst().size());
        args.getFirst().add(this.reference);
        args.getSecond().put("reference", args.getFirst().size());
        args.getFirst().add(this.after);
        args.getSecond().put("after", args.getFirst().size());
        args.getFirst().add(this.element);
        args.getSecond().put("element", args.getFirst().size());
        return args;
    }
    
    // The following is safe because we have control over how these exceptions 
    // are constructed.
    @SuppressWarnings("unchecked")
    public MetaprogramListConflictDiagnosticImpl(BsjSourceLocation source, MetaprogramListConflictException exception)
    {
        this(source, exception, exception.getFirstAnchor(), exception.getSecondAnchor(), exception.getConflictNode(), (ListNode<N>)exception.getList(), (N)exception.getReference(), exception.getAfter(), (N)exception.getElement());
    }
    
}
