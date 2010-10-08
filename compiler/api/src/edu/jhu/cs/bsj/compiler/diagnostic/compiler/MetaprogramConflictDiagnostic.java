/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramErrorException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
/**
 * Indicates that two metaprograms are in conflict due to some access.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramConflictDiagnostic<T extends MetaprogramErrorException> extends MetaprogramDetectedErrorDiagnostic<T>
{
    /**
     * Retrieves the anchor of the first metaprogram that conflicted.
     * @return The anchor of the first metaprogram that conflicted.
     */
    public MetaprogramAnchorNode<?> getFirstAnchor();
    
    /**
     * Retrieves the anchor of the second metaprogram that conflicted.
     * @return The anchor of the second metaprogram that conflicted.
     */
    public MetaprogramAnchorNode<?> getSecondAnchor();
    
    /**
     * Retrieves the node over which the metaprograms conflicted.
     * @return The node over which the metaprograms conflicted.
     */
    public Node getConflictNode();
    
}
