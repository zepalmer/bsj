package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.UnqualifiedSingleStaticImportNameDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * A diagnostic representing a single static import which used an unqualified name.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class UnqualifiedSingleStaticImportNameDiagnosticImpl extends BsjParserDiagnosticImpl implements UnqualifiedSingleStaticImportNameDiagnostic
{
    /** The name which was provided. */
    private String name;
    
    public UnqualifiedSingleStaticImportNameDiagnosticImpl(
            BsjSourceLocation source,
            String ruleName,
            String name)
    {
        super(source, UnqualifiedSingleStaticImportNameDiagnostic.CODE, Kind.ERROR, ruleName);
        this.name = name;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getName()
    {
        return this.name;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.name);
        args.getSecond().put("name", args.getFirst().size());
        return args;
    }
    
}
