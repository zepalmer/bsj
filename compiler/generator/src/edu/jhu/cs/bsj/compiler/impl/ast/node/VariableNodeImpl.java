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
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.AttributeName;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class VariableNodeImpl extends NodeImpl implements VariableNode
{
    /** The modifiers of this parameter. */
    private NodeUnion<? extends VariableModifiersNode> modifiers;
    
    /** The type of the variable. */
    private NodeUnion<? extends TypeNode> type;
    
    /** The name of the variable. */
    private NodeUnion<? extends IdentifierNode> identifier;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(VariableNodeImpl.this, attributeName);
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
        /** Attribute identifier for the identifier property. */
        IDENTIFIER,
    }
    
    /** General constructor. */
    public VariableNodeImpl(
            NodeUnion<? extends VariableModifiersNode> modifiers,
            NodeUnion<? extends TypeNode> type,
            NodeUnion<? extends IdentifierNode> identifier,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setUnionForModifiers(modifiers, false);
        setUnionForType(type, false);
        setUnionForIdentifier(identifier, false);
    }
    
    /**
     * Gets the modifiers of this parameter.  This property's value is assumed to be a normal node.
     * @return The modifiers of this parameter.
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
     * Gets the modifiers of this parameter.
     * @return The modifiers of this parameter.
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
     * Changes the modifiers of this parameter.
     * @param modifiers The modifiers of this parameter.
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
     * Changes the modifiers of this parameter.
     * @param modifiers The modifiers of this parameter.
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
     * Gets the type of the variable.  This property's value is assumed to be a normal node.
     * @return The type of the variable.
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
     * Gets the type of the variable.
     * @return The type of the variable.
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
     * Changes the type of the variable.
     * @param type The type of the variable.
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
     * Changes the type of the variable.
     * @param type The type of the variable.
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
     * Gets the name of the variable.  This property's value is assumed to be a normal node.
     * @return The name of the variable.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public IdentifierNode getIdentifier()
    {
        getAttribute(LocalAttribute.IDENTIFIER).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.identifier == null)
        {
            return null;
        } else
        {
            return this.identifier.getNormalNode();
        }
    }
    
    /**
     * Gets the name of the variable.
     * @return The name of the variable.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForIdentifier()
    {
        getAttribute(LocalAttribute.IDENTIFIER).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.identifier == null)
        {
            this.identifier = new NormalNodeUnion<IdentifierNode>(null);
        }
        return this.identifier;
    }
    
    /**
     * Changes the name of the variable.
     * @param identifier The name of the variable.
     */
    public void setIdentifier(IdentifierNode identifier)
    {
            setIdentifier(identifier, true);
            getManager().notifyChange(this);
    }
    
    private void setIdentifier(IdentifierNode identifier, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.IDENTIFIER).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.identifier != null)
        {
            setAsChild(this.identifier.getNodeValue(), false);
        }
        this.identifier = new NormalNodeUnion<IdentifierNode>(identifier);
        setAsChild(identifier, true);
    }
    
    /**
     * Changes the name of the variable.
     * @param identifier The name of the variable.
     */
    public void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier)
    {
            setUnionForIdentifier(identifier, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.IDENTIFIER).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (identifier == null)
        {
            identifier = new NormalNodeUnion<IdentifierNode>(null);
        }
        if (this.identifier != null)
        {
            setAsChild(this.identifier.getNodeValue(), false);
        }
        this.identifier = identifier;
        setAsChild(identifier.getNodeValue(), true);
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
        if (this.identifier.getNodeValue() != null)
        {
            this.identifier.getNodeValue().receive(visitor);
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
        if (this.identifier.getNodeValue() != null)
        {
            this.identifier.getNodeValue().receiveTyped(visitor);
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
        visitor.visitVariableNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitVariableNameBindingNodeStart(this);
        visitor.visitModifiedNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitVariableNameBindingNodeStop(this);
        visitor.visitModifiedNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitVariableNodeStop(this, true);
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
        list.add(getUnionForType());
        list.add(getUnionForModifiers());
        list.add(getUnionForIdentifier());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForModifiers().getNodeValue(), getUnionForType().getNodeValue(), getUnionForIdentifier().getNodeValue()});
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
        sb.append("identifier=");
        sb.append(this.getUnionForIdentifier().getNodeValue() == null? "null" : this.getUnionForIdentifier().getNodeValue().getClass().getSimpleName());
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
        return operation.executeVariableNode(this, p);
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
        return operation.executeVariableNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public VariableNode deepCopy(BsjNodeFactory factory)
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
        NodeUnion<? extends IdentifierNode> identifierCopy;
        switch (getUnionForIdentifier().getType())
        {
            case NORMAL:
                if (getUnionForIdentifier().getNormalNode() == null)
                {
                    identifierCopy = factory.<IdentifierNode>makeNormalNodeUnion(null);
                } else
                {
                    identifierCopy = factory.makeNormalNodeUnion(getUnionForIdentifier().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForIdentifier().getSpliceNode() == null)
                {
                    identifierCopy = factory.<IdentifierNode>makeSpliceNodeUnion(null);
                } else
                {
                    identifierCopy = factory.makeSpliceNodeUnion(getUnionForIdentifier().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForIdentifier().getType());
        }
        return factory.makeVariableNodeWithUnions(
                modifiersCopy,
                typeCopy,
                identifierCopy,
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
        if (before.equals(this.getUnionForIdentifier().getNodeValue()))
        {
            setIdentifier((IdentifierNode)after);
            return true;
        }
        return false;
    }
    
}
