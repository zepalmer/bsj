package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents an annotation element, as in
 * <pre>
 * <i>ident</i>=<i>value</i>
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AnnotationElementNode extends Node
{
    /**
     * Gets the identifier.
     * @return The identifier.
     */
    public IdentifierNode getIdentifier();

    /**
     * Changes the identifier.
     * @param identifier The identifier.
     */
    public void setIdentifier(IdentifierNode identifier);

    /**
     * Gets the element's value.
     * @return The element's value.
     */
    public AnnotationValueNode getValue();

    /**
     * Changes the element's value.
     * @param value The element's value.
     */
    public void setValue(AnnotationValueNode value);

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnnotationElementNode deepCopy(BsjNodeFactory factory);
}
