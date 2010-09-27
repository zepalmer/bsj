package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

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
public interface AnnotationDeclarationNode extends Node, NamedTypeDeclarationNode<AnnotationMemberNode>, ModifiedNode<AnnotationModifiersNode>
{
    /**
     * Gets the modifiers for this type.
     * @return The modifiers for this type.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public AnnotationModifiersNode getModifiers() throws ClassCastException;
    
    /**
     * Gets the union object for the modifiers for this type.
     * @return A union object representing The modifiers for this type.
     */
    public NodeUnion<? extends AnnotationModifiersNode> getUnionForModifiers();
    
    /**
     * Changes the modifiers for this type.
     * @param modifiers The modifiers for this type.
     */
    public void setModifiers(AnnotationModifiersNode modifiers);
    
    /**
     * Changes the modifiers for this type.
     * @param modifiers The modifiers for this type.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForModifiers(NodeUnion<? extends AnnotationModifiersNode> modifiers) throws NullPointerException;
    
    /**
     * Gets this annotation's body.
     * @return This annotation's body.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public AnnotationBodyNode getBody() throws ClassCastException;
    
    /**
     * Gets the union object for this annotation's body.
     * @return A union object representing This annotation's body.
     */
    public NodeUnion<? extends AnnotationBodyNode> getUnionForBody();
    
    /**
     * Changes this annotation's body.
     * @param body This annotation's body.
     */
    public void setBody(AnnotationBodyNode body);
    
    /**
     * Changes this annotation's body.
     * @param body This annotation's body.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForBody(NodeUnion<? extends AnnotationBodyNode> body) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnnotationDeclarationNode deepCopy(BsjNodeFactory factory);
    
}
