package edu.jhu.cs.bsj.compiler.impl.diagnostic.typechecker;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.UnknownTypeNameDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * Indicates that a type name could not be resolved because no such type declaration could be found
 * in scope.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class UnknownTypeNameDiagnosticImpl extends NamespaceLookupFailureDiagnosticImpl implements UnknownTypeNameDiagnostic
{
    public UnknownTypeNameDiagnosticImpl(
            BsjSourceLocation source,
            String name)
    {
        super(source, UnknownTypeNameDiagnostic.CODE, Kind.ERROR, name);
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        return args;
    }
    
}
