package edu.jhu.cs.bsj.compiler.type;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents one of the primitive types in the BSJ object program's type space.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjPrimitiveType extends BsjType
{
    /**
     * Gets the primitive type represented by this object.
     * @return The primitive type represented by this object.
     */
    public Class<?> getType();

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    public BsjPrimitiveType deepCopy(BsjNodeFactory factory);
}
