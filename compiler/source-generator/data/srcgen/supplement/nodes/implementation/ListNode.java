import java.util.Collections;
import java.util.List;

public class ListNodeImpl<T extends Node> extends Node implements ListNode<T>
{
	/* GEN:start */

	/**
	 * Creates a list of this node's child objects. Modifying the list has no effect on this node.
	 * 
	 * @return A mutable list of this node's child objects.
	 */
	public List<Object> getChildObjects()
	{
		List<Object> list = super.getChildObjects();
		list.addAll(this.children);
		return list;
	}
	
	/**
	 * A proxy list used a list node to ensure that children in the list can access the list node as a parent.
	 * @author Zachary Palmer
	 */
	protected class ListNodeProxyList extends ProxyList<T>
	{
		public ListNodeProxyList(List<T> list)
		{
			super(new ArrayList<T>(list));
		}
		protected void elementAdded(int index, T element)
		{
			if (element instanceof Node)
			{
				getManager().removeParent(ListNodeImpl.this, (Node)element);
			}
		}
		protected void elementRemoved(int index, T element)
		{
			if (element instanceof Node)
			{
				getManager().addParent(ListNodeImpl.this, (Node)element);
			}
		}
	}
	
	/**
	 * A convenience method which passes this call to the list of nodes contained in this list node.
	 */
	@Override
	public void add(int index, T element)
	{
		this.children.add(index, element);
	}

	/**
	 * A convenience method which passes this call to the list of nodes contained in this list node.
	 */
	@Override
	public boolean add(T e)
	{
		return this.children.add(e);
	}

	/**
	 * A convenience method which passes this call to the list of nodes contained in this list node.
	 */
	@Override
	public boolean addAll(Collection<? extends T> c)
	{
		return this.children.addAll(c);
	}

	/**
	 * A convenience method which passes this call to the list of nodes contained in this list node.
	 */
	@Override
	public boolean addAll(int index, Collection<? extends T> c)
	{
		return this.children.addAll(index, c);
	}

	/**
	 * A convenience method which passes this call to the list of nodes contained in this list node.
	 */
	@Override
	public void clear()
	{
		this.children.clear();
	}

	/**
	 * A convenience method which passes this call to the list of nodes contained in this list node.
	 */
	@Override
	public boolean contains(Object o)
	{
		return this.children.contains(o);
	}

	/**
	 * A convenience method which passes this call to the list of nodes contained in this list node.
	 */
	@Override
	public boolean containsAll(Collection<?> c)
	{
		return this.children.containsAll(c);
	}

	/**
	 * A convenience method which passes this call to the list of nodes contained in this list node.
	 */
	@Override
	public T get(int index)
	{
		return this.children.get(index);
	}

	/**
	 * A convenience method which passes this call to the list of nodes contained in this list node.
	 */
	@Override
	public int indexOf(Object o)
	{
		return this.children.indexOf(o);
	}

	/**
	 * A convenience method which passes this call to the list of nodes contained in this list node.
	 */
	@Override
	public boolean isEmpty()
	{
		return this.children.isEmpty();
	}

	/**
	 * A convenience method which passes this call to the list of nodes contained in this list node.
	 */
	@Override
	public Iterator<T> iterator()
	{
		return this.children.iterator();
	}

	/**
	 * A convenience method which passes this call to the list of nodes contained in this list node.
	 */
	@Override
	public int lastIndexOf(Object o)
	{
		return this.children.lastIndexOf(o);
	}

	/**
	 * A convenience method which passes this call to the list of nodes contained in this list node.
	 */
	@Override
	public ListIterator<T> listIterator()
	{
		return this.children.listIterator();
	}

	/**
	 * A convenience method which passes this call to the list of nodes contained in this list node.
	 */
	@Override
	public ListIterator<T> listIterator(int index)
	{
		return this.children.listIterator(index);
	}

	/**
	 * A convenience method which passes this call to the list of nodes contained in this list node.
	 */
	@Override
	public T remove(int index)
	{
		return this.children.remove(index);
	}

	/**
	 * A convenience method which passes this call to the list of nodes contained in this list node.
	 */
	@Override
	public boolean remove(Object o)
	{
		return this.children.remove(o);
	}

	/**
	 * A convenience method which passes this call to the list of nodes contained in this list node.
	 */
	@Override
	public boolean removeAll(Collection<?> c)
	{
		return this.children.removeAll(c);
	}

	/**
	 * A convenience method which passes this call to the list of nodes contained in this list node.
	 */
	@Override
	public boolean retainAll(Collection<?> c)
	{
		return this.children.retainAll(c);
	}

	/**
	 * A convenience method which passes this call to the list of nodes contained in this list node.
	 */
	@Override
	public T set(int index, T element)
	{
		return this.children.set(index, element);
	}

	/**
	 * A convenience method which passes this call to the list of nodes contained in this list node.
	 */
	@Override
	public int size()
	{
		return this.children.size();
	}

	/**
	 * A convenience method which passes this call to the list of nodes contained in this list node.
	 */
	@Override
	public List<T> subList(int fromIndex, int toIndex)
	{
		return this.children.subList(fromIndex, toIndex);
	}

	/**
	 * A convenience method which passes this call to the list of nodes contained in this list node.
	 */
	@Override
	public Object[] toArray()
	{
		return this.children.toArray();
	}

	/**
	 * A convenience method which passes this call to the list of nodes contained in this list node.
	 */
	@Override
	public <E> E[] toArray(E[] a)
	{
		return this.children.<E>toArray(a);
	}
	/* GEN:stop */
}