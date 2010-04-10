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
