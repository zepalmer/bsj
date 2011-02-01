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
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramAttributeConflictDiagnostic;

/**
 * Indicates that two metaprograms are in conflict because of the manner in which they accessed the same
 * attribute of a given node.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class MetaprogramAttributeConflictException extends MetaprogramConflictException
{
    private static final long serialVersionUID = 1L;
    
    /** The name of the attribute in conflict. */
    private String attributeName;
    
    /** A description of the access performed by the first metaprogram. */
    private String firstAccess;
    
    /** A description of the access performed by the second metaprogram. */
    private String secondAccess;
    
    public MetaprogramAttributeConflictException(
            MetaprogramAnchorNode<?> firstAnchor,
            MetaprogramAnchorNode<?> secondAnchor,
            Node conflictNode,
            String attributeName,
            String firstAccess,
            String secondAccess)
    {
        super(firstAnchor, secondAnchor, conflictNode);
        this.attributeName = attributeName;
        this.firstAccess = firstAccess;
        this.secondAccess = secondAccess;
    }
    
    /**
     * Retrieves the name of the attribute in conflict.
     * @return The name of the attribute in conflict.
     */
    public String getAttributeName()
    {
        return this.attributeName;
    }
    
    /**
     * Retrieves a description of the access performed by the first metaprogram.
     * @return A description of the access performed by the first metaprogram.
     */
    public String getFirstAccess()
    {
        return this.firstAccess;
    }
    
    /**
     * Retrieves a description of the access performed by the second metaprogram.
     * @return A description of the access performed by the second metaprogram.
     */
    public String getSecondAccess()
    {
        return this.secondAccess;
    }
    
    /**
     * Creates a {@link BsjDiagnostic} corresponding to this exception type.
     * @param location The source location to report as the cause for the diagnostic.
     * @return A suitable diagnostic.
     */
    public abstract MetaprogramAttributeConflictDiagnostic getDiagnostic(BsjSourceLocation location);
}
