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
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ClassMemberListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.EnumConstantDeclarationListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.EnumBodyNodeSetConstantsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.EnumBodyNodeSetMembersPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.EnumBodyNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class EnumBodyNodeImpl extends NodeImpl implements EnumBodyNode
{
    /** The enumeration constants. */
    private NodeUnion<? extends EnumConstantDeclarationListNode> constants;
    
    /** The members of the class body part. */
    private NodeUnion<? extends ClassMemberListNode> members;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<EnumBodyNodeProperties> populatedProperties;
    
    /** General constructor. */
    public EnumBodyNodeImpl(
            NodeUnion<? extends EnumConstantDeclarationListNode> constants,
            NodeUnion<? extends ClassMemberListNode> members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetConstants(constants);
        doSetMembers(members);
    }
    
    /** Proxy constructor. */
    public EnumBodyNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, EnumBodyNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(EnumBodyNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected EnumBodyNode getBackingNode()
    {
        return (EnumBodyNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the constants value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkConstantsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                EnumBodyNodeProperties.CONSTANTS))
            return;
        this.populatedProperties.add(EnumBodyNodeProperties.CONSTANTS);
        NodeUnion<? extends EnumConstantDeclarationListNode> union = this.getBackingNode().getUnionForConstants();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeEnumConstantDeclarationListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.constants = union;
    }
    
    /**
     * Ensures that the members value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkMembersWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                EnumBodyNodeProperties.MEMBERS))
            return;
        this.populatedProperties.add(EnumBodyNodeProperties.MEMBERS);
        NodeUnion<? extends ClassMemberListNode> union = this.getBackingNode().getUnionForMembers();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeClassMemberListNode(union.getNormalNode()));
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
     * Gets the enumeration constants.  This property's value is assumed to be a normal node.
     * @return The enumeration constants.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public EnumConstantDeclarationListNode getConstants()
    {
        checkConstantsWrapped();
        if (this.constants == null)
        {
            return null;
        } else
        {
            return this.constants.getNormalNode();
        }
    }
    
    /**
     * Gets the enumeration constants.
     * @return The enumeration constants.
     */
    public NodeUnion<? extends EnumConstantDeclarationListNode> getUnionForConstants()
    {
        checkConstantsWrapped();
        if (this.constants == null)
        {
            this.constants = new NormalNodeUnion<EnumConstantDeclarationListNode>(null);
        }
        return this.constants;
    }
    
    /**
     * Changes the enumeration constants.
     * @param constants The enumeration constants.
     */
    public void setConstants(EnumConstantDeclarationListNode constants)
    {
        checkConstantsWrapped();
        this.setUnionForConstants(new NormalNodeUnion<EnumConstantDeclarationListNode>(constants));
    }
    
    /**
     * Changes the enumeration constants.
     * @param constants The enumeration constants.
     */
    public void setUnionForConstants(NodeUnion<? extends EnumConstantDeclarationListNode> constants)
    {
        checkConstantsWrapped();
        this.getManager().assertMutatable(this);
        this.doSetConstants(constants);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new EnumBodyNodeSetConstantsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), constants.getNodeValue() == null ? null : constants.getNodeValue().getUid()));
    }
    
    private void doSetConstants(NodeUnion<? extends EnumConstantDeclarationListNode> constants)
    {
        if (constants == null)
        {
            constants = new NormalNodeUnion<EnumConstantDeclarationListNode>(null);
        }
        if (this.constants != null)
        {
            setAsChild(this.constants.getNodeValue(), false);
        }
        this.constants = constants;
        setAsChild(constants.getNodeValue(), true);
    }
    
    /**
     * Gets the members of the class body part.  This property's value is assumed to be a normal node.
     * @return The members of the class body part.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ClassMemberListNode getMembers()
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
     * Gets the members of the class body part.
     * @return The members of the class body part.
     */
    public NodeUnion<? extends ClassMemberListNode> getUnionForMembers()
    {
        checkMembersWrapped();
        if (this.members == null)
        {
            this.members = new NormalNodeUnion<ClassMemberListNode>(null);
        }
        return this.members;
    }
    
    /**
     * Changes the members of the class body part.
     * @param members The members of the class body part.
     */
    public void setMembers(ClassMemberListNode members)
    {
        checkMembersWrapped();
        this.setUnionForMembers(new NormalNodeUnion<ClassMemberListNode>(members));
    }
    
    /**
     * Changes the members of the class body part.
     * @param members The members of the class body part.
     */
    public void setUnionForMembers(NodeUnion<? extends ClassMemberListNode> members)
    {
        checkMembersWrapped();
        this.getManager().assertMutatable(this);
        this.doSetMembers(members);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new EnumBodyNodeSetMembersPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), members.getNodeValue() == null ? null : members.getNodeValue().getUid()));
    }
    
    private void doSetMembers(NodeUnion<? extends ClassMemberListNode> members)
    {
        if (members == null)
        {
            members = new NormalNodeUnion<ClassMemberListNode>(null);
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
        if (this.getUnionForConstants().getNodeValue() != null)
        {
            this.getUnionForConstants().getNodeValue().receive(visitor);
        }
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
        if (this.getUnionForConstants().getNodeValue() != null)
        {
            this.getUnionForConstants().getNodeValue().receiveTyped(visitor);
        }
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
        visitor.visitEnumBodyNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitTypeBodyNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitTypeBodyNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitEnumBodyNodeStop(this, true);
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
        list.add(getUnionForConstants());
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
        map.put("constants", getUnionForConstants());
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
        return Arrays.asList(new Node[]{getUnionForConstants().getNodeValue(), getUnionForMembers().getNodeValue()});
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
        sb.append("constants=");
        sb.append(this.getUnionForConstants().getNodeValue() == null? "null" : this.getUnionForConstants().getNodeValue().getClass().getSimpleName());
        sb.append(',');
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
        return operation.executeEnumBodyNode(this, p);
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
        return operation.executeEnumBodyNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public EnumBodyNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends EnumConstantDeclarationListNode> constantsCopy;
        switch (getUnionForConstants().getType())
        {
            case NORMAL:
                if (getUnionForConstants().getNormalNode() == null)
                {
                    constantsCopy = factory.<EnumConstantDeclarationListNode>makeNormalNodeUnion(null);
                } else
                {
                    constantsCopy = factory.makeNormalNodeUnion(getUnionForConstants().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForConstants().getSpliceNode() == null)
                {
                    constantsCopy = factory.<EnumConstantDeclarationListNode>makeSpliceNodeUnion(null);
                } else
                {
                    constantsCopy = factory.makeSpliceNodeUnion(getUnionForConstants().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForConstants().getType());
        }
        NodeUnion<? extends ClassMemberListNode> membersCopy;
        switch (getUnionForMembers().getType())
        {
            case NORMAL:
                if (getUnionForMembers().getNormalNode() == null)
                {
                    membersCopy = factory.<ClassMemberListNode>makeNormalNodeUnion(null);
                } else
                {
                    membersCopy = factory.makeNormalNodeUnion(getUnionForMembers().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForMembers().getSpliceNode() == null)
                {
                    membersCopy = factory.<ClassMemberListNode>makeSpliceNodeUnion(null);
                } else
                {
                    membersCopy = factory.makeSpliceNodeUnion(getUnionForMembers().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForMembers().getType());
        }
        return factory.makeEnumBodyNodeWithUnions(
                constantsCopy,
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
        
        if (before.equals(this.getUnionForConstants().getNodeValue()))
        {
            setConstants((EnumConstantDeclarationListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForMembers().getNodeValue()))
        {
            setMembers((ClassMemberListNode)after);
            return true;
        }
        return false;
    }
    
}
