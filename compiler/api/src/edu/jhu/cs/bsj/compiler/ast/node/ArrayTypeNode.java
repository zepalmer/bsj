package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * Represents an array type.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ArrayTypeNode extends Node, ReferenceTypeNode, LiteralizableTypeNode
{
    /**
     * Gets the element type of the array.
     * @return The element type of the array.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public TypeNode getType()throws ClassCastException;
    
    /**
     * Gets the union object for the element type of the array.
     * @return A union object representing The element type of the array.
     */
    public NodeUnion<? extends TypeNode> getUnionForType();
    
    /**
     * Changes the element type of the array.
     * @param type The element type of the array.
     */
    public void setType(TypeNode type);
    
    /**
     * Changes the element type of the array.
     * @param type The element type of the array.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForType(NodeUnion<? extends TypeNode> type) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ArrayTypeNode deepCopy(BsjNodeFactory factory);
    
}
