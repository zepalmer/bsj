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
import edu.jhu.cs.bsj.compiler.diagnostic.BsjDiagnostic;
import edu.jhu.cs.bsj.compiler.diagnostic.compiler.MultipleParentNodeDiagnostic;

/**
 * An exception indicating that a metaprogram as assigned as a child to a node when another node
 * was already listed as its parent.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class MultipleParentNodeException extends MetaprogramDetectedErrorException
{
    private static final long serialVersionUID = 1L;
    
    /** The node which was attempting to become the parent of the child. */
    private Node parent;
    
    /** The child node which already had a parent. */
    private Node child;
    
    public MultipleParentNodeException(
            Node parent,
            Node child)
    {
        super();
        this.parent = parent;
        this.child = child;
    }
    
    /**
     * Retrieves the node which was attempting to become the parent of the child.
     * @return The node which was attempting to become the parent of the child.
     */
    public Node getParent()
    {
        return this.parent;
    }
    
    /**
     * Retrieves the child node which already had a parent.
     * @return The child node which already had a parent.
     */
    public Node getChild()
    {
        return this.child;
    }
    
    /**
     * Creates a {@link BsjDiagnostic} corresponding to this exception type.
     * @param location The source location to report as the cause for the diagnostic.
     * @return A suitable diagnostic.
     */
    public abstract MultipleParentNodeDiagnostic getDiagnostic(BsjSourceLocation location);
}
