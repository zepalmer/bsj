package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.UnqualifiedSingleStaticImportNameDiagnostic;


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
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = super.getMessageArgs(locale);
        args.add(this.name);
        return args;
    }
    
}
