package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * Acts as a superclass for all named type declarations.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface NamedTypeDeclarationNode<T extends Node> extends Node, TypeDeclarationNode, TypeNameBindingNode
{
    /**
     * Gets the name of this declared type.
     * @return The name of this declared type.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public IdentifierNode getIdentifier() throws ClassCastException;
    
    /**
     * Gets the union object for the name of this declared type.
     * @return A union object representing The name of this declared type.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForIdentifier();
    
    /**
     * Changes the name of this declared type.
     * @param identifier The name of this declared type.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Changes the name of this declared type.
     * @param identifier The name of this declared type.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier) throws NullPointerException;
    
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
     * Gets the modifiers associated with this node.
     * @return The modifiers associated with this node.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ModifiersNode getModifiers() throws ClassCastException;
    
    /**
     * Gets the union object for the modifiers associated with this node.
     * @return A union object representing The modifiers associated with this node.
     */
    public NodeUnion<? extends ModifiersNode> getUnionForModifiers();
    
    /**
     * Gets this type's body.
     * @return This type's body.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public TypeBodyNode<? extends T> getBody() throws ClassCastException;
    
    /**
     * Gets the union object for this type's body.
     * @return A union object representing This type's body.
     */
    public NodeUnion<? extends TypeBodyNode<? extends T>> getUnionForBody();
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public NamedTypeDeclarationNode<T> deepCopy(BsjNodeFactory factory);
    
	/**
	 * Retrieves the specified member type declaration from this node.
	 * 
	 * @param name The simple name of the member type declaration to retrieve.
	 * @return The declaration of that type or <code>null</code> if no such declaration exists.
	 */
	public NamedTypeDeclarationNode<?> getTypeDeclaration(String name);

	/**
	 * Retrieves the fully qualified name of this type declaration as a string. A named type declaration might not have
	 * a fully qualified name if it appears as a local class inside of a method, a member of an anonymous class, or is
	 * simply disconnected from the root package node.
	 * 
	 * @return The fully qualified name of this type declaration or <code>null</code> if this type declaration does not
	 *         have one.
	 */
	public String getFullyQualifiedName();
}
