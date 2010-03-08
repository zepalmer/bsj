package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierListNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;

/**
 * Represents a metaprogram target declaration, as in
 * <pre>
 * #target target;
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaprogramTargetNode extends Node
{
    /**
     * Gets the names of the metaprogram targets in which to participate.
     * @return The names of the metaprogram targets in which to participate.
     */
    public IdentifierListNode getTargets();
    
    /**
     * Changes the names of the metaprogram targets in which to participate.
     * @param targets The names of the metaprogram targets in which to participate.
     */
    public void setTargets(IdentifierListNode targets);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramTargetNode deepCopy(BsjNodeFactory factory);
}
