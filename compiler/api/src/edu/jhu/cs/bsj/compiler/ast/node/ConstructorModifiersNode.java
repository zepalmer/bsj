package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents the modifiers which can be associated with a constructor.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ConstructorModifiersNode extends ModifiersNode
{
    /**
     * Gets the access for the associated constructor.
     * @return The access for the associated constructor.
     */
    public AccessModifier getAccess();

    /**
     * Changes the access for the associated constructor.
     * @param access The access for the associated constructor.
     */
    public void setAccess(AccessModifier access);

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ConstructorModifiersNode deepCopy(BsjNodeFactory factory);
}
