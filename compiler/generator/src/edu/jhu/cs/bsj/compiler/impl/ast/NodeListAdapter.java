package edu.jhu.cs.bsj.compiler.impl.ast;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import edu.jhu.cs.bsj.compiler.ast.NodeList;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.utils.SubList;

/**
 * This wrapper class allows a {@link NodeList} to be accessed as if it were a Java {@link List}.
 * 
 * @author Zachary Palmer
 */
public class NodeListAdapter<T extends Node> implements List<T>
{
	/** The node list which backs all operations by this list. */
	private NodeList<T> list;

	public NodeListAdapter(NodeList<T> list)
	{
		super();
		this.list = list;
	}

	@Override
	public void add(int index, T element)
	{
		if (index == 0)
		{
			this.list.addFirst(element);
		} else
		{
			T e = this.list.getFirst();
			for (int i = 0; i < index - 1; i++)
			{
				if (e == null)
					throw new IndexOutOfBoundsException(String.valueOf(index));
				e = this.list.getAfter(e);
			}
			if (e == null)
				throw new IndexOutOfBoundsException(String.valueOf(index));
			this.list.addAfter(e, element);
		}
	}

	@Override
	public boolean add(T e)
	{
		this.list.addLast(e);
		return true;
	}

	@Override
	public boolean addAll(Collection<? extends T> c)
	{
		for (T e : c)
		{
			this.add(e);
		}
		return c.size() > 0;
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c)
	{
		for (T t : c)
		{
			add(index, t);
			index++;
		}
		return c.size() > 0;
	}

	@Override
	public void clear()
	{
		while (this.list.getFirst() != null)
		{
			this.list.remove(this.list.getFirst());
		}
	}

	@Override
	public boolean contains(Object o)
	{
		for (T t : this)
		{
			if (t.equals(o))
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
				return false;
		}
		return true;
	}

