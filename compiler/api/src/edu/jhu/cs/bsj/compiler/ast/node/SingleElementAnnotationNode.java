package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents a single element annotation, as in:
 * <pre>@<i>type</i>(<i>value</i>)</pre>
 */
public interface SingleElementAnnotationNode extends AnnotationNode
{
    /**
     * Gets the value of the "value" element.
     * @return The value of the "value" element.
     */
    public AnnotationValueNode getValue();

    /**
     * Changes the value of the "value" element.
     * @param value The value of the "value" element.
     */
    public void setValue(AnnotationValueNode value);

}
