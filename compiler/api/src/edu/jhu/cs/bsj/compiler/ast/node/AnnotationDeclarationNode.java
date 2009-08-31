package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents the declaration of an annotation, as in:
 * <pre>
 * <i>modifiers</i> @interface <i>name</i>
 * {
 *     <i>member</i>
 *     ...
 * }
 * </pre>
 */
public interface AnnotationDeclarationNode extends TypeDeclarationNode
{
    /**
     * Gets this annotation's mbody.
     * @return This annotation's mbody.
     */
    public AnnotationBodyNode getBody();

    /**
     * Changes this annotation's mbody.
     * @param body This annotation's mbody.
     */
    public void setBody(AnnotationBodyNode body);

}
