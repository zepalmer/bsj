package edu.jhu.cs.bsj.stdlib.diagnostic.impl;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;
import javax.tools.Diagnostic.Kind;

import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;
import edu.jhu.cs.bsj.stdlib.diagnostic.MissingMethodDeclarationDiagnostic;


/**
 * A diagnostic indicating that an expected method declaration is missing.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MissingMethodDeclarationDiagnosticImpl extends MissingDeclarationDiagnosticImpl implements MissingMethodDeclarationDiagnostic
{
    public MissingMethodDeclarationDiagnosticImpl(
            Node node,
            String name)
    {
        super(MissingMethodDeclarationDiagnostic.CODE, Kind.ERROR, node, name);
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        return args;
    }
    
}
