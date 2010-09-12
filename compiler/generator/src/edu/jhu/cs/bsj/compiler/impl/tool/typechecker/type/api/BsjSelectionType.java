package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api;

import edu.jhu.cs.bsj.compiler.impl.utils.Bag;

/**
 * Reprsents a selection type over multiple other types (as specified in the BSJ Language Specification).  Selection
 * types are not part of the core Java language and are used specifically for raw code literals.
 * @author Zachary Palmer
 */
public interface BsjSelectionType extends BsjActualType
{
	/**
	 * Permits iteration over the component types of this selection type.
	 */
	public Bag<? extends BsjActualType> getComponentTypes();
}
