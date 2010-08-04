package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * This interface represents a node which has a child node that modifies it.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ModifiedNode<T extends ModifiersNode> extends Node
{
    /**
     * Gets the modifiers for this node.
     * @return The modifiers for this node.
     */
    public T getModifiers();
    
    /**
     * Changes the modifiers for this node.
     * @param modifiers The modifiers for this node.
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
