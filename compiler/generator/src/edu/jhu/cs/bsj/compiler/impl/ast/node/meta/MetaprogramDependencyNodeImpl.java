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
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.meta.MetaprogramDependencyNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MetaprogramDependencyNodeSetTargetNamePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MetaprogramDependencyNodeSetWeakPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.node.NodeImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.MetaprogramDependencyNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MetaprogramDependencyNodeImpl extends NodeImpl implements MetaprogramDependencyNode
{
    /** The name of the metaprogram target on which to depend. */
    private NodeUnion<? extends NameNode> targetName;
    
    /** Whether or not this dependency is weak. */
    private boolean weak;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<MetaprogramDependencyNodeProperties> populatedProperties;
    
    /** General constructor. */
    public MetaprogramDependencyNodeImpl(
            NodeUnion<? extends NameNode> targetName,
            boolean weak,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetTargetName(targetName);
        doSetWeak(weak);
    }
    
    /** Proxy constructor. */
    public MetaprogramDependencyNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, MetaprogramDependencyNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(MetaprogramDependencyNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected MetaprogramDependencyNode getBackingNode()
    {
        return (MetaprogramDependencyNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the targetName value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkTargetNameWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MetaprogramDependencyNodeProperties.TARGET_NAME))
            return;
        this.populatedProperties.add(MetaprogramDependencyNodeProperties.TARGET_NAME);
        NodeUnion<? extends NameNode> union = this.getBackingNode().getUnionForTargetName();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeNameNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.targetName = union;
    }
    
    /**
     * Ensures that the weak value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkWeakWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MetaprogramDependencyNodeProperties.WEAK))
            return;
        this.populatedProperties.add(MetaprogramDependencyNodeProperties.WEAK);
        this.weak = this.getBackingNode().getWeak();
    }
    
    /**
     * Gets the name of the metaprogram target on which to depend.  This property's value is assumed to be a normal node.
     * @return The name of the metaprogram target on which to depend.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public NameNode getTargetName()
    {
        checkTargetNameWrapped();
        if (this.targetName == null)
        {
            return null;
        } else
        {
            return this.targetName.getNormalNode();
        }
    }
    
    /**
     * Gets the name of the metaprogram target on which to depend.
     * @return The name of the metaprogram target on which to depend.
     */
    public NodeUnion<? extends NameNode> getUnionForTargetName()
    {
        checkTargetNameWrapped();
        if (this.targetName == null)
        {
            this.targetName = new NormalNodeUnion<NameNode>(null);
        }
        return this.targetName;
    }
    
    /**
     * Changes the name of the metaprogram target on which to depend.
     * @param targetName The name of the metaprogram target on which to depend.
     */
    public void setTargetName(NameNode targetName)
    {
        checkTargetNameWrapped();
        this.setUnionForTargetName(new NormalNodeUnion<NameNode>(targetName));
    }
    
    /**
     * Changes the name of the metaprogram target on which to depend.
     * @param targetName The name of the metaprogram target on which to depend.
     */
    public void setUnionForTargetName(NodeUnion<? extends NameNode> targetName)
    {
        checkTargetNameWrapped();
        this.getManager().assertMutatable(this);
        this.doSetTargetName(targetName);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MetaprogramDependencyNodeSetTargetNamePropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), targetName.getNodeValue() == null ? null : targetName.getNodeValue().getUid()));
    }
    
    private void doSetTargetName(NodeUnion<? extends NameNode> targetName)
    {
        if (targetName == null)
        {
            targetName = new NormalNodeUnion<NameNode>(null);
        }
        if (this.targetName != null)
        {
            setAsChild(this.targetName.getNodeValue(), false);
        }
        this.targetName = targetName;
        setAsChild(targetName.getNodeValue(), true);
    }
    
    /**
     * Gets whether or not this dependency is weak.
     * @return Whether or not this dependency is weak.
     */
    public boolean getWeak()
    {
        checkWeakWrapped();
        return this.weak;
    }
    
    /**
     * Changes whether or not this dependency is weak.
     * @param weak Whether or not this dependency is weak.
     */
    public void setWeak(boolean weak)
    {
        checkWeakWrapped();
        this.getManager().assertMutatable(this);
        this.doSetWeak(weak);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MetaprogramDependencyNodeSetWeakPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), weak));
    }
    
    private void doSetWeak(boolean weak)
    {
        this.weak = weak;
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
        if (this.getUnionForTargetName().getNodeValue() != null)
        {
            this.getUnionForTargetName().getNodeValue().receive(visitor);
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
        if (this.getUnionForTargetName().getNodeValue() != null)
        {
            this.getUnionForTargetName().getNodeValue().receiveTyped(visitor);
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
        visitor.visitMetaprogramDependencyNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitMetaprogramDependencyNodeStop(this, true);
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
        list.add(getUnionForTargetName());
        list.add(getWeak());
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
        map.put("targetName", getUnionForTargetName());
        map.put("weak", getWeak());
        return map;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForTargetName().getNodeValue()});
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
        sb.append("targetName=");
        sb.append(this.getUnionForTargetName().getNodeValue() == null? "null" : this.getUnionForTargetName().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("weak=");
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
        return operation.executeMetaprogramDependencyNode(this, p);
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
        return operation.executeMetaprogramDependencyNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaprogramDependencyNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends NameNode> targetNameCopy;
        switch (getUnionForTargetName().getType())
        {
            case NORMAL:
                if (getUnionForTargetName().getNormalNode() == null)
                {
                    targetNameCopy = factory.<NameNode>makeNormalNodeUnion(null);
                } else
                {
                    targetNameCopy = factory.makeNormalNodeUnion(getUnionForTargetName().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForTargetName().getSpliceNode() == null)
                {
                    targetNameCopy = factory.<NameNode>makeSpliceNodeUnion(null);
                } else
                {
                    targetNameCopy = factory.makeSpliceNodeUnion(getUnionForTargetName().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForTargetName().getType());
        }
        return factory.makeMetaprogramDependencyNodeWithUnions(
                targetNameCopy,
                getWeak(),
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
        
        if (before.equals(this.getUnionForTargetName().getNodeValue()))
        {
            setTargetName((NameNode)after);
            return true;
        }
        return false;
    }
    
}
