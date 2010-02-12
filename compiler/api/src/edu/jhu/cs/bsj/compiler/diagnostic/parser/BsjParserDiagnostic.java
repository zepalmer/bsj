package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.diagnostic.AbstractBsjDiagnostic;

/**
 * A diagnostic which acts as the parent for all parser diagnostics.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class BsjParserDiagnostic<T extends javax.tools.JavaFileObject> extends AbstractBsjDiagnostic<T>
{
    /** The rule which caused this diagnostic. */
    private String ruleName;
    
    public BsjParserDiagnostic(
                long lineNumber,
                long columnNumber,
                T source,
                String code,
                javax.tools.Diagnostic.Kind kind,
                String ruleName)
    {
        super(lineNumber, columnNumber, source, code, kind);
        this.ruleName = ruleName;
    }
    
    /**
     * Retrieves the rule which caused this diagnostic.
     * @return The rule which caused this diagnostic.
     */
    public String getRuleName()
    {
        return this.ruleName;
    }
    
    @Override
    protected List<Object> getMessageArgs()
    {
        List<Object> args = new ArrayList<Object>();
        args.add(this.ruleName);
        return args;
    }
}
