package edu.jhu.cs.bsj.compiler.impl.ast.node.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.NodeList;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.NodeUnionFilter;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramListMissingElementException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.helper.NodeListImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.ConversionList;
import edu.jhu.cs.bsj.compiler.impl.utils.Converter;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class ListNodeImpl<T extends Node> extends NodeImpl implements ListNode<T>
{
    /** The list of children. */
    private List<NodeUnion<? extends T>> children;
    
    /** General constructor. */
    protected ListNodeImpl(
            List<NodeUnion<? extends T>> children,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        doSetChildren(getChildrenList(children));
    }
    
    /** Proxy constructor. */
    protected ListNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, ListNode<T> backingNode)
    {
        super(manager, proxyFactory, backingNode);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    // This SuppressWarnings is always safe because backingNode is set by the node
    // constructor and never changed.  This is equivalent to a read-only value
    // defined by a type parameter without complicating the type reference site.
    @SuppressWarnings("unchecked")
    protected ListNode<T> getBackingNode()
    {
        return (ListNode<T>)super.getBackingNode();
    }
    
    /**
     * Gets whether or not this list's contents are always order-dependent.
     * @return Whether or not this list's contents are always order-dependent.
     */
    public abstract boolean getAlwaysOrdered();
    
    /**
     * Gets the list of children.  This property's value is assumed to be a list of normal nodes.
     * @return The list of children.
     */
    public List<T> getChildren()
    {
        checkChildrenWrapped();
        if (this.children == null)
        {
            return null;
        } else
        {
            return new ConversionList<T, NodeUnion<? extends T>>(this.children, getChildrenElementType(),
                    new Converter<T, NodeUnion<? extends T>>()
                    {
                        @Override
                        public NodeUnion<? extends T> convert(T t)
                        {
                            return new NormalNodeUnion<T>(t);
                        }
                    }, new Converter<NodeUnion<? extends T>, T>()
                    {
                        @Override
                        public T convert(NodeUnion<? extends T> t)
                        {
                            return t.getNormalNode();
                        }
                    });
        }
    }
    
    /**
     * Gets the list of children.
     * @return The list of children.
     */
    public List<NodeUnion<? extends T>> getUnionForChildren()
    {
        checkChildrenWrapped();
        return this.children;
    }
    
    private void doSetChildren(List<NodeUnion<? extends T>> children)
    {
        this.children = children;
    }
    
    protected abstract Class<T> getChildrenElementType();
    
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
        if (this.getChildren() != null)
        {
            for (NodeUnion<?> nodeUnion : this.getUnionForChildren())
            {
                nodeUnion.getNodeValue().receive(visitor);
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
        if (this.getChildren() != null)
        {
            for (NodeUnion<?> nodeUnion : this.getUnionForChildren())
            {
                nodeUnion.getNodeValue().receiveTyped(visitor);
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
        list.add(getUnionForChildren());
        return list;
    }
    */
    /**
     * Produces a mutable map of this node's children.  Modifying this map will have no
     * effect on this node.
     * @return A mapping of the node's children.
     */
    /* // (not generating children)
    @Override
    public Map<String,Object> getChildMap()
    {
        Map<String,Object> map = super.getChildMap();
        map.put("children", getUnionForChildren());
        return map;
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
        sb.append('#');
        sb.append(this.getUid());
        sb.append('[');
        sb.append("children=");
        sb.append(this.getUnionForChildren() == null? "null" : this.getUnionForChildren().getClass().getSimpleName());
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
    
    @Override
    public <U extends T> List<U> filterByType(Class<U> type)
    {
        List<U> ret = new ArrayList<U>();
        for (T t : this)
        {
            if (type.isInstance(t))
                ret.add(type.cast(t));
        }
        return ret;
    }
}
