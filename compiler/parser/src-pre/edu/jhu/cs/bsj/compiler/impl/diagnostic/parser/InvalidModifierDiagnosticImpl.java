package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.diagnostic.parser.InvalidModifierDiagnostic;


/**
 * A diagnostic representing an invalid modifier (a modifier which appeared in an incorrect context).
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InvalidModifierDiagnosticImpl<T extends javax.tools.JavaFileObject> extends BsjParserDiagnosticImpl<T> implements InvalidModifierDiagnostic<T>
{
    /** The modifier which was used incorrectly. */
    private String modifier;
    
    public InvalidModifierDiagnosticImpl(
            long lineNumber,
            long columnNumber,
            T source,
            String ruleName,
            String modifier)
    {
        super(lineNumber, columnNumber, source, InvalidModifierDiagnostic.CODE, Kind.ERROR, ruleName);
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
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.modifier);
        return args;
    }
}
