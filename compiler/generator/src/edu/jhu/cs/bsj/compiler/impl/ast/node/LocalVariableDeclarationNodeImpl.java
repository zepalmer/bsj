package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjAbortableNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
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
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.LocalVariableDeclarationNodeSetDeclaratorsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.LocalVariableDeclarationNodeSetModifiersPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.LocalVariableDeclarationNodeSetTypePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.LocalVariableDeclarationNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class LocalVariableDeclarationNodeImpl extends NodeImpl implements LocalVariableDeclarationNode
{
    /** The modifiers for this variable. */
    private NodeUnion<? extends VariableModifiersNode> modifiers;
    
    /** The type of the declared variables. */
    private NodeUnion<? extends TypeNode> type;
    
    /** The variable declarators for this node. */
    private NodeUnion<? extends VariableDeclaratorListNode> declarators;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<LocalVariableDeclarationNodeProperties> populatedProperties;
    
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
        this.populatedProperties = null;
        doSetModifiers(modifiers);
        doSetType(type);
        doSetDeclarators(declarators);
    }
    
    /** Proxy constructor. */
    public LocalVariableDeclarationNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, LocalVariableDeclarationNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(LocalVariableDeclarationNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected LocalVariableDeclarationNode getBackingNode()
    {
        return (LocalVariableDeclarationNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the modifiers value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkModifiersWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                LocalVariableDeclarationNodeProperties.MODIFIERS))
            return;
        this.populatedProperties.add(LocalVariableDeclarationNodeProperties.MODIFIERS);
        NodeUnion<? extends VariableModifiersNode> union = this.getBackingNode().getUnionForModifiers();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeVariableModifiersNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.modifiers = union;
    }
    
    /**
     * Ensures that the type value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkTypeWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                LocalVariableDeclarationNodeProperties.TYPE))
            return;
        this.populatedProperties.add(LocalVariableDeclarationNodeProperties.TYPE);
        NodeUnion<? extends TypeNode> union = this.getBackingNode().getUnionForType();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeTypeNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.type = union;
    }
    
    /**
     * Ensures that the declarators value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkDeclaratorsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                LocalVariableDeclarationNodeProperties.DECLARATORS))
            return;
        this.populatedProperties.add(LocalVariableDeclarationNodeProperties.DECLARATORS);
        NodeUnion<? extends VariableDeclaratorListNode> union = this.getBackingNode().getUnionForDeclarators();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeVariableDeclaratorListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.declarators = union;
    }
    
    /**
     * Gets the modifiers for this variable.  This property's value is assumed to be a normal node.
     * @return The modifiers for this variable.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public VariableModifiersNode getModifiers()
    {
        checkModifiersWrapped();
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
        checkModifiersWrapped();
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
        checkModifiersWrapped();
        this.setUnionForModifiers(new NormalNodeUnion<VariableModifiersNode>(modifiers));
    }
    
    /**
     * Changes the modifiers for this variable.
     * @param modifiers The modifiers for this variable.
     */
    public void setUnionForModifiers(NodeUnion<? extends VariableModifiersNode> modifiers)
    {
        checkModifiersWrapped();
        this.getManager().assertMutatable(this);
        this.doSetModifiers(modifiers);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new LocalVariableDeclarationNodeSetModifiersPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()));
    }
    
    private void doSetModifiers(NodeUnion<? extends VariableModifiersNode> modifiers)
    {
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
        checkTypeWrapped();
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
        checkTypeWrapped();
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
        checkTypeWrapped();
        this.setUnionForType(new NormalNodeUnion<TypeNode>(type));
    }
    
    /**
     * Changes the type of the declared variables.
     * @param type The type of the declared variables.
     */
    public void setUnionForType(NodeUnion<? extends TypeNode> type)
    {
        checkTypeWrapped();
        this.getManager().assertMutatable(this);
        this.doSetType(type);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new LocalVariableDeclarationNodeSetTypePropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), type.getNodeValue() == null ? null : type.getNodeValue().getUid()));
    }
    
    private void doSetType(NodeUnion<? extends TypeNode> type)
    {
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
        checkDeclaratorsWrapped();
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
        checkDeclaratorsWrapped();
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
        checkDeclaratorsWrapped();
        this.setUnionForDeclarators(new NormalNodeUnion<VariableDeclaratorListNode>(declarators));
    }
    
    /**
     * Changes the variable declarators for this node.
     * @param declarators The variable declarators for this node.
     */
    public void setUnionForDeclarators(NodeUnion<? extends VariableDeclaratorListNode> declarators)
    {
        checkDeclaratorsWrapped();
        this.getManager().assertMutatable(this);
        this.doSetDeclarators(declarators);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new LocalVariableDeclarationNodeSetDeclaratorsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), declarators.getNodeValue() == null ? null : declarators.getNodeValue().getUid()));
    }
    
    private void doSetDeclarators(NodeUnion<? extends VariableDeclaratorListNode> declarators)
    {
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
        if (this.getUnionForModifiers().getNodeValue() != null)
        {
            this.getUnionForModifiers().getNodeValue().receive(visitor);
        }
        if (this.getUnionForType().getNodeValue() != null)
        {
            this.getUnionForType().getNodeValue().receive(visitor);
        }
        if (this.getUnionForDeclarators().getNodeValue() != null)
        {
            this.getUnionForDeclarators().getNodeValue().receive(visitor);
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
        if (this.getUnionForModifiers().getNodeValue() != null)
        {
            this.getUnionForModifiers().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForType().getNodeValue() != null)
        {
            this.getUnionForType().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForDeclarators().getNodeValue() != null)
        {
            this.getUnionForDeclarators().getNodeValue().receiveTyped(visitor);
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
        sb.append('#');
        sb.append(this.getUid());
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
    public <P,R,X extends Exception> R executeOperation(BsjAbortableNodeOperation<P,R,X> operation, P p) throws X
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
    public <P1,P2,R,X extends Exception> R executeOperation(BsjAbortableNodeOperation2Arguments<P1,P2,R,X> operation, P1 p1, P2 p2) throws X
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
