package edu.jhu.cs.bsj.compiler.type;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents a type in the BSJ object program's type space which may have methods amongst its members.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjMethodMemberType extends BsjDeclaredType
{
    /**
     * Gets the methods which are members of this type.
     * @return The methods which are members of this type.
     */
    public List<BsjMethod> getMethods();

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    public BsjMethodMemberType deepCopy(BsjNodeFactory factory);
}
