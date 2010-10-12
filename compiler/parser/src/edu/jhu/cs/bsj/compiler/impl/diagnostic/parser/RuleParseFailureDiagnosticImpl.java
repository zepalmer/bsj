/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.RuleParseFailureDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * A diagnostic representing a failure to parse a specific rule.  In this case, the particular rule
 * which did not parse is known and the tokens which were not parsed correctly are identified but the
 * specific problem cannot be determined.  <tt>source</tt> represents the location of the first failed
 * token; <tt>endSource</tt> represents the location of the last failed token.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class RuleParseFailureDiagnosticImpl extends BsjParserDiagnosticImpl implements RuleParseFailureDiagnostic
{
    /** The location where the parse failure stopped. */
    private BsjSourceLocation endSource;
    
    public RuleParseFailureDiagnosticImpl(
            BsjSourceLocation source,
            String ruleName,
            BsjSourceLocation endSource)
    {
        super(source, RuleParseFailureDiagnostic.CODE, Kind.ERROR, ruleName);
        this.endSource = endSource;
    }
    
    /**
     * {@inheritDoc}
     */
    public BsjSourceLocation getEndSource()
    {
        return this.endSource;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.endSource);
        args.getSecond().put("endSource", args.getFirst().size());
        return args;
    }
    
}
