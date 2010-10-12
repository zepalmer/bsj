/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
/**
 * A diagnostic representing a failure to parse a specific rule.  In this case, the particular rule
 * which did not parse is known and the tokens which were not parsed correctly are identified but the
 * specific problem cannot be determined.  <tt>source</tt> represents the location of the first failed
 * token; <tt>endSource</tt> represents the location of the last failed token.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface RuleParseFailureDiagnostic extends BsjParserDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.parser.error.ruleParseFailure";
    
    /**
     * Retrieves the location where the parse failure stopped.
     * @return The location where the parse failure stopped.
     */
    public BsjSourceLocation getEndSource();
    
}
