package edu.jhu.cs.bsj.compiler.type;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents a type in the BSJ object program's type space which may have type parameters.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjParameterizableType extends BsjDeclaredType
{
    /**
     * Gets the type parameters for this type.
     * @return The type parameters for this type.
     */
    public List<BsjTypeParameter> getParameters();

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    public BsjParameterizableType deepCopy(BsjNodeFactory factory);
}
