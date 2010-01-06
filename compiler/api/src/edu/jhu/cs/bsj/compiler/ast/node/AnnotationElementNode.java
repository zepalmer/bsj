package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents an annotation element, as in
 * <pre>
 * <i>ident</i>=<i>value</i>
 * </pre>
 */
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

}