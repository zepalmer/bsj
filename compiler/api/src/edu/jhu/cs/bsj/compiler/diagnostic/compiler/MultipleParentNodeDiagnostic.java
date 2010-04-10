package edu.jhu.cs.bsj.compiler.diagnostic.compiler;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.exception.MultipleParentNodeException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
/**
 * A diagnostic indicating that a metaprogram as assigned as a child to a node when another node was
 * already listed as its parent.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MultipleParentNodeDiagnostic extends MetaprogramDetectedErrorDiagnostic<MultipleParentNodeException>
{
    /** The code for this diagnostic. */
    public static final String CODE = "bsj.compiler.metaprogram.node.parent.multiple";
    
    /**
     * Retrieves the node which was attempting to become the parent of the child.
     * @return The node which was attempting to become the parent of the child.
     */
    public Node getParent();
    
    /**
     * Retrieves the child node which already had a parent.
     * @return The child node which already had a parent.
     */
    public Node getChild();
    
}
