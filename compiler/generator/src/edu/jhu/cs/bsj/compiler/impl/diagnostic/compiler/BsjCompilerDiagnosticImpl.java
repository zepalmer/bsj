package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.BsjCompilerDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.BsjDiagnosticImpl;


/**
 * A diagnostic which acts as a supertype for all BSJ compiler diagnostics.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class BsjCompilerDiagnosticImpl extends BsjDiagnosticImpl implements BsjCompilerDiagnostic
{
    public BsjCompilerDiagnosticImpl(
            BsjSourceLocation source,
            String code,
            javax.tools.Diagnostic.Kind kind)
    {
        super(source, code, kind);
    }
    
    @Override
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = new ArrayList<Object>();
        return args;
    }
    
}
