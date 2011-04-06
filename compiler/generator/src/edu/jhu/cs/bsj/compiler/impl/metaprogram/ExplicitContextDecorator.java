package edu.jhu.cs.bsj.compiler.impl.metaprogram;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.ExplicitMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.user.BsjUserDiagnosticListener;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoadingInfo;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.compiler.metaprogram.ExplicitContext;
import edu.jhu.cs.bsj.compiler.tool.typechecker.BsjTypecheckerFactory;

/**
 * A decorator for explicit contexts. This context implementation takes a basic context and decorates it with behavior
 * specific to the {@link ExplicitContext} interface.
 * 
 * @author Zachary Palmer
 */
public class ExplicitContextDecorator<T extends ExplicitMetaprogramAnchorNode<U>, U extends Node> implements
        ExplicitContext<T, U>
{
    private Context<T, U> backingContext;
    private Class<U> replacementClass;

    public ExplicitContextDecorator(Context<T, U> backingContext, Class<U> replacementClass)
    {
        super();
        this.backingContext = backingContext;
        this.replacementClass = replacementClass;
    }

    @Override
    public T getAnchor()
    {
        return this.backingContext.getAnchor();
    }

    @Override
    public BsjNodeFactory getFactory()
    {
        return this.backingContext.getFactory();
    }

    @Override
    public BsjTypecheckerFactory getTypecheckerFactory()
    {
        return this.backingContext.getTypecheckerFactory();
    }

    @Override
    public BsjUserDiagnosticListener getDiagnosticListener()
    {
        return this.backingContext.getDiagnosticListener();
    }

    @Override
    public CompilationUnitLoadingInfo getCompilationUnitLoadingInfo()
    {
        return this.backingContext.getCompilationUnitLoadingInfo();
    }

    @Override
    public U getReplacement()
    {
        return this.backingContext.getReplacement();
    }

    @Override
    public void setReplacement(U replacement)
    {
        this.backingContext.setReplacement(replacement);
    }

    @Override
    public void addBefore(U node)
    {
        if (node ==null)
            throw new NullPointerException();
        getPeers().addBefore(this.replacementClass.cast(this.getAnchor()), node);
    }

    @Override
    public void addAfter(U node)
    {
        if (node ==null)
            throw new NullPointerException();
        getPeers().addAfter(this.replacementClass.cast(this.getAnchor()), node);
    }

    @Override
    public ListNode<U> getPeers()
    {
        ListNode<?> parent = (ListNode<?>) this.getAnchor().getParent();
        if (parent == null)
        {
            throw new NullPointerException("anchor has null parent");
        }
        if (this.replacementClass.equals(parent.getElementType()))
        {
            // We know this warning suppression to be safe because the list node's element type matches the one which
            // represents the type parameter U.
            @SuppressWarnings("unchecked")
            ListNode<U> list = (ListNode<U>) parent;
            return list;
        } else
        {
            throw new ClassCastException("anchor is in a list node with element type "
                    + parent.getElementType().getName() + "; expected element type " + this.replacementClass.getName());
        }
    }
}
