package edu.jhu.cs.bsj.compiler.impl.diagnostic.typechecker;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.OnDemandImportAmbiguousTypeNameDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * Indicates that multiple on-demand imports cause ambiguity over the simple name.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class OnDemandImportAmbiguousTypeNameDiagnosticImpl extends AmbiguousTypeNameDiagnosticImpl implements OnDemandImportAmbiguousTypeNameDiagnostic
{
    public OnDemandImportAmbiguousTypeNameDiagnosticImpl(
            BsjSourceLocation source,
            String name,
            List<NamedTypeDeclarationNode<?>> examples)
    {
        super(source, OnDemandImportAmbiguousTypeNameDiagnostic.CODE, Kind.ERROR, name, examples);
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        return args;
    }
    
}
