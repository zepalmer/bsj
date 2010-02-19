package edu.jhu.cs.bsj.compiler.type;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents a type in a BSJ object program's type space.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjType
{
    /**
     * Gets the simple name of this type.
     * @return The simple name of this type.
     */
    public String getName();

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    public BsjType deepCopy(BsjNodeFactory factory);
}
