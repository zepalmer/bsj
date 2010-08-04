package edu.jhu.cs.bsj.compiler.impl.diagnostic.typechecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.BsjTypeCheckerDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.diagnostic.BsjDiagnosticImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * A diagnostic which acts as a supertype for all BSJ type checking diagnostics.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class BsjTypeCheckerDiagnosticImpl extends BsjDiagnosticImpl implements BsjTypeCheckerDiagnostic
{
    public BsjTypeCheckerDiagnosticImpl(
            BsjSourceLocation source,
            String code,
            javax.tools.Diagnostic.Kind kind)
    {
        super(source, code, kind);
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = new Pair<List<Object>,Map<String,Integer>>(new ArrayList<Object>(), new HashMap<String,Integer>());
        return args;
    }
    
}
