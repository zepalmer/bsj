package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.diagnostic.parser.ConflictingAccessModifierDiagnostic;


/**
 * A diagnostic which represents a conflicting access modifier.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ConflictingAccessModifierDiagnosticImpl<T extends javax.tools.JavaFileObject> extends BsjParserDiagnosticImpl<T> implements ConflictingAccessModifierDiagnostic<T>
{
    /** The first modifier which conflicts. */
    private String firstModifier;
    
    /** The second modifier which conflicts. */
    private String secondModifier;
    
    public ConflictingAccessModifierDiagnosticImpl(
            long lineNumber,
            long columnNumber,
            T source,
            String ruleName,
            String firstModifier,
            String secondModifier)
    {
        super(lineNumber, columnNumber, source, ConflictingAccessModifierDiagnostic.CODE, Kind.ERROR, ruleName);
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
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.firstModifier);
        args.add(this.secondModifier);
        return args;
    }
}
