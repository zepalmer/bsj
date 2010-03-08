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
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.utils.ProxyList;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class ListNodeImpl<T extends Node> extends NodeImpl implements ListNode<T>
{
    /** The list of children. */
    private List<T> children;
    
    /** General constructor. */
    protected ListNodeImpl(
            List<T> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager)
    {
        super(startLocation, stopLocation, manager);
        this.children = new ListNodeProxyList(new ArrayList<T>(children));
    }
    
    /**
     * Gets the list of children.
     * @return The list of children.
     */
    public List<T> getChildren()
    {
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
			ListNodeImpl.this.getManager().assertInsertable(ListNodeImpl.this);
			if (element instanceof NodeImpl)
			{
				((NodeImpl)element).setParent(ListNodeImpl.this);
			}
		}
		protected void elementRemoved(int index, T element)
		{
			ListNodeImpl.this.getManager().assertMutatable(ListNodeImpl.this);
			if (element instanceof NodeImpl)
			{
				((NodeImpl)element).setParent(null);
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
}
