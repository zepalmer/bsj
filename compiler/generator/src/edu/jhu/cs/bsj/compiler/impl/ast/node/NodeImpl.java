package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.InvokableNameBindingNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNameBindingNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNameBindingNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.EditScriptElement;
import edu.jhu.cs.bsj.compiler.impl.ast.exception.MultipleParentNodeExceptionImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.NodeProperties;
import edu.jhu.cs.bsj.compiler.impl.tool.serializer.BsjSourceSerializerImpl;
import edu.jhu.cs.bsj.compiler.impl.utils.EmptyIterator;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class NodeImpl implements Node
{
    /** The location at which this node's text starts (inclusive). */
    private BsjSourceLocation startLocation;
    
    /** The location at which this node's text stops (exclusive). */
    private BsjSourceLocation stopLocation;
    
    /** The BSJ node manager for this node. */
    private BsjNodeManager manager;
    
    /** Whether or not this node originated in a binary file. */
    private boolean binary;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<NodeProperties> populatedProperties;
    
    /** General constructor. */
    protected NodeImpl(
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super();
        this.populatedProperties = null;
        doSetStartLocation(startLocation);
        doSetStopLocation(stopLocation);
        this.manager = manager;
        this.binary = binary;
    }
    
    /** Proxy constructor. */
    protected NodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, Node backingNode)
    {
        super();
        this.manager = manager;
        this.proxyFactory = proxyFactory;
        this.backingNode = backingNode;
        this.populatedProperties = EnumSet.noneOf(NodeProperties.class);
    }
    
    /**
     * Ensures that the startLocation value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkStartLocationWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                NodeProperties.START_LOCATION))
            return;
        this.populatedProperties.add(NodeProperties.START_LOCATION);
        this.startLocation = this.getBackingNode().getStartLocation();
    }
    
    /**
     * Ensures that the stopLocation value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkStopLocationWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                NodeProperties.STOP_LOCATION))
            return;
        this.populatedProperties.add(NodeProperties.STOP_LOCATION);
        this.stopLocation = this.getBackingNode().getStopLocation();
    }
    
    /**
     * Gets the location at which this node's text starts (inclusive).
     * @return The location at which this node's text starts (inclusive).
     */
    public BsjSourceLocation getStartLocation()
    {
        checkStartLocationWrapped();
        return this.startLocation;
    }
    
    private void doSetStartLocation(BsjSourceLocation startLocation)
    {
        this.startLocation = startLocation;
    }
    
    /**
     * Gets the location at which this node's text stops (exclusive).
     * @return The location at which this node's text stops (exclusive).
     */
    public BsjSourceLocation getStopLocation()
    {
        checkStopLocationWrapped();
        return this.stopLocation;
    }
    
    private void doSetStopLocation(BsjSourceLocation stopLocation)
    {
        this.stopLocation = stopLocation;
    }
    
    /**
     * Handles the visitation of this node's children for the provided visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
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
    protected void receiveTypedToChildren(BsjTypedNodeVisitor visitor)
    {
        Iterator<? extends Node> extras = getHiddenVisitorChildren();
        if (extras != null)
        {
            while (extras.hasNext())
            {
                extras.next().receiveTyped(visitor);
            }
        }
    }
    
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitStopEnd(this);
    }
    
    /**
     * Produces a mutable list of this node's children.  Modifying this list will have no
     * effect on this node.
     * @return A list of this node's children.
     */
    public List<Object> getChildObjects()
    {
        List<Object> list = new ArrayList<Object>();
        list.add(getStartLocation().toString() + " - " + getStopLocation().toString());
        return list;
    }
    
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
        sb.append("startLocation=");
        sb.append(String.valueOf(this.getStartLocation()) + ":" + (this.getStartLocation() != null ? this.getStartLocation().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("stopLocation=");
        sb.append(String.valueOf(this.getStopLocation()) + ":" + (this.getStopLocation() != null ? this.getStopLocation().getClass().getSimpleName() : "null"));
        sb.append(']');
        return sb.toString();
    }
    
    
    
    /**
     * The next globally unique UID to assign.
     */
    private static AtomicLong sUid = new AtomicLong(0);

    /**
     * The unique ID of this node.
     */
    private long uid = sUid.getAndIncrement();

    /**
     * Assigns this node a UID.
     */
    private BsjNodeProxyFactory proxyFactory;

    /**
     * The backing node over which to proxy (if one exists).
     */
    private Node backingNode;

    /**
     * The parent for this node.
     */
    private Node parent = null;
    /**
     * A variable indicating whether or not the <code>parent</code> variable has ever been populated from the backing
     * node. This field is meaningless if this node is not a proxy.
     */
    private boolean parentPopulated = false;

    public boolean equals(Object object)
    {
        if (object instanceof NodeImpl)
        {
            NodeImpl other = (NodeImpl) object;
            return (this.uid == other.uid);
        } else
        {
            return false;
        }
    }

    public int hashCode()
    {
        return (int) this.uid;
    }

    public void receive(BsjNodeVisitor visitor)
    {
        visitor.visitStart(this);
        receiveToChildren(visitor);
        visitor.visitStop(this);
    }

    /**
     * Used to obtain an iterator of additional children of this node that visitors should visit. The default
     * implementation specifies no additional children.
     * 
     * @return An iterator of children that visitors to this node should visit. If <code>null</code>, no additional
     *         children are used.
     */
    protected Iterator<? extends Node> getHiddenVisitorChildren()
    {
        return new EmptyIterator<Node>();
    }

    public long getUid()
    {
        return this.uid;
    }

    protected BsjNodeProxyFactory getProxyFactory()
    {
        return this.proxyFactory;
    }

    protected Node getBackingNode()
    {
        return this.backingNode;
    }

    public Node getParent()
    {
        checkParentWrapped();
        return this.parent;
    }

    private void checkParentWrapped()
    {
        if (this.backingNode != null && !this.parentPopulated)
        {
            this.parentPopulated = true;
            this.parent = this.proxyFactory.makeNode(this.backingNode.getParent());
        }
    }

    /**
     * Changes the parent node reference object for this node.
     * 
     * @param node The parent node for this node.
     */
    public void setParent(Node node)
    {
        checkParentWrapped();
        if (this.parent != null && node != null && this.parent.getUid() != node.getUid())
        {
            throw new MultipleParentNodeExceptionImpl(node, this);
        }
        // Note: we don't need to record an edit to the parent property here. This is because the parent property is
        // only updated in accordance with other properties, so the edits that are recorded for them will suffice.
        this.parent = node;
    }

    protected void setAsChild(Node node, boolean child)
    {
        if (node instanceof NodeImpl)
        {
            ((NodeImpl) node).setParent(child ? this : null);
        } else if (node != null)
        {
            // TODO: throw an exception indicating a heterogeneous tree?
        }
    }

    public <N> N getNearestAncestorOfType(Class<N> nodeClass)
    {
        return getNearestAncestorOfType(nodeClass, null);
    }

    public <N> N getNearestAncestorOfType(Class<N> nodeClass, List<? super Node> list)
    {
        return this.getNearestAncestorOfTypes(Collections.<Class<? extends N>> singletonList(nodeClass), list);
    }

    public <N> N getNearestAncestorOfTypes(Collection<Class<? extends N>> nodeClasses)
    {
        return getNearestAncestorOfTypes(nodeClasses, null);
    }

    public <N> N getNearestAncestorOfTypes(Collection<Class<? extends N>> nodeClasses, List<? super Node> list)
    {
        List<Node> nodeList = new ArrayList<Node>();
        Node node = this.getParent();
        while (node != null)
        {
            Class<? extends N> nodeClass = null;
            for (Class<? extends N> candidateClass : nodeClasses)
            {
                if (candidateClass.isInstance(node))
                {
                    nodeClass = candidateClass;
                    break;
                }
            }
            if (nodeClass != null)
            {
                if (list != null)
                {
                    list.addAll(nodeList);
                }
                return nodeClass.cast(node);
            }
            nodeList.add(node);
            node = node.getParent();
        }
        return null;
    }

    public Node getFurthestAncestor()
    {
        Node node = this;
        while (node.getParent() != null)
        {
            node = node.getParent();
        }
        return node;
    }

    public PackageNode getRootPackage()
    {
        Node node = getFurthestAncestor();
        if (node instanceof PackageNode)
        {
            PackageNode packageNode = (PackageNode) node;
            if (packageNode.getName() == null)
            {
                return packageNode;
            }
        }
        return null;
    }

    public BsjNodeManager getManager()
    {
        return this.manager;
    }

    public boolean isBinary()
    {
        if (this.backingNode == null)
        {
            return this.binary;
        } else
        {
            return this.backingNode.isBinary();
        }
    }

    public String toSourceCode()
    {
        return this.executeOperation(new BsjSourceSerializerImpl(), null);
    }

    public Collection<? extends Node> getDeclarationsInScope(NameNode name)
    {
        return this.getManager().getDeclarationsInScope(this, name);
    }

    public Collection<? extends TypeNameBindingNode> getTypeDeclarationsInScope(String name)
    {
        return this.getManager().getTypeDeclarationsInScope(this, name);
    }

    public Collection<? extends TypeNameBindingNode> getTypeDeclarationsInScope(List<String> nameComponents)
    {
        return this.getManager().getTypeDeclarationsInScope(this, nameComponents);
    }

    public Collection<? extends InvokableNameBindingNode> getMethodDeclarationsInScope(String name)
    {
        return this.getManager().getMethodDeclarationsInScope(this, name);
    }

    public Collection<? extends VariableNameBindingNode> getVariableDeclarationsInScope(String name)
    {
        return this.getManager().getVariableDeclarationsInScope(this, name);
    }

    /**
     * Reports an edit script element. This method is invoked whenever a setter is called to record the change in a
     * change log.
     * 
     * @param element The edit script element in question.
     */
    protected void recordEdit(EditScriptElement element)
    {
        this.getManager().recordEdit(element);
    }

}
