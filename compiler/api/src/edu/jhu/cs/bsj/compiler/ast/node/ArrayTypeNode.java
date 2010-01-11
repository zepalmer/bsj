package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents an array type.
 */
public interface ArrayTypeNode extends ReferenceTypeNode
{
    /**
     * Gets the element type of the array.
     * @return The element type of the array.
     */
    public TypeNode getType();

    /**
     * Changes the element type of the array.
     * @param type The element type of the array.
     */
    public void setType(TypeNode type);

}
