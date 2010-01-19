package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;

/**
 * Represents the modifiers which can be associated with an annotation.  While <tt>public</tt> and
 * <tt>abstract</tt> are syntactically legal modifiers, they are not included here because they are implicit to all
 * annotations.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AnnotationModifiersNode extends ModifiersNode
{
    /**
     * Gets the access for the associated annotation.
     * @return The access for the associated annotation.
     */
    public AccessModifier getAccess();

    /**
     * Changes the access for the associated annotation.
     * @param access The access for the associated annotation.
     */
    public void setAccess(AccessModifier access);

    /**
     * Gets whether or not the associated annotation is static.
     * @return Whether or not the associated annotation is static.
     */
    public boolean getStaticFlag();

    /**
     * Changes whether or not the associated annotation is static.
     * @param staticFlag Whether or not the associated annotation is static.
     */
    public void setStaticFlag(boolean staticFlag);

    /**
     * Gets whether or not the associated annotation uses strict floating-point.
     * @return Whether or not the associated annotation uses strict floating-point.
     */
    public boolean getStrictfpFlag();

    /**
     * Changes whether or not the associated annotation uses strict floating-point.
     * @param strictfpFlag Whether or not the associated annotation uses strict floating-point.
     */
    public void setStrictfpFlag(boolean strictfpFlag);

}
