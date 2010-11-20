package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.AnnotationMemberListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.AttributeName;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class AnnotationBodyNodeImpl extends NodeImpl implements AnnotationBodyNode
{
    /** The members of this annotation body. */
    private NodeUnion<? extends AnnotationMemberListNode> members;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(AnnotationBodyNodeImpl.this, attributeName);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute implements AttributeName
    {
        /** Attribute identifier for the members property. */
        MEMBERS,
    }
    
    /** General constructor. */
    public AnnotationBodyNodeImpl(
            NodeUnion<? extends AnnotationMemberListNode> members,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setUnionForMembers(members, false);
    }
    
    /**
     * Gets the members of this annotation body.  This property's value is assumed to be a normal node.
     * @return The members of this annotation body.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public AnnotationMemberListNode getMembers()
    {
        getAttribute(LocalAttribute.MEMBERS).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.members == null)
        {
            return null;
        } else
        {
            return this.members.getNormalNode();
        }
    }
    
    /**
     * Gets the members of this annotation body.
     * @return The members of this annotation body.
     */
    public NodeUnion<? extends AnnotationMemberListNode> getUnionForMembers()
    {
        getAttribute(LocalAttribute.MEMBERS).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.members == null)
        {
            this.members = new NormalNodeUnion<AnnotationMemberListNode>(null);
        }
        return this.members;
    }
    
    /**
     * Changes the members of this annotation body.
     * @param members The members of this annotation body.
     */
    public void setMembers(AnnotationMemberListNode members)
    {
            setMembers(members, true);
            getManager().notifyChange(this);
    }
    
    private void setMembers(AnnotationMemberListNode members, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.MEMBERS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.members != null)
        {
            setAsChild(this.members.getNodeValue(), false);
        }
        this.members = new NormalNodeUnion<AnnotationMemberListNode>(members);
        setAsChild(members, true);
    }
    
    /**
     * Changes the members of this annotation body.
     * @param members The members of this annotation body.
     */
    public void setUnionForMembers(NodeUnion<? extends AnnotationMemberListNode> members)
    {
            setUnionForMembers(members, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForMembers(NodeUnion<? extends AnnotationMemberListNode> members, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.MEMBERS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (members == null)
        {
            members = new NormalNodeUnion<AnnotationMemberListNode>(null);
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
        if (this.members.getNodeValue() != null)
        {
            this.members.getNodeValue().receive(visitor);
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
        if (this.members.getNodeValue() != null)
        {
            this.members.getNodeValue().receiveTyped(visitor);
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
        visitor.visitAnnotationBodyNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitTypeBodyNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitTypeBodyNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitAnnotationBodyNodeStop(this, true);
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
    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p)
    {
        return operation.executeAnnotationBodyNode(this, p);
    }
    
    /**
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p1 The parameter to pass to the operation.
     * @param p2 The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P1,P2,R> R executeOperation(BsjNodeOperation2Arguments<P1,P2,R> operation, P1 p1, P2 p2)
    {
        return operation.executeAnnotationBodyNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnnotationBodyNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends AnnotationMemberListNode> membersCopy;
        switch (getUnionForMembers().getType())
        {
            case NORMAL:
                if (getUnionForMembers().getNormalNode() == null)
                {
                    membersCopy = factory.<AnnotationMemberListNode>makeNormalNodeUnion(null);
                } else
                {
                    membersCopy = factory.makeNormalNodeUnion(getUnionForMembers().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForMembers().getSpliceNode() == null)
                {
                    membersCopy = factory.<AnnotationMemberListNode>makeSpliceNodeUnion(null);
                } else
                {
                    membersCopy = factory.makeSpliceNodeUnion(getUnionForMembers().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForMembers().getType());
        }
        return factory.makeAnnotationBodyNodeWithUnions(
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
            setMembers((AnnotationMemberListNode)after);
            return true;
        }
        return false;
    }
    
}
