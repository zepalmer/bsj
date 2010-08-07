package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * This interface is implemented by nodes which have modifiers.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ModifiedNode<T extends ModifiersNode> extends Node
{
    /**
     * Gets the modifiers which apply to this node.
     * @return The modifiers which apply to this node.
     */
    public T getModifiers();
    
    /**
     * Changes the modifiers which apply to this node.
     * @param modifiers The modifiers which apply to this node.
     */
    public void setModifiers(T modifiers);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ModifiedNode<T> deepCopy(BsjNodeFactory factory);
}
