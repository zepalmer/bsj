package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/**
 * This specialized {@link Set} implementation is immutable and holds exactly two elements.
 * 
 * @author Zachary Palmer
 */
public class TwoElementImmutableSet<T> extends AbstractSet<T>
{
	/** The first element. */
	private T first;
	/** The second element. */
	private T second;

	public TwoElementImmutableSet(T first, T second)
	{
		super();
		this.first = first;
		this.second = second;
	}

	@Override
	public Iterator<T> iterator()
	{
		return new Iterator<T>()
		{
			private int index = 0;

			@Override
			public boolean hasNext()
			{
				return index < 2;
			}

			@Override
			public T next()
			{
				T ret;
				switch (index)
				{
					case 0:
						ret = TwoElementImmutableSet.this.first;
						break;
					case 1:
						ret = TwoElementImmutableSet.this.second;
						break;
					default:
						throw new NoSuchElementException();
				}
				index++;
				return ret;
			}

			@Override
			public void remove()
			{
				throw new UnsupportedOperationException("Cannot remove from immutable collection: "
						+ this.getClass().getName());
			}
		};
	}

	@Override
	public int size()
	{
		return 2;
	}
}
