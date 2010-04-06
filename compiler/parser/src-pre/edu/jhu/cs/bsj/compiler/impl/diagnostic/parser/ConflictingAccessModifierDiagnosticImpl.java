package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.ConflictingAccessModifierDiagnostic;


/**
 * A diagnostic which represents a conflicting access modifier.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ConflictingAccessModifierDiagnosticImpl extends BsjParserDiagnosticImpl implements ConflictingAccessModifierDiagnostic
{
    /** The first modifier which conflicts. */
    private String firstModifier;
    
    /** The second modifier which conflicts. */
    private String secondModifier;
    
    public ConflictingAccessModifierDiagnosticImpl(
            BsjSourceLocation source,
            String ruleName,
            String firstModifier,
            String secondModifier)
    {
        super(source, ConflictingAccessModifierDiagnostic.CODE, Kind.ERROR, ruleName);
        this.firstModifier = firstModifier;
        this.secondModifier = secondModifier;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getFirstModifier()
    {
        return this.firstModifier;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getSecondModifier()
    {
        return this.secondModifier;
    }
    
    @Override
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = super.getMessageArgs(locale);
        args.add(this.firstModifier);
        args.add(this.secondModifier);
        return args;
    }
    
}
