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
	/** The current iterator. */
	private Iterator<? extends T> current;
	/** The last iterator. */
	private Iterator<? extends T> last;
	/** Indicates whether or not a remove is valid. */
	private boolean canRemove;

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
		this.canRemove = false;
	}

	/**
	 * Ensures that the current iterator has something to retrieve if it is at all possible.
	 */
	private void ensureCurrent()
	{
		if (this.current != null && !this.current.hasNext())
		{
			this.last = current;
			this.current = null;
		}
		if (this.current == null && this.backingIterators.hasNext())
		{
			this.current = this.backingIterators.next();
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
		this.canRemove = true;
		this.last = null;
		ensureCurrent();
		if (this.current == null)
		{
			throw new NoSuchElementException();
		} else
		{
			return this.current.next();
		}
	}

	@Override
	public void remove()
	{
		if (!this.canRemove)
		{
			throw new IllegalStateException();
		}
		this.canRemove = false;
		if (this.last!=null)
		{
			this.last.remove();
			this.last = null;
		} else
		{
			this.current.remove();
		}
	}
}
