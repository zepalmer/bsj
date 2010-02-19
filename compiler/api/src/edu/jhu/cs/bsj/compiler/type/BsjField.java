package edu.jhu.cs.bsj.compiler.type;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents a field in the BSJ object program's type space.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjField
{
    /**
     * Gets the simple name of this field.
     * @return The simple name of this field.
     */
    public String getName();

    /**
     * Gets the type of this field.
     * @return The type of this field.
     */
    public BsjTypeReference getType();

    /**
     * Gets the annotations applied to this field.
     * @return The annotations applied to this field.
     */
    public List<BsjAnnotationReference> getAnnotations();

    /**
     * Gets the access modifier for this field.
     * @return The access modifier for this field.
     */
    public AccessModifier getAccess();

    /**
     * Gets whether or not this field is static.
     * @return Whether or not this field is static.
     */
    public boolean getStaticFlag();

    /**
     * Gets whether or not this field is final.
     * @return Whether or not this field is final.
     */
    public boolean getFinalFlag();

    /**
     * Gets whether or not this field is transient.
     * @return Whether or not this field is transient.
     */
    public boolean getTransientFlag();

    /**
     * Gets whether or not this field is volatile.
     * @return Whether or not this field is volatile.
     */
    public boolean getVolatileFlag();

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    public BsjField deepCopy(BsjNodeFactory factory);
}
