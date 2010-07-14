package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents the modifiers which can be associated with a local class.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface LocalClassModifiersNode extends ModifiersNode
{
    /**
     * Gets whether or not the associated class is abstract.
     * @return Whether or not the associated class is abstract.
     */
    public boolean getAbstractFlag();
    
    /**
     * Changes whether or not the associated class is abstract.
     * @param abstractFlag Whether or not the associated class is abstract.
     */
    public void setAbstractFlag(boolean abstractFlag);
    
    /**
     * Gets whether or not the associated class is final.
     * @return Whether or not the associated class is final.
     */
    public boolean getFinalFlag();
    
    /**
     * Changes whether or not the associated class is final.
     * @param finalFlag Whether or not the associated class is final.
     */
    public void setFinalFlag(boolean finalFlag);
    
    /**
     * Gets whether or not the associated class uses strict floating-point.
     * @return Whether or not the associated class uses strict floating-point.
     */
    public boolean getStrictfpFlag();
    
    /**
     * Changes whether or not the associated class uses strict floating-point.
     * @param strictfpFlag Whether or not the associated class uses strict floating-point.
     */
    public void setStrictfpFlag(boolean strictfpFlag);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public LocalClassModifiersNode deepCopy(BsjNodeFactory factory);
}
