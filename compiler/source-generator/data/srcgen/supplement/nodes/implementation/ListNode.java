/* GEN:headerstart */
import java.util.Collections;
import java.util.List;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
/* GEN:headerstop */

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
	 * An attribute type for the list elements in this class.
	 */
	protected class ListAttribute implements Attribute
	{
		/** The ID number for this attribute. */
		private int id;
		/**
		 * Creates a new attribute.
		 * @param id The ID number for this attribute.
		 */
		public ListAttribute()
		{
			this.id = nextAttributeID++;
		}
		/**
		 * Compares this list attribute to another for equality.
		 */
		public boolean equals(Object o)
		{
			if (getClass().isInstance(o))
			{
				ListAttribute other = (ListAttribute)o;
				return this.id == other.id;
			} else
			{
				return false;
			}
		}
		/**
		 * Creates a hash code for this attribute..
		 */
		public int hashCode()
		{
			return this.id;
		}
		/**
		 * Records an access to this attribute.  (Convenience method.)
		 */
		public void recordAccess(Attribute.AccessType accessType)
		{
			ListNodeImpl.this.recordAccess(this, accessType);
		}
	}
	
	/** The next ID number to assign to an attribute. */
	private int nextAttributeID = 0;
	
	/** The list of before attributes corresponding to the proxy list. */
	private List<ListAttribute> beforeAttributes = new ArrayList<ListAttribute>();
	/** The list of present attributes corresponding to the proxy list. */
	private List<ListAttribute> presentAttributes = new ArrayList<ListAttribute>();
	/** The tailing after attribute which always appears after the end of the list. */
	private ListAttribute afterAttribute = new ListAttribute();
	/** The size attribute of this list. */
	private ListAttribute sizeAttribute = new ListAttribute();
	
	/**
	 * Retrieves the between attribute which appears before the given index.
	 * @param index The index before which the attribute appears.  Must be within the range of [0,size].
	 */
	private ListAttribute getBetweenAttribute(int index)
	{
		if (index == this.beforeAttributes.size())
		{
			return this.afterAttribute;
		} else
		{
			return this.beforeAttributes.get(index);
		}
	}
	
	/**
	 * Retrieves the presence attribute which appears at the given index.
	 * @param index The index at which the attribute appears.  Must be within the range of [0,size).
	 */
	private ListAttribute getPresentAttribute(int index)
	{
		return this.presentAttributes.get(index);
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
		protected void elementAdded(int index, T element, boolean replaced)
		{
			ListNodeImpl.this.getManager().assertInsertable(ListNodeImpl.this);
			if (!replaced)
			{
				ListNodeImpl.this.beforeAttributes.add(index, new ListAttribute());
				ListNodeImpl.this.presentAttributes.add(index, new ListAttribute());
				ListNodeImpl.this.sizeAttribute.recordAccess(Attribute.AccessType.WRITE);
			}
			getBetweenAttribute(index).recordAccess(Attribute.AccessType.WRITE);
			getPresentAttribute(index).recordAccess(Attribute.AccessType.WRITE);
			getBetweenAttribute(index+1).recordAccess(Attribute.AccessType.WRITE);
			if (element instanceof NodeImpl)
			{
				((NodeImpl)element).setParent(ListNodeImpl.this);
			}
		}
		protected void elementRemoved(int index, T element, boolean replaced)
		{
			ListNodeImpl.this.getManager().assertMutatable(ListNodeImpl.this);
			getBetweenAttribute(index).recordAccess(Attribute.AccessType.WRITE);
			getPresentAttribute(index).recordAccess(Attribute.AccessType.WRITE);
			getBetweenAttribute(index+1).recordAccess(Attribute.AccessType.WRITE);
			if (!replaced)
			{
				ListNodeImpl.this.beforeAttributes.remove(index);
				ListNodeImpl.this.presentAttributes.remove(index);
				ListNodeImpl.this.sizeAttribute.recordAccess(Attribute.AccessType.WRITE);
			}
			if (element instanceof NodeImpl)
			{
				((NodeImpl)element).setParent(null);
			}
		}
		protected void elementRetrieved(int index, T element)
		{
			getPresentAttribute(index).recordAccess(Attribute.AccessType.READ);
		}
		protected void sizeChecked()
		{
			ListNodeImpl.this.sizeAttribute.recordAccess(Attribute.AccessType.READ);
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