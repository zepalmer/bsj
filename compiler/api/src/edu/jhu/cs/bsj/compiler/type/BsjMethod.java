package edu.jhu.cs.bsj.compiler.type;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.AccessModifier;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents a method in the BSJ object program's type space.  The <code>varArg</code> parameter is the
 * type before the implicit array is applied.  For example, the method <code>foo(int... x)</code> would
 * have the type <code>int</code> here (and not <code>int[]</code>).
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjMethod
{
    /**
     * Gets the simple name of this method.
     * @return The simple name of this method.
     */
    public String getName();

    /**
     * Gets the type returned by invocations of this method.
     * @return The type returned by invocations of this method.
     */
    public BsjTypeReference getReturnType();

    /**
     * Gets the types of the arguments accepted by this method.
     * @return The types of the arguments accepted by this method.
     */
    public List<BsjTypeReference> getArgs();

    /**
     * Gets the type of the vararg parameter accepted by this method.
     * @return The type of the vararg parameter accepted by this method.
     */
    public BsjTypeReference getVarArg();

    /**
     * Gets the types of the arguments which are thrown by this method.
     * @return The types of the arguments which are thrown by this method.
     */
    public List<BsjTypeReference> getThrowTypes();

    /**
     * Gets the annotations applied to this method.
     * @return The annotations applied to this method.
     */
    public List<BsjAnnotationReference> getAnnotations();

    /**
     * Gets the access modifier for this method.
     * @return The access modifier for this method.
     */
    public AccessModifier getAccess();

    /**
     * Gets whether or not this method is abstract.
     * @return Whether or not this method is abstract.
     */
    public boolean getAbstractFlag();

    /**
     * Gets whether or not this method is static.
     * @return Whether or not this method is static.
     */
    public boolean getStaticFlag();

    /**
     * Gets whether or not this method is final.
     * @return Whether or not this method is final.
     */
    public boolean getFinalFlag();

    /**
     * Gets whether or not this method is synchronized.
     * @return Whether or not this method is synchronized.
     */
    public boolean getSynchronizedFlag();

    /**
     * Gets whether or not this method is native.
     * @return Whether or not this method is native.
     */
    public boolean getNativeFlag();

    /**
     * Gets whether or not this method uses strict floating-point.
     * @return Whether or not this method uses strict floating-point.
     */
    public boolean getStrictfpFlag();

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    public BsjMethod deepCopy(BsjNodeFactory factory);
}
