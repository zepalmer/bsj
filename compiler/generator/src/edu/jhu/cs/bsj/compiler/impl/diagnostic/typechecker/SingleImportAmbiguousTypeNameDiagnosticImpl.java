package edu.jhu.cs.bsj.compiler.impl.diagnostic.typechecker;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.diagnostic.typechecker.SingleImportAmbiguousTypeNameDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * Indicates that multiple single imports cause ambiguity over the simple name.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class SingleImportAmbiguousTypeNameDiagnosticImpl extends AmbiguousTypeNameDiagnosticImpl implements SingleImportAmbiguousTypeNameDiagnostic
{
    public SingleImportAmbiguousTypeNameDiagnosticImpl(
            BsjSourceLocation source,
            String name,
            List<NamedTypeDeclarationNode<?>> examples)
    {
        super(source, SingleImportAmbiguousTypeNameDiagnostic.CODE, Kind.ERROR, name, examples);
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        return args;
    }
    
}
