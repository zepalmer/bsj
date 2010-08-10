package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Creates an iterator which effectively concatenates other iterators.
 * 
 * @author Zachary Palmer
 */
public class ConcatenatingIterator<T> implements Iterator<T>
{
	private List<Iterator<? extends T>> iterators;

	private Iterator<? extends T> lastIteratorUsed;

	public ConcatenatingIterator(List<Iterator<? extends T>> iterators)
	{
		this.iterators = new LinkedList<Iterator<? extends T>>(iterators);
	}

	public ConcatenatingIterator(Iterator<? extends T> iterator1, Iterator<? extends T> iterator2)
	{
		this.iterators = new LinkedList<Iterator<? extends T>>();
		this.iterators.add(iterator1);
		this.iterators.add(iterator2);
	}

	private Iterator<? extends T> getCurrentIterator()
	{
		while (this.iterators.size() > 0 && !this.iterators.get(0).hasNext())
		{
			this.iterators.remove(0);
		}
		if (this.iterators.size() > 0)
		{
			return this.iterators.get(0);
		} else
		{
			return null;
		}
	}

	@Override
	public boolean hasNext()
	{
		return getCurrentIterator() != null;
	}

	@Override
	public T next()
	{
		Iterator<? extends T> iterator = getCurrentIterator();
		if (iterator == null)
		{
			throw new NoSuchElementException();
		}
		T t = iterator.next();
		this.lastIteratorUsed = iterator;
		return t;
	}

	@Override
	public void remove()
	{
		if (this.lastIteratorUsed == null)
			throw new IllegalStateException(
					"No recent element retrieved; it was either already removed or never requested.");

		this.lastIteratorUsed.remove();
		this.lastIteratorUsed = null;
	}
}
