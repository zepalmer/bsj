package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.Iterator;

/**
 * An iterator proxy which prevents mutation access.
 * @author Zachary Palmer
 *
 * @param <T> The type of object returned by the iterator.
 */
public class ImmutableIterator<T> implements Iterator<T>
{
	private Iterator<T> backingIterator;

	public ImmutableIterator(Iterator<T> backingIterator)
	{
		super();
		this.backingIterator = backingIterator;
	}

	@Override
	public boolean hasNext()
	{
		return this.backingIterator.hasNext();
	}

	@Override
	public T next()
	{
		return this.backingIterator.next();
	}

	@Override
	public void remove()
	{
		throw new UnsupportedOperationException();
	}
}
