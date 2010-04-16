/* GEN:headerstart */
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.utils.SubList;
import static edu.jhu.cs.bsj.compiler.impl.ast.Attribute.AccessType;

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
	/* GEN:stop */
}