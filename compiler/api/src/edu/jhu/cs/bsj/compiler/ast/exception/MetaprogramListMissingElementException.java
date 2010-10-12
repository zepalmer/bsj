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
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramAnchorNode;
import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MetaprogramListMissingElementDiagnostic;

/**
 * Indicates that a list operation occurred on an AST node using a base element which was not contained
 * in the list.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class MetaprogramListMissingElementException extends MetaprogramDetectedErrorException
{
    private static final long serialVersionUID = 1L;
    
    /** The metaprogram which performed the illegal operation. */
    private MetaprogramAnchorNode<?> anchor;
    
    /** The location of the metaprogram which performed the illegal operation. */
    private BsjSourceLocation metaprogram;
    
    /** The element which was used as a base in the list which did not contain it. */
    private NodeUnion<?> element;
    
    public MetaprogramListMissingElementException(
            MetaprogramAnchorNode<?> anchor,
            BsjSourceLocation metaprogram,
            NodeUnion<?> element)
    {
        super();
        this.anchor = anchor;
        this.metaprogram = metaprogram;
        this.element = element;
    }
    
    /**
     * Retrieves the metaprogram which performed the illegal operation.
     * @return The metaprogram which performed the illegal operation.
     */
    public MetaprogramAnchorNode<?> getAnchor()
    {
        return this.anchor;
    }
    
    /**
     * Retrieves the location of the metaprogram which performed the illegal operation.
     * @return The location of the metaprogram which performed the illegal operation.
     */
    public BsjSourceLocation getMetaprogram()
    {
        return this.metaprogram;
    }
    
    /**
     * Retrieves the element which was used as a base in the list which did not contain it.
     * @return The element which was used as a base in the list which did not contain it.
     */
    public NodeUnion<?> getElement()
    {
        return this.element;
    }
    
    /**
     * Creates a {@link BsjDiagnostic} corresponding to this exception type.
     * @param location The source location to report as the cause for the diagnostic.
     * @return A suitable diagnostic.
     */
    public abstract MetaprogramListMissingElementDiagnostic getDiagnostic(BsjSourceLocation location);
}
