package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.Collection;
import java.util.Iterator;

import edu.jhu.cs.bsj.compiler.utils.Bag;

/**
 * A proxy bag which prevents mutation access to the underlying bag.
 */
public class UnmodifiableBag<T> implements Bag<T>
{
	private Bag<T> backingBag;

	public UnmodifiableBag(Bag<T> backingBag)
	{
		super();
		this.backingBag = backingBag;
	}

	@Override
	public int size()
	{
		return this.backingBag.size();
	}

	@Override
	public boolean isEmpty()
	{
		return this.backingBag.isEmpty();
	}

	@Override
	public boolean contains(Object o)
	{
		return this.backingBag.contains(o);
	}

	@Override
	public Iterator<T> iterator()
	{
		return new ImmutableIterator<T>(this.backingBag.iterator());
	}

	@Override
	public Object[] toArray()
	{
		return this.backingBag.toArray();
	}

	@Override
	public <E> E[] toArray(E[] a)
	{
		return this.backingBag.toArray(a);
	}

	@Override
	public boolean add(T e)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean remove(Object o)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean addAll(Collection<? extends T> c)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean removeAll(Collection<?> c)
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public void clear()
	{
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean containsAll(Collection<?> c)
	{
		return this.backingBag.containsAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c)
	{
		throw new UnsupportedOperationException();
	}

    @Override
    public int count(T element)
    {
        return this.backingBag.count(element);
    }
}
