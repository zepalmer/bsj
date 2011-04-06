package edu.jhu.cs.bsj.compiler.impl.metaprogram;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaAnnotationMetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.user.BsjUserDiagnosticListener;
import edu.jhu.cs.bsj.compiler.metaprogram.CompilationUnitLoadingInfo;
import edu.jhu.cs.bsj.compiler.metaprogram.Context;
import edu.jhu.cs.bsj.compiler.metaprogram.ExplicitContext;
import edu.jhu.cs.bsj.compiler.metaprogram.MetaAnnotationContext;
import edu.jhu.cs.bsj.compiler.tool.typechecker.BsjTypecheckerFactory;

/**
 * A decorator for explicit contexts. This context implementation takes a basic context and decorates it with behavior
 * specific to the {@link ExplicitContext} interface.
 * 
 * @author Zachary Palmer
 */
public class MetaAnnotationContextDecorator implements MetaAnnotationContext
{
    private Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> backingContext;

    public MetaAnnotationContextDecorator(
            Context<MetaAnnotationMetaprogramAnchorNode, MetaAnnotationMetaprogramAnchorNode> backingContext)
    {
        super();
        this.backingContext = backingContext;
    }

    @Override
    public MetaAnnotationMetaprogramAnchorNode getAnchor()
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
    public MetaAnnotationMetaprogramAnchorNode getReplacement()
    {
        return this.backingContext.getReplacement();
    }

    @Override
    public void setReplacement(MetaAnnotationMetaprogramAnchorNode replacement)
    {
        this.backingContext.setReplacement(replacement);
    }
}
