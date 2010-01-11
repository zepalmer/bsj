package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.NameCategory;

/**
 * A common supertype for all nodes representing a name.  In Java, a name is either a simple name (a single
 * identifier) or a qualified name (a name, a dot, and an identifier).  The meaning of a name is context-sensitive
 * and is partially dependent upon type information; therefore, this node maintains information about the facts
 * currently known about this name.
 * <p/>
 * Note that some identifiers are not used as names; as a result, not all identifiers are children of this class
 * or one of its subclasses.  Examples of such cases include variable and type declarations, where the identifier
 * is not technically a name because it is being used to create a name which does not exist.  For more information,
 * please see the Java Language Specification v3.0 &
 */
public interface NameNode extends Node
{
    /**
     * Gets the category for this name.
     * @return The category for this name.
     */
    public NameCategory getCategory();

	// TODO: Protect this method call to prevent it from being abused by misbehaving metaprograms.
	// TODO: Improve error handling; we should be able to log errors on a node based on some vaguely global context
	//       (possibly provided by the node factory?).
	/**
	 * Asserts that this node should fall into the specified category.
	 * @param category The category into which this node should fall.
	 * @throws IllegalStateException If this node cannot fall into that category because it has already been marked with
	 *                               another category.
	 */
	public void assertCategory(NameCategory category);
}
