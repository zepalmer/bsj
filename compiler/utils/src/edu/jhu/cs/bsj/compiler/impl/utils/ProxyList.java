package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * This proxy class activates template methods whenever changes to it are made.
 * 
 * @author Zachary Palmer
 * 
 * @param <T> The type of objects contained within this list.
 */
public abstract class ProxyList<T> implements List<T>
{
	/** The backing list. */
	private List<T> backingList;

	/**
	 * Creates a new proxy list.
	 * 
	 * @param backingList The backing list for this proxy.
	 */
	public ProxyList(List<T> backingList)
	{
		super();
		this.backingList = backingList;
	}

	/**
	 * This method is invoked whenever a new element is introduced to this list. This method's invocation occurs after
	 * the addition.
	 * 
	 * @param index The index of the new element.
	 * @param element The new element.
	 */
	protected abstract void elementAdded(int index, T element);

	/**
	 * This method is invoked whenever an element is removed from this list. This method's invocation occurs after the
	 * removal.
	 * 
	 * @param index The index previously held by the element.
	 * @param element The element which was removed.
	 */
	protected abstract void elementRemoved(int index, T element);

	@Override
	public void add(int index, T element)
	{
		this.backingList.add(index, element);
		this.elementAdded(index, element);
	}

	@Override
	public boolean add(T e)
	{
		this.backingList.add(e);
		this.elementAdded(this.backingList.size() - 1, e);
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends T> c)
	{
		boolean ret = false;
		for (T t : c)
		{
			this.add(t);
			ret = true;
		}
		return ret;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c)
	{
		boolean ret = false;
		for (T t : c)
		{
			this.add(index++, t);
			ret = true;
		}
		return ret;
	}

	@Override
	public void clear()
	{
		while (this.backingList.size() > 0)
		{
			T t = this.backingList.remove(0);
			this.elementRemoved(0, t);
		}
	}

	@Override
	public boolean contains(Object o)
	{
		return this.backingList.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c)
	{
		return this.backingList.containsAll(c);
	}

	@Override
	public T get(int index)
	{
		return this.backingList.get(index);
	}

	@Override
	public int indexOf(Object o)
	{
		return this.backingList.indexOf(o);
	}

	@Override
	public boolean isEmpty()
	{
		return this.backingList.isEmpty();
	}

	@Override
	public Iterator<T> iterator()
	{
		return new Iterator<T>()
		{
			private Iterator<T> backingIterator = backingList.iterator();
			private int index = -1;
			private T lastValue;

			@Override
			public boolean hasNext()
			{
				return this.backingIterator.hasNext();
			}

			@Override
			public T next()
			{
				this.index++;
				this.lastValue = this.backingIterator.next();
				return this.lastValue;
			}

			@Override
			public void remove()
			{
				this.backingIterator.remove();
				elementRemoved(this.index, this.lastValue);
				this.index--;
			}
		};
	}

	@Override
	public int lastIndexOf(Object o)
	{
		return this.backingList.lastIndexOf(o);
	}

	@Override
	public ListIterator<T> listIterator()
	{
		return listIterator(0);
	}

	@Override
	public ListIterator<T> listIterator(final int startIndex)
	{
		return new ListIterator<T>()
		{
			/** The backing iterator. */
			private ListIterator<T> backingIterator = backingList.listIterator(startIndex);
			/** The replacement/removal index. */
			private int lastIndex = Integer.MIN_VALUE;
			/** The last value retrieved. */
			private T lastValue = null;

			@Override
			public void add(T e)
			{
				this.backingIterator.add(e);
				elementAdded(this.backingIterator.previousIndex(), e);
			}

			@Override
			public boolean hasNext()
			{
				return this.backingIterator.hasNext();
			}

			@Override
			public boolean hasPrevious()
			{
				return this.backingIterator.hasPrevious();
			}

			@Override
			public T next()
			{
				this.lastIndex = this.backingIterator.nextIndex();
				this.lastValue = this.backingIterator.next();
				return this.lastValue;
			}

			@Override
			public int nextIndex()
			{
				return this.backingIterator.nextIndex();
			}

			@Override
			public T previous()
			{
				this.lastIndex = this.backingIterator.previousIndex();
				this.lastValue = this.backingIterator.previous();
				return this.lastValue;
			}

			@Override
			public int previousIndex()
			{
				return this.backingIterator.previousIndex();
			}

			@Override
			public void remove()
			{
				this.backingIterator.remove();
				ProxyList.this.elementRemoved(this.lastIndex, this.lastValue);
			}

			@Override
			public void set(T e)
			{
				this.backingIterator.set(e);
				ProxyList.this.elementRemoved(this.lastIndex, e);
				ProxyList.this.elementAdded(this.lastIndex, e);
			}
		};
	}

	@Override
	public T remove(int index)
	{
		T t = this.backingList.remove(index);
		elementRemoved(index, t);
		return t;
	}

	@Override
	public boolean remove(Object o)
	{
		for (int i = 0; i < this.backingList.size(); i++)
		{
			T t = this.backingList.get(i);
			if ((t == null && o == null) || (t != null && t.equals(o)))
			{
				// We found a match
				this.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c)
	{
		boolean ret = false;
		for (Object o : c)
		{
			ret |= remove(o);
		}
		return ret;
	}

	@Override
	public boolean retainAll(Collection<?> c)
	{
		boolean change = false;
		int i = 0;
		while (i < this.backingList.size())
		{
			if (c.contains(this.backingList.get(i)))
			{
				i++;
			} else
			{
				T t = this.backingList.remove(i);
				elementRemoved(i, t);
				change = true;
			}
		}
		return change;
	}

	@Override
	public T set(int index, T element)
	{
		T t = this.backingList.set(index, element);
		elementRemoved(index, element);
		elementAdded(index, element);
		return t;
	}

	@Override
	public int size()
	{
		return this.backingList.size();
	}

	@Override
	public List<T> subList(final int fromIndex, final int toIndex)
	{
		final ProxyList<T> parent = this;
		return new ProxyList<T>(this.backingList.subList(fromIndex, toIndex))
		{
			@Override
			protected void elementAdded(int index, T element)
			{
				parent.elementAdded(fromIndex + index, element);
			}

			@Override
			protected void elementRemoved(int index, T element)
			{
				parent.elementRemoved(fromIndex + index, element);
			}
		};
	}

	@Override
	public Object[] toArray()
	{
		return this.backingList.toArray();
	}

	@Override
	public <E> E[] toArray(E[] a)
	{
		return this.backingList.toArray(a);
	}
}
