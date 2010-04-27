package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MultipleParentNodeException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MultipleParentNodeDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * A diagnostic indicating that a metaprogram as assigned as a child to a node when another node was
 * already listed as its parent.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MultipleParentNodeDiagnosticImpl extends MetaprogramDetectedErrorDiagnosticImpl<MultipleParentNodeException> implements MultipleParentNodeDiagnostic
{
    /** The node which was attempting to become the parent of the child. */
    private Node parent;
    
    /** The child node which already had a parent. */
    private Node child;
    
    public MultipleParentNodeDiagnosticImpl(
            BsjSourceLocation source,
            MultipleParentNodeException exception,
            Node parent,
            Node child)
    {
        super(source, MultipleParentNodeDiagnostic.CODE, Kind.ERROR, exception);
        this.parent = parent;
        this.child = child;
    }
    
    /**
     * {@inheritDoc}
     */
    public Node getParent()
    {
        return this.parent;
    }
    
    /**
     * {@inheritDoc}
     */
    public Node getChild()
    {
        return this.child;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.parent);
        args.getSecond().put("parent", args.getFirst().size());
        args.getFirst().add(this.child);
        args.getSecond().put("child", args.getFirst().size());
        return args;
    }
    
    public MultipleParentNodeDiagnosticImpl(BsjSourceLocation source, MultipleParentNodeException exception)
    {
        this(source, exception, exception.getParent(), exception.getChild());
    }
    
}
