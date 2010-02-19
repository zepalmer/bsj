package edu.jhu.cs.bsj.compiler.type;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents a reference type in a BSJ object program's type space.  A reference type is any non-primitive
 * type.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjReferenceType extends BsjType, BsjTypeArgument
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    public BsjReferenceType deepCopy(BsjNodeFactory factory);
}
