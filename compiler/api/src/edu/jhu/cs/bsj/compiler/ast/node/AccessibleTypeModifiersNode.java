package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A node representing the modifiers applied to a type declaration which has an access modifier.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AccessibleTypeModifiersNode extends ModifiersNode
{
    /**
     * Gets the access for the associated type.
     * @return The access for the associated type.
     */
    public AccessModifier getAccess();
    
    /**
     * Changes the access for the associated type.
     * @param access The access for the associated type.
     */
    public void setAccess(AccessModifier access);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AccessibleTypeModifiersNode deepCopy(BsjNodeFactory factory);
}
