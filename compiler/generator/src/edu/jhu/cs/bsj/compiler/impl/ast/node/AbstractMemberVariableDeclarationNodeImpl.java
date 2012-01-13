package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.AbstractMemberVariableDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableDeclaratorListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.AbstractMemberVariableDeclarationNodeSetDeclaratorsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.AbstractMemberVariableDeclarationNodeSetJavadocPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.AbstractMemberVariableDeclarationNodeSetModifiersPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.AbstractMemberVariableDeclarationNodeSetTypePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.AbstractMemberVariableDeclarationNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class AbstractMemberVariableDeclarationNodeImpl<T extends ModifiersNode> extends NodeImpl implements AbstractMemberVariableDeclarationNode<T>
{
    /** The modifiers for this declaration. */
    private NodeUnion<? extends T> modifiers;
    
    /** The type of the declared variables. */
    private NodeUnion<? extends TypeNode> type;
    
    /** The variable declarators for this node. */
    private NodeUnion<? extends VariableDeclaratorListNode> declarators;
    
    /** The associated javadoc comment for this node. */
    private NodeUnion<? extends JavadocNode> javadoc;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<AbstractMemberVariableDeclarationNodeProperties> populatedProperties;
    
    /** General constructor. */
    protected AbstractMemberVariableDeclarationNodeImpl(
            NodeUnion<? extends T> modifiers,
            NodeUnion<? extends TypeNode> type,
            NodeUnion<? extends VariableDeclaratorListNode> declarators,
            NodeUnion<? extends JavadocNode> javadoc,
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
        doSetJavadoc(javadoc);
    }
    
    /** Proxy constructor. */
    protected AbstractMemberVariableDeclarationNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, AbstractMemberVariableDeclarationNode<T> backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(AbstractMemberVariableDeclarationNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    // This SuppressWarnings is always safe because backingNode is set by the node
    // constructor and never changed.  This is equivalent to a read-only value
    // defined by a type parameter without complicating the type reference site.
    @SuppressWarnings("unchecked")
    protected AbstractMemberVariableDeclarationNode<T> getBackingNode()
    {
        return (AbstractMemberVariableDeclarationNode<T>)super.getBackingNode();
    }
    
    /**
     * Ensures that the modifiers value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkModifiersWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                AbstractMemberVariableDeclarationNodeProperties.MODIFIERS))
            return;
        this.populatedProperties.add(AbstractMemberVariableDeclarationNodeProperties.MODIFIERS);
        NodeUnion<? extends T> union = this.getBackingNode().getUnionForModifiers();
        switch (union.getType())
        {
            case NORMAL:
                        // The following @SuppressWarnings is safe as long as the proxy
                        // factory is not exposed (because we can ensure that the parameter
                        // is bounded from below by an API type).
                        @SuppressWarnings("unchecked")
                        final NodeUnion<? extends T> val = (NodeUnion<? extends T>)
                                this.getProxyFactory().makeNormalNodeUnion(
                                        this.getProxyFactory().makeModifiersNode(union.getNormalNode()));
                        union = val;
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
                AbstractMemberVariableDeclarationNodeProperties.TYPE))
            return;
        this.populatedProperties.add(AbstractMemberVariableDeclarationNodeProperties.TYPE);
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
                AbstractMemberVariableDeclarationNodeProperties.DECLARATORS))
            return;
        this.populatedProperties.add(AbstractMemberVariableDeclarationNodeProperties.DECLARATORS);
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
     * Ensures that the javadoc value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkJavadocWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                AbstractMemberVariableDeclarationNodeProperties.JAVADOC))
            return;
        this.populatedProperties.add(AbstractMemberVariableDeclarationNodeProperties.JAVADOC);
        NodeUnion<? extends JavadocNode> union = this.getBackingNode().getUnionForJavadoc();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeJavadocNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.javadoc = union;
    }
    
    /**
     * Gets the modifiers for this declaration.  This property's value is assumed to be a normal node.
     * @return The modifiers for this declaration.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public T getModifiers()
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
     * Gets the modifiers for this declaration.
     * @return The modifiers for this declaration.
     */
    public NodeUnion<? extends T> getUnionForModifiers()
    {
        checkModifiersWrapped();
        if (this.modifiers == null)
        {
            this.modifiers = new NormalNodeUnion<T>(null);
        }
        return this.modifiers;
    }
    
    /**
     * Changes the modifiers for this declaration.
     * @param modifiers The modifiers for this declaration.
     */
    public void setModifiers(T modifiers)
    {
        checkModifiersWrapped();
        this.setUnionForModifiers(new NormalNodeUnion<T>(modifiers));
    }
    
    /**
     * Changes the modifiers for this declaration.
     * @param modifiers The modifiers for this declaration.
     */
    public void setUnionForModifiers(NodeUnion<? extends T> modifiers)
    {
        checkModifiersWrapped();
        this.getManager().assertMutatable(this);
        this.doSetModifiers(modifiers);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new AbstractMemberVariableDeclarationNodeSetModifiersPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()));
    }
    
    private void doSetModifiers(NodeUnion<? extends T> modifiers)
    {
        if (modifiers == null)
        {
            modifiers = new NormalNodeUnion<T>(null);
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
            super.recordEdit(new AbstractMemberVariableDeclarationNodeSetTypePropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), type.getNodeValue() == null ? null : type.getNodeValue().getUid()));
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
            super.recordEdit(new AbstractMemberVariableDeclarationNodeSetDeclaratorsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), declarators.getNodeValue() == null ? null : declarators.getNodeValue().getUid()));
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
     * Gets the associated javadoc comment for this node.  This property's value is assumed to be a normal node.
     * @return The associated javadoc comment for this node.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public JavadocNode getJavadoc()
    {
        checkJavadocWrapped();
        if (this.javadoc == null)
        {
            return null;
        } else
        {
            return this.javadoc.getNormalNode();
        }
    }
    
    /**
     * Gets the associated javadoc comment for this node.
     * @return The associated javadoc comment for this node.
     */
    public NodeUnion<? extends JavadocNode> getUnionForJavadoc()
    {
        checkJavadocWrapped();
        if (this.javadoc == null)
        {
            this.javadoc = new NormalNodeUnion<JavadocNode>(null);
        }
        return this.javadoc;
    }
    
    /**
     * Changes the associated javadoc comment for this node.
     * @param javadoc The associated javadoc comment for this node.
     */
    public void setJavadoc(JavadocNode javadoc)
    {
        checkJavadocWrapped();
        this.setUnionForJavadoc(new NormalNodeUnion<JavadocNode>(javadoc));
    }
    
    /**
     * Changes the associated javadoc comment for this node.
     * @param javadoc The associated javadoc comment for this node.
     */
    public void setUnionForJavadoc(NodeUnion<? extends JavadocNode> javadoc)
    {
        checkJavadocWrapped();
        this.getManager().assertMutatable(this);
        this.doSetJavadoc(javadoc);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new AbstractMemberVariableDeclarationNodeSetJavadocPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()));
    }
    
    private void doSetJavadoc(NodeUnion<? extends JavadocNode> javadoc)
    {
        if (javadoc == null)
        {
            javadoc = new NormalNodeUnion<JavadocNode>(null);
        }
        if (this.javadoc != null)
        {
            setAsChild(this.javadoc.getNodeValue(), false);
        }
        this.javadoc = javadoc;
        setAsChild(javadoc.getNodeValue(), true);
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
        if (this.getUnionForJavadoc().getNodeValue() != null)
        {
            this.getUnionForJavadoc().getNodeValue().receive(visitor);
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
        if (this.getUnionForJavadoc().getNodeValue() != null)
        {
            this.getUnionForJavadoc().getNodeValue().receiveTyped(visitor);
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
        visitor.visitAbstractMemberVariableDeclarationNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitVariableDeclaratorOwnerNodeStart(this);
        visitor.visitDeclarationNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitVariableDeclaratorOwnerNodeStop(this);
        visitor.visitDeclarationNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitAbstractMemberVariableDeclarationNodeStop(this);
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
        list.add(getUnionForJavadoc());
        list.add(getUnionForType());
        list.add(getUnionForDeclarators());
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
        map.put("modifiers", getUnionForModifiers());
        map.put("javadoc", getUnionForJavadoc());
        map.put("type", getUnionForType());
        map.put("declarators", getUnionForDeclarators());
        return map;
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
        sb.append("javadoc=");
        sb.append(this.getUnionForJavadoc().getNodeValue() == null? "null" : this.getUnionForJavadoc().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("startLocation=");
        sb.append(String.valueOf(this.getStartLocation()) + ":" + (this.getStartLocation() != null ? this.getStartLocation().getClass().getSimpleName() : "null"));
        sb.append(',');
        sb.append("stopLocation=");
        sb.append(String.valueOf(this.getStopLocation()) + ":" + (this.getStopLocation() != null ? this.getStopLocation().getClass().getSimpleName() : "null"));
        sb.append(']');
        return sb.toString();
    }
    
    
    
}
