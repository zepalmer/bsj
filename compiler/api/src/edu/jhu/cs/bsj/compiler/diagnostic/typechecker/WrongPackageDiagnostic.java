/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.diagnostic.typechecker;

import javax.annotation.Generated;
/**
 * A diagnostic indicating that a compilation unit does not contain a correct package declaration.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface WrongPackageDiagnostic extends BsjTypeCheckerDiagnostic
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.typechecker.incorrectPackageDeclaration";
    
    /**
     * Retrieves the name of the expected package declaration.
     * @return The name of the expected package declaration.
     */
    public String getExpectedName();
    
    /**
     * Retrieves the name of the package declaration which was found.
     * @return The name of the package declaration which was found.
     */
    public String getActualName();
    
}
