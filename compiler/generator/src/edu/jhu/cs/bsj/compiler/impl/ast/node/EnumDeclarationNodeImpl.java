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
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.AttributeName;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class EnumDeclarationNodeImpl extends NodeImpl implements EnumDeclarationNode
{
    /** The modifiers for this type. */
    private NodeUnion<? extends EnumModifiersNode> modifiers;
    
    /** The implements clause. */
    private NodeUnion<? extends DeclaredTypeListNode> implementsClause;
    
    /** This enum's body. */
    private NodeUnion<? extends EnumBodyNode> body;
    
    /** The name of this declared type. */
    private NodeUnion<? extends IdentifierNode> identifier;
    
    /** The associated javadoc comment for this node. */
    private NodeUnion<? extends JavadocNode> javadoc;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(EnumDeclarationNodeImpl.this, attributeName);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute implements AttributeName
    {
        /** Attribute identifier for the modifiers property. */
        MODIFIERS,
        /** Attribute identifier for the implementsClause property. */
        IMPLEMENTS_CLAUSE,
        /** Attribute identifier for the body property. */
        BODY,
        /** Attribute identifier for the identifier property. */
        IDENTIFIER,
        /** Attribute identifier for the javadoc property. */
        JAVADOC,
    }
    
    /** General constructor. */
    public EnumDeclarationNodeImpl(
            NodeUnion<? extends EnumModifiersNode> modifiers,
            NodeUnion<? extends DeclaredTypeListNode> implementsClause,
            NodeUnion<? extends EnumBodyNode> body,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends JavadocNode> javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setUnionForModifiers(modifiers, false);
        setUnionForImplementsClause(implementsClause, false);
        setUnionForBody(body, false);
        setUnionForIdentifier(identifier, false);
        setUnionForJavadoc(javadoc, false);
    }
    
    /**
     * Gets the modifiers for this type.  This property's value is assumed to be a normal node.
     * @return The modifiers for this type.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public EnumModifiersNode getModifiers()
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
     * Gets the modifiers for this type.
     * @return The modifiers for this type.
     */
    public NodeUnion<? extends EnumModifiersNode> getUnionForModifiers()
    {
        getAttribute(LocalAttribute.MODIFIERS).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.modifiers == null)
        {
            this.modifiers = new NormalNodeUnion<EnumModifiersNode>(null);
        }
        return this.modifiers;
    }
    
    /**
     * Changes the modifiers for this type.
     * @param modifiers The modifiers for this type.
     */
    public void setModifiers(EnumModifiersNode modifiers)
    {
            setModifiers(modifiers, true);
            getManager().notifyChange(this);
    }
    
    private void setModifiers(EnumModifiersNode modifiers, boolean checkPermissions)
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
        this.modifiers = new NormalNodeUnion<EnumModifiersNode>(modifiers);
        setAsChild(modifiers, true);
    }
    
    /**
     * Changes the modifiers for this type.
     * @param modifiers The modifiers for this type.
     */
    public void setUnionForModifiers(NodeUnion<? extends EnumModifiersNode> modifiers)
    {
            setUnionForModifiers(modifiers, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForModifiers(NodeUnion<? extends EnumModifiersNode> modifiers, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.MODIFIERS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (modifiers == null)
        {
            modifiers = new NormalNodeUnion<EnumModifiersNode>(null);
        }
        if (this.modifiers != null)
        {
            setAsChild(this.modifiers.getNodeValue(), false);
        }
        this.modifiers = modifiers;
        setAsChild(modifiers.getNodeValue(), true);
    }
    
    /**
     * Gets the implements clause.  This property's value is assumed to be a normal node.
     * @return The implements clause.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public DeclaredTypeListNode getImplementsClause()
    {
        getAttribute(LocalAttribute.IMPLEMENTS_CLAUSE).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.implementsClause == null)
        {
            return null;
        } else
        {
            return this.implementsClause.getNormalNode();
        }
    }
    
    /**
     * Gets the implements clause.
     * @return The implements clause.
     */
    public NodeUnion<? extends DeclaredTypeListNode> getUnionForImplementsClause()
    {
        getAttribute(LocalAttribute.IMPLEMENTS_CLAUSE).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.implementsClause == null)
        {
            this.implementsClause = new NormalNodeUnion<DeclaredTypeListNode>(null);
        }
        return this.implementsClause;
    }
    
    /**
     * Changes the implements clause.
     * @param implementsClause The implements clause.
     */
    public void setImplementsClause(DeclaredTypeListNode implementsClause)
    {
            setImplementsClause(implementsClause, true);
            getManager().notifyChange(this);
    }
    
    private void setImplementsClause(DeclaredTypeListNode implementsClause, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.IMPLEMENTS_CLAUSE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.implementsClause != null)
        {
            setAsChild(this.implementsClause.getNodeValue(), false);
        }
        this.implementsClause = new NormalNodeUnion<DeclaredTypeListNode>(implementsClause);
        setAsChild(implementsClause, true);
    }
    
    /**
     * Changes the implements clause.
     * @param implementsClause The implements clause.
     */
    public void setUnionForImplementsClause(NodeUnion<? extends DeclaredTypeListNode> implementsClause)
    {
            setUnionForImplementsClause(implementsClause, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForImplementsClause(NodeUnion<? extends DeclaredTypeListNode> implementsClause, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.IMPLEMENTS_CLAUSE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (implementsClause == null)
        {
            implementsClause = new NormalNodeUnion<DeclaredTypeListNode>(null);
        }
        if (this.implementsClause != null)
        {
            setAsChild(this.implementsClause.getNodeValue(), false);
        }
        this.implementsClause = implementsClause;
        setAsChild(implementsClause.getNodeValue(), true);
    }
    
    /**
     * Gets this enum's body.  This property's value is assumed to be a normal node.
     * @return This enum's body.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public EnumBodyNode getBody()
    {
        getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.body == null)
        {
            return null;
        } else
        {
            return this.body.getNormalNode();
        }
    }
    
    /**
     * Gets this enum's body.
     * @return This enum's body.
     */
    public NodeUnion<? extends EnumBodyNode> getUnionForBody()
    {
        getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.body == null)
        {
            this.body = new NormalNodeUnion<EnumBodyNode>(null);
        }
        return this.body;
    }
    
    /**
     * Changes this enum's body.
     * @param body This enum's body.
     */
    public void setBody(EnumBodyNode body)
    {
            setBody(body, true);
            getManager().notifyChange(this);
    }
    
    private void setBody(EnumBodyNode body, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.body != null)
        {
            setAsChild(this.body.getNodeValue(), false);
        }
        this.body = new NormalNodeUnion<EnumBodyNode>(body);
        setAsChild(body, true);
    }
    
    /**
     * Changes this enum's body.
     * @param body This enum's body.
     */
    public void setUnionForBody(NodeUnion<? extends EnumBodyNode> body)
    {
            setUnionForBody(body, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForBody(NodeUnion<? extends EnumBodyNode> body, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (body == null)
        {
            body = new NormalNodeUnion<EnumBodyNode>(null);
        }
        if (this.body != null)
        {
            setAsChild(this.body.getNodeValue(), false);
        }
        this.body = body;
        setAsChild(body.getNodeValue(), true);
    }
    
    /**
     * Gets the name of this declared type.  This property's value is assumed to be a normal node.
     * @return The name of this declared type.
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
     * Gets the name of this declared type.
     * @return The name of this declared type.
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
     * Changes the name of this declared type.
     * @param identifier The name of this declared type.
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
     * Changes the name of this declared type.
     * @param identifier The name of this declared type.
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
        if (this.implementsClause.getNodeValue() != null)
        {
            this.implementsClause.getNodeValue().receive(visitor);
        }
        if (this.body.getNodeValue() != null)
        {
            this.body.getNodeValue().receive(visitor);
        }
        if (this.identifier.getNodeValue() != null)
        {
            this.identifier.getNodeValue().receive(visitor);
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
        if (this.implementsClause.getNodeValue() != null)
        {
            this.implementsClause.getNodeValue().receiveTyped(visitor);
        }
        if (this.body.getNodeValue() != null)
        {
            this.body.getNodeValue().receiveTyped(visitor);
        }
        if (this.identifier.getNodeValue() != null)
        {
            this.identifier.getNodeValue().receiveTyped(visitor);
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
        visitor.visitEnumDeclarationNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitNamedTypeDeclarationNodeStart(this);
        visitor.visitModifiedNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNamedTypeDeclarationNodeStop(this);
        visitor.visitModifiedNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitEnumDeclarationNodeStop(this, true);
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
        list.add(getUnionForImplementsClause());
        list.add(getUnionForIdentifier());
        list.add(getUnionForJavadoc());
        list.add(getUnionForModifiers());
        list.add(getUnionForBody());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForModifiers().getNodeValue(), getUnionForImplementsClause().getNodeValue(), getUnionForBody().getNodeValue(), getUnionForIdentifier().getNodeValue(), getUnionForJavadoc().getNodeValue()});
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
        sb.append("implementsClause=");
        sb.append(this.getUnionForImplementsClause().getNodeValue() == null? "null" : this.getUnionForImplementsClause().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("body=");
        sb.append(this.getUnionForBody().getNodeValue() == null? "null" : this.getUnionForBody().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("identifier=");
        sb.append(this.getUnionForIdentifier().getNodeValue() == null? "null" : this.getUnionForIdentifier().getNodeValue().getClass().getSimpleName());
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
        return operation.executeEnumDeclarationNode(this, p);
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
        return operation.executeEnumDeclarationNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public EnumDeclarationNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends EnumModifiersNode> modifiersCopy;
        switch (getUnionForModifiers().getType())
        {
            case NORMAL:
                if (getUnionForModifiers().getNormalNode() == null)
                {
                    modifiersCopy = factory.<EnumModifiersNode>makeNormalNodeUnion(null);
                } else
                {
                    modifiersCopy = factory.makeNormalNodeUnion(getUnionForModifiers().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForModifiers().getSpliceNode() == null)
                {
                    modifiersCopy = factory.<EnumModifiersNode>makeSpliceNodeUnion(null);
                } else
                {
                    modifiersCopy = factory.makeSpliceNodeUnion(getUnionForModifiers().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForModifiers().getType());
        }
        NodeUnion<? extends DeclaredTypeListNode> implementsClauseCopy;
        switch (getUnionForImplementsClause().getType())
        {
            case NORMAL:
                if (getUnionForImplementsClause().getNormalNode() == null)
                {
                    implementsClauseCopy = factory.<DeclaredTypeListNode>makeNormalNodeUnion(null);
                } else
                {
                    implementsClauseCopy = factory.makeNormalNodeUnion(getUnionForImplementsClause().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForImplementsClause().getSpliceNode() == null)
                {
                    implementsClauseCopy = factory.<DeclaredTypeListNode>makeSpliceNodeUnion(null);
                } else
                {
                    implementsClauseCopy = factory.makeSpliceNodeUnion(getUnionForImplementsClause().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForImplementsClause().getType());
        }
        NodeUnion<? extends EnumBodyNode> bodyCopy;
        switch (getUnionForBody().getType())
        {
            case NORMAL:
                if (getUnionForBody().getNormalNode() == null)
                {
                    bodyCopy = factory.<EnumBodyNode>makeNormalNodeUnion(null);
                } else
                {
                    bodyCopy = factory.makeNormalNodeUnion(getUnionForBody().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForBody().getSpliceNode() == null)
                {
                    bodyCopy = factory.<EnumBodyNode>makeSpliceNodeUnion(null);
                } else
                {
                    bodyCopy = factory.makeSpliceNodeUnion(getUnionForBody().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForBody().getType());
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
        return factory.makeEnumDeclarationNodeWithUnions(
                modifiersCopy,
                implementsClauseCopy,
                bodyCopy,
                identifierCopy,
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
            setModifiers((EnumModifiersNode)after);
            return true;
        }
        if (before.equals(this.getUnionForImplementsClause().getNodeValue()))
        {
            setImplementsClause((DeclaredTypeListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForBody().getNodeValue()))
        {
            setBody((EnumBodyNode)after);
            return true;
        }
        if (before.equals(this.getUnionForIdentifier().getNodeValue()))
        {
            setIdentifier((IdentifierNode)after);
            return true;
        }
        if (before.equals(this.getUnionForJavadoc().getNodeValue()))
        {
            setJavadoc((JavadocNode)after);
            return true;
        }
        return false;
    }
    
	/**
	 * {@inheritDoc}
	 */
	public NamedTypeDeclarationNode<?> getTypeDeclaration(String name)
	{
		for (Node node : getBody().getMembers())
		{
			if (node instanceof NamedTypeDeclarationNode<?>)
			{
				NamedTypeDeclarationNode<?> namedTypeDeclarationNode = (NamedTypeDeclarationNode<?>)node;
				if (namedTypeDeclarationNode.getIdentifier().getIdentifier().equals(name))
				{
					return namedTypeDeclarationNode;
				}
			}
		}
		return null;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getFullyQualifiedName()
	{
		String id = this.getIdentifier().getIdentifier();
		
		NamedTypeDeclarationNode<?> enclosingType = this.getNearestAncestorOfType(NamedTypeDeclarationNode.class);
		if (enclosingType != null)
		{
			return enclosingType.getFullyQualifiedName() + "." + id;
		}
		
		PackageNode enclosingPackage = this.getNearestAncestorOfType(PackageNode.class);
		if (enclosingPackage != null)
		{
			String packageName = ((PackageNode)enclosingPackage).getFullyQualifiedName();
			if (packageName.length()>0)
			{
				return packageName + "." + id;
			} else
			{
				return id;
			}
		}

		return null;
	}
}
