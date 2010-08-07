package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.Iterator;

import edu.jhu.cs.bsj.compiler.impl.utils.function.Function;

/**
 * A wrapper {@link Iterable} which produces {@link FilteringIterator}s.
 * @author Zachary Palmer
 */
public class FilteringIterable<T> implements Iterable<T>
{
	private Iterable<? extends T> backingIterable;
	private Function<? super T, Boolean> filterFunction;

	public FilteringIterable(Iterable<? extends T> backingIterable, Function<? super T, Boolean> filterFunction)
	{
		super();
		this.backingIterable = backingIterable;
		this.filterFunction = filterFunction;
	}


	@Override
	public Iterator<T> iterator()
	{
		return new FilteringIterator<T>(this.backingIterable.iterator(), this.filterFunction);
	}
}
