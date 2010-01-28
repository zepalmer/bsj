package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents the modifiers which can be associated with a class.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ClassModifiersNode extends ModifiersNode
{
    /**
     * Gets the access for the associated class.
     * @return The access for the associated class.
     */
    public AccessModifier getAccess();

    /**
     * Changes the access for the associated class.
     * @param access The access for the associated class.
     */
    public void setAccess(AccessModifier access);

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
     * Gets whether or not the associated class is static.
     * @return Whether or not the associated class is static.
     */
    public boolean getStaticFlag();

    /**
     * Changes whether or not the associated class is static.
     * @param staticFlag Whether or not the associated class is static.
     */
    public void setStaticFlag(boolean staticFlag);

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
    public ClassModifiersNode deepCopy(BsjNodeFactory factory);
}
