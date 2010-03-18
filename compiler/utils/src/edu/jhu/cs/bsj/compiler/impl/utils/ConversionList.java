package edu.jhu.cs.bsj.compiler.impl.utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * This list proxy class allows a list of type <tt>U</tt> to be viewed as a list of type <tt>T</tt>.
 * 
 * @author Zachary Palmer
 * 
 * @param <T> The type that this list appears to contain.
 * @param <U> The type contained by the backinglist.
 */
public class ConversionList<T, U> implements List<T>
{
	/** The backing list. */
	private List<U> backingList;
	/** The view type's class. */
	private Class<T> viewType;
	/** A converter from the view type to the backing type. */
	private Converter<T, U> frontToBackConverter;
	/** A converter from the backing type to the view type. */
	private Converter<U, T> backToFrontConverter;

	/**
	 * Creates a new conversion list.
	 * 
	 * @param backingList The original contents of this list.
	 * @param viewType The class of objects which this list represents.
	 * @param frontToBackConverter The converter from the view type to the backing type.
	 * @param backToFrontConverter The converter from the backing type to the view type.
	 */
	public ConversionList(List<U> backingList, Class<T> viewType, Converter<T, U> frontToBackConverter,
			Converter<U, T> backToFrontConverter)
	{
		super();
		this.backingList = backingList;
		this.viewType = viewType;
		this.frontToBackConverter = frontToBackConverter;
		this.backToFrontConverter = backToFrontConverter;
	}

	/**
	 * Converts a collection from the backing list type to the view type.
	 * 
	 * @param c A collection of backing list elements.
	 * @return The converted collection.
	 */
	protected Collection<T> convertBackToFrontCollection(Collection<? extends U> c)
	{
		Collection<T> tc = new ArrayList<T>(c.size());
		for (U u : c)
		{
			tc.add(backToFrontConverter.convert(u));
		}
		return tc;
	}

	/**
	 * Converts a collection from the view type to the backing list type.
	 * 
	 * @param c A collection of view elements.
	 * @return The converted collection.
	 */
	protected Collection<U> convertFrontToBackCollection(Collection<? extends T> c)
	{
		Collection<U> uc = new ArrayList<U>(c.size());
		for (T t : c)
		{
			uc.add(frontToBackConverter.convert(t));
		}
		return uc;
	}

	@Override
	public void add(int index, T element)
	{
		this.backingList.add(index, frontToBackConverter.convert(element));
	}

	@Override
	public boolean add(T e)
	{
		return this.backingList.add(frontToBackConverter.convert(e));
	}

	@Override
	public boolean addAll(Collection<? extends T> c)
	{
		return this.backingList.addAll(convertFrontToBackCollection(c));
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c)
	{
		return this.backingList.addAll(index, convertFrontToBackCollection(c));
	}

	@Override
	public void clear()
	{
		this.backingList.clear();
	}

	@Override
	public boolean contains(Object o)
	{
		if (viewType.isInstance(o))
		{
			return this.backingList.contains(frontToBackConverter.convert(viewType.cast(o)));
		} else
		{
			return false;
		}
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
		return backToFrontConverter.convert(this.backingList.get(index));
	}

	@Override
	public int indexOf(Object o)
	{
		if (viewType.isInstance(o))
		{
			return this.backingList.indexOf(frontToBackConverter.convert(viewType.cast(o)));
		} else
		{
			return -1;
		}
	}

	@Override
	public boolean isEmpty()
	{
		return this.backingList.isEmpty();
	}

	@Override
	public Iterator<T> iterator()
	{
		return new ConversionIterator<T, U>(this.backingList.iterator(), this.backToFrontConverter);
	}

	@Override
	public int lastIndexOf(Object o)
	{
		if (this.viewType.isInstance(o))
		{
			return this.backingList.lastIndexOf(this.frontToBackConverter.convert(this.viewType.cast(o)));
		} else
		{
			return -1;
		}
	}

	@Override
	public ListIterator<T> listIterator()
	{
		return new ConversionListIterator<T, U>(this.backingList.listIterator(), this.frontToBackConverter,
				this.backToFrontConverter);
	}

	@Override
	public ListIterator<T> listIterator(int index)
	{
		return new ConversionListIterator<T, U>(this.backingList.listIterator(index), this.frontToBackConverter,
				this.backToFrontConverter);
	}

	@Override
	public T remove(int index)
	{
		return this.backToFrontConverter.convert(this.backingList.remove(index));
	}

	@Override
	public boolean remove(Object o)
	{
		if (this.viewType.isInstance(o))
		{
			return this.backingList.remove(this.frontToBackConverter.convert(this.viewType.cast(o)));
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
		Iterator<U> it = this.backingList.iterator();
		while (it.hasNext())
		{
			if (!c.contains(this.backToFrontConverter.convert(it.next())))
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
		return this.backToFrontConverter.convert(this.backingList.set(index, this.frontToBackConverter.convert(element)));
	}

	@Override
	public int size()
	{
		return this.backingList.size();
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex)
	{
		return new ConversionList<T, U>(this.backingList.subList(fromIndex, toIndex), this.viewType,
				this.frontToBackConverter, this.backToFrontConverter);
	}

	@Override
	public Object[] toArray()
	{
		Object[] o = new Object[this.backingList.size()];
		for (int i = 0; i < o.length; i++)
		{
			o[i] = this.backToFrontConverter.convert(this.backingList.get(i));
		}
		return o;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E> E[] toArray(E[] a)
	{
		Class<E> componentType = (Class<E>) a.getClass().getComponentType();
		if (!componentType.isAssignableFrom(this.viewType))
		{
			throw new ArrayStoreException("Incompatible types: array of type " + componentType + " and list of type "
					+ this.viewType);
		}

		if (a.length < this.backingList.size())
		{
			a = (E[]) Array.newInstance(componentType, this.backingList.size());
		}

		for (int i = 0; i < a.length; i++)
		{
			a[i] = componentType.cast(this.backToFrontConverter.convert(this.backingList.get(i)));
		}

		return a;
	}
}
