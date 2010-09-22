package edu.jhu.cs.bsj.compiler.lang.type;

import edu.jhu.cs.bsj.compiler.utils.Bag;

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
