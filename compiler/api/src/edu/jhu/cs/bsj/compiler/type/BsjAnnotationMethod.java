package edu.jhu.cs.bsj.compiler.type;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationValueNode;

/**
 * Represents an annotation method in the BSJ object program's type space.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjAnnotationMethod
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
     * Gets the default value for this method.
     * @return The default value for this method.
     */
    public AnnotationValueNode getDefaultValue();

    /**
     * Gets the annotations applied to this method.
     * @return The annotations applied to this method.
     */
    public List<BsjAnnotationReference> getAnnotations();

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    public BsjAnnotationMethod deepCopy(BsjNodeFactory factory);
}
