/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramListMissingElementException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
/**
 * Indicates that a list operation occurred on an AST node using a base element which was not contained
 * in the list.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramListMissingElementDiagnostic extends MetaprogramDetectedErrorDiagnostic<MetaprogramListMissingElementException>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaprogram.failure.list.element.missing";
    
    /**
     * Retrieves the metaprogram which performed the illegal operation.
     * @return The metaprogram which performed the illegal operation.
     */
    public MetaprogramAnchorNode<?> getAnchor();
    
    /**
     * Retrieves the location of the metaprogram which performed the illegal operation.
     * @return The location of the metaprogram which performed the illegal operation.
     */
    public BsjSourceLocation getMetaprogram();
    
    /**
     * Retrieves the element which was used as a base in the list which did not contain it.
     * @return The element which was used as a base in the list which did not contain it.
     */
    public Node getElement();
    
}
