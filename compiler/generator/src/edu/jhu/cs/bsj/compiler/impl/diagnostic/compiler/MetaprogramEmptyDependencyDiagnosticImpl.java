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
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramEmptyDependencyDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * A diagnostic indicating that a metaprogram's dependency list contains a non-weak target in which
 * no metaprograms participate.  This usually indicates that the name of the target contains a
 * typographical error.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramEmptyDependencyDiagnosticImpl extends BsjCompilerDiagnosticImpl implements MetaprogramEmptyDependencyDiagnostic
{
    /** The name of the target on which the metaprogram depends. */
    private String name;
    
    public MetaprogramEmptyDependencyDiagnosticImpl(
            BsjSourceLocation source,
            String name)
    {
        super(source, MetaprogramEmptyDependencyDiagnostic.CODE, Kind.ERROR);
        this.name = name;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getName()
    {
        return this.name;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.name);
        args.getSecond().put("name", args.getFirst().size());
        return args;
    }
    
}
