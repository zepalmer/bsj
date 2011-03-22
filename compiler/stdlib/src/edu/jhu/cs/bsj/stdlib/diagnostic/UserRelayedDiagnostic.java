/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.stdlib.diagnostic;

import javax.annotation.Generated;
import javax.tools.Diagnostic;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
/**
 * A diagnostic indicating that the reporting metaprogram received a compiler diagnostic from one of
 * the compiler utilities.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface UserRelayedDiagnostic extends BsjUtilDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.stdlib.diagnostic.relayed";
    
    /**
     * Retrieves the compiler diagnostic that this user diagnostic is relaying.
     * @return The compiler diagnostic that this user diagnostic is relaying.
     */
    public Diagnostic<? extends BsjSourceLocation> getDiagnostic();
    
}
