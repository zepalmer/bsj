package edu.jhu.cs.bsj.compiler.type;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents a type in the BSJ object program's type space which may have annotation methods amongst its members.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjAnnotationMethodMemberType extends BsjDeclaredType
{
    /**
     * Gets the annotation methods which are members of this type.
     * @return The annotation methods which are members of this type.
     */
    public List<BsjAnnotationMethod> getMethods();

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    public BsjAnnotationMethodMemberType deepCopy(BsjNodeFactory factory);
}
