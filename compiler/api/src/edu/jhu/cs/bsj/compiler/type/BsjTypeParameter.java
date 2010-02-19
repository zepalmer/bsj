package edu.jhu.cs.bsj.compiler.type;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents a type parameter for a type in the BSJ object program's type space.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjTypeParameter
{
    /**
     * Gets the simple name of the type parameter.
     * @return The simple name of the type parameter.
     */
    public String getName();

    /**
     * Gets the bounds on this type parameter.
     * @return The bounds on this type parameter.
     */
    public List<BsjTypeArgument> getBounds();

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    public BsjTypeParameter deepCopy(BsjNodeFactory factory);
}
