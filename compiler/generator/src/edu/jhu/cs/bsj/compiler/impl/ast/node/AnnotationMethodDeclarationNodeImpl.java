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
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationMethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationMethodModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.AnnotationValueNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.AttributeName;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class AnnotationMethodDeclarationNodeImpl extends NodeImpl implements AnnotationMethodDeclarationNode
{
    /** The modifiers for this annotation method. */
    private NodeUnion<? extends AnnotationMethodModifiersNode> modifiers;
    
    /** The return type of this annotation method. */
    private NodeUnion<? extends TypeNode> type;
    
    /** This annotation method's name. */
    private NodeUnion<? extends IdentifierNode> identifier;
    
    /** The default value for this method. */
    private NodeUnion<? extends AnnotationValueNode> defaultValue;
    
    /** The associated javadoc comment for this node. */
    private NodeUnion<? extends JavadocNode> javadoc;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(AnnotationMethodDeclarationNodeImpl.this, attributeName);
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
        /** Attribute identifier for the defaultValue property. */
        DEFAULT_VALUE,
        /** Attribute identifier for the javadoc property. */
        JAVADOC,
    }
    
    /** General constructor. */
    public AnnotationMethodDeclarationNodeImpl(
            NodeUnion<? extends AnnotationMethodModifiersNode> modifiers,
            NodeUnion<? extends TypeNode> type,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends AnnotationValueNode> defaultValue,
            NodeUnion<? extends JavadocNode> javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setUnionForModifiers(modifiers, false);
        setUnionForType(type, false);
        setUnionForIdentifier(identifier, false);
        setUnionForDefaultValue(defaultValue, false);
        setUnionForJavadoc(javadoc, false);
    }
    
    /**
     * Gets the modifiers for this annotation method.  This property's value is assumed to be a normal node.
     * @return The modifiers for this annotation method.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public AnnotationMethodModifiersNode getModifiers()
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
     * Gets the modifiers for this annotation method.
     * @return The modifiers for this annotation method.
     */
    public NodeUnion<? extends AnnotationMethodModifiersNode> getUnionForModifiers()
    {
        getAttribute(LocalAttribute.MODIFIERS).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.modifiers == null)
        {
            this.modifiers = new NormalNodeUnion<AnnotationMethodModifiersNode>(null);
        }
        return this.modifiers;
    }
    
    /**
     * Changes the modifiers for this annotation method.
     * @param modifiers The modifiers for this annotation method.
     */
    public void setModifiers(AnnotationMethodModifiersNode modifiers)
    {
            setModifiers(modifiers, true);
            getManager().notifyChange(this);
    }
    
    private void setModifiers(AnnotationMethodModifiersNode modifiers, boolean checkPermissions)
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
        this.modifiers = new NormalNodeUnion<AnnotationMethodModifiersNode>(modifiers);
        setAsChild(modifiers, true);
    }
    
    /**
     * Changes the modifiers for this annotation method.
     * @param modifiers The modifiers for this annotation method.
     */
    public void setUnionForModifiers(NodeUnion<? extends AnnotationMethodModifiersNode> modifiers)
    {
            setUnionForModifiers(modifiers, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForModifiers(NodeUnion<? extends AnnotationMethodModifiersNode> modifiers, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.MODIFIERS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (modifiers == null)
        {
            modifiers = new NormalNodeUnion<AnnotationMethodModifiersNode>(null);
        }
        if (this.modifiers != null)
        {
            setAsChild(this.modifiers.getNodeValue(), false);
        }
        this.modifiers = modifiers;
        setAsChild(modifiers.getNodeValue(), true);
    }
    
    /**
     * Gets the return type of this annotation method.  This property's value is assumed to be a normal node.
     * @return The return type of this annotation method.
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
     * Gets the return type of this annotation method.
     * @return The return type of this annotation method.
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
     * Changes the return type of this annotation method.
     * @param type The return type of this annotation method.
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
     * Changes the return type of this annotation method.
     * @param type The return type of this annotation method.
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
     * Gets this annotation method's name.  This property's value is assumed to be a normal node.
     * @return This annotation method's name.
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
     * Gets this annotation method's name.
     * @return This annotation method's name.
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
     * Changes this annotation method's name.
     * @param identifier This annotation method's name.
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
     * Changes this annotation method's name.
     * @param identifier This annotation method's name.
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
     * Gets the default value for this method.  This property's value is assumed to be a normal node.
     * @return The default value for this method.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public AnnotationValueNode getDefaultValue()
    {
        getAttribute(LocalAttribute.DEFAULT_VALUE).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.defaultValue == null)
        {
            return null;
        } else
        {
            return this.defaultValue.getNormalNode();
        }
    }
    
    /**
     * Gets the default value for this method.
     * @return The default value for this method.
     */
    public NodeUnion<? extends AnnotationValueNode> getUnionForDefaultValue()
    {
        getAttribute(LocalAttribute.DEFAULT_VALUE).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.defaultValue == null)
        {
            this.defaultValue = new NormalNodeUnion<AnnotationValueNode>(null);
        }
        return this.defaultValue;
    }
    
    /**
     * Changes the default value for this method.
     * @param defaultValue The default value for this method.
     */
    public void setDefaultValue(AnnotationValueNode defaultValue)
    {
            setDefaultValue(defaultValue, true);
            getManager().notifyChange(this);
    }
    
    private void setDefaultValue(AnnotationValueNode defaultValue, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.DEFAULT_VALUE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.defaultValue != null)
        {
            setAsChild(this.defaultValue.getNodeValue(), false);
        }
        this.defaultValue = new NormalNodeUnion<AnnotationValueNode>(defaultValue);
        setAsChild(defaultValue, true);
    }
    
    /**
     * Changes the default value for this method.
     * @param defaultValue The default value for this method.
     */
    public void setUnionForDefaultValue(NodeUnion<? extends AnnotationValueNode> defaultValue)
    {
            setUnionForDefaultValue(defaultValue, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForDefaultValue(NodeUnion<? extends AnnotationValueNode> defaultValue, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.DEFAULT_VALUE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (defaultValue == null)
        {
            defaultValue = new NormalNodeUnion<AnnotationValueNode>(null);
        }
        if (this.defaultValue != null)
        {
            setAsChild(this.defaultValue.getNodeValue(), false);
        }
        this.defaultValue = defaultValue;
        setAsChild(defaultValue.getNodeValue(), true);
    }
    
    /**
     * Gets the associated javadoc comment for this node.  This property's value is assumed to be a normal node.
     * @return The associated javadoc comment for this node.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public JavadocNode getJavadoc()
    {
        getAttribute(LocalAttribute.JAVADOC).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        getAttribute(LocalAttribute.JAVADOC).recordAccess(ReadWriteAttribute.AccessType.READ);
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
            setJavadoc(javadoc, true);
            getManager().notifyChange(this);
    }
    
    private void setJavadoc(JavadocNode javadoc, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.JAVADOC).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.javadoc != null)
        {
            setAsChild(this.javadoc.getNodeValue(), false);
        }
        this.javadoc = new NormalNodeUnion<JavadocNode>(javadoc);
        setAsChild(javadoc, true);
    }
    
    /**
     * Changes the associated javadoc comment for this node.
     * @param javadoc The associated javadoc comment for this node.
     */
    public void setUnionForJavadoc(NodeUnion<? extends JavadocNode> javadoc)
    {
            setUnionForJavadoc(javadoc, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForJavadoc(NodeUnion<? extends JavadocNode> javadoc, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.JAVADOC).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
        if (this.defaultValue.getNodeValue() != null)
        {
            this.defaultValue.getNodeValue().receive(visitor);
        }
        if (this.javadoc.getNodeValue() != null)
        {
            this.javadoc.getNodeValue().receive(visitor);
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
        if (this.defaultValue.getNodeValue() != null)
        {
            this.defaultValue.getNodeValue().receiveTyped(visitor);
        }
        if (this.javadoc.getNodeValue() != null)
        {
            this.javadoc.getNodeValue().receiveTyped(visitor);
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
        visitor.visitAnnotationMethodDeclarationNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitAnnotationMemberNodeStart(this);
        visitor.visitDeclarationNodeStart(this);
        visitor.visitInvokableNameBindingNodeStart(this);
        visitor.visitModifiedNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitAnnotationMemberNodeStop(this);
        visitor.visitDeclarationNodeStop(this);
        visitor.visitInvokableNameBindingNodeStop(this);
        visitor.visitModifiedNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitAnnotationMethodDeclarationNodeStop(this, true);
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
        list.add(getUnionForDefaultValue());
        list.add(getUnionForJavadoc());
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
        return Arrays.asList(new Node[]{getUnionForModifiers().getNodeValue(), getUnionForType().getNodeValue(), getUnionForIdentifier().getNodeValue(), getUnionForDefaultValue().getNodeValue(), getUnionForJavadoc().getNodeValue()});
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
        sb.append("defaultValue=");
        sb.append(this.getUnionForDefaultValue().getNodeValue() == null? "null" : this.getUnionForDefaultValue().getNodeValue().getClass().getSimpleName());
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
    
    /**
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p)
    {
        return operation.executeAnnotationMethodDeclarationNode(this, p);
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
        return operation.executeAnnotationMethodDeclarationNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnnotationMethodDeclarationNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends AnnotationMethodModifiersNode> modifiersCopy;
        switch (getUnionForModifiers().getType())
        {
            case NORMAL:
                if (getUnionForModifiers().getNormalNode() == null)
                {
                    modifiersCopy = factory.<AnnotationMethodModifiersNode>makeNormalNodeUnion(null);
                } else
                {
                    modifiersCopy = factory.makeNormalNodeUnion(getUnionForModifiers().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForModifiers().getSpliceNode() == null)
                {
                    modifiersCopy = factory.<AnnotationMethodModifiersNode>makeSpliceNodeUnion(null);
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
        NodeUnion<? extends AnnotationValueNode> defaultValueCopy;
        switch (getUnionForDefaultValue().getType())
        {
            case NORMAL:
                if (getUnionForDefaultValue().getNormalNode() == null)
                {
                    defaultValueCopy = factory.<AnnotationValueNode>makeNormalNodeUnion(null);
                } else
                {
                    defaultValueCopy = factory.makeNormalNodeUnion(getUnionForDefaultValue().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForDefaultValue().getSpliceNode() == null)
                {
                    defaultValueCopy = factory.<AnnotationValueNode>makeSpliceNodeUnion(null);
                } else
                {
                    defaultValueCopy = factory.makeSpliceNodeUnion(getUnionForDefaultValue().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForDefaultValue().getType());
        }
        NodeUnion<? extends JavadocNode> javadocCopy;
        switch (getUnionForJavadoc().getType())
        {
            case NORMAL:
                if (getUnionForJavadoc().getNormalNode() == null)
                {
                    javadocCopy = factory.<JavadocNode>makeNormalNodeUnion(null);
                } else
                {
                    javadocCopy = factory.makeNormalNodeUnion(getUnionForJavadoc().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForJavadoc().getSpliceNode() == null)
                {
                    javadocCopy = factory.<JavadocNode>makeSpliceNodeUnion(null);
                } else
                {
                    javadocCopy = factory.makeSpliceNodeUnion(getUnionForJavadoc().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForJavadoc().getType());
        }
        return factory.makeAnnotationMethodDeclarationNodeWithUnions(
                modifiersCopy,
                typeCopy,
                identifierCopy,
                defaultValueCopy,
                javadocCopy,
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
            setModifiers((AnnotationMethodModifiersNode)after);
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
        if (before.equals(this.getUnionForDefaultValue().getNodeValue()))
        {
            setDefaultValue((AnnotationValueNode)after);
            return true;
        }
        if (before.equals(this.getUnionForJavadoc().getNodeValue()))
        {
            setJavadoc((JavadocNode)after);
            return true;
        }
        return false;
    }
    
}
