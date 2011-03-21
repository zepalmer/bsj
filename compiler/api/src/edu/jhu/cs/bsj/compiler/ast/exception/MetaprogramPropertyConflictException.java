/*
 * WARNING: THIS FILE IS GENERATED.  Do not make any changes to this file
 * directly; it was generated from the BSJ source generator project.  If changes
 * are necessary, changes must be applied either to the source generator
 * application or to one of its data files.  The source generator's fully
 * qualified name is edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator.
 */

package edu.jhu.cs.bsj.compiler.ast.exception;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramPropertyConflictDiagnostic;

/**
 * Indicates that two metaprograms are in conflict because they performed write operations to the same
 * property of the same node and neither is dependent upon the other.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class MetaprogramPropertyConflictException extends MetaprogramConflictException
{
    private static final long serialVersionUID = 1L;
    
    /** The name of the property in conflict. */
    private String attributeName;
    
    public MetaprogramPropertyConflictException(
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            String attributeName)
    {
        super(firstAnchor, secondAnchor, conflictNode);
        this.attributeName = attributeName;
    }
    
    /**
     * Retrieves the name of the property in conflict.
     * @return The name of the property in conflict.
     */
    public String getAttributeName()
    {
        return this.attributeName;
    }
    
    /**
     * Creates a {@link BsjDiagnostic} corresponding to this exception type.
     * @param location The source location to report as the cause for the diagnostic.
     * @return A suitable diagnostic.
     */
    public abstract MetaprogramPropertyConflictDiagnostic getDiagnostic(BsjSourceLocation location);
}
