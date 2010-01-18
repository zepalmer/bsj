package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * Represents an array type.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ArrayTypeNode extends Node, ReferenceTypeNode,  LiteralizableTypeNode
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
