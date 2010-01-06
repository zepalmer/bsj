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
public interface AnnotationDeclarationNode extends NamedTypeDeclarationNode
{
    /**
     * Gets this annotation's body.
     * @return This annotation's body.
     */
    public AnnotationBodyNode getBody();

    /**
     * Changes this annotation's body.
     * @param body This annotation's body.
     */
    public void setBody(AnnotationBodyNode body);

}
