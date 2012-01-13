package edu.jhu.cs.bsj.compiler.impl.ast.node.meta;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.IdentifierListNode;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramTargetNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MetaprogramTargetNodeSetTargetsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.MetaprogramTargetNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramTargetNodeImpl extends NodeImpl implements MetaprogramTargetNode
{
    /** The names of the metaprogram targets in which to participate. */
    private NodeUnion<? extends IdentifierListNode> targets;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<MetaprogramTargetNodeProperties> populatedProperties;
    
    /** General constructor. */
    public MetaprogramTargetNodeImpl(
            NodeUnion<? extends IdentifierListNode> targets,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetTargets(targets);
    }
    
    /** Proxy constructor. */
    public MetaprogramTargetNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, MetaprogramTargetNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(MetaprogramTargetNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected MetaprogramTargetNode getBackingNode()
    {
        return (MetaprogramTargetNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the targets value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkTargetsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MetaprogramTargetNodeProperties.TARGETS))
            return;
        this.populatedProperties.add(MetaprogramTargetNodeProperties.TARGETS);
        NodeUnion<? extends IdentifierListNode> union = this.getBackingNode().getUnionForTargets();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeIdentifierListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.targets = union;
    }
    
    /**
     * Gets the names of the metaprogram targets in which to participate.  This property's value is assumed to be a normal node.
     * @return The names of the metaprogram targets in which to participate.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public IdentifierListNode getTargets()
    {
        checkTargetsWrapped();
        if (this.targets == null)
        {
            return null;
        } else
        {
            return this.targets.getNormalNode();
        }
    }
    
    /**
     * Gets the names of the metaprogram targets in which to participate.
     * @return The names of the metaprogram targets in which to participate.
     */
    public NodeUnion<? extends IdentifierListNode> getUnionForTargets()
    {
        checkTargetsWrapped();
        if (this.targets == null)
        {
            this.targets = new NormalNodeUnion<IdentifierListNode>(null);
        }
        return this.targets;
    }
    
    /**
     * Changes the names of the metaprogram targets in which to participate.
     * @param targets The names of the metaprogram targets in which to participate.
     */
    public void setTargets(IdentifierListNode targets)
    {
        checkTargetsWrapped();
        this.setUnionForTargets(new NormalNodeUnion<IdentifierListNode>(targets));
    }
    
    /**
     * Changes the names of the metaprogram targets in which to participate.
     * @param targets The names of the metaprogram targets in which to participate.
     */
    public void setUnionForTargets(NodeUnion<? extends IdentifierListNode> targets)
    {
        checkTargetsWrapped();
        this.getManager().assertMutatable(this);
        this.doSetTargets(targets);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MetaprogramTargetNodeSetTargetsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), targets.getNodeValue() == null ? null : targets.getNodeValue().getUid()));
    }
    
    private void doSetTargets(NodeUnion<? extends IdentifierListNode> targets)
    {
        if (targets == null)
        {
            targets = new NormalNodeUnion<IdentifierListNode>(null);
        }
        if (this.targets != null)
        {
            setAsChild(this.targets.getNodeValue(), false);
        }
        this.targets = targets;
        setAsChild(targets.getNodeValue(), true);
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
        if (this.getUnionForTargets().getNodeValue() != null)
        {
            this.getUnionForTargets().getNodeValue().receive(visitor);
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
        if (this.getUnionForTargets().getNodeValue() != null)
        {
            this.getUnionForTargets().getNodeValue().receiveTyped(visitor);
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
        visitor.visitMetaprogramTargetNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitMetaprogramTargetNodeStop(this, true);
        visitor.visitStopEnd(this);
    }
    
    /**
     * Produces a mutable list of this node's children.  Modifying this list will have no
     * effect on this node.
     * @return A list of this node's children.
     */
    @Override
    public List<Object> getChildObjects()
    {
        List<Object> list = super.getChildObjects();
        list.add(getUnionForTargets());
        return list;
    }
    
    /**
     * Produces a mutable map of this node's children.  Modifying this map will have no
     * effect on this node.
     * @return A mapping of the node's children.
     */
    @Override
    public Map<String,Object> getChildMap()
    {
        Map<String,Object> map = super.getChildMap();
        map.put("targets", getUnionForTargets());
        return map;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForTargets().getNodeValue()});
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
        sb.append("targets=");
        sb.append(this.getUnionForTargets().getNodeValue() == null? "null" : this.getUnionForTargets().getNodeValue().getClass().getSimpleName());
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
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P,R,X extends Exception> R executeOperation(BsjAbortableNodeOperation<P,R,X> operation, P p) throws X
    {
        return operation.executeMetaprogramTargetNode(this, p);
    }
    
    /**
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p1 The parameter to pass to the operation.
     * @param p2 The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P1,P2,R,X extends Exception> R executeOperation(BsjAbortableNodeOperation2Arguments<P1,P2,R,X> operation, P1 p1, P2 p2) throws X
    {
        return operation.executeMetaprogramTargetNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramTargetNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends IdentifierListNode> targetsCopy;
        switch (getUnionForTargets().getType())
        {
            case NORMAL:
                if (getUnionForTargets().getNormalNode() == null)
                {
                    targetsCopy = factory.<IdentifierListNode>makeNormalNodeUnion(null);
                } else
                {
                    targetsCopy = factory.makeNormalNodeUnion(getUnionForTargets().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForTargets().getSpliceNode() == null)
                {
                    targetsCopy = factory.<IdentifierListNode>makeSpliceNodeUnion(null);
                } else
                {
                    targetsCopy = factory.makeSpliceNodeUnion(getUnionForTargets().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForTargets().getType());
        }
        return factory.makeMetaprogramTargetNodeWithUnions(
                targetsCopy,
                getStartLocation(),
                getStopLocation());
    }
    /**
     * Performs replacement for this node.
     * @param before The node to replace.
     * @param after The node to replace the <tt>before</tt> node.
     * @return <code>true</code> if the replacement was successful; <code>false</code> if the
     *         specified <tt>before</tt> node is not a child of this node.
     */
    public boolean replace(Node before, Node after)
    {
        if (before==null)
            throw new IllegalArgumentException("Cannot replace node with before value of null.");
        
        if (before.equals(this.getUnionForTargets().getNodeValue()))
        {
            setTargets((IdentifierListNode)after);
            return true;
        }
        return false;
    }
    
}
