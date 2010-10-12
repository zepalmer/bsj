package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.AbstractlyUnmodifiedClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class AbstractlyUnmodifiedClassDeclarationNodeImpl<T extends ModifiersNode> extends NodeImpl implements AbstractlyUnmodifiedClassDeclarationNode<T>
{
    /** The modifiers for this type. */
    private NodeUnion<? extends T> modifiers;
    
    /** The extends clause. */
    private NodeUnion<? extends DeclaredTypeNode> extendsClause;
    
    /** The implements clause. */
    private NodeUnion<? extends DeclaredTypeListNode> implementsClause;
    
    /** The body of this class. */
    private NodeUnion<? extends ClassBodyNode> body;
    
    /** This class's type parameters. */
    private NodeUnion<? extends TypeParameterListNode> typeParameters;
    
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
            attribute = new ReadWriteAttribute(AbstractlyUnmodifiedClassDeclarationNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the modifiers property. */
        MODIFIERS,
        /** Attribute identifier for the extendsClause property. */
        EXTENDS_CLAUSE,
        /** Attribute identifier for the implementsClause property. */
        IMPLEMENTS_CLAUSE,
        /** Attribute identifier for the body property. */
        BODY,
        /** Attribute identifier for the typeParameters property. */
        TYPE_PARAMETERS,
        /** Attribute identifier for the identifier property. */
        IDENTIFIER,
        /** Attribute identifier for the javadoc property. */
        JAVADOC,
    }
    
    /** General constructor. */
    protected AbstractlyUnmodifiedClassDeclarationNodeImpl(
            NodeUnion<? extends T> modifiers,
            NodeUnion<? extends DeclaredTypeNode> extendsClause,
            NodeUnion<? extends DeclaredTypeListNode> implementsClause,
            NodeUnion<? extends ClassBodyNode> body,
            NodeUnion<? extends TypeParameterListNode> typeParameters,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends JavadocNode> javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setUnionForModifiers(modifiers, false);
        setUnionForExtendsClause(extendsClause, false);
        setUnionForImplementsClause(implementsClause, false);
        setUnionForBody(body, false);
        setUnionForTypeParameters(typeParameters, false);
        setUnionForIdentifier(identifier, false);
        setUnionForJavadoc(javadoc, false);
    }
    
    /**
     * Gets the modifiers for this type.  This property's value is assumed to be a normal node.
     * @return The modifiers for this type.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public T getModifiers()
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
    public NodeUnion<? extends T> getUnionForModifiers()
    {
        getAttribute(LocalAttribute.MODIFIERS).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.modifiers == null)
        {
            this.modifiers = new NormalNodeUnion<T>(null);
        }
        return this.modifiers;
    }
    
    /**
     * Changes the modifiers for this type.
     * @param modifiers The modifiers for this type.
     */
    public void setModifiers(T modifiers)
    {
            setModifiers(modifiers, true);
            getManager().notifyChange(this);
    }
    
    private void setModifiers(T modifiers, boolean checkPermissions)
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
        this.modifiers = new NormalNodeUnion<T>(modifiers);
        setAsChild(modifiers, true);
    }
    
    /**
     * Changes the modifiers for this type.
     * @param modifiers The modifiers for this type.
     */
    public void setUnionForModifiers(NodeUnion<? extends T> modifiers)
    {
            setUnionForModifiers(modifiers, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForModifiers(NodeUnion<? extends T> modifiers, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.MODIFIERS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
     * Gets the extends clause.  This property's value is assumed to be a normal node.
     * @return The extends clause.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public DeclaredTypeNode getExtendsClause()
    {
        getAttribute(LocalAttribute.EXTENDS_CLAUSE).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.extendsClause == null)
        {
            return null;
        } else
        {
            return this.extendsClause.getNormalNode();
        }
    }
    
    /**
     * Gets the extends clause.
     * @return The extends clause.
     */
    public NodeUnion<? extends DeclaredTypeNode> getUnionForExtendsClause()
    {
        getAttribute(LocalAttribute.EXTENDS_CLAUSE).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.extendsClause == null)
        {
            this.extendsClause = new NormalNodeUnion<DeclaredTypeNode>(null);
        }
        return this.extendsClause;
    }
    
    /**
     * Changes the extends clause.
     * @param extendsClause The extends clause.
     */
    public void setExtendsClause(DeclaredTypeNode extendsClause)
    {
            setExtendsClause(extendsClause, true);
            getManager().notifyChange(this);
    }
    
    private void setExtendsClause(DeclaredTypeNode extendsClause, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.EXTENDS_CLAUSE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.extendsClause != null)
        {
            setAsChild(this.extendsClause.getNodeValue(), false);
        }
        this.extendsClause = new NormalNodeUnion<DeclaredTypeNode>(extendsClause);
        setAsChild(extendsClause, true);
    }
    
    /**
     * Changes the extends clause.
     * @param extendsClause The extends clause.
     */
    public void setUnionForExtendsClause(NodeUnion<? extends DeclaredTypeNode> extendsClause)
    {
            setUnionForExtendsClause(extendsClause, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForExtendsClause(NodeUnion<? extends DeclaredTypeNode> extendsClause, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.EXTENDS_CLAUSE).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (extendsClause == null)
        {
            extendsClause = new NormalNodeUnion<DeclaredTypeNode>(null);
        }
        if (this.extendsClause != null)
        {
            setAsChild(this.extendsClause.getNodeValue(), false);
        }
        this.extendsClause = extendsClause;
        setAsChild(extendsClause.getNodeValue(), true);
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
     * Gets the body of this class.  This property's value is assumed to be a normal node.
     * @return The body of this class.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ClassBodyNode getBody()
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
     * Gets the body of this class.
     * @return The body of this class.
     */
    public NodeUnion<? extends ClassBodyNode> getUnionForBody()
    {
        getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.body == null)
        {
            this.body = new NormalNodeUnion<ClassBodyNode>(null);
        }
        return this.body;
    }
    
    /**
     * Changes the body of this class.
     * @param body The body of this class.
     */
    public void setBody(ClassBodyNode body)
    {
            setBody(body, true);
            getManager().notifyChange(this);
    }
    
    private void setBody(ClassBodyNode body, boolean checkPermissions)
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
        this.body = new NormalNodeUnion<ClassBodyNode>(body);
        setAsChild(body, true);
    }
    
    /**
     * Changes the body of this class.
     * @param body The body of this class.
     */
    public void setUnionForBody(NodeUnion<? extends ClassBodyNode> body)
    {
            setUnionForBody(body, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForBody(NodeUnion<? extends ClassBodyNode> body, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (body == null)
        {
            body = new NormalNodeUnion<ClassBodyNode>(null);
        }
        if (this.body != null)
        {
            setAsChild(this.body.getNodeValue(), false);
        }
        this.body = body;
        setAsChild(body.getNodeValue(), true);
    }
    
    /**
     * Gets this class's type parameters.  This property's value is assumed to be a normal node.
     * @return This class's type parameters.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public TypeParameterListNode getTypeParameters()
    {
        getAttribute(LocalAttribute.TYPE_PARAMETERS).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.typeParameters == null)
        {
            return null;
        } else
        {
            return this.typeParameters.getNormalNode();
        }
    }
    
    /**
     * Gets this class's type parameters.
     * @return This class's type parameters.
     */
    public NodeUnion<? extends TypeParameterListNode> getUnionForTypeParameters()
    {
        getAttribute(LocalAttribute.TYPE_PARAMETERS).recordAccess(ReadWriteAttribute.AccessType.READ);
        if (this.typeParameters == null)
        {
            this.typeParameters = new NormalNodeUnion<TypeParameterListNode>(null);
        }
        return this.typeParameters;
    }
    
    /**
     * Changes this class's type parameters.
     * @param typeParameters This class's type parameters.
     */
    public void setTypeParameters(TypeParameterListNode typeParameters)
    {
            setTypeParameters(typeParameters, true);
            getManager().notifyChange(this);
    }
    
    private void setTypeParameters(TypeParameterListNode typeParameters, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.TYPE_PARAMETERS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.typeParameters != null)
        {
            setAsChild(this.typeParameters.getNodeValue(), false);
        }
        this.typeParameters = new NormalNodeUnion<TypeParameterListNode>(typeParameters);
        setAsChild(typeParameters, true);
    }
    
    /**
     * Changes this class's type parameters.
     * @param typeParameters This class's type parameters.
     */
    public void setUnionForTypeParameters(NodeUnion<? extends TypeParameterListNode> typeParameters)
    {
            setUnionForTypeParameters(typeParameters, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForTypeParameters(NodeUnion<? extends TypeParameterListNode> typeParameters, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.TYPE_PARAMETERS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (typeParameters == null)
        {
            typeParameters = new NormalNodeUnion<TypeParameterListNode>(null);
        }
        if (this.typeParameters != null)
        {
            setAsChild(this.typeParameters.getNodeValue(), false);
        }
        this.typeParameters = typeParameters;
        setAsChild(typeParameters.getNodeValue(), true);
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
        if (this.extendsClause.getNodeValue() != null)
        {
            this.extendsClause.getNodeValue().receive(visitor);
        }
        if (this.implementsClause.getNodeValue() != null)
        {
            this.implementsClause.getNodeValue().receive(visitor);
        }
        if (this.body.getNodeValue() != null)
        {
            this.body.getNodeValue().receive(visitor);
        }
        if (this.typeParameters.getNodeValue() != null)
        {
            this.typeParameters.getNodeValue().receive(visitor);
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
        if (this.extendsClause.getNodeValue() != null)
        {
            this.extendsClause.getNodeValue().receiveTyped(visitor);
        }
        if (this.implementsClause.getNodeValue() != null)
        {
            this.implementsClause.getNodeValue().receiveTyped(visitor);
        }
        if (this.body.getNodeValue() != null)
        {
            this.body.getNodeValue().receiveTyped(visitor);
        }
        if (this.typeParameters.getNodeValue() != null)
        {
            this.typeParameters.getNodeValue().receiveTyped(visitor);
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
        visitor.visitAbstractlyUnmodifiedClassDeclarationNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitNamedTypeDeclarationNodeStart(this);
        visitor.visitModifiedNodeStart(this);
        visitor.visitParameterizableTypeDeclarationNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNamedTypeDeclarationNodeStop(this);
        visitor.visitModifiedNodeStop(this);
        visitor.visitParameterizableTypeDeclarationNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitAbstractlyUnmodifiedClassDeclarationNodeStop(this);
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
        list.add(getModifiers());
        list.add(getExtendsClause());
        list.add(getImplementsClause());
        list.add(getBody());
        list.add(getTypeParameters());
        return list;
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
        sb.append("extendsClause=");
        sb.append(this.getUnionForExtendsClause().getNodeValue() == null? "null" : this.getUnionForExtendsClause().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("implementsClause=");
        sb.append(this.getUnionForImplementsClause().getNodeValue() == null? "null" : this.getUnionForImplementsClause().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("body=");
        sb.append(this.getUnionForBody().getNodeValue() == null? "null" : this.getUnionForBody().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("typeParameters=");
        sb.append(this.getUnionForTypeParameters().getNodeValue() == null? "null" : this.getUnionForTypeParameters().getNodeValue().getClass().getSimpleName());
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
