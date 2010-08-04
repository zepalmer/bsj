package edu.jhu.cs.bsj.compiler.impl.ast.node.list;

import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.NodeList;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NodeListAdapter;
import edu.jhu.cs.bsj.compiler.impl.ast.NodeListImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class ListNodeImpl<T extends Node> extends NodeImpl implements ListNode<T>
{
    /** The list of children. */
    private List<T> children;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(ListNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the children property. */
        CHILDREN,
    }
    
    /** General constructor. */
    protected ListNodeImpl(
            List<T> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.children = getChildrenList(children);
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
        getAttribute(LocalAttribute.CHILDREN).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        Iterator<? extends Node> extras = getHiddenVisitorChildren();
        if (extras != null)
        {
            while (extras.hasNext())
            {
                extras.next().receive(visitor);
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
        Iterator<? extends Node> extras = getHiddenVisitorChildren();
        if (extras != null)
        {
            while (extras.hasNext())
            {
                extras.next().receiveTyped(visitor);
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
	
	/** The backing node list. */
	private NodeList<T> nodeList;
	
	/**
	 * Retrieves the list to use for this node's list interface.
	 * @param children The children which should populate that list initially.
	 */
	private List<T> getChildrenList(List<T> children)
	{
		this.nodeList = new NodeListImpl<T>(getManager(), this, getAlwaysOrdered(), children);
		return new NodeListAdapter<T>(nodeList);
	}

	@Override
	public void add(int index, T element)
	{
		this.children.add(index, element);
	}

	@Override
	public boolean add(T e)
	{
		return this.children.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends T> c)
	{
		return this.children.addAll(c);
	}

	@Override
	public boolean addAll(int index, Collection<? extends T> c)
	{
		return this.children.addAll(index, c);
	}

	@Override
	public void clear()
	{
		this.children.clear();
	}

	@Override
	public boolean contains(Object o)
	{
		return this.children.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c)
	{
		return this.children.containsAll(c);
	}

	@Override
	public T get(int index)
	{
		return this.children.get(index);
	}

	@Override
	public int indexOf(Object o)
	{
		return this.children.indexOf(o);
	}

	@Override
	public boolean isEmpty()
	{
		return this.children.isEmpty();
	}

	@Override
	public Iterator<T> iterator()
	{
		return this.children.iterator();
	}

	@Override
	public int lastIndexOf(Object o)
	{
		return this.children.lastIndexOf(o);
	}

	@Override
	public ListIterator<T> listIterator()
	{
		return this.children.listIterator();
	}

	@Override
	public ListIterator<T> listIterator(int index)
	{
		return this.children.listIterator(index);
	}

	@Override
	public T remove(int index)
	{
		return this.children.remove(index);
	}

	@Override
	public boolean remove(Object o)
	{
		return this.children.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c)
	{
		return this.children.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c)
	{
		return this.children.retainAll(c);
	}

	@Override
	public T set(int index, T element)
	{
		return this.children.set(index, element);
	}

	@Override
	public int size()
	{
		return this.children.size();
	}

	@Override
	public List<T> subList(int fromIndex, int toIndex)
	{
		return this.children.subList(fromIndex, toIndex);
	}

	@Override
	public Object[] toArray()
	{
		return this.children.toArray();
	}

	@Override
	public <E> E[] toArray(E[] a)
	{
		return this.children.<E> toArray(a);
	}

	public void addFirst(T node)
	{
		this.nodeList.addFirst(node);
	}

	public void addLast(T node)
	{
		this.nodeList.addLast(node);
	}

	public void addBefore(T member, T node) throws IllegalArgumentException
	{
		this.nodeList.addBefore(member,node);
	}

	public void addAfter(T member, T node) throws IllegalArgumentException
	{
		this.nodeList.addAfter(member,node);
	}

	public boolean remove(T node)
	{
		return this.nodeList.remove(node);
	}
	
	public T getFirst()
	{
		return this.nodeList.getFirst();
	}

	public T getLast()
	{
		return this.nodeList.getLast();
	}

	public T getBefore(T member) throws IllegalArgumentException
	{
		return this.nodeList.getBefore(member);
	}

	public T getAfter(T member) throws IllegalArgumentException
	{
		return this.nodeList.getAfter(member);
	}

	public Set<T> filter(NodeFilter<? super T> filter)
	{
		return this.nodeList.filter(filter);
	}
}
