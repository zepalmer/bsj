package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.DuplicateModifierDiagnostic;


/**
 * A diagnostic representing a duplicated modifier.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class DuplicateModifierDiagnosticImpl extends BsjParserDiagnosticImpl implements DuplicateModifierDiagnostic
{
    /** The modifier which was duplicated. */
    private String modifier;
    
    public DuplicateModifierDiagnosticImpl(
            BsjSourceLocation source,
            String ruleName,
            String modifier)
    {
        super(source, DuplicateModifierDiagnostic.CODE, Kind.ERROR, ruleName);
        this.modifier = modifier;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getModifier()
    {
        return this.modifier;
    }
    
    @Override
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = super.getMessageArgs(locale);
        args.add(this.modifier);
        return args;
    }
    
}
