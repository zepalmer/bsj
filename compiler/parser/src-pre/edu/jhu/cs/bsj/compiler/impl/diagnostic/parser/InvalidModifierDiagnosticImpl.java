package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.InvalidModifierDiagnostic;


/**
 * A diagnostic representing an invalid modifier (a modifier which appeared in an incorrect context).
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InvalidModifierDiagnosticImpl extends BsjParserDiagnosticImpl implements InvalidModifierDiagnostic
{
    /** The modifier which was used incorrectly. */
    private String modifier;
    
    public InvalidModifierDiagnosticImpl(
            BsjSourceLocation source,
            String ruleName,
            String modifier)
    {
        super(source, InvalidModifierDiagnostic.CODE, Kind.ERROR, ruleName);
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
