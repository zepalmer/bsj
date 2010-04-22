public interface NamedTypeDeclarationNode
{
	/* GEN:start */
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
	/* GEN:stop */
}