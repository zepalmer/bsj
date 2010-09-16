package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.DuplicateModifierDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


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
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.modifier);
        args.getSecond().put("modifier", args.getFirst().size());
        return args;
    }
    
}
