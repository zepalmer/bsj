package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api;

import java.util.List;


/**
 * Represents an implicitly declared intersection type, such as in the bounds of the type parameter declaration
 * <tt>T extends A &amp; B</tt>.
 * @author Zachary Palmer
 *
 */
public interface BsjIntersectionType extends BsjDeclaredType
{
	/**
	 * Retrieves a list of the supertypes of which this type is an intersection.
	 */
	public List<? extends BsjTypeArgument> getSupertypes();
}
