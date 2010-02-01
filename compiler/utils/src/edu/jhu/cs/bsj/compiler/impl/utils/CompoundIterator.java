package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class allows multiple iterators to be concatenated into a single iterator.
 * 
 * @author Zachary Palmer
 */
public class CompoundIterator<T> implements Iterator<T>
{
	/** The list of backing iterators. */
	private Iterator<Iterator<? extends T>> backingIterators;
	/** The iterator from which the next element will be drawn. */
	private Iterator<? extends T> current;
	/** The iterator from which the last element was drawn. */
	private Iterator<? extends T> last;

	/**
	 * Creates a compound iterator.
	 * 
	 * @param backingIterators The iterators to concatenate.
	 */
	public CompoundIterator(Iterator<Iterator<? extends T>> backingIterators)
	{
		super();
		this.backingIterators = backingIterators;
		this.current = null;
		this.last = null;
	}

	/**
	 * Ensures that the current iterator has something to retrieve if it is at all possible.
	 */
	private void ensureCurrent()
	{
		while (this.current == null || !this.current.hasNext())
		{
			if (this.backingIterators.hasNext())
			{
				this.current = this.backingIterators.next();
			} else
			{
				this.current = null;
				break;
			}
		}
	}

	@Override
	public boolean hasNext()
	{
		ensureCurrent();
		return this.current != null;
	}

	@Override
	public T next()
	{
		ensureCurrent();
		if (this.current == null)
		{
			throw new NoSuchElementException();
		} else
		{
			this.last = this.current;
			return this.current.next();
		}
	}

	@Override
	public void remove()
	{
		if (this.last == null)
		{
			throw new IllegalStateException();
		} else
		{
			this.last.remove();
			this.last = null;
		}
	}
}
