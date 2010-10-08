/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.impl.diagnostic.parser;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.diagnostic.parser.ConflictingAccessModifierDiagnostic;
import edu.jhu.cs.bsj.compiler.impl.utils.Pair;


/**
 * A diagnostic which represents a conflicting access modifier.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ConflictingAccessModifierDiagnosticImpl extends BsjParserDiagnosticImpl implements ConflictingAccessModifierDiagnostic
{
    /** The first modifier which conflicts. */
    private String firstModifier;
    
    /** The second modifier which conflicts. */
    private String secondModifier;
    
    public ConflictingAccessModifierDiagnosticImpl(
            BsjSourceLocation source,
            String ruleName,
            String firstModifier,
            String secondModifier)
    {
        super(source, ConflictingAccessModifierDiagnostic.CODE, Kind.ERROR, ruleName);
        this.firstModifier = firstModifier;
        this.secondModifier = secondModifier;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getFirstModifier()
    {
        return this.firstModifier;
    }
    
    /**
     * {@inheritDoc}
     */
    public String getSecondModifier()
    {
        return this.secondModifier;
    }
    
    @Override
    protected Pair<List<Object>,Map<String,Integer>> getMessageArgs(Locale locale)
    {
        Pair<List<Object>,Map<String,Integer>> args = super.getMessageArgs(locale);
        args.getFirst().add(this.firstModifier);
        args.getSecond().put("firstModifier", args.getFirst().size());
        args.getFirst().add(this.secondModifier);
        args.getSecond().put("secondModifier", args.getFirst().size());
        return args;
    }
    
}
