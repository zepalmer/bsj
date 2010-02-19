package edu.jhu.cs.bsj.compiler.type;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents an annotation constant value.  Boxing types (such as {@link Integer}) are used to represent
 * primitive constants (such as <code>int</code>).
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BsjAnnotationConstantValue extends BsjAnnotationValue
{
    /**
     * Gets the constant value.
     * @return The constant value.
     */
    public Object getValue();

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    public BsjAnnotationConstantValue deepCopy(BsjNodeFactory factory);
}
