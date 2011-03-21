/* GEN:headerstart */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.helper.*;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramListMissingElementException;
import edu.jhu.cs.bsj.compiler.impl.utils.SubList;

/* GEN:headerstop */

public abstract class ListNodeImpl<T extends Node> extends Node implements ListNode<T>
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
     * Retrieves the list to use for this node's list interface.
     * 
     * @param children The children which should populate that list initially.
     */
    private List<NodeUnion<? extends T>> getChildrenList(List<NodeUnion<? extends T>> children)
    {
        return new NodeListImpl<T>(children, this,getManager());
    }

    protected abstract T wrapElement(T backingNode);

    private void checkChildrenWrapped()
    {
        if (this.children == null && this.getBackingNode() != null)
        {
            List<NodeUnion<? extends T>> backingChildren = this.getBackingNode().getUnionForChildren();
            List<NodeUnion<? extends T>> list = new ArrayList<NodeUnion<? extends T>>(backingChildren.size());
            for (NodeUnion<? extends T> child : backingChildren)
            {
                switch (child.getType())
                {
                    case NORMAL:
                        list.add(getProxyFactory().makeNormalNodeUnion(wrapElement(child.getNormalNode())));
                        break;
                    case SPLICE:
                        list.add(getProxyFactory().<T>makeSpliceNodeUnion(
                                getProxyFactory().makeSpliceNode(child.getSpliceNode())));
                        break;
                    default:
                        throw new IllegalStateException("Unrecognized union type: " + child.getType());
                }
            }
            this.children = new NodeListImpl<T>(list, this, getManager());
        }
    }
    
    @SuppressWarnings("unchecked")
    private NodeList<T> getNodeList()
    {
        return (NodeList<T>)getUnionForChildren();
    }

    @Override
    public void add(int index, T element)
    {
        getChildren().add(index, element);
    }

    @Override
    public boolean add(T e)
    {
        return getChildren().add(e);
    }

    @Override
    public boolean addAll(Collection<? extends T> c)
    {
        return getChildren().addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c)
    {
        return getChildren().addAll(index, c);
    }

    @Override
    public void clear()
    {
        getChildren().clear();
    }

    @Override
    public boolean contains(Object o)
    {
        return getChildren().contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        return getChildren().containsAll(c);
    }

    @Override
    public T get(int index)
    {
        return getChildren().get(index);
    }

    @Override
    public int indexOf(Object o)
    {
        return getChildren().indexOf(o);
    }

    @Override
    public boolean isEmpty()
    {
        return getChildren().isEmpty();
    }

    @Override
    public Iterator<T> iterator()
    {
        return getChildren().iterator();
    }

    @Override
    public int lastIndexOf(Object o)
    {
        return getChildren().lastIndexOf(o);
    }

    @Override
    public ListIterator<T> listIterator()
    {
        return getChildren().listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index)
    {
        return getChildren().listIterator(index);
    }

    @Override
    public T remove(int index)
    {
        return getChildren().remove(index);
    }

    @Override
    public boolean remove(Object o)
    {
        return getChildren().remove(o);
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        return getChildren().removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        return getChildren().retainAll(c);
    }

    @Override
    public T set(int index, T element)
    {
        return getChildren().set(index, element);
    }

    @Override
    public int size()
    {
        return getChildren().size();
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex)
    {
        return getChildren().subList(fromIndex, toIndex);
    }

    @Override
    public Object[] toArray()
    {
        return getChildren().toArray();
    }

    @Override
    public <E> E[] toArray(E[] a)
    {
        return getChildren().<E> toArray(a);
    }

    @Override
    public void addFirst(T node)
    {
        this.getNodeList().addFirst(node);
    }

    @Override
    public void addLast(T node)
    {
        this.getNodeList().addLast(node);
    }

    @Override
    public void addBefore(T member, T node) throws IllegalArgumentException
    {
        this.getNodeList().addBefore(member, node);
    }

    @Override
    public void addAfter(T member, T node) throws IllegalArgumentException
    {
        this.getNodeList().addAfter(member, node);
    }

    @Override
    public boolean remove(T node)
    {
        return this.getNodeList().remove(node);
    }

    @Override
    public T getFirst()
    {
        return this.getNodeList().getFirst();
    }

    @Override
    public T getLast()
    {
        return this.getNodeList().getLast();
    }

    @Override
    public T getBefore(T member) throws IllegalArgumentException
    {
        return this.getNodeList().getBefore(member);
    }

    @Override
    public T getAfter(T member) throws IllegalArgumentException
    {
        return this.getNodeList().getAfter(member);
    }

    @Override
    public Set<T> filter(NodeFilter<? super T> filter)
    {
        return this.getNodeList().filter(filter);
    }

    @Override
    public void addFirstUnion(NodeUnion<? extends T> node)
    {
        this.getNodeList().addFirstUnion(node);
    }

    @Override
    public void addLastUnion(NodeUnion<? extends T> node)
    {
        this.getNodeList().addLastUnion(node);
    }

    @Override
    public void addBeforeUnion(NodeUnion<? extends T> member, NodeUnion<? extends T> node)
            throws MetaprogramListMissingElementException
    {
        this.getNodeList().addBeforeUnion(member, node);
    }

    @Override
    public void addAfterUnion(NodeUnion<? extends T> member, NodeUnion<? extends T> node)
            throws MetaprogramListMissingElementException
    {
        this.getNodeList().addAfterUnion(member, node);
    }

    @Override
    public boolean removeUnion(NodeUnion<? extends T> node)
    {
        return this.getNodeList().removeUnion(node);
    }

    @Override
    public NodeUnion<? extends T> getFirstUnion()
    {
        return this.getNodeList().getFirstUnion();
    }

    @Override
    public NodeUnion<? extends T> getLastUnion()
    {
        return this.getNodeList().getLastUnion();
    }

    @Override
    public NodeUnion<? extends T> getBeforeUnion(NodeUnion<? extends T> member)
    {
        return this.getNodeList().getBeforeUnion(member);
    }

    @Override
    public NodeUnion<? extends T> getAfterUnion(NodeUnion<? extends T> member)
    {
        return this.getNodeList().getAfterUnion(member);
    }

    @Override
    public Set<NodeUnion<? extends T>> filterUnions(NodeUnionFilter<? super T> filter)
    {
        return this.getNodeList().filterUnions(filter);
    }
    /* GEN:stop */
}