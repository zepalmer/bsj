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
 * Indicates that a namespace lookup failed during BSJ type checking.  This means that some name
 * could not be resolved to a unique symbol (type, method, or variable).
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface NamespaceLookupFailureDiagnostic extends BsjTypeCheckerDiagnostic
{
    /**
     * Retrieves the name of the symbol which could not be resolved or was ambiguous.
     * @return The name of the symbol which could not be resolved or was ambiguous.
     */
    public String getName();
    
    /**
     * Retrieves the type of symbol that could not be resolved.
     * @return The type of symbol that could not be resolved.
     */
    public SymbolType getSymbolType();
    
}
