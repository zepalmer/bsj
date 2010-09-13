package edu.jhu.cs.bsj.compiler.impl.tool.typechecker.value.api;

import java.util.Collection;

import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjSelectionType;
import edu.jhu.cs.bsj.compiler.impl.tool.typechecker.type.api.BsjType;
import edu.jhu.cs.bsj.compiler.impl.utils.Bag;

/**
 * Represents a BSJ selection bag value.  This interface is not an extension of the more general {@link Bag} interface
 * because BSJ selection bags have specific constraints as to how they can be manipulated and these constraints are
 * reflected here.
 * @author Zachary Palmer
 * @param <T> A lower bound on the types of values stored in this bag.
 */
public interface SelectionBag<T>
{
	/**
	 * Selects a value of the specified type from this bag.
	 * @param type The type in question.
	 * @return The resulting value or <code>null</code> if the type in question is ambiguous.
	 */
	public T select(BsjType type);
	
	/**
	 * Selects all values of the specified type from this bag.
	 * @param type The type in question.
	 * @return The resulting values.
	 */
	public Collection<? extends T> selectAll(BsjType type);
	
	/**
	 * Calculates the type of this selection bag.
	 * @return The type of this selection bag.
	 */
	public BsjSelectionType getType();
}
