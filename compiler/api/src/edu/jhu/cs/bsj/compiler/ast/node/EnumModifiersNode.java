package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;

/**
 * Represents the modifiers which can be associated with an enum.  The <tt>static</tt> modifier is syntactically
 * legal but also implicit, so it does not appear here.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface EnumModifiersNode extends ModifiersNode
{
    /**
     * Gets the access for the associated enum.
     * @return The access for the associated enum.
     */
    public AccessModifier getAccess();

    /**
     * Changes the access for the associated enum.
     * @param access The access for the associated enum.
     */
    public void setAccess(AccessModifier access);

    /**
     * Gets whether or not the associated enum uses strict floating-point.
     * @return Whether or not the associated enum uses strict floating-point.
     */
    public boolean getStrictfpFlag();

    /**
     * Changes whether or not the associated enum uses strict floating-point.
     * @param strictfpFlag Whether or not the associated enum uses strict floating-point.
     */
    public void setStrictfpFlag(boolean strictfpFlag);

}
