package edu.jhu.cs.bsj.compiler.impl.ast.helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import edu.jhu.cs.bsj.compiler.ast.NodeFilter;
import edu.jhu.cs.bsj.compiler.ast.NodeList;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.NodeUnionFilter;
import edu.jhu.cs.bsj.compiler.ast.exception.MetaprogramListMissingElementException;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.ListNodeUtilities;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.list.ListAddAfterEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.list.ListAddBeforeEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.list.ListRemovalEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.list.ShadowList;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.NotImplementedYetException;
import edu.jhu.cs.bsj.compiler.impl.utils.SubList;

/**
 * Represents a list that a {@link ListNode} would use for backing data. In an ideal world, this logic would be built
 * into ListNode. Due to the complexity of the logic and the pain of concatenating source generation, however, it
 * currently resides here. This explains the massive feature envy this class demonstrates toward ListNode.
 * 
 * @author Zachary Palmer
 */
public class NodeListImpl<T extends Node> implements List<NodeUnion<? extends T>>, NodeList<T>
{
    // TODO: detection of multiple parents over *all* methods

    /** The backing list data structure. */
    private List<NodeUnion<? extends T>> backingList;
    /**
     * A mapping between UIDs of elements in this list and a UID tracking how many times they have been introduced. A
     * value of <code>1</code> is assigned to all elements which are initially present in the list. Each time an element
     * is added, it is assigned a number; first time elements start at one while repeat elements receive a number higher
     * than their previous one. This ID is used to describe changes when they are learned.
     */
    private Map<Long, Integer> elementMap;
    /** The parent of all nodes added to this list. */
    private ListNode<T> parent;
    /** The node manager to which updates should be reported. */
    private BsjNodeManager manager;

    public NodeListImpl(List<NodeUnion<? extends T>> elements, ListNode<T> parent, BsjNodeManager manager)
    {
        this.parent = parent;
        this.manager = manager;

        this.backingList = new ArrayList<NodeUnion<? extends T>>(elements);
        this.elementMap = new HashMap<Long, Integer>();

        for (NodeUnion<? extends T> union : elements)
        {
            introduce(union);
            setAsChild(union, true);
        }
    }

    private void checkNotNull(NodeUnion<?> node, boolean member)
    {
        if (node == null || node.getNodeValue() == null)
        {
            if (member)
            {
                throw new NullPointerException("Cannot use null as a reference in a node list.");
            } else
            {
                throw new NullPointerException("Cannot add null to a node list.");
            }
        }
    }
    
    /**
     * Indicates whether or not a given element is ordered.  Only valid for elements which are suitable children of the
     * list node that this object is backing.
     * @param element The element to consider.
     * @return <code>true</code> if it is ordered; <code>false</code> if it is not.
     */
    private boolean isOrdered(NodeUnion<? extends T> element)
    {
        return ListNodeUtilities.isOrderedElement(element, this.parent);
    }

    private void recordAddAfter(NodeUnion<? extends T> element, NodeUnion<? extends T> member)
    {
        this.manager.assertInsertable(this.parent);
        if (this.manager.isRecordingEdits())
        {
            if (member == null)
            {
                this.manager.recordEdit(new ListAddAfterEditScriptElementImpl(this.manager.getCurrentMetaprogramId(),
                        this.parent.getUid(), element.getNodeValue().getUid(), isOrdered(element),
                        this.elementMap.get(element.getNodeValue().getUid()), null, ShadowList.HEAD_OCCURRENCE));
            } else
            {
                this.manager.recordEdit(new ListAddAfterEditScriptElementImpl(this.manager.getCurrentMetaprogramId(),
                        this.parent.getUid(), element.getNodeValue().getUid(), isOrdered(element),
                        this.elementMap.get(element.getNodeValue().getUid()), member.getNodeValue().getUid(),
                        this.elementMap.get(member.getNodeValue().getUid())));
            }
        }
    }

