package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.DuplicateModeDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * A diagnostic representing a duplicated metaprogram mode.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class DuplicateModeDiagnosticImpl extends BsjParserDiagnosticImpl implements DuplicateModeDiagnostic
{
    /** The mode which was duplicated. */
    private String mode;
    
    public DuplicateModeDiagnosticImpl(
            BsjSourceLocation source,
            String ruleName,
            String mode)
    {
        super(source, DuplicateModeDiagnostic.CODE, Kind.ERROR, ruleName);
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
