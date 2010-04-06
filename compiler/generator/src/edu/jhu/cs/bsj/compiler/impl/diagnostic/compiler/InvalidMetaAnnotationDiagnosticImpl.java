package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.InvalidMetaAnnotationDiagnostic;


/**
 * A diagnostic indicating a problem with a meta-annotation's use. 
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class InvalidMetaAnnotationDiagnosticImpl extends BsjCompilerDiagnosticImpl implements InvalidMetaAnnotationDiagnostic
{
    public InvalidMetaAnnotationDiagnosticImpl(
            BsjSourceLocation source,
            String code,
            javax.tools.Diagnostic.Kind kind)
    {
        super(source, code, kind);
    }
    
    @Override
    protected List<Object> getMessageArgs(Locale locale)
    {
        List<Object> args = super.getMessageArgs(locale);
        return args;
    }
    
}
