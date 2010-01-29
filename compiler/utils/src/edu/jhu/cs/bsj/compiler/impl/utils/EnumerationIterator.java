package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * This adapter class allows an enumeration to be used like an iterator.
 * @author Zachary Palmer
 */
public class EnumerationIterator<T> implements Iterator<T>, Iterable<T>
{
	/** The backing enumeration. */
	private Enumeration<? extends T> backingEnumeration;

	/**
	 * Creates the adapter.
	 * @param backingEnumeration The backing enumeration.
	 */
	public EnumerationIterator(Enumeration<? extends T> backingEnumeration)
	{
		super();
		this.backingEnumeration = backingEnumeration;
	}

	@Override
	public boolean hasNext()
	{
		return this.backingEnumeration.hasMoreElements();
	}

	@Override
	public T next()
	{
		return this.backingEnumeration.nextElement();
	}

	@Override
	public void remove()
	{
		throw new UnsupportedOperationException("Enumerations do not support removal.");
	}

	@Override
	public Iterator<T> iterator()
	{
		return this;
	}
}
