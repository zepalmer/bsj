package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import java.util.List;

import javax.annotation.Generated;

/**
 * A diagnostic representing a single static import which used an unqualified name.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class UnqualifiedSingleStaticImportNameDiagnostic<T extends javax.tools.JavaFileObject> extends BsjParserDiagnostic<T>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.invalidSingleStaticImportName";
    
    /** The name which was provided. */
    private String name;
    
    public UnqualifiedSingleStaticImportNameDiagnostic(
                long lineNumber,
                long columnNumber,
                T source,
                String ruleName,
                String name)
    {
        super(lineNumber, columnNumber, source, CODE, Kind.ERROR, ruleName);
        this.name = name;
    }
    
    /**
     * Retrieves the name which was provided.
     * @return The name which was provided.
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
