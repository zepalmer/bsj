package edu.jhu.cs.bsj.compiler.impl.ast.node;

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
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnonymousClassMemberListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.AnonymousClassBodyNodeSetMembersPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.AnonymousClassBodyNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class AnonymousClassBodyNodeImpl extends NodeImpl implements AnonymousClassBodyNode
{
    /** The members of this anonymous class body. */
    private NodeUnion<? extends AnonymousClassMemberListNode> members;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<AnonymousClassBodyNodeProperties> populatedProperties;
    
    /** General constructor. */
    public AnonymousClassBodyNodeImpl(
            NodeUnion<? extends AnonymousClassMemberListNode> members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetMembers(members);
    }
    
    /** Proxy constructor. */
    public AnonymousClassBodyNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, AnonymousClassBodyNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(AnonymousClassBodyNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected AnonymousClassBodyNode getBackingNode()
    {
        return (AnonymousClassBodyNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the members value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkMembersWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                AnonymousClassBodyNodeProperties.MEMBERS))
            return;
        this.populatedProperties.add(AnonymousClassBodyNodeProperties.MEMBERS);
        NodeUnion<? extends AnonymousClassMemberListNode> union = this.getBackingNode().getUnionForMembers();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeAnonymousClassMemberListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.members = union;
    }
    
    /**
     * Gets the members of this anonymous class body.  This property's value is assumed to be a normal node.
     * @return The members of this anonymous class body.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public AnonymousClassMemberListNode getMembers()
    {
        checkMembersWrapped();
        if (this.members == null)
        {
            return null;
        } else
        {
            return this.members.getNormalNode();
        }
    }
    
    /**
     * Gets the members of this anonymous class body.
     * @return The members of this anonymous class body.
     */
    public NodeUnion<? extends AnonymousClassMemberListNode> getUnionForMembers()
    {
        checkMembersWrapped();
        if (this.members == null)
        {
            this.members = new NormalNodeUnion<AnonymousClassMemberListNode>(null);
        }
        return this.members;
    }
    
    /**
     * Changes the members of this anonymous class body.
     * @param members The members of this anonymous class body.
     */
    public void setMembers(AnonymousClassMemberListNode members)
    {
        checkMembersWrapped();
        this.setUnionForMembers(new NormalNodeUnion<AnonymousClassMemberListNode>(members));
    }
    
    /**
     * Changes the members of this anonymous class body.
     * @param members The members of this anonymous class body.
     */
    public void setUnionForMembers(NodeUnion<? extends AnonymousClassMemberListNode> members)
    {
        checkMembersWrapped();
        this.getManager().assertMutatable(this);
        this.doSetMembers(members);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new AnonymousClassBodyNodeSetMembersPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), members.getNodeValue() == null ? null : members.getNodeValue().getUid()));
    }
    
    private void doSetMembers(NodeUnion<? extends AnonymousClassMemberListNode> members)
    {
        if (members == null)
        {
            members = new NormalNodeUnion<AnonymousClassMemberListNode>(null);
        }
        if (this.members != null)
        {
            setAsChild(this.members.getNodeValue(), false);
        }
        this.members = members;
        setAsChild(members.getNodeValue(), true);
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
        if (this.getUnionForMembers().getNodeValue() != null)
        {
            this.getUnionForMembers().getNodeValue().receive(visitor);
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
        if (this.getUnionForMembers().getNodeValue() != null)
        {
            this.getUnionForMembers().getNodeValue().receiveTyped(visitor);
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
        visitor.visitAnonymousClassBodyNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitTypeBodyNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitTypeBodyNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitAnonymousClassBodyNodeStop(this, true);
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
        list.add(getUnionForMembers());
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
        map.put("members", getUnionForMembers());
        return map;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForMembers().getNodeValue()});
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
        sb.append("members=");
        sb.append(this.getUnionForMembers().getNodeValue() == null? "null" : this.getUnionForMembers().getNodeValue().getClass().getSimpleName());
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
        return operation.executeAnonymousClassBodyNode(this, p);
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
        return operation.executeAnonymousClassBodyNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnonymousClassBodyNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends AnonymousClassMemberListNode> membersCopy;
        switch (getUnionForMembers().getType())
        {
            case NORMAL:
                if (getUnionForMembers().getNormalNode() == null)
                {
                    membersCopy = factory.<AnonymousClassMemberListNode>makeNormalNodeUnion(null);
                } else
                {
                    membersCopy = factory.makeNormalNodeUnion(getUnionForMembers().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForMembers().getSpliceNode() == null)
                {
                    membersCopy = factory.<AnonymousClassMemberListNode>makeSpliceNodeUnion(null);
                } else
                {
                    membersCopy = factory.makeSpliceNodeUnion(getUnionForMembers().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForMembers().getType());
        }
        return factory.makeAnonymousClassBodyNodeWithUnions(
                membersCopy,
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
        
        if (before.equals(this.getUnionForMembers().getNodeValue()))
        {
            setMembers((AnonymousClassMemberListNode)after);
            return true;
        }
        return false;
    }
    
}
