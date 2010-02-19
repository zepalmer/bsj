package edu.jhu.cs.bsj.compiler.type;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents a reference to a type in the BSJ object program's type space.  A type reference contains the
 * necessary arguments to fully realize that type (such as type arguments for the underlying type's
 * parameters).
 * <p/>
 * The <tt>arguments</tt> property may not always contain a number of arguments equal to the number of
 * type parameters on the provided type.  This might occur if this reference is based on an AST which has
 * not yet been compiled and is currently inconsistent.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjTypeReference
{
    /**
     * Gets the type being referenced.
     * @return The type being referenced.
     */
    public BsjType getType();

    /**
     * Gets the type arguments to the referenced type.
     * @return The type arguments to the referenced type.
     */
    public List<BsjTypeArgument> getArguments();

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    public BsjTypeReference deepCopy(BsjNodeFactory factory);
}
