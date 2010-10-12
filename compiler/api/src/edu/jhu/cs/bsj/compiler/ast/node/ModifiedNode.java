package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * This interface is implemented by nodes which have modifiers.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ModifiedNode<T extends ModifiersNode> extends Node
{
    /**
     * Gets the modifiers which apply to this node.
     * @return The modifiers which apply to this node.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public T getModifiers()throws ClassCastException;
    
    /**
     * Gets the union object for the modifiers which apply to this node.
     * @return A union object representing The modifiers which apply to this node.
     */
    public NodeUnion<? extends T> getUnionForModifiers();
    
    /**
     * Changes the modifiers which apply to this node.
     * @param modifiers The modifiers which apply to this node.
     */
    public void setModifiers(T modifiers);
    
    /**
     * Changes the modifiers which apply to this node.
     * @param modifiers The modifiers which apply to this node.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForModifiers(NodeUnion<? extends T> modifiers) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ModifiedNode<T> deepCopy(BsjNodeFactory factory);
    
}
