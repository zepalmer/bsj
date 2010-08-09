package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents the modifiers which can be associated with a method.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MethodModifiersNode extends ModifiersNode
{
    /**
     * Gets the access for the associated method.
     * @return The access for the associated method.
     */
    public AccessModifier getAccess();
    
    /**
     * Changes the access for the associated method.
     * @param access The access for the associated method.
     */
    public void setAccess(AccessModifier access);
    
    /**
     * Gets whether or not the associated method is abstract.
     * @return Whether or not the associated method is abstract.
     */
    public boolean getAbstractFlag();
    
    /**
     * Changes whether or not the associated method is abstract.
     * @param abstractFlag Whether or not the associated method is abstract.
     */
    public void setAbstractFlag(boolean abstractFlag);
    
    /**
     * Gets whether or not the associated method is static.
     * @return Whether or not the associated method is static.
     */
    public boolean getStaticFlag();
    
    /**
     * Changes whether or not the associated method is static.
     * @param staticFlag Whether or not the associated method is static.
     */
    public void setStaticFlag(boolean staticFlag);
    
    /**
     * Gets whether or not the associated method is final.
     * @return Whether or not the associated method is final.
     */
    public boolean getFinalFlag();
    
    /**
     * Changes whether or not the associated method is final.
     * @param finalFlag Whether or not the associated method is final.
     */
    public void setFinalFlag(boolean finalFlag);
    
    /**
     * Gets whether or not the associated method is synchronized.
     * @return Whether or not the associated method is synchronized.
     */
    public boolean getSynchronizedFlag();
    
    /**
     * Changes whether or not the associated method is synchronized.
     * @param synchronizedFlag Whether or not the associated method is synchronized.
     */
    public void setSynchronizedFlag(boolean synchronizedFlag);
    
    /**
     * Gets whether or not the associated method is native.
     * @return Whether or not the associated method is native.
     */
    public boolean getNativeFlag();
    
    /**
     * Changes whether or not the associated method is native.
     * @param nativeFlag Whether or not the associated method is native.
     */
    public void setNativeFlag(boolean nativeFlag);
    
    /**
     * Gets whether or not the associated method uses strict floating-point.
     * @return Whether or not the associated method uses strict floating-point.
     */
    public boolean getStrictfpFlag();
    
    /**
     * Changes whether or not the associated method uses strict floating-point.
     * @param strictfpFlag Whether or not the associated method uses strict floating-point.
     */
    public void setStrictfpFlag(boolean strictfpFlag);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MethodModifiersNode deepCopy(BsjNodeFactory factory);
    
}
