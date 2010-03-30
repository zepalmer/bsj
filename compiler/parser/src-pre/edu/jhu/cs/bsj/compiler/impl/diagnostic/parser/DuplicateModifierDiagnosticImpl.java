package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.diagnostic.parser.DuplicateModifierDiagnostic;


/**
 * A diagnostic representing a duplicated modifier.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class DuplicateModifierDiagnosticImpl<T extends javax.tools.JavaFileObject> extends BsjParserDiagnosticImpl<T> implements DuplicateModifierDiagnostic<T>
{
    /** The modifier which was duplicated. */
    private String modifier;
    
    public DuplicateModifierDiagnosticImpl(
            long lineNumber,
            long columnNumber,
            T source,
            String ruleName,
            String modifier)
    {
        super(lineNumber, columnNumber, source, DuplicateModifierDiagnostic.CODE, Kind.ERROR, ruleName);
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
