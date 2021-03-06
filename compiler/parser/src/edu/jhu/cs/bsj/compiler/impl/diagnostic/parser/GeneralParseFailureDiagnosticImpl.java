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
import edu.jhu.cs.bsj.compiler.diagnostic.parser.GeneralParseFailureDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * A diagnostic representing a general parsing failure starting at a given location.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class GeneralParseFailureDiagnosticImpl extends BsjParserDiagnosticImpl implements GeneralParseFailureDiagnostic
{
    /** The type of the token where the errors started. */
    private String tokenType;
    
    /** The text of the token where the errors started. */
    private String tokenText;
    
    public GeneralParseFailureDiagnosticImpl(
            BsjSourceLocation source,
            String ruleName,
            String tokenType,
            String tokenText)
    {
        super(source, GeneralParseFailureDiagnostic.CODE, Kind.ERROR, ruleName);
        this.tokenType = tokenType;
        this.tokenText = tokenText;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getTokenType()
    {
        return this.tokenType;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getTokenText()
    {
        return this.tokenText;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.tokenType);
        args.getSecond().put("tokenType", args.getFirst().size());
        args.getFirst().add(this.tokenText);
        args.getSecond().put("tokenText", args.getFirst().size());
        return args;
    }
    
}
