/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.diagnostic.parser;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
/**
 * A diagnostic which acts as the parent for all parser diagnostics.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjParserDiagnostic extends BsjDiagnostic
{
    /**
     * Retrieves the rule which caused this diagnostic.
     * @return The rule which caused this diagnostic.
     */
    public String getRuleName();
    
}
