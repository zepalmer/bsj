package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.DuplicateModeDiagnostic;


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
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = super.getMessageArgs(locale);
        args.add(this.mode);
        return args;
    }
    
}
