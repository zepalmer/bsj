package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/**
 * This class acts as a generic sublist.
 * @author Zachary Palmer
 *
 * @param <T> The type of element contained in the list.
 */
public class SubList<T> implements List<T>
{
	/** The backing list. */
	private List<T> list;
	/** The starting index in the backing list. */
	private int startIndex;
	/** The ending index (exclusive) in the backing list. */
	private int endIndex;
	
	/**
	 * Creates a new list which behaves as a sublist of the specified list.
	 * @param list The list in question.
	 * @param startIndex The starting index of the sublist (inclusive).
	 * @param endIndex The ending index of the sublist (exclusive).
	 */
	public SubList(List<T> list, int startIndex, int endIndex)
	{
		super();
		this.list = list;
		this.startIndex = startIndex;
		this.endIndex = endIndex;
	}
	
	/**
	 * Ensures that the specified index is within the bounds of this sublist.
	 * @param index The index to check.
	 * @throws ArrayIndexOutOfBoundsException If the index is out of bounds.
	 */
	private void checkIndex(int index)
	{
		if (index < 0 || index >= this.size())
		{
			throw new IndexOutOfBoundsException("Invalid index " + index + " not in range [0," + this.size() + ")");
		}
	}

	@Override
	public void add(int index, T element)
	{
		checkIndex(index);
		this.list.add(this.startIndex + index, element);
		this.endIndex++;
	}

	@Override
	public boolean add(T e)
	{
		this.list.add(this.endIndex, e);
		this.endIndex++;
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends T> c)
	{
		boolean ret = this.list.addAll(this.endIndex, c);
		this.endIndex += c.size();
		return ret;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c)
	{
		checkIndex(index);
		boolean ret = this.list.addAll(this.startIndex + index, c);
		this.endIndex += c.size();
		return ret;
	}

	@Override
	public void clear()
	{
		while (this.size()>0)
		{
			remove(0);
		}
	}

	@Override
	public boolean contains(Object o)
	{
		Iterator<T> it = this.iterator();
		while (it.hasNext())
		{
			T t = it.next();
			if ((t==null && o==null) || (t!=null && t.equals(o)))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c)
	{
		for (Object o : c)
		{
			if (!contains(o))
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public T get(int index)
	{
		checkIndex(index);
		return this.list.get(this.startIndex + index);
	}

	@Override
	public int indexOf(Object o)
	{
		ListIterator<T> it = this.listIterator();
		while (it.hasNext())
		{
			T t = it.next();
			if ((t==null && o==null) || (t!=null && t.equals(o)))
			{
				return it.previousIndex();
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty()
	{
		return size() == 0;
	}

	@Override
	public Iterator<T> iterator()
	{
		return listIterator();
	}

	@Override
	public int lastIndexOf(Object o)
	{
		ListIterator<T> it = this.listIterator(this.size());
		while (it.hasPrevious())
		{
			T t = it.previous();
			if ((t==null && o==null) || (t!=null && t.equals(o)))
			{
				return it.nextIndex();
			}
		}
		return -1;
	}

	@Override
	public ListIterator<T> listIterator()
	{
		return listIterator(0);
	}

	@Override
	public ListIterator<T> listIterator(int index)
	{
		return new ListIterator<T>()
		{
			private ListIterator<T> iterator = SubList.this.list.listIterator(SubList.this.startIndex);

			@Override
			public void add(T e)
			{
				this.iterator.add(e);
			}

			@Override
			public boolean hasNext()
			{
				return this.iterator.hasNext() && this.iterator.nextIndex() < SubList.this.endIndex;
			}

			@Override
			public boolean hasPrevious()
			{
				return this.iterator.hasPrevious() && this.iterator.previousIndex() >= SubList.this.startIndex;
			}

			@Override
			public T next()
			{
				if (hasNext())
				{
					return this.iterator.next();
				} else
				{
					throw new NoSuchElementException();
				}
			}

			@Override
			public int nextIndex()
			{
				return this.iterator.nextIndex() - SubList.this.startIndex;
			}

			@Override
			public T previous()
			{
				if (hasPrevious())
				{
					return this.iterator.previous();
				} else
				{
					throw new NoSuchElementException();
				}
			}

			@Override
			public int previousIndex()
			{
				return this.iterator.previousIndex() - SubList.this.startIndex;
			}

			@Override
			public void remove()
			{
				this.iterator.remove();
			}

			@Override
			public void set(T e)
			{
				this.iterator.set(e);
			}			
		};
	}

	@Override
	public T remove(int index)
	{
		checkIndex(index);
		T t = this.list.remove(this.startIndex + index);
		this.endIndex--;
		return t;
	}

	@Override
	public boolean remove(Object o)
	{
		int index = indexOf(o);
		if (index != -1)
		{
			remove(index);
			return true;
		} else
		{
			return false;
		}
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
		boolean ret = false;
		Iterator<T> it = iterator();
		while (it.hasNext())
		{
			if (!c.contains(it.next()))
			{
				it.remove();
				ret = true;
			}
		}
		return ret;
	}

	@Override
	public T set(int index, T element)
	{
		checkIndex(index);
		return this.list.set(this.startIndex + index, element);
	}

	@Override
	public int size()
	{
		return this.endIndex - this.startIndex;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex)
	{
		return new SubList<T>(this, fromIndex, endIndex);
	}

	@Override
	public Object[] toArray()
	{
		return toArray(null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E> E[] toArray(E[] a)
	{
        if (a==null || a.length < this.size())
        {
            a = (E[])java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), this.size());
        }
        Object[] o = a;
        int i = 0;
        Iterator<T> it = this.iterator();
        while (it.hasNext())
        {
        	o[i++] = it.next();
        }
        if (i<o.length)
        {
        	o[i] = null;
        }
        return a;
	}
}
