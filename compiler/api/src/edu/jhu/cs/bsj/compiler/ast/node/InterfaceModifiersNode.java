package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents the modifiers which can be associated with an interface.  While <tt>public</tt> and <tt>abstract</tt>
 * are syntactically legal modifiers, they are not included here because they are implicit to all interfaces.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InterfaceModifiersNode extends ModifiersNode, AccessibleTypeModifiersNode
{
    /**
     * Gets the access for the associated interface.
     * @return The access for the associated interface.
     */
    public AccessModifier getAccess();
    
    /**
     * Changes the access for the associated interface.
     * @param access The access for the associated interface.
     */
    public void setAccess(AccessModifier access);
    
    /**
     * Gets whether or not the associated interface is static.
     * @return Whether or not the associated interface is static.
     */
    public boolean getStaticFlag();
    
    /**
     * Changes whether or not the associated interface is static.
     * @param staticFlag Whether or not the associated interface is static.
     */
    public void setStaticFlag(boolean staticFlag);
    
    /**
     * Gets whether or not the associated interface uses strict floating-point.
     * @return Whether or not the associated interface uses strict floating-point.
     */
    public boolean getStrictfpFlag();
    
    /**
     * Changes whether or not the associated interface uses strict floating-point.
     * @param strictfpFlag Whether or not the associated interface uses strict floating-point.
     */
    public void setStrictfpFlag(boolean strictfpFlag);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public InterfaceModifiersNode deepCopy(BsjNodeFactory factory);
    
}
