public interface NamedTypeDeclarationNode
{
	/* GEN:start */
	/**
	 * Retrieves the specified member type declaration from this node.
	 * @param name The simple name of the member type declaration to retrieve.
	 * @return The declaration of that type or <code>null</code> if no such declaration exists.
	 */
	public NamedTypeDeclarationNode<?> getTypeDeclaration(String name);
	/* GEN:stop */
}