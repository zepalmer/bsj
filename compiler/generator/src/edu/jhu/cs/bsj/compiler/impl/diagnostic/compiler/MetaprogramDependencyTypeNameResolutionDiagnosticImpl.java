/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.diagnostic.compiler;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramDependencyTypeNameResolutionDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * A diagnostic indicating that a metaprogram's dependency list contains a target whose type name could
 * not be resolved.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramDependencyTypeNameResolutionDiagnosticImpl extends BsjCompilerDiagnosticImpl implements MetaprogramDependencyTypeNameResolutionDiagnostic
{
    /** The name of the type which could not be resolved. */
    private String typeName;
    
    public MetaprogramDependencyTypeNameResolutionDiagnosticImpl(
            BsjSourceLocation source,
            String typeName)
    {
        super(source, MetaprogramDependencyTypeNameResolutionDiagnostic.CODE, Kind.ERROR);
        this.typeName = typeName;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getTypeName()
    {
        return this.typeName;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.typeName);
        args.getSecond().put("typeName", args.getFirst().size());
        return args;
    }
    
}
