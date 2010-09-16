package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.ConflictingModeDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * A diagnostic which represents a conflicting metaprogram mode.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ConflictingModeDiagnosticImpl extends BsjParserDiagnosticImpl implements ConflictingModeDiagnostic
{
    /** The first mode which conflicts. */
    private String firstMode;
    
    /** The second mode which conflicts. */
    private String secondMode;
    
    public ConflictingModeDiagnosticImpl(
            BsjSourceLocation source,
            String ruleName,
            String firstMode,
            String secondMode)
    {
        super(source, ConflictingModeDiagnostic.CODE, Kind.ERROR, ruleName);
        this.firstMode = firstMode;
        this.secondMode = secondMode;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getFirstMode()
    {
        return this.firstMode;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getSecondMode()
    {
        return this.secondMode;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.firstMode);
        args.getSecond().put("firstMode", args.getFirst().size());
        args.getFirst().add(this.secondMode);
        args.getSecond().put("secondMode", args.getFirst().size());
        return args;
    }
    
}
