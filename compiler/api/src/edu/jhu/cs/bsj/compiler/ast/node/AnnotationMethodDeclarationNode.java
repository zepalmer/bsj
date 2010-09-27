package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * A node representing an annotation method declaration, as in:
 * <pre>
 *     <i>modifiers type identifier</i> () default <i>defaultValue</i>;
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AnnotationMethodDeclarationNode extends Node, AnnotationMemberNode, DeclarationNode, InvokableNameBindingNode, ModifiedNode<AnnotationMethodModifiersNode>
{
    /**
     * Gets the modifiers for this annotation method.
     * @return The modifiers for this annotation method.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public AnnotationMethodModifiersNode getModifiers() throws ClassCastException;
    
    /**
     * Gets the union object for the modifiers for this annotation method.
     * @return A union object representing The modifiers for this annotation method.
     */
    public NodeUnion<? extends AnnotationMethodModifiersNode> getUnionForModifiers();
    
    /**
     * Changes the modifiers for this annotation method.
     * @param modifiers The modifiers for this annotation method.
     */
    public void setModifiers(AnnotationMethodModifiersNode modifiers);
    
    /**
     * Changes the modifiers for this annotation method.
     * @param modifiers The modifiers for this annotation method.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForModifiers(NodeUnion<? extends AnnotationMethodModifiersNode> modifiers) throws NullPointerException;
    
    /**
     * Gets the return type of this annotation method.
     * @return The return type of this annotation method.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public TypeNode getType() throws ClassCastException;
    
    /**
     * Gets the union object for the return type of this annotation method.
     * @return A union object representing The return type of this annotation method.
     */
    public NodeUnion<? extends TypeNode> getUnionForType();
    
    /**
     * Changes the return type of this annotation method.
     * @param type The return type of this annotation method.
     */
    public void setType(TypeNode type);
    
    /**
     * Changes the return type of this annotation method.
     * @param type The return type of this annotation method.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForType(NodeUnion<? extends TypeNode> type) throws NullPointerException;
    
    /**
     * Gets this annotation method's name.
     * @return This annotation method's name.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public IdentifierNode getIdentifier() throws ClassCastException;
    
    /**
     * Gets the union object for this annotation method's name.
     * @return A union object representing This annotation method's name.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForIdentifier();
    
    /**
     * Changes this annotation method's name.
     * @param identifier This annotation method's name.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Changes this annotation method's name.
     * @param identifier This annotation method's name.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier) throws NullPointerException;
    
    /**
     * Gets the default value for this method.
     * @return The default value for this method.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public AnnotationValueNode getDefaultValue() throws ClassCastException;
    
    /**
     * Gets the union object for the default value for this method.
     * @return A union object representing The default value for this method.
     */
    public NodeUnion<? extends AnnotationValueNode> getUnionForDefaultValue();
    
    /**
     * Changes the default value for this method.
     * @param defaultValue The default value for this method.
     */
    public void setDefaultValue(AnnotationValueNode defaultValue);
    
    /**
     * Changes the default value for this method.
     * @param defaultValue The default value for this method.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForDefaultValue(NodeUnion<? extends AnnotationValueNode> defaultValue) throws NullPointerException;
    
    /**
     * Gets the associated javadoc comment for this node.
     * @return The associated javadoc comment for this node.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public JavadocNode getJavadoc() throws ClassCastException;
    
    /**
     * Gets the union object for the associated javadoc comment for this node.
     * @return A union object representing The associated javadoc comment for this node.
     */
    public NodeUnion<? extends JavadocNode> getUnionForJavadoc();
    
    /**
     * Changes the associated javadoc comment for this node.
     * @param javadoc The associated javadoc comment for this node.
     */
    public void setJavadoc(JavadocNode javadoc);
    
    /**
     * Changes the associated javadoc comment for this node.
     * @param javadoc The associated javadoc comment for this node.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForJavadoc(NodeUnion<? extends JavadocNode> javadoc) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnnotationMethodDeclarationNode deepCopy(BsjNodeFactory factory);
    
}
