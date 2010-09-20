import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* GEN:headerstart */
/* GEN:headerstop */
public class ListImpl<T> implements List<T>
{
	/* GEN:start */
	@Override
	public int size()
	{
		${METHOD_BODY}
	}

	@Override
	public boolean isEmpty()
	{
		${METHOD_BODY}
	}

	@Override
	public boolean contains(Object o)
	{
		${METHOD_BODY}
	}

	@Override
	public Iterator<T> iterator()
	{
        ${METHOD_BODY}
    }

	@Override
	public Object[] toArray()
	{
        ${METHOD_BODY}
    }

	@Override
	public <E> E[] toArray(E[] a)
	{
        ${METHOD_BODY}
    }

	@Override
	public boolean add(T e)
	{
        ${METHOD_BODY}
    }

	@Override
	public boolean remove(Object o)
	{
        ${METHOD_BODY}
    }

	@Override
	public boolean containsAll(Collection<?> c)
	{
        ${METHOD_BODY}
    }

	@Override
	public boolean addAll(Collection<? extends T> c)
	{
        ${METHOD_BODY}
    }

	@Override
	public boolean addAll(int index, Collection<? extends T> c)
	{
        ${METHOD_BODY}
    }

	@Override
	public boolean removeAll(Collection<?> c)
	{
        ${METHOD_BODY}
    }

	@Override
	public boolean retainAll(Collection<?> c)
	{
        ${METHOD_BODY}
    }

	@Override
	public void clear()
	{
        ${METHOD_BODY}
    }

	@Override
	public T get(int index)
	{
        ${METHOD_BODY}
    }

	@Override
	public T set(int index, T element)
	{
        ${METHOD_BODY}
    }

	@Override
	public void add(int index, T element)
	{
        ${METHOD_BODY}
    }

	@Override
	public T remove(int index)
	{
        ${METHOD_BODY}
    }

	@Override
	public int indexOf(Object o)
	{
        ${METHOD_BODY}
    }

	@Override
	public int lastIndexOf(Object o)
	{
        ${METHOD_BODY}
    }

	@Override
	public ListIterator<T> listIterator()
	{
        ${METHOD_BODY}
    }

	@Override
	public ListIterator<T> listIterator(int index)
	{
        ${METHOD_BODY}
    }

	@Override
	public List<T> subList(int fromIndex, int toIndex)
	{
        ${METHOD_BODY}
    }	

	@Override
	public void addFirst(T node)
	{
        ${METHOD_BODY}
	}

	@Override
	public void addLast(T node)
	{
        ${METHOD_BODY}
	}

	@Override
	public void addBefore(T member, T node) throws MetaprogramListMissingElementException
	{
        ${METHOD_BODY}
	}

	@Override
	public void addAfter(T member, T node) throws MetaprogramListMissingElementException
	{
        ${METHOD_BODY}
	}

	@Override
	public boolean remove(T node)
	{
        ${METHOD_BODY}
	}

	@Override
	public T getFirst()
	{
        ${METHOD_BODY}
	}

	@Override
	public T getLast()
	{
        ${METHOD_BODY}
	}

	@Override
	public T getBefore(T member) throws MetaprogramListMissingElementException
	{
        ${METHOD_BODY}
	}

	@Override
	public T getAfter(T member) throws MetaprogramListMissingElementException
	{
        ${METHOD_BODY}
	}

	@Override
	public Set<T> filter(NodeFilter<? super T> filter)
	{
        ${METHOD_BODY}
	}
	/* GEN:stop */
}