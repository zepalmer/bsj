package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.InitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute.AccessType;
import edu.jhu.cs.bsj.compiler.impl.utils.SubList;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class ListNodeImpl<T extends Node> extends NodeImpl implements ListNode<T>
{
    /** The list of children. */
    private List<T> children;
    
    private static enum LocalAttribute implements edu.jhu.cs.bsj.compiler.impl.ast.Attribute
    {
        /** Attribute for the children property. */
        CHILDREN,
    }
    
    /** General constructor. */
    protected ListNodeImpl(
            List<T> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager)
    {
        super(startLocation, stopLocation, manager);
        this.children = new ListNodeList(new ArrayList<T>(children));
    }
    
    /**
     * Gets whether or not this list's contents are always order-dependent.
     * @return Whether or not this list's contents are always order-dependent.
     */
    public abstract boolean getAlwaysOrdered();
    
    /**
     * Gets the list of children.
     * @return The list of children.
     */
    public List<T> getChildren()
    {
        recordAccess(LocalAttribute.CHILDREN, Attribute.AccessType.READ);
        return this.children;
    }
    
    /**
     * Handles the visitation of this node's children for the provided visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        super.receiveToChildren(visitor);
        if (this.children != null)
        {
            for (Node node : this.children)
            {
                node.receive(visitor);
            }
        }
    }
    
    /**
     * Handles the visitation of this node's children for the provided typed visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveTypedToChildren(BsjTypedNodeVisitor visitor)
    {
        super.receiveTypedToChildren(visitor);
        if (this.children != null)
        {
            for (Node node : this.children)
            {
                node.receiveTyped(visitor);
            }
        }
    }
    
    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitListNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitListNodeStop(this);
        visitor.visitStopEnd(this);
    }
    
    /**
     * Produces a mutable list of this node's children.  Modifying this list will have no
     * effect on this node.
     * @return A list of this node's children.
     */
    /* // (not generating children)
    @Override
    public List<Object> getChildObjects()
    {
        List<Object> list = super.getChildObjects();
        list.add(getChildren());
        return list;
    }
    */
    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append('[');
        sb.append("children=");
        sb.append(String.valueOf(this.getChildren()) + ":" + (this.getChildren() != null ? this.getChildren().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("startLocation=");
        sb.append(String.valueOf(this.getStartLocation()) + ":" + (this.getStartLocation() != null ? this.getStartLocation().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("stopLocation=");
        sb.append(String.valueOf(this.getStopLocation()) + ":" + (this.getStopLocation() != null ? this.getStopLocation().getClass().getSimpleName() : "null"));
        sb.append(']');
        return sb.toString();
    }
    
    

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
	 * The backing class for the list contained by a list node. This list provides list-based storage for data as well
	 * as attribute management and conflict detection.
	 */
	protected class ListNodeList implements List<T>
	{
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
		/** The list containing the actual data. */
		private List<T> backingList = new ArrayList<T>();

		public ListNodeList(List<T> data)
		{
			addAll(data);
		}
		
		/**
		 * Determines whether or not the specified element should be treated as order-dependent in this list.
		 * @param element The element to check.
		 * @return <code>true</code> if the element is order-dependent; <code>false</code> if it is not.
		 */
		private boolean checkOrderDependent(T element)
		{
			return getAlwaysOrdered() || (element instanceof InitializerDeclarationNode);
		}
		
		/**
		 * Performs a read operation on the specified between attribute before the given index.
		 * @param index The index before which the attribute appears.  Must be within the range of [0,size].
		 */
		private void readBetweenAttribute(int index)
		{
			getBetweenAttribute(index).recordAccess(AccessType.READ);
		}
		
		/**
		 * Performs a read operation on the specified presence attribute at the given index.
		 * @param index The index at which the attribute appears. Must be within the range of [0,size).
		 */
		private void readPresentAttribute(int index)
		{
			getPresentAttribute(index).recordAccess(AccessType.READ);
		}
		
		/**
		 * Performs a write operation on the specified between attribute before the given index.
		 * @param index The index before which the attribute appears.  Must be within the range of [0,size].
		 * @param element The element for which the write is occurring.  This value is used to determine whether the
		 *                write is weak or strong.
		 */
		private void writeBetweenAttribute(int index, T element)
		{
			AccessType writeType = checkOrderDependent(element) ? AccessType.STRONG_WRITE : AccessType.WEAK_WRITE;
			getBetweenAttribute(index).recordAccess(writeType);
		}
		
		/**
		 * Performs a write operation on the specified presence attribute at the given index.
		 * @param index The index at which the attribute appears. Must be within the range of [0,size).
		 */
		private void writePresentAttribute(int index)
		{
			getPresentAttribute(index).recordAccess(AccessType.STRONG_WRITE);
		}
		
		/**
		 * Performs a read operation on the size attribute.
		 */
		private void readSizeAttribute()
		{
			this.sizeAttribute.recordAccess(AccessType.READ);
		}
		
		/**
		 * Performs a write operation on the size attribute.
		 */
		private void writeSizeAttribute()
		{
			this.sizeAttribute.recordAccess(AccessType.WEAK_WRITE);
		}

		/**
		 * Retrieves the between attribute which appears before the given index.
		 * 
		 * @param index The index before which the attribute appears. Must be within the range of [0,size].
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
		 * 
		 * @param index The index at which the attribute appears. Must be within the range of [0,size).
		 */
		private ListAttribute getPresentAttribute(int index)
		{
			return this.presentAttributes.get(index);
		}
		
		/**
		 * Called to set the parent on nodes which are removed from this node.
		 */
		private void elementAdded(T t)
		{
			if (t instanceof NodeImpl)
			{
				((NodeImpl)t).setParent(ListNodeImpl.this);
			}
		}

		/**
		 * Called to set the parent on nodes which are removed from this node.
		 */
		private void elementRemoved(T t)
		{
			if (t instanceof NodeImpl)
			{
				((NodeImpl)t).setParent(null);
			}
		}

		/**
		 * Removes an element from this list internally by index. This method does not perform any recording of access;
		 * it simply removes the element from the backing list and performs other corresponding operations.
		 * 
		 * @param index The index of the element to remove.
		 * @return The element that was removed.
		 */
		private T removeElementByIndex(int index)
		{
			this.beforeAttributes.remove(index);
			this.presentAttributes.remove(index);
			T t = this.backingList.remove(index);
			elementRemoved(t);
			return t;
		}

		@Override
		public void add(int index, T element)
		{
			getManager().assertInsertable(ListNodeImpl.this);
			
			this.beforeAttributes.add(index, new ListAttribute());
			this.presentAttributes.add(index, new ListAttribute());
			this.backingList.add(index, element);
			elementAdded(element);

			writeBetweenAttribute(index, element);
			writePresentAttribute(index);
			writeBetweenAttribute(index+1, element);
			writeSizeAttribute();
		}

		@Override
		public boolean add(T e)
		{
			this.add(this.backingList.size(), e);
			return true;
		}

		@Override
		public boolean addAll(Collection<? extends T> c)
		{
			for (T t : c)
			{
				add(t);
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
			while (this.backingList.size() > 0)
			{
				this.remove(this.backingList.size() - 1);
			}
		}

		@Override
		public boolean contains(Object o)
		{
			ListIterator<T> it = this.backingList.listIterator();
			while (it.hasNext())
			{
				T t = it.next();
				if ((o == null && t == null) || (o != null && o.equals(t)))
				{
					readPresentAttribute(it.previousIndex());
					return true;
				}
			}
			return false;
		}

		@Override
		public boolean containsAll(Collection<?> c)
		{
			boolean ret = true;
			for (Object o : c)
			{
				ret &= contains(o);
			}
			return ret;
		}

		@Override
		public T get(int index)
		{
			readBetweenAttribute(index);
			readPresentAttribute(index);
			readBetweenAttribute(index+1);
			return this.backingList.get(index);
		}

		@Override
		public int indexOf(Object o)
		{
			ListIterator<T> it = listIterator();
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
			ListIterator<T> it = listIterator(size());
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
		public ListIterator<T> listIterator(final int index)
		{
			return new ListIterator<T>()
			{
				private ListIterator<T> iterator = ListNodeList.this.backingList.listIterator(index);
				private int lastIndex;
				private T lastValue;
				private boolean lastValid = false;

				@Override
				public void add(T e)
				{
					getManager().assertInsertable(ListNodeImpl.this);
					
					this.lastValid = false;
					int index = this.iterator.nextIndex();
					ListNodeList.this.beforeAttributes.add(index, new ListAttribute());
					ListNodeList.this.presentAttributes.add(index, new ListAttribute());
					
					this.iterator.add(e);
					elementAdded(e);
					
					writeBetweenAttribute(index, e);
					writePresentAttribute(index);
					writeBetweenAttribute(index+1, e);
					writeSizeAttribute();
				}

				@Override
				public boolean hasNext()
				{
					readBetweenAttribute(iterator.nextIndex());
					return iterator.hasNext();
				}

				@Override
				public boolean hasPrevious()
				{
					readBetweenAttribute(iterator.previousIndex());
					return iterator.hasPrevious();
				}

				@Override
				public T next()
				{
					this.lastIndex = iterator.nextIndex();
					readBetweenAttribute(this.lastIndex);
					readPresentAttribute(this.lastIndex);
					this.lastValid = true;
					this.lastValue = iterator.next();
					return this.lastValue;
				}

				@Override
				public int nextIndex()
				{
					return iterator.nextIndex();
				}

				@Override
				public T previous()
				{
					this.lastIndex = iterator.previousIndex();
					readBetweenAttribute(this.lastIndex);
					readPresentAttribute(this.lastIndex);
					this.lastValid = true;
					this.lastValue = iterator.previous();
					return this.lastValue;
				}

				@Override
				public int previousIndex()
				{
					return iterator.previousIndex();
				}

				@Override
				public void remove()
				{
					getManager().assertMutatable(ListNodeImpl.this);
					
					if (!this.lastValid)
					{
						throw new IllegalStateException("Iterator cannot remove - no valid element");
					}
					this.lastValid = false;
					writeBetweenAttribute(this.lastIndex, this.lastValue);
					writePresentAttribute(this.lastIndex);
					writeBetweenAttribute(this.lastIndex+1, this.lastValue);
					writeSizeAttribute();
					ListNodeList.this.beforeAttributes.remove(this.lastIndex);
					ListNodeList.this.presentAttributes.remove(this.lastIndex);
					iterator.remove();
					elementRemoved(this.lastValue);
					this.lastValue = null;
				}

				@Override
				public void set(T e)
				{
					getManager().assertMutatable(ListNodeImpl.this);
					if (!this.lastValid)
					{
						throw new IllegalStateException("Iterator cannot remove - no valid element");
					}
					writePresentAttribute(this.lastIndex);
					iterator.set(e);
					elementRemoved(this.lastValue);
					elementAdded(e);
					this.lastValue = e;
				}
			};
		}

		@Override
		public T remove(int index)
		{
			getManager().assertMutatable(ListNodeImpl.this);
			
			T element = this.backingList.get(index);
			writeBetweenAttribute(index, element);
			writePresentAttribute(index);
			writeBetweenAttribute(index+1, element);
			writeSizeAttribute();
			removeElementByIndex(index);
			return element;
		}

		@Override
		public boolean remove(Object o)
		{
			getManager().assertMutatable(ListNodeImpl.this);
			
			int index = indexOf(o);
			if (index != -1)
			{
				writePresentAttribute(index);
				writeSizeAttribute();
				removeElementByIndex(index);
				return true;
			} else
			{
				return false;
			}
		}

		@Override
		public boolean removeAll(Collection<?> c)
		{
			getManager().assertMutatable(ListNodeImpl.this);
			
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
			getManager().assertMutatable(ListNodeImpl.this);
			
			boolean ret = false;
			ListIterator<T> it = this.backingList.listIterator();
			while (it.hasNext())
			{
				if (!c.contains(it.next()))
				{
					int index = it.previousIndex();
					writePresentAttribute(index);
					writeSizeAttribute();
					removeElementByIndex(index);
					ret = true;
				}
			}
			return ret;
		}

		@Override
		public T set(int index, T element)
		{
			getManager().assertMutatable(ListNodeImpl.this);
			
			writeBetweenAttribute(index, element);
			writePresentAttribute(index);
			writeBetweenAttribute(index+1, element);
			T ret = this.backingList.set(index, element);
			writeBetweenAttribute(index, ret);
			writeBetweenAttribute(index+1, ret);
			elementRemoved(ret);
			elementAdded(element);
			return ret;
		}

		@Override
		public int size()
		{
			readSizeAttribute();
			return this.backingList.size();
		}

		@Override
		public List<T> subList(int fromIndex, int toIndex)
		{
			return new SubList<T>(this, fromIndex, toIndex);
		}

		@Override
		public Object[] toArray()
		{
			Object[] ret = this.backingList.toArray();
			recordAllAccesses(AccessType.READ);
			return ret;
		}

		@Override
		public <E> E[] toArray(E[] a)
		{
			E[] ret = this.backingList.toArray(a);
			recordAllAccesses(AccessType.READ);
			return ret;
		}
		
		private void recordAllAccesses(AccessType accessType)
		{
			for (ListAttribute att : this.beforeAttributes)
				att.recordAccess(accessType);
			for (ListAttribute att : this.presentAttributes)
				att.recordAccess(accessType);
			this.afterAttribute.recordAccess(accessType);
			this.sizeAttribute.recordAccess(accessType);
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
			 * 
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
					ListAttribute other = (ListAttribute) o;
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
			 * Records an access to this attribute. (Convenience method.)
			 */
			public void recordAccess(Attribute.AccessType accessType)
			{
				ListNodeImpl.this.recordAccess(this, accessType);
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
		return this.children.<E> toArray(a);
	}
}
