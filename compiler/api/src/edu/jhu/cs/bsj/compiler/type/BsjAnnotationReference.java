package edu.jhu.cs.bsj.compiler.type;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents an annotation applied to a type or one of its members in the BSJ object program's type space.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjAnnotationReference
{
    /**
     * Gets the annotation being referenced.
     * @return The annotation being referenced.
     */
    public BsjAnnotation getType();

    /**
     * Gets the arguments to this annotation reference.
     * @return The arguments to this annotation reference.
     */
    public List<BsjAnnotationValueElement> getArguments();

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    public BsjAnnotationReference deepCopy(BsjNodeFactory factory);
}
