package edu.jhu.cs.bsj.compiler.impl.ast.attribute;

import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramAttributeConflictException;

/**
 * This interface is implemented by any object which can function as an attribute for BSJ nodes.
 * 
 * @author Zachary Palmer
 * @param <T> The type of access type that this attribute records.
 */
public interface Attribute<T extends AccessType<T>>
{
	/**
	 * Records access to this attribute for the current metaprogram ID.  If this access causes a conflict, an appropriate
	 * exception is thrown.
	 * @param type The type of access.
	 * @throws MetaprogramAttributeConflictException If a conflict has occurred.
	 */
	public void recordAccess(T type) throws MetaprogramAttributeConflictException;
	
	/**
	 * Records access to this attribute for the given metaprogram ID.  If this access causes a conflict, an appropriate
	 * exception is thrown.
	 * @param type The type of access.
	 * @param metaprogramId The metaprogram in question.
	 * @throws MetaprogramAttributeConflictException If a conflict has occurred.
	 */
	public void recordAccess(T type, Integer metaprogramId) throws MetaprogramAttributeConflictException;
}
