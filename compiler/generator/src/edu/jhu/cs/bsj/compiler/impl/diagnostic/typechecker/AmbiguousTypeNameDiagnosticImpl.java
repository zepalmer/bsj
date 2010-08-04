package edu.jhu.cs.bsj.compiler.impl.diagnostic.typechecker;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.AmbiguousTypeNameDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * Indicates that a type name could not be resolved because at least two different types applied.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class AmbiguousTypeNameDiagnosticImpl extends NamespaceLookupFailureDiagnosticImpl implements AmbiguousTypeNameDiagnostic
{
    /** The type declarations which caused the ambiguity. */
    private List<NamedTypeDeclarationNode<?>> examples;
    
    public AmbiguousTypeNameDiagnosticImpl(
            BsjSourceLocation source,
            String code,
            javax.tools.Diagnostic.Kind kind,
            String name,
            List<NamedTypeDeclarationNode<?>> examples)
    {
        super(source, code, kind, name);
        this.examples = examples;
    }
    
    /**
     * {@inheritDoc}
     */
    public List<NamedTypeDeclarationNode<?>> getExamples()
    {
        return this.examples;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.examples);
        args.getSecond().put("examples", args.getFirst().size());
        return args;
    }
    
}
