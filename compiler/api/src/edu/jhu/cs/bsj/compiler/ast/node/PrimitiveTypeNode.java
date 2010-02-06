package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.PrimitiveType;

/**
 * A node representing a primitive type.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface PrimitiveTypeNode extends Node, TypeNode, BaseTypeNode, LiteralizableTypeNode
{
    /**
     * Gets the primitive type being represented.
     * @return The primitive type being represented.
     */
    public PrimitiveType getPrimitiveType();

    /**
     * Changes the primitive type being represented.
     * @param primitiveType The primitive type being represented.
     */
    public void setPrimitiveType(PrimitiveType primitiveType);

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public PrimitiveTypeNode deepCopy(BsjNodeFactory factory);
}
