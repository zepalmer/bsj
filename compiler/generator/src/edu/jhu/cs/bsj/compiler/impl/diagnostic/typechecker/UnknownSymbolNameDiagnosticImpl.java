package edu.jhu.cs.bsj.compiler.impl.diagnostic.typechecker;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.SymbolType;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.UnknownSymbolNameDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * Indicates that a name could not be resolved because no corresponding declaration could be found
 * in scope.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class UnknownSymbolNameDiagnosticImpl extends NamespaceLookupFailureDiagnosticImpl implements UnknownSymbolNameDiagnostic
{
    public UnknownSymbolNameDiagnosticImpl(
            BsjSourceLocation source,
            String name,
            SymbolType symbolType)
    {
        super(source, UnknownSymbolNameDiagnostic.CODE, Kind.ERROR, name, symbolType);
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        return args;
    }
    
}
