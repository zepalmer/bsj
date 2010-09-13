package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.Collection;

/**
 * This interface represents a collection which acts as a bag. A bag is often described as an unordered list or a
 * multiset. The contents of a bag are not ordered but duplicates may occur.
 * 
 * @author Zachary Palmer
 * @param <T> The type of object contained in the bag.
 */
public interface Bag<T> extends Collection<T>
{
	/**
	 * Determines whether or not this bag contains all of the elements in the specified collection. In particular, if
	 * the collection contains more than one of a specified element, this bag must also contain that many of the
	 * specified element.
	 * 
	 * @param c The collection to use.
	 * @return <code>true</code> if the collection contains all of the elements in the specified collection (in at least
	 *         as large number as the provided collection) or <code>false</code> if it does not.
	 */
	public boolean containsAll(Collection<?> c);

	/**
	 * Ensures that this bag contains only the elements indicated in the specified collection. In particular, if this
	 * bag contains more elements of a given equivalent value than the specified collection, then the number of elements
	 * of that value contained by this bag will be accordingly reduced.
	 * 
	 * @param c The collection to use.
	 * @return <code>true</code> if this bag was modified as a result of this call; <code>false</code> if it was not.
	 */
	public boolean retainAll(Collection<?> c);

	public boolean equals(Object obj);

	public int hashCode();
}
