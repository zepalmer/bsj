package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.Iterator;

/**
 * This adapter allows an {@link Iterable} to be used as a different but compatible type of iterable.
 * @author Zachary Palmer
 */
public class TypeTranslatingIterable<T> implements Iterable<T>
{
	/** The backing {@link Iterable}. */
	private Iterable<? extends T> iterable;

	public TypeTranslatingIterable(Iterable<? extends T> iterable)
	{
		super();
		this.iterable = iterable;
	}

	@Override
	public Iterator<T> iterator()
	{
		return new Iterator<T>()
		{
			private Iterator<? extends T> backing = TypeTranslatingIterable.this.iterable.iterator();

			@Override
			public boolean hasNext()
			{
				return this.backing.hasNext();
			}

			@Override
			public T next()
			{
				return this.backing.next();
			}

			@Override
			public void remove()
			{
				this.backing.remove();
			}
		};
	}
}
