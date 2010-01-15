package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

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
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
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
