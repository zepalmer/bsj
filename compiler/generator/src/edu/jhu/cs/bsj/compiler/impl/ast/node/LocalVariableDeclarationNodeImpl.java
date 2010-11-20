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
import edu.jhu.cs.bsj.compiler.ast.node.LocalVariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableDeclaratorListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.AttributeName;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class LocalVariableDeclarationNodeImpl extends NodeImpl implements LocalVariableDeclarationNode
{
    /** The modifiers for this variable. */
    private NodeUnion<? extends VariableModifiersNode> modifiers;
    
    /** The type of the declared variables. */
    private NodeUnion<? extends TypeNode> type;
    
    /** The variable declarators for this node. */
    private NodeUnion<? extends VariableDeclaratorListNode> declarators;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(LocalVariableDeclarationNodeImpl.this, attributeName);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute implements AttributeName
    {
        /** Attribute identifier for the modifiers property. */
        MODIFIERS,
        /** Attribute identifier for the type property. */
        TYPE,
        /** Attribute identifier for the declarators property. */
        DECLARATORS,
    }
    
    /** General constructor. */
    public LocalVariableDeclarationNodeImpl(
            NodeUnion<? extends VariableModifiersNode> modifiers,
            NodeUnion<? extends TypeNode> type,
            NodeUnion<? extends VariableDeclaratorListNode> declarators,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setUnionForModifiers(modifiers, false);
        setUnionForType(type, false);
        setUnionForDeclarators(declarators, false);
    }
    
    /**
     * Gets the modifiers for this variable.  This property's value is assumed to be a normal node.
     * @return The modifiers for this variable.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public VariableModifiersNode getModifiers()
    {
        getAttribute(LocalAttribute.MODIFIERS).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.modifiers == null)
        {
            return null;
        } else
        {
            return this.modifiers.getNormalNode();
        }
    }
    
    /**
     * Gets the modifiers for this variable.
     * @return The modifiers for this variable.
     */
    public NodeUnion<? extends VariableModifiersNode> getUnionForModifiers()
    {
        getAttribute(LocalAttribute.MODIFIERS).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.modifiers == null)
        {
            this.modifiers = new NormalNodeUnion<VariableModifiersNode>(null);
        }
        return this.modifiers;
    }
    
    /**
     * Changes the modifiers for this variable.
     * @param modifiers The modifiers for this variable.
     */
    public void setModifiers(VariableModifiersNode modifiers)
    {
            setModifiers(modifiers, true);
            getManager().notifyChange(this);
    }
    
    private void setModifiers(VariableModifiersNode modifiers, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.MODIFIERS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.modifiers != null)
        {
            setAsChild(this.modifiers.getNodeValue(), false);
        }
        this.modifiers = new NormalNodeUnion<VariableModifiersNode>(modifiers);
        setAsChild(modifiers, true);
    }
    
    /**
     * Changes the modifiers for this variable.
     * @param modifiers The modifiers for this variable.
     */
    public void setUnionForModifiers(NodeUnion<? extends VariableModifiersNode> modifiers)
    {
            setUnionForModifiers(modifiers, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForModifiers(NodeUnion<? extends VariableModifiersNode> modifiers, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.MODIFIERS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (modifiers == null)
        {
            modifiers = new NormalNodeUnion<VariableModifiersNode>(null);
        }
        if (this.modifiers != null)
        {
            setAsChild(this.modifiers.getNodeValue(), false);
        }
        this.modifiers = modifiers;
        setAsChild(modifiers.getNodeValue(), true);
    }
    
    /**
     * Gets the type of the declared variables.  This property's value is assumed to be a normal node.
     * @return The type of the declared variables.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public TypeNode getType()
    {
        getAttribute(LocalAttribute.TYPE).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.type == null)
        {
            return null;
        } else
        {
            return this.type.getNormalNode();
        }
    }
    
    /**
     * Gets the type of the declared variables.
     * @return The type of the declared variables.
     */
    public NodeUnion<? extends TypeNode> getUnionForType()
    {
        getAttribute(LocalAttribute.TYPE).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.type == null)
        {
            this.type = new NormalNodeUnion<TypeNode>(null);
        }
        return this.type;
    }
    
    /**
     * Changes the type of the declared variables.
     * @param type The type of the declared variables.
     */
    public void setType(TypeNode type)
    {
            setType(type, true);
            getManager().notifyChange(this);
    }
    
    private void setType(TypeNode type, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.TYPE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.type != null)
        {
            setAsChild(this.type.getNodeValue(), false);
        }
        this.type = new NormalNodeUnion<TypeNode>(type);
        setAsChild(type, true);
    }
    
    /**
     * Changes the type of the declared variables.
     * @param type The type of the declared variables.
     */
    public void setUnionForType(NodeUnion<? extends TypeNode> type)
    {
            setUnionForType(type, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForType(NodeUnion<? extends TypeNode> type, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.TYPE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (type == null)
        {
            type = new NormalNodeUnion<TypeNode>(null);
        }
        if (this.type != null)
        {
            setAsChild(this.type.getNodeValue(), false);
        }
        this.type = type;
        setAsChild(type.getNodeValue(), true);
    }
    
    /**
     * Gets the variable declarators for this node.  This property's value is assumed to be a normal node.
     * @return The variable declarators for this node.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public VariableDeclaratorListNode getDeclarators()
    {
        getAttribute(LocalAttribute.DECLARATORS).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.declarators == null)
        {
            return null;
        } else
        {
            return this.declarators.getNormalNode();
        }
    }
    
    /**
     * Gets the variable declarators for this node.
     * @return The variable declarators for this node.
     */
    public NodeUnion<? extends VariableDeclaratorListNode> getUnionForDeclarators()
    {
        getAttribute(LocalAttribute.DECLARATORS).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.declarators == null)
        {
            this.declarators = new NormalNodeUnion<VariableDeclaratorListNode>(null);
        }
        return this.declarators;
    }
    
    /**
     * Changes the variable declarators for this node.
     * @param declarators The variable declarators for this node.
     */
    public void setDeclarators(VariableDeclaratorListNode declarators)
    {
            setDeclarators(declarators, true);
            getManager().notifyChange(this);
    }
    
    private void setDeclarators(VariableDeclaratorListNode declarators, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.DECLARATORS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.declarators != null)
        {
            setAsChild(this.declarators.getNodeValue(), false);
        }
        this.declarators = new NormalNodeUnion<VariableDeclaratorListNode>(declarators);
        setAsChild(declarators, true);
    }
    
    /**
     * Changes the variable declarators for this node.
     * @param declarators The variable declarators for this node.
     */
    public void setUnionForDeclarators(NodeUnion<? extends VariableDeclaratorListNode> declarators)
    {
            setUnionForDeclarators(declarators, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForDeclarators(NodeUnion<? extends VariableDeclaratorListNode> declarators, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.DECLARATORS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (declarators == null)
        {
            declarators = new NormalNodeUnion<VariableDeclaratorListNode>(null);
        }
        if (this.declarators != null)
        {
            setAsChild(this.declarators.getNodeValue(), false);
        }
        this.declarators = declarators;
        setAsChild(declarators.getNodeValue(), true);
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
        if (this.modifiers.getNodeValue() != null)
        {
            this.modifiers.getNodeValue().receive(visitor);
        }
        if (this.type.getNodeValue() != null)
        {
            this.type.getNodeValue().receive(visitor);
        }
        if (this.declarators.getNodeValue() != null)
        {
            this.declarators.getNodeValue().receive(visitor);
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
        if (this.modifiers.getNodeValue() != null)
        {
            this.modifiers.getNodeValue().receiveTyped(visitor);
        }
        if (this.type.getNodeValue() != null)
        {
            this.type.getNodeValue().receiveTyped(visitor);
        }
        if (this.declarators.getNodeValue() != null)
        {
            this.declarators.getNodeValue().receiveTyped(visitor);
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
        visitor.visitLocalVariableDeclarationNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitBlockStatementNodeStart(this);
        visitor.visitVariableDeclaratorOwnerNodeStart(this);
        visitor.visitDeclarationNodeStart(this);
        visitor.visitModifiedNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitBlockStatementNodeStop(this);
        visitor.visitVariableDeclaratorOwnerNodeStop(this);
        visitor.visitDeclarationNodeStop(this);
        visitor.visitModifiedNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitLocalVariableDeclarationNodeStop(this, true);
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
        list.add(getUnionForModifiers());
        list.add(getUnionForType());
        list.add(getUnionForDeclarators());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForModifiers().getNodeValue(), getUnionForType().getNodeValue(), getUnionForDeclarators().getNodeValue()});
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
        sb.append("modifiers=");
        sb.append(this.getUnionForModifiers().getNodeValue() == null? "null" : this.getUnionForModifiers().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("type=");
        sb.append(this.getUnionForType().getNodeValue() == null? "null" : this.getUnionForType().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("declarators=");
        sb.append(this.getUnionForDeclarators().getNodeValue() == null? "null" : this.getUnionForDeclarators().getNodeValue().getClass().getSimpleName());
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
        return operation.executeLocalVariableDeclarationNode(this, p);
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
        return operation.executeLocalVariableDeclarationNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public LocalVariableDeclarationNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends VariableModifiersNode> modifiersCopy;
        switch (getUnionForModifiers().getType())
        {
            case NORMAL:
                if (getUnionForModifiers().getNormalNode() == null)
                {
                    modifiersCopy = factory.<VariableModifiersNode>makeNormalNodeUnion(null);
                } else
                {
                    modifiersCopy = factory.makeNormalNodeUnion(getUnionForModifiers().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForModifiers().getSpliceNode() == null)
                {
                    modifiersCopy = factory.<VariableModifiersNode>makeSpliceNodeUnion(null);
                } else
                {
                    modifiersCopy = factory.makeSpliceNodeUnion(getUnionForModifiers().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForModifiers().getType());
        }
        NodeUnion<? extends TypeNode> typeCopy;
        switch (getUnionForType().getType())
        {
            case NORMAL:
                if (getUnionForType().getNormalNode() == null)
                {
                    typeCopy = factory.<TypeNode>makeNormalNodeUnion(null);
                } else
                {
                    typeCopy = factory.makeNormalNodeUnion(getUnionForType().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForType().getSpliceNode() == null)
                {
                    typeCopy = factory.<TypeNode>makeSpliceNodeUnion(null);
                } else
                {
                    typeCopy = factory.makeSpliceNodeUnion(getUnionForType().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForType().getType());
        }
        NodeUnion<? extends VariableDeclaratorListNode> declaratorsCopy;
        switch (getUnionForDeclarators().getType())
        {
            case NORMAL:
                if (getUnionForDeclarators().getNormalNode() == null)
                {
                    declaratorsCopy = factory.<VariableDeclaratorListNode>makeNormalNodeUnion(null);
                } else
                {
                    declaratorsCopy = factory.makeNormalNodeUnion(getUnionForDeclarators().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForDeclarators().getSpliceNode() == null)
                {
                    declaratorsCopy = factory.<VariableDeclaratorListNode>makeSpliceNodeUnion(null);
                } else
                {
                    declaratorsCopy = factory.makeSpliceNodeUnion(getUnionForDeclarators().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForDeclarators().getType());
        }
        return factory.makeLocalVariableDeclarationNodeWithUnions(
                modifiersCopy,
                typeCopy,
                declaratorsCopy,
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
        
        if (before.equals(this.getUnionForModifiers().getNodeValue()))
        {
            setModifiers((VariableModifiersNode)after);
            return true;
        }
        if (before.equals(this.getUnionForType().getNodeValue()))
        {
            setType((TypeNode)after);
            return true;
        }
        if (before.equals(this.getUnionForDeclarators().getNodeValue()))
        {
            setDeclarators((VariableDeclaratorListNode)after);
            return true;
        }
        return false;
    }
    
}
