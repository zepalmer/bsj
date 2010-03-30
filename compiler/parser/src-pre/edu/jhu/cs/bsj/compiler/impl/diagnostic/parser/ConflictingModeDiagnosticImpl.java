package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.diagnostic.parser.ConflictingModeDiagnostic;


/**
 * A diagnostic which represents a conflicting metaprogram mode.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ConflictingModeDiagnosticImpl<T extends javax.tools.JavaFileObject> extends BsjParserDiagnosticImpl<T> implements ConflictingModeDiagnostic<T>
{
    /** The first mode which conflicts. */
    private String firstMode;
    
    /** The second mode which conflicts. */
    private String secondMode;
    
    public ConflictingModeDiagnosticImpl(
            long lineNumber,
            long columnNumber,
            T source,
            String ruleName,
            String firstMode,
            String secondMode)
    {
        super(lineNumber, columnNumber, source, ConflictingModeDiagnostic.CODE, Kind.ERROR, ruleName);
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
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.firstMode);
        args.add(this.secondMode);
        return args;
    }
}
