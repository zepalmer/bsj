package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.InvalidModifierDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


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
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.modifier);
        args.getSecond().put("modifier", args.getFirst().size());
        return args;
    }
    
}
