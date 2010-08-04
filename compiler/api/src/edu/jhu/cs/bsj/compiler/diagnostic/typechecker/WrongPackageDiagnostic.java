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
