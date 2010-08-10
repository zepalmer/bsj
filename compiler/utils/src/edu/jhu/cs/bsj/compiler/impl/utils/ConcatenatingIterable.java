package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Concatenates a number of iterable objects.
 * @author Zachary Palmer
 *
 * @param <T> The type of object over which this object iterates.
 */
public class ConcatenatingIterable<T> implements Iterable<T>
{
	private Iterable<Iterable<? extends T>> iterables;

	public ConcatenatingIterable(Iterable<Iterable<? extends T>> iterables)
	{
		super();
		this.iterables = iterables;
	}
	
	public ConcatenatingIterable(Iterable<? extends T> iterable1, Iterable<? extends T> iterable2)
	{
		super();
		List<Iterable<? extends T>> list = new ArrayList<Iterable<? extends T>>(2);
		list.add(iterable1);
		list.add(iterable2);
		this.iterables = list;
	}

	@Override
	public Iterator<T> iterator()
	{
		List<Iterator<? extends T>> iterators = new LinkedList<Iterator<? extends T>>();
		for (Iterable<? extends T> it : iterables)
		{
			iterators.add(it.iterator());
		}
		return new ConcatenatingIterator<T>(iterators);
	}
}
