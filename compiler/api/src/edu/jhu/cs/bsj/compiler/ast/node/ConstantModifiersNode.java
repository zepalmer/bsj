package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents the modifiers which can be associated with a constant.  The modifiers
 * <tt>public</tt>, <tt>static</tt>, and <tt>final</tt> are implicit for all constants and so are not
 * listed here.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ConstantModifiersNode extends ModifiersNode
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ConstantModifiersNode deepCopy(BsjNodeFactory factory);
}
