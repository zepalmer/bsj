package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Implements a compound iterable object. This object is comprised of a number of underlying iterable objects which are
 * iterated in turn when this object is asked for an iterator.
 * 
 * @author Zachary Palmer
 * 
 * @param <T>
 */
public class CompoundIterable<T> implements Iterable<T>
{
	/** The iterable object containing the iterables. */
	private Iterable<Iterable<? extends T>> backingIterables;

	/**
	 * Creates a new compound iterable for two backing iterables. This is a convenience routine.
	 */
	public CompoundIterable(Iterable<? extends T> a, Iterable<? extends T> b)
	{
		this(new TwoElementImmutableList<Iterable<? extends T>>(a, b));
	}

	/**
	 * Creates a new compound iterable.
	 * 
	 * @param backingIterables The iterable object containing the iterables.
	 */
	public CompoundIterable(Iterable<Iterable<? extends T>> backingIterables)
	{
		super();
		this.backingIterables = backingIterables;
	}

	@Override
	public Iterator<T> iterator()
	{
		List<Iterator<? extends T>> list = new ArrayList<Iterator<? extends T>>();
		for (Iterable<? extends T> iterable : this.backingIterables)
		{
			list.add(iterable.iterator());
		}
		return new CompoundIterator<T>(list.iterator());
	}
}
