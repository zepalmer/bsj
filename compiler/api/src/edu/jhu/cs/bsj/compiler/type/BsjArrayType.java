package edu.jhu.cs.bsj.compiler.type;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents an array of a type in the BSJ object program's type space.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjArrayType extends BsjReferenceType
{
    /**
     * Gets the type for which an array is created.
     * @return The type for which an array is created.
     */
    public BsjType getType();

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    public BsjArrayType deepCopy(BsjNodeFactory factory);
}
