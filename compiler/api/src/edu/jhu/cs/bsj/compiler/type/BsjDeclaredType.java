package edu.jhu.cs.bsj.compiler.type;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents a declared type in a BSJ object program's type space.  A declared type is any type which
 * requires an explicit declaration to exist.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjDeclaredType extends BsjReferenceType
{
    /**
     * Gets the annotations on this type.
     * @return The annotations on this type.
     */
    public List<BsjAnnotationReference> getAnnotations();

    /**
     * Gets the types contained within this type.
     * @return The types contained within this type.
     */
    public List<BsjDeclaredType> getInnerTypes();

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    public BsjDeclaredType deepCopy(BsjNodeFactory factory);
}
