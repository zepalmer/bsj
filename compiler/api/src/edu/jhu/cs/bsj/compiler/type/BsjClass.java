package edu.jhu.cs.bsj.compiler.type;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents a class in a BSJ object program's type space.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjClass extends BsjParameterizableType, BsjFieldMemberType, BsjMethodMemberType
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    public BsjClass deepCopy(BsjNodeFactory factory);
}
