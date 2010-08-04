package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Acts as a superclass for all named type declarations.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface NamedTypeDeclarationNode<T extends Node> extends Node, TypeDeclarationNode
{
    /**
     * Gets the name of this declared type.
     * @return The name of this declared type.
     */
    public IdentifierNode getIdentifier();
    
    /**
     * Changes the name of this declared type.
     * @param identifier The name of this declared type.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Gets the associated javadoc comment for this node.
     * @return The associated javadoc comment for this node.
     */
    public JavadocNode getJavadoc();
    
    /**
     * Changes the associated javadoc comment for this node.
     * @param javadoc The associated javadoc comment for this node.
     */
    public void setJavadoc(JavadocNode javadoc);
    
    /**
     * Gets the modifiers associated with this node.
     * @return The modifiers associated with this node.
     */
    public ModifiersNode getModifiers();
    
    /**
     * Gets this type's body.
     * @return This type's body.
     */
    public TypeBodyNode<? extends T> getBody();
    
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
