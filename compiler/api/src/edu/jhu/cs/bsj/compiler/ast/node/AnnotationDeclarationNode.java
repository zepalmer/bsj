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
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AnnotationDeclarationNode extends NamedTypeDeclarationNode
{
    /**
     * Gets the modifiers for this type.
     * @return The modifiers for this type.
     */
    public AnnotationModifiersNode getModifiers();

    /**
     * Changes the modifiers for this type.
     * @param modifiers The modifiers for this type.
     */
    public void setModifiers(AnnotationModifiersNode modifiers);

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
