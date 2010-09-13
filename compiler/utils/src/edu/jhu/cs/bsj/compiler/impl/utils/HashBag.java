package edu.jhu.cs.bsj.compiler.impl.utils;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/**
 * An implementation of the {@link Bag} interface which relies on the hashing behavior of the provided objects to
 * provide improved performance.
 * 
 * @author Zachary Palmer
 * 
 * @param <T>The type of object contained in this bag.
 */
public class HashBag<T> extends AbstractCollection<T> implements Bag<T>
{
	/**
	 * A map which represents the contents of this bag. Each key is mapped to the number of times that object appears in
	 * the bag.
	 */
	private Map<T, Integer> backingMap;
	/**
	 * A modification counter which is used to provide fail-fast behavior for iterators.
	 */
	private int modificationCount;
	/**
	 * A tally indicating the size of this bag.
	 */
	private int size;

	public HashBag()
	{
		this.backingMap = new HashMap<T, Integer>();
		this.size = 0;
	}

	public HashBag(Collection<? extends T> elements)
	{
		this();
		this.addAll(elements);
	}

	@Override
	public int size()
	{
		return this.size;
	}

	@Override
	public boolean isEmpty()
	{
		return this.size == 0;
	}

	@Override
	public boolean contains(Object o)
	{
		return this.backingMap.containsKey(o);
	}

	@Override
	public Iterator<T> iterator()
	{
		return new Iterator<T>()
		{
			/** The modification count at the time that this iterator was created. */
			private int modificationCount = HashBag.this.modificationCount;
			/** An iterator of the keys over the bag's backing map. */
			private final Iterator<T> keyIterator = new HashSet<T>(HashBag.this.backingMap.keySet()).iterator();
			/** The number of times that next() will return the contents of the "last" variable. */
			private int currentLastCount = 0;
			/** The last value returned. */
			private T last = null;
			/** Whether or not the last return value can be removed. */
			private boolean lastValid = false;
			
			private void checkModificationCount()
			{
				if (this.modificationCount != HashBag.this.modificationCount)
				{
					throw new ConcurrentModificationException();
				}
			}
			
			@Override
			public boolean hasNext()
			{
				checkModificationCount();
				return this.currentLastCount > 0 || this.keyIterator.hasNext();
			}

			@Override
			public T next()
			{
				checkModificationCount();
				if (this.currentLastCount == 0)
				{
					this.last = keyIterator.next();
					this.currentLastCount = HashBag.this.backingMap.get(this.last);
				}
				this.currentLastCount--;
				this.lastValid = true;
				return this.last;
			}

			@Override
			public void remove()
			{
				checkModificationCount();
				if (!this.lastValid)
					throw new IllegalStateException("No element from next() to remove");
				this.lastValid = false;
				HashBag.this.remove(this.last);
				this.modificationCount = HashBag.this.modificationCount;
			}
		};
	}

	@Override
	public boolean add(T e)
	{
		if (this.backingMap.containsKey(e))
		{
			this.backingMap.put(e, this.backingMap.get(e) + 1);
		} else
		{
			this.backingMap.put(e, 1);
		}
		this.size++;
		this.modificationCount++;
		return true;
	}

	@Override
	public boolean remove(Object o)
	{
		if (this.backingMap.containsKey(o))
		{
			// This is known to be safe because containsKey cannot return true for objects not of the key type.
			@SuppressWarnings("unchecked")
			T key = (T)o;
			int count = this.backingMap.get(key);
			if (count == 1)
			{
				this.backingMap.remove(key);
			} else
			{
				this.backingMap.put(key, count - 1);
			}
			this.size--;
			this.modificationCount++;
			return true;
		} else
		{
			return false;
		}
	}

	@Override
	public boolean containsAll(Collection<?> c)
	{
		Map<Object,Integer> map = new HashMap<Object,Integer>();
		for (Object o : c)
		{
			if (!this.backingMap.containsKey(o))
			{
				return false;
			}
			if (map.containsKey(o))
			{
				map.put(o, map.get(o)+1);
			} else
			{
				map.put(o, 1);
			}
		}
		for (Map.Entry<Object,Integer> entry : map.entrySet())
		{
			if (this.backingMap.get(entry.getKey()) < entry.getValue())
			{
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends T> c)
	{
		for (T t : c)
		{
			this.add(t);
		}
		return c.size() != 0;
	}

	@Override
	public boolean removeAll(Collection<?> c)
	{
		boolean change = false;
		for (Object o : c)
		{
			change |= remove(o);
		}
		return change;
	}

	@Override
	public boolean retainAll(Collection<?> c)
	{
		Map<Object,Integer> map = new HashMap<Object,Integer>();
		for (Object o : c)
		{
			if (!this.backingMap.containsKey(o))
			{
				continue;
			}
			if (map.containsKey(o))
			{
				map.put(o, map.get(o)+1);
			} else
			{
				map.put(o, 1);
			}
		}
		boolean change = false;
		for (T key : new HashSet<T>(this.backingMap.keySet()))
		{
			if (!map.containsKey(key))
			{
				change = true;
				this.size -= this.backingMap.remove(key);
				this.modificationCount++;
			} else
			{
				int count = map.get(key);
				if (this.backingMap.get(key) > count)
				{
					change = true;
					this.size -= this.backingMap.put(key, count) - count;
					this.modificationCount++;
				}
			}
		}
		return change;
	}

	@Override
	public void clear()
	{
		this.backingMap.clear();
		this.size = 0;
		this.modificationCount++;
	}

	@Override
	public int hashCode()
	{
		int ret = 0;
		for (T t : this)
		{
			ret ^= t.hashCode();
		}
		return ret;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof Bag)
		{
			Bag<?> other = (Bag<?>)obj;
			if (other.containsAll(this) && this.containsAll(other))
			{
				return true;
			} else
			{
				return false;
			}
		} else
		{
			return false;
		}
	}
}
