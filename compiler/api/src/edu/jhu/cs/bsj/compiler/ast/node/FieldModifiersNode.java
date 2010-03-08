package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents the modifiers which can be associated with a field.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface FieldModifiersNode extends ModifiersNode
{
    /**
     * Gets the access for the associated fields.
     * @return The access for the associated fields.
     */
    public AccessModifier getAccess();
    
    /**
     * Changes the access for the associated fields.
     * @param access The access for the associated fields.
     */
    public void setAccess(AccessModifier access);
    
    /**
     * Gets whether or not the associated field is static.
     * @return Whether or not the associated field is static.
     */
    public boolean getStaticFlag();
    
    /**
     * Changes whether or not the associated field is static.
     * @param staticFlag Whether or not the associated field is static.
     */
    public void setStaticFlag(boolean staticFlag);
    
    /**
     * Gets whether or not the associated field is final.
     * @return Whether or not the associated field is final.
     */
    public boolean getFinalFlag();
    
    /**
     * Changes whether or not the associated field is final.
     * @param finalFlag Whether or not the associated field is final.
     */
    public void setFinalFlag(boolean finalFlag);
    
    /**
     * Gets whether or not the associated field is transient.
     * @return Whether or not the associated field is transient.
     */
    public boolean getTransientFlag();
    
    /**
     * Changes whether or not the associated field is transient.
     * @param transientFlag Whether or not the associated field is transient.
     */
    public void setTransientFlag(boolean transientFlag);
    
    /**
     * Gets whether or not the associated field is volatile.
     * @return Whether or not the associated field is volatile.
     */
    public boolean getVolatileFlag();
    
    /**
     * Changes whether or not the associated field is volatile.
     * @param volatileFlag Whether or not the associated field is volatile.
     */
    public void setVolatileFlag(boolean volatileFlag);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public FieldModifiersNode deepCopy(BsjNodeFactory factory);
}
