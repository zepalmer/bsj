package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.diagnostic.parser.UnqualifiedSingleStaticImportNameDiagnostic;


/**
 * A diagnostic representing a single static import which used an unqualified name.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class UnqualifiedSingleStaticImportNameDiagnosticImpl<T extends javax.tools.JavaFileObject> extends BsjParserDiagnosticImpl<T> implements UnqualifiedSingleStaticImportNameDiagnostic<T>
{
    /** The name which was provided. */
    private String name;
    
    public UnqualifiedSingleStaticImportNameDiagnosticImpl(
            long lineNumber,
            long columnNumber,
            T source,
            String ruleName,
            String name)
    {
        super(lineNumber, columnNumber, source, UnqualifiedSingleStaticImportNameDiagnostic.CODE, Kind.ERROR, ruleName);
        this.name = name;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getName()
    {
        return this.name;
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = super.getMessageArgs();
        args.add(this.name);
        return args;
    }
}
