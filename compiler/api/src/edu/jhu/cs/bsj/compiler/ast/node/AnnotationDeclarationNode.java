package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

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

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnnotationDeclarationNode deepCopy(BsjNodeFactory factory);
}