	@Override
	public T get(int index)
	{
		if (index < 0)
		{
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		Iterator<T> it = this.iterator();
		T ret = null;
		for (int i = 0; i <= index; i++)
		{
			if (!it.hasNext())
			{
				throw new IndexOutOfBoundsException(String.valueOf(index));
			}
			ret = it.next();
		}
		return ret;
	}

	@Override
	public int indexOf(Object o)
	{
		int i = 0;
		for (T t : this)
		{
			if (t.equals(o))
			{
				return i;
			}
			i++;
		}
		return -1;
	}

	@Override
	public boolean isEmpty()
	{
		return (this.list.getFirst() == null);
	}

	@Override
	public Iterator<T> iterator()
	{
		return listIterator(0);
	}

	@Override
	public int lastIndexOf(Object o)
	{
		ListIterator<T> it = this.listIterator();
		int i = 0;
		while (it.hasNext())
		{
			it.next();
			i++;
		}
		while (it.hasPrevious())
		{
			i--;
			T t = it.previous();
			if (t.equals(o))
			{
				return i;
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
			/** Indicates this iterator's current cursor. */
			private int position = 0;
			/** Indicates the index of the anchor. */
			private int anchorIndex = Integer.MIN_VALUE;
			/** Indicates a value in the list (or <code>null</code> if no value has been read). */
			private T anchor = null;
			/** Indicates whether or not set may be called. */
			private boolean setValid = false;
			/** Indicates whether or not remove may be called. */
			private boolean removeValid = false;
			/** Indicates the index of the last element returned. */
			private int lastIndex = -1;

			private boolean moveAnchorTo(int index)
			{
				if (anchor == null)
				{
					T t = NodeListAdapter.this.list.getFirst();
					if (t == null)
					{
						anchor = null;
						anchorIndex = Integer.MIN_VALUE;
						return false;
					}
					anchor = t;
					anchorIndex = 0;
				}

				while (anchorIndex < index)
				{
					T result = NodeListAdapter.this.list.getAfter(anchor);
					if (result == null)
					{
						return false;
					}
					anchor = result;
					anchorIndex++;
				}

				while (anchorIndex > index)
				{
					T result = NodeListAdapter.this.list.getBefore(anchor);
					if (result == null)
					{
						return false;
					}
					anchor = result;
					anchorIndex--;
				}

				return true;
			}

			private T peekNext()
			{
				if (moveAnchorTo(position))
				{
					return this.anchor;
				} else
				{
					return null;
				}
			}

			private T peekPrevious()
			{
				if (moveAnchorTo(position - 1))
				{
					return this.anchor;
				} else
				{
					return null;
				}
			}

			@Override
			public void add(T e)
			{
				if (moveAnchorTo(this.position))
				{
					NodeListAdapter.this.list.addAfter(anchor, e);
				} else
				{
					NodeListAdapter.this.list.addLast(e);
				}
				this.position++;
				this.setValid = false;
				this.removeValid = false;
			}

			@Override
			public boolean hasNext()
			{
				return (peekNext() != null);
			}

			@Override
			public boolean hasPrevious()
			{
				return position != 0;
			}

			@Override
			public T next()
			{
				T ret = peekNext();
				if (ret == null)
				{
					throw new NoSuchElementException();
				}
				this.position++;
				this.setValid = true;
				this.removeValid = true;
				this.lastIndex = anchorIndex;
				return ret;
			}

			@Override
			public int nextIndex()
			{
				return position;
			}

			@Override
			public T previous()
			{
				T ret = peekPrevious();
				if (ret == null)
				{
					throw new NoSuchElementException();
				}
				this.position--;
				this.setValid = true;
				this.removeValid = true;
				this.lastIndex = anchorIndex;
				return ret;
			}

			@Override
			public int previousIndex()
			{
				return position - 1;
			}

			@Override
			public void remove()
			{
				if (!removeValid)
				{
					throw new IllegalStateException("Cannot remove: invalid at this time");
				}

				moveAnchorTo(lastIndex);
				T value = this.anchor;
				if (this.lastIndex == 0)
				{
					moveAnchorTo(lastIndex + 1);
				} else
				{
					moveAnchorTo(lastIndex - 1);
				}
				NodeListAdapter.this.list.remove(value);
				this.removeValid = false;
				this.setValid = false;
				if (anchorIndex >= lastIndex)
					anchorIndex--;
			}

			@Override
			public void set(T e)
			{
				if (!setValid)
				{
					throw new IllegalStateException("Cannot set: invalid at this time");
				}

				if (lastIndex == 0)
				{
					NodeListAdapter.this.list.remove(NodeListAdapter.this.list.getFirst());
					NodeListAdapter.this.list.addFirst(e);
					if (anchorIndex == 0)
					{
						anchor = e;
					}
				} else
				{
					moveAnchorTo(lastIndex - 1);
					NodeListAdapter.this.list.remove(NodeListAdapter.this.list.getAfter(anchor));
					NodeListAdapter.this.list.addAfter(anchor, e);
				}
			}

			@Override
			public String toString()
			{
				return "NodeListAdapter$Iterator [anchor=" + anchor + ", anchorIndex=" + anchorIndex + ", lastIndex="
						+ lastIndex + ", removeValid=" + removeValid + ", setValid=" + setValid + ", list="
						+ NodeListAdapter.this + "]";
			}
		};
	}

	@Override
	public T remove(int index)
	{
		T ret = this.get(index);
		this.remove(ret);
		return ret;
	}

	@Override
	public boolean remove(Object o)
	{
		Iterator<T> it = this.iterator();
		while (it.hasNext())
		{
			if (it.next().equals(o))
			{
				it.remove();
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
		boolean ret = false;
		Iterator<T> it = this.iterator();
		while (it.hasNext())
		{
			if (!c.contains(it.next()))
			{
				ret = true;
				it.remove();
			}
		}
		return ret;
	}

	@Override
	public T set(int index, T element)
	{
		if (index < 0)
		{
			throw new IndexOutOfBoundsException(String.valueOf(index));
		}
		ListIterator<T> it = this.listIterator();
		T last = null;
		for (int i = 0; i <= index; i++)
		{
			if (!it.hasNext())
			{
				throw new IndexOutOfBoundsException(String.valueOf(index));
			}
			last = it.next();
		}
		it.set(element);
		return last;
	}

	@Override
	public int size()
	{
		int size = 0;
		for (@SuppressWarnings("unused")
		T t : this)
		{
			size++;
		}
		return size;
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex)
	{
		return new SubList<T>(this, fromIndex, toIndex);
	}

	@Override
	public Object[] toArray()
	{
		Object[] ret = new Object[size()];
		int i = 0;
		for (T t : this)
		{
			ret[i++] = t;
		}
		return ret;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <E> E[] toArray(E[] a)
	{
		int size = this.size();
		int i = 0;
		if (a.length < size)
		{
			a = (E[]) Array.newInstance(a.getClass().getComponentType(), size);
		}

		for (T t : this)
		{
			Array.set(a, i++, t);
		}

		return a;
	}

	@Override
	public String toString()
	{
		return "NodeListAdapter [list=" + list + "]";
	}
}
