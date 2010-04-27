package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramErrorDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * This diagnostic class is the ancestor of any diagnostic which indicates a runtime failure on the
 * part of a metaprogram.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class MetaprogramErrorDiagnosticImpl extends BsjCompilerDiagnosticImpl implements MetaprogramErrorDiagnostic
{
    public MetaprogramErrorDiagnosticImpl(
            BsjSourceLocation source,
            String code,
            javax.tools.Diagnostic.Kind kind)
    {
        super(source, code, kind);
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        return args;
    }
    
}
