package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.jhu.cs.bsj.compiler.impl.utils.function.Function;

/**
 * This iterator permits runtime filtering of its contents. Using this approach, one can prevent the unnecessary
 * creation of a secondary collection over which to iterate. It accepts a simple predicate function which determines
 * whether or not the specified element should be visible in the filtered view. Due to the need for lookahead in the
 * {@link FilteringIterator#hasNext()} function, remove functionality is not supported.
 * 
 * @author Zachary Palmer
 * 
 * @param <T> The type of elements in the underlying iterator.
 */
public class FilteringIterator<T> implements Iterator<T>
{
	private Iterator<? extends T> backingIterator;
	private Function<? super T, Boolean> filterFunction;

	private boolean bufferValid = false;
	private T buffer = null;

	public FilteringIterator(Iterator<? extends T> backingIterator, Function<? super T, Boolean> filterFunction)
	{
		super();
		this.backingIterator = backingIterator;
		this.filterFunction = filterFunction;
	}

	@Override
	public boolean hasNext()
	{
		if (this.bufferValid)
			return true;

		while (this.backingIterator.hasNext())
		{
			this.buffer = this.backingIterator.next();
			if (this.filterFunction.execute(this.buffer))
			{
				this.bufferValid = true;
				return true;
			}
		}

		return false;
	}

	@Override
	public T next()
	{
		if (!this.bufferValid)
		{
			// The act of asking if there is a next element will populate the buffer if possible, making it valid to
			// use. If it does not populate, the if-statement's block will run and the method will terminate.
			if (!this.hasNext())
			{
				throw new NoSuchElementException();
			}
		}

		// Buffer must be valid by now.
		this.bufferValid = false;
		return this.buffer;
	}

	@Override
	public void remove()
	{
		throw new UnsupportedOperationException();
	}
}
