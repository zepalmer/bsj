package edu.jhu.cs.bsj.compiler.type;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents a type in the BSJ object program's type space which may have fields amongst its members.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjFieldMemberType extends BsjDeclaredType
{
    /**
     * Gets the fields which are members of this type.
     * @return The fields which are members of this type.
     */
    public List<BsjField> getFields();

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    public BsjFieldMemberType deepCopy(BsjNodeFactory factory);
}