    private void recordAddBefore(NodeUnion<? extends T> element, NodeUnion<? extends T> member)
    {
        this.manager.assertInsertable(this.parent);
        if (this.manager.isRecordingEdits())
        {
            if (member == null)
            {
                this.manager.recordEdit(new ListAddBeforeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(),
                        this.parent.getUid(), element.getNodeValue().getUid(), isOrdered(element),
                        this.elementMap.get(element.getNodeValue().getUid()), null, ShadowList.TAIL_OCCURRENCE));
            } else
            {
                this.manager.recordEdit(new ListAddBeforeEditScriptElementImpl(this.manager.getCurrentMetaprogramId(),
                        this.parent.getUid(), element.getNodeValue().getUid(), isOrdered(element),
                        this.elementMap.get(element.getNodeValue().getUid()), member.getNodeValue().getUid(),
                        this.elementMap.get(member.getNodeValue().getUid())));
            }
        }
    }

    private void recordRemove(NodeUnion<?> element)
    {
        this.manager.assertMutatable(this.parent);
        if (this.manager.isRecordingEdits())
        {
            this.manager.recordEdit(new ListRemovalEditScriptElementImpl(this.manager.getCurrentMetaprogramId(),
                    this.parent.getUid(), element.getNodeValue().getUid(),
                    this.elementMap.get(element.getNodeValue().getUid())));
        }
    }

    private void setAsChild(NodeUnion<? extends T> union, boolean child)
    {
        setAsChild(union.getNodeValue(), child);
    }

    private void setAsChild(Node node, boolean child)
    {
        if (node instanceof NodeImpl)
        {
            NodeImpl nodeImpl = (NodeImpl) node;
            if (!child && (nodeImpl.getParent().getUid() != this.parent.getUid()))
            {
                // Then this isn't the parent of that child anyway!
                return;
            }
            nodeImpl.setParent(child ? this.parent : null);
        } else if (node != null)
        {
            // TODO: throw an exception indicating a heterogeneous tree?
        }
    }

    private void introduce(NodeUnion<? extends T> node)
    {
        introduce(node.getNodeValue().getUid());
    }

    private void introduce(long uid)
    {
        if (this.elementMap.containsKey(uid))
        {
            this.elementMap.put(uid, this.elementMap.get(uid) + 1);
        } else
        {
            this.elementMap.put(uid, 1);
        }
    }

    private int assertedIndexOf(NodeUnion<? extends T> union)
    {
        int index = this.backingList.indexOf(union);
        if (index == -1)
        {
            // Raise MLMEE instead
            throw new NotImplementedYetException();
        }
        return index;
    }

    @Override
    public void addFirst(T node)
    {
        addFirstUnion(new NormalNodeUnion<T>(node));
    }

    @Override
    public void addLast(T node)
    {
        addLastUnion(new NormalNodeUnion<T>(node));
    }

    @Override
    public void addBefore(T member, T node) throws MetaprogramListMissingElementException
    {
        addBeforeUnion(new NormalNodeUnion<T>(member), new NormalNodeUnion<T>(node));
    }

    @Override
    public void addAfter(T member, T node) throws MetaprogramListMissingElementException
    {
        addAfterUnion(new NormalNodeUnion<T>(member), new NormalNodeUnion<T>(node));
    }

    @Override
    public boolean remove(T node)
    {
        return removeUnion(new NormalNodeUnion<T>(node));
    }

    @Override
    public T getFirst()
    {
        return getFirstUnion() == null ? null : getFirstUnion().getNormalNode();
    }

    @Override
    public T getLast()
    {
        return getLastUnion() == null ? null : getLastUnion().getNormalNode();
    }

    @Override
    public T getBefore(T member) throws MetaprogramListMissingElementException
    {
        NodeUnion<? extends T> union = getBeforeUnion(new NormalNodeUnion<T>(member));
        return union == null ? null : union.getNormalNode();
    }

    @Override
    public T getAfter(T member) throws MetaprogramListMissingElementException
    {
        NodeUnion<? extends T> union = getAfterUnion(new NormalNodeUnion<T>(member));
        return union == null ? null : union.getNormalNode();
    }

    @Override
    public Set<T> filter(NodeFilter<? super T> filter)
    {
        Set<T> set = new HashSet<T>();
        for (NodeUnion<? extends T> union : this)
        {
            if (filter.filter(union.getNormalNode()))
                set.add(union.getNormalNode());
        }
        return set;
    }

    @Override
    public void addFirstUnion(NodeUnion<? extends T> node)
    {
        checkNotNull(node, false);
        introduce(node);
        setAsChild(node, true);
        recordAddAfter(node, null);
        this.backingList.add(0, node);
    }

    @Override
    public void addLastUnion(NodeUnion<? extends T> node)
    {
        checkNotNull(node, false);
        introduce(node);
        setAsChild(node, true);
        recordAddBefore(node, null);
        this.backingList.add(node);
    }

    @Override
    public void addBeforeUnion(NodeUnion<? extends T> member, NodeUnion<? extends T> node)
            throws MetaprogramListMissingElementException
    {
        checkNotNull(node, false);
        checkNotNull(member, true);
        introduce(node);
        setAsChild(node, true);
        recordAddBefore(node, member);
        int index = assertedIndexOf(member);
        this.backingList.add(index, node);
    }

    @Override
    public void addAfterUnion(NodeUnion<? extends T> member, NodeUnion<? extends T> node)
            throws MetaprogramListMissingElementException
    {
        checkNotNull(node, false);
        checkNotNull(member, true);
        introduce(node);
        setAsChild(node, true);
        recordAddAfter(node, member);
        int index = assertedIndexOf(member);
        this.backingList.add(index + 1, node);
    }

    @Override
    public boolean removeUnion(NodeUnion<? extends T> node)
    {
        checkNotNull(node, true);
        setAsChild(node, false);
        recordRemove(node);
        return this.backingList.remove(node);
    }

    @Override
    public NodeUnion<? extends T> getFirstUnion()
    {
        if (this.backingList.size() > 0)
        {
            return this.backingList.get(0);
        } else
        {
            return null;
        }
    }

    @Override
    public NodeUnion<? extends T> getLastUnion()
    {
        if (this.backingList.size() > 0)
        {
            return this.backingList.get(this.backingList.size() - 1);
        } else
        {
            return null;
        }
    }

    @Override
    public NodeUnion<? extends T> getBeforeUnion(NodeUnion<? extends T> member)
            throws MetaprogramListMissingElementException
    {
        int index = assertedIndexOf(member);
        if (index == 0)
        {
            return null;
        } else
        {
            return this.backingList.get(index - 1);
        }
    }

    @Override
    public NodeUnion<? extends T> getAfterUnion(NodeUnion<? extends T> member)
            throws MetaprogramListMissingElementException
    {
        int index = assertedIndexOf(member);
        if (index == this.backingList.size() - 1)
        {
            return null;
        } else
        {
            return this.backingList.get(index + 1);
        }
    }

    @Override
    public Set<NodeUnion<? extends T>> filterUnions(NodeUnionFilter<? super T> filter)
    {
        Set<NodeUnion<? extends T>> set = new HashSet<NodeUnion<? extends T>>();
        for (NodeUnion<? extends T> union : this)
        {
            if (filter.filter(union))
                set.add(union);
        }
        return set;
    }

    @Override
    public int size()
    {
        return this.backingList.size();
    }

    @Override
    public boolean isEmpty()
    {
        return this.backingList.isEmpty();
    }

    @Override
    public boolean contains(Object o)
    {
        return this.backingList.contains(o);
    }

    @Override
    public Iterator<NodeUnion<? extends T>> iterator()
    {
        return listIterator();
    }

    @Override
    public Object[] toArray()
    {
        return this.backingList.toArray();
    }

    @Override
    public <E> E[] toArray(E[] a)
    {
        return this.backingList.toArray(a);
    }

    @Override
    public boolean add(NodeUnion<? extends T> e)
    {
        addLastUnion(e);
        return true;
    }

    @Override
    public boolean remove(Object o)
    {
        if (o == null || ((o instanceof NodeUnion<?>) && ((NodeUnion<?>) o).getNodeValue() == null))
            throw new NullPointerException("Cannot use null as a reference in a node list.");
        boolean result = this.backingList.remove(o);
        if (result)
        {
            NodeUnion<?> union = (NodeUnion<?>) o;
            setAsChild(union.getNodeValue(), false);
            recordRemove(union);
        }
        return result;
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        return this.backingList.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends NodeUnion<? extends T>> c)
    {
        for (NodeUnion<? extends T> nodeUnion : c)
        {
            this.add(nodeUnion);
        }
        return c.size() > 0;
    }

    @Override
    public boolean addAll(int index, Collection<? extends NodeUnion<? extends T>> c)
    {
        for (NodeUnion<? extends T> nodeUnion : c)
        {
            this.add(index++, nodeUnion);
        }
        return c.size() > 0;
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        boolean ret = false;
        for (Object object : c)
        {
            ret |= this.remove(object);
        }
        return ret;
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        boolean ret = false;
        int index = 0;
        while (index < size())
        {
            if (c.contains(this.get(index)))
            {
                index++;
            } else
            {
                this.remove(index);
                ret = true;
            }
        }
        return ret;
    }

    @Override
    public void clear()
    {
        while (this.size() > 0)
        {
            this.remove(0);
        }
    }

    @Override
    public NodeUnion<? extends T> get(int index)
    {
        return this.backingList.get(index);
    }

    @Override
    public NodeUnion<? extends T> set(int index, NodeUnion<? extends T> element)
    {
        checkNotNull(element, false);
        introduce(element);
        NodeUnion<? extends T> old = this.backingList.set(index, element);
        recordAddAfter(element, old);
        recordRemove(old);
        setAsChild(old, false);
        setAsChild(element, true);
        return old;
    }

    @Override
    public void add(int index, NodeUnion<? extends T> element)
    {
        if (index == 0)
        {
            addFirstUnion(element);
        } else
        {
            addAfterUnion(get(index - 1), element);
        }
        this.backingList.add(index, element);
    }

    @Override
    public NodeUnion<? extends T> remove(int index)
    {
        NodeUnion<? extends T> union = this.backingList.remove(index);
        setAsChild(union, false);
        recordRemove(union);
        return union;
    }

    @Override
    public int indexOf(Object o)
    {
        return this.backingList.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o)
    {
        return this.backingList.lastIndexOf(o);
    }

    @Override
    public ListIterator<NodeUnion<? extends T>> listIterator()
    {
        return this.listIterator(0);
    }

    @Override
    public ListIterator<NodeUnion<? extends T>> listIterator(final int index)
    {
        return new ListIterator<NodeUnion<? extends T>>()
        {
            private ListIterator<NodeUnion<? extends T>> backingIterator = NodeListImpl.this.backingList.listIterator(index);
            private NodeUnion<? extends T> lastValue = null;

            @Override
            public boolean hasNext()
            {
                return this.backingIterator.hasNext();
            }

            @Override
            public NodeUnion<? extends T> next()
            {
                this.lastValue = this.backingIterator.next();
                return this.lastValue;
            }

            @Override
            public boolean hasPrevious()
            {
                return this.backingIterator.hasPrevious();
            }

            @Override
            public NodeUnion<? extends T> previous()
            {
                this.lastValue = this.backingIterator.previous();
                return this.lastValue;
            }

            @Override
            public int nextIndex()
            {
                return this.backingIterator.nextIndex();
            }

            @Override
            public int previousIndex()
            {
                return this.backingIterator.previousIndex();
            }

            @Override
            public void remove()
            {
                this.backingIterator.remove();
                if (this.lastValue != null)
                {
                    NodeListImpl.this.setAsChild(this.lastValue, false);
                    recordRemove(this.lastValue);
                    this.lastValue = null;
                }
            }

            @Override
            public void set(NodeUnion<? extends T> e)
            {
                checkNotNull(e, false);
                this.backingIterator.set(e);
                NodeListImpl.this.introduce(e);
                NodeListImpl.this.setAsChild(e, true);
                recordAddAfter(e, this.lastValue);
                recordRemove(this.lastValue);
                if (this.lastValue != null)
                {
                    NodeListImpl.this.setAsChild(this.lastValue, false);
                }
                this.lastValue = e;
            }

            @Override
            public void add(NodeUnion<? extends T> e)
            {
                checkNotNull(e, false);
                this.backingIterator.add(e);
                NodeListImpl.this.introduce(e);
                NodeListImpl.this.setAsChild(e, true);
                int index = this.backingIterator.previousIndex() - 1;
                if (index == -1)
                {
                    recordAddAfter(e, null);
                } else
                {
                    recordAddAfter(e, NodeListImpl.this.get(index));
                }
                this.lastValue = null;
            }
        };
    }

    @Override
    public List<NodeUnion<? extends T>> subList(int fromIndex, int toIndex)
    {
        return new SubList<NodeUnion<? extends T>>(this, fromIndex, toIndex);
    }
}
