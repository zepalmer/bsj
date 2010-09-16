package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.InvalidModeDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * A diagnostic representing an invalid metaprogram mode.  Because metaprogram modes are identifiers
 * and not keywords, use of an incorrect mode (one which is parseable as a keyword but has no BSJ
 * meaning) is reported through this type of diagnostic rather than a typical parse failure.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InvalidModeDiagnosticImpl extends BsjParserDiagnosticImpl implements InvalidModeDiagnostic
{
    /** The invalid mode. */
    private String mode;
    
    public InvalidModeDiagnosticImpl(
            BsjSourceLocation source,
            String ruleName,
            String mode)
    {
        super(source, InvalidModeDiagnostic.CODE, Kind.ERROR, ruleName);
        this.mode = mode;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getMode()
    {
        return this.mode;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.mode);
        args.getSecond().put("mode", args.getFirst().size());
        return args;
    }
    
}
