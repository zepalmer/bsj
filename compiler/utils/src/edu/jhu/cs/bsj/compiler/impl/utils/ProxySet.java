package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * This proxy class activates template methods whenever changes to it are made.
 * 
 * @author Zachary Palmer
 * 
 * @param <T> The type of objects contained within this set.
 */
public abstract class ProxySet<T> extends AbstractSet<T> implements Set<T>
{
	/** The backing list. */
	private Set<T> backingSet;

	/**
	 * Creates a new, empty proxy set.
	 */
	public ProxySet()
	{
		this(new HashSet<T>());
	}

	/**
	 * Creates a new proxy set.
	 * 
	 * @param backingSet The backing set for this proxy.
	 */
	public ProxySet(Set<T> backingSet)
	{
		super();
		this.backingSet = backingSet;

		for (T element : backingSet)
		{
			elementAdded(element);
		}
	}

	/**
	 * This method is invoked whenever a new element is introduced to this set. This method's invocation occurs after
	 * the addition.
	 * 
	 * @param element The new element.
	 */
	protected abstract void elementAdded(T element);

	/**
	 * This method is invoked whenever an element is removed from this set. This method's invocation occurs after the
	 * removal.
	 * 
	 * @param element The element which was removed.
	 */
	protected abstract void elementRemoved(T element);

	@Override
	public Iterator<T> iterator()
	{
		return new Iterator<T>()
		{
			private Iterator<T> it = ProxySet.this.backingSet.iterator();
			private T last = null;

			@Override
			public boolean hasNext()
			{
				return it.hasNext();
			}

			@Override
			public T next()
			{
				last = it.next();
				return last;
			}

			@Override
			public void remove()
			{
				it.remove();
				elementRemoved(last);
			}
		};
	}

	@Override
	public boolean add(T e)
	{
		boolean ret = this.backingSet.add(e);
		if (ret)
		{
			elementAdded(e);
		}
		return ret;
	}

	@Override
	public int size()
	{
		return this.backingSet.size();
	}
}
