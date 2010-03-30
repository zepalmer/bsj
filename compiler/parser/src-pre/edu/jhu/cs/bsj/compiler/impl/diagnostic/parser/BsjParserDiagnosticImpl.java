package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.BsjParserDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.BsjDiagnosticImpl;


/**
 * A diagnostic which acts as the parent for all parser diagnostics.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class BsjParserDiagnosticImpl extends BsjDiagnosticImpl implements BsjParserDiagnostic
{
    /** The rule which caused this diagnostic. */
    private String ruleName;
    
    public BsjParserDiagnosticImpl(
            BsjSourceLocation source,
            String code,
            javax.tools.Diagnostic.Kind kind,
            String ruleName)
    {
        super(source, code, kind);
        this.ruleName = ruleName;
    }
    
    /**
     * {@inheritDoc}
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