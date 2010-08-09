package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents the modifiers which can be associated with an enum constant.  Only annotations and
 * meta-annotations can be used.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface EnumConstantModifiersNode extends ModifiersNode
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public EnumConstantModifiersNode deepCopy(BsjNodeFactory factory);
    
}
