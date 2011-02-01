/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramAttributeConflictException;
/**
 * Indicates that two metaprograms are in conflict because of the manner in which they accessed the same
 * attribute of a given node.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramAttributeConflictDiagnostic extends MetaprogramConflictDiagnostic<MetaprogramAttributeConflictException>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaprogram.failure.conflict.attribute";
    
    /**
     * Retrieves the name of the attribute in conflict.
     * @return The name of the attribute in conflict.
     */
    public String getAttributeName();
    
    /**
     * Retrieves a description of the access performed by the first metaprogram.
     * @return A description of the access performed by the first metaprogram.
     */
    public String getFirstAccess();
    
    /**
     * Retrieves a description of the access performed by the second metaprogram.
     * @return A description of the access performed by the second metaprogram.
     */
    public String getSecondAccess();
    
}
