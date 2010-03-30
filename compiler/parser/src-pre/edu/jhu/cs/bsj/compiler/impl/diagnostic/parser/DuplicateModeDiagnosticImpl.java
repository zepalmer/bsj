package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.diagnostic.parser.DuplicateModeDiagnostic;


/**
 * A diagnostic representing a duplicated metaprogram mode.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class DuplicateModeDiagnosticImpl<T extends javax.tools.JavaFileObject> extends BsjParserDiagnosticImpl<T> implements DuplicateModeDiagnostic<T>
{
    /** The mode which was duplicated. */
    private String mode;
    
    public DuplicateModeDiagnosticImpl(
            long lineNumber,
            long columnNumber,
            T source,
            String ruleName,
            String mode)
    {
        super(lineNumber, columnNumber, source, DuplicateModeDiagnostic.CODE, Kind.ERROR, ruleName);
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
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.mode);
        return args;
    }
}
