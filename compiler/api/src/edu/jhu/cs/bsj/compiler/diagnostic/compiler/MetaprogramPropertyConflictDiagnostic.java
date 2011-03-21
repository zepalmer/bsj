/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramPropertyConflictException;
/**
 * Indicates that two metaprograms are in conflict because they performed write operations to the same
 * property of the same node and neither is dependent upon the other.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramPropertyConflictDiagnostic extends MetaprogramConflictDiagnostic<MetaprogramPropertyConflictException>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaprogram.failure.conflict.property";
    
    /**
     * Retrieves the name of the property in conflict.
     * @return The name of the property in conflict.
     */
    public String getAttributeName();
    
}
