package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.AttributeName;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class EnumBodyNodeImpl extends NodeImpl implements EnumBodyNode
{
    /** The enumeration constants. */
    private NodeUnion<? extends EnumConstantDeclarationListNode> constants;
    
    /** The members of the class body part. */
    private NodeUnion<? extends ClassMemberListNode> members;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(EnumBodyNodeImpl.this, attributeName);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute implements AttributeName
    {
        /** Attribute identifier for the constants property. */
        CONSTANTS,
        /** Attribute identifier for the members property. */
        MEMBERS,
    }
    
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
        setUnionForConstants(constants, false);
        setUnionForMembers(members, false);
    }
    
    /**
     * Gets the enumeration constants.  This property's value is assumed to be a normal node.
     * @return The enumeration constants.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public EnumConstantDeclarationListNode getConstants()
    {
        getAttribute(LocalAttribute.CONSTANTS).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        getAttribute(LocalAttribute.CONSTANTS).recordAccess(ReadWriteAttribute.AccessType.READ);
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
            setConstants(constants, true);
            getManager().notifyChange(this);
    }
    
    private void setConstants(EnumConstantDeclarationListNode constants, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.CONSTANTS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.constants != null)
        {
            setAsChild(this.constants.getNodeValue(), false);
        }
        this.constants = new NormalNodeUnion<EnumConstantDeclarationListNode>(constants);
        setAsChild(constants, true);
    }
    
    /**
     * Changes the enumeration constants.
     * @param constants The enumeration constants.
     */
    public void setUnionForConstants(NodeUnion<? extends EnumConstantDeclarationListNode> constants)
    {
            setUnionForConstants(constants, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForConstants(NodeUnion<? extends EnumConstantDeclarationListNode> constants, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.CONSTANTS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
     * Gets the members of the class body part.
     * @return The members of the class body part.
     */
    public NodeUnion<? extends ClassMemberListNode> getUnionForMembers()
    {
        getAttribute(LocalAttribute.MEMBERS).recordAccess(ReadWriteAttribute.AccessType.READ);
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
            setMembers(members, true);
            getManager().notifyChange(this);
    }
    
    private void setMembers(ClassMemberListNode members, boolean checkPermissions)
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
        this.members = new NormalNodeUnion<ClassMemberListNode>(members);
        setAsChild(members, true);
    }
    
    /**
     * Changes the members of the class body part.
     * @param members The members of the class body part.
     */
    public void setUnionForMembers(NodeUnion<? extends ClassMemberListNode> members)
    {
            setUnionForMembers(members, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForMembers(NodeUnion<? extends ClassMemberListNode> members, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.MEMBERS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
        if (this.constants.getNodeValue() != null)
        {
            this.constants.getNodeValue().receive(visitor);
        }
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
        if (this.constants.getNodeValue() != null)
        {
            this.constants.getNodeValue().receiveTyped(visitor);
        }
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
