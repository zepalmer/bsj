package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

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
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.AbstractlyUnmodifiedClassDeclarationNodeSetBodyPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.AbstractlyUnmodifiedClassDeclarationNodeSetExtendsClausePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.AbstractlyUnmodifiedClassDeclarationNodeSetIdentifierPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.AbstractlyUnmodifiedClassDeclarationNodeSetImplementsClausePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.AbstractlyUnmodifiedClassDeclarationNodeSetJavadocPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.AbstractlyUnmodifiedClassDeclarationNodeSetModifiersPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.AbstractlyUnmodifiedClassDeclarationNodeSetTypeParametersPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.AbstractlyUnmodifiedClassDeclarationNodeProperties;

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
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<AbstractlyUnmodifiedClassDeclarationNodeProperties> populatedProperties;
    
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
        this.populatedProperties = null;
        doSetModifiers(modifiers);
        doSetExtendsClause(extendsClause);
        doSetImplementsClause(implementsClause);
        doSetBody(body);
        doSetTypeParameters(typeParameters);
        doSetIdentifier(identifier);
        doSetJavadoc(javadoc);
    }
    
    /** Proxy constructor. */
    protected AbstractlyUnmodifiedClassDeclarationNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, AbstractlyUnmodifiedClassDeclarationNode<T> backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(AbstractlyUnmodifiedClassDeclarationNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    // This SuppressWarnings is always safe because backingNode is set by the node
    // constructor and never changed.  This is equivalent to a read-only value
    // defined by a type parameter without complicating the type reference site.
    @SuppressWarnings("unchecked")
    protected AbstractlyUnmodifiedClassDeclarationNode<T> getBackingNode()
    {
        return (AbstractlyUnmodifiedClassDeclarationNode<T>)super.getBackingNode();
    }
    
    /**
     * Ensures that the modifiers value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkModifiersWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                AbstractlyUnmodifiedClassDeclarationNodeProperties.MODIFIERS))
            return;
        this.populatedProperties.add(AbstractlyUnmodifiedClassDeclarationNodeProperties.MODIFIERS);
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
     * Ensures that the extendsClause value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkExtendsClauseWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                AbstractlyUnmodifiedClassDeclarationNodeProperties.EXTENDS_CLAUSE))
            return;
        this.populatedProperties.add(AbstractlyUnmodifiedClassDeclarationNodeProperties.EXTENDS_CLAUSE);
        NodeUnion<? extends DeclaredTypeNode> union = this.getBackingNode().getUnionForExtendsClause();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeDeclaredTypeNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.extendsClause = union;
    }
    
    /**
     * Ensures that the implementsClause value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkImplementsClauseWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                AbstractlyUnmodifiedClassDeclarationNodeProperties.IMPLEMENTS_CLAUSE))
            return;
        this.populatedProperties.add(AbstractlyUnmodifiedClassDeclarationNodeProperties.IMPLEMENTS_CLAUSE);
        NodeUnion<? extends DeclaredTypeListNode> union = this.getBackingNode().getUnionForImplementsClause();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeDeclaredTypeListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.implementsClause = union;
    }
    
    /**
     * Ensures that the body value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkBodyWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                AbstractlyUnmodifiedClassDeclarationNodeProperties.BODY))
            return;
        this.populatedProperties.add(AbstractlyUnmodifiedClassDeclarationNodeProperties.BODY);
        NodeUnion<? extends ClassBodyNode> union = this.getBackingNode().getUnionForBody();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeClassBodyNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.body = union;
    }
    
    /**
     * Ensures that the typeParameters value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkTypeParametersWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                AbstractlyUnmodifiedClassDeclarationNodeProperties.TYPE_PARAMETERS))
            return;
        this.populatedProperties.add(AbstractlyUnmodifiedClassDeclarationNodeProperties.TYPE_PARAMETERS);
        NodeUnion<? extends TypeParameterListNode> union = this.getBackingNode().getUnionForTypeParameters();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeTypeParameterListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.typeParameters = union;
    }
    
    /**
     * Ensures that the identifier value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkIdentifierWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                AbstractlyUnmodifiedClassDeclarationNodeProperties.IDENTIFIER))
            return;
        this.populatedProperties.add(AbstractlyUnmodifiedClassDeclarationNodeProperties.IDENTIFIER);
        NodeUnion<? extends IdentifierNode> union = this.getBackingNode().getUnionForIdentifier();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeIdentifierNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.identifier = union;
    }
    
    /**
     * Ensures that the javadoc value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkJavadocWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                AbstractlyUnmodifiedClassDeclarationNodeProperties.JAVADOC))
            return;
        this.populatedProperties.add(AbstractlyUnmodifiedClassDeclarationNodeProperties.JAVADOC);
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
     * Gets the modifiers for this type.  This property's value is assumed to be a normal node.
     * @return The modifiers for this type.
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
     * Gets the modifiers for this type.
     * @return The modifiers for this type.
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
     * Changes the modifiers for this type.
     * @param modifiers The modifiers for this type.
     */
    public void setModifiers(T modifiers)
    {
        checkModifiersWrapped();
        this.setUnionForModifiers(new NormalNodeUnion<T>(modifiers));
    }
    
    /**
     * Changes the modifiers for this type.
     * @param modifiers The modifiers for this type.
     */
    public void setUnionForModifiers(NodeUnion<? extends T> modifiers)
    {
        checkModifiersWrapped();
        this.getManager().assertMutatable(this);
        this.doSetModifiers(modifiers);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new AbstractlyUnmodifiedClassDeclarationNodeSetModifiersPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()));
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
     * Gets the extends clause.  This property's value is assumed to be a normal node.
     * @return The extends clause.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public DeclaredTypeNode getExtendsClause()
    {
        checkExtendsClauseWrapped();
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
        checkExtendsClauseWrapped();
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
        checkExtendsClauseWrapped();
        this.setUnionForExtendsClause(new NormalNodeUnion<DeclaredTypeNode>(extendsClause));
    }
    
    /**
     * Changes the extends clause.
     * @param extendsClause The extends clause.
     */
    public void setUnionForExtendsClause(NodeUnion<? extends DeclaredTypeNode> extendsClause)
    {
        checkExtendsClauseWrapped();
        this.getManager().assertMutatable(this);
        this.doSetExtendsClause(extendsClause);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new AbstractlyUnmodifiedClassDeclarationNodeSetExtendsClausePropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), extendsClause.getNodeValue() == null ? null : extendsClause.getNodeValue().getUid()));
    }
    
    private void doSetExtendsClause(NodeUnion<? extends DeclaredTypeNode> extendsClause)
    {
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
        checkImplementsClauseWrapped();
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
        checkImplementsClauseWrapped();
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
        checkImplementsClauseWrapped();
        this.setUnionForImplementsClause(new NormalNodeUnion<DeclaredTypeListNode>(implementsClause));
    }
    
    /**
     * Changes the implements clause.
     * @param implementsClause The implements clause.
     */
    public void setUnionForImplementsClause(NodeUnion<? extends DeclaredTypeListNode> implementsClause)
    {
        checkImplementsClauseWrapped();
        this.getManager().assertMutatable(this);
        this.doSetImplementsClause(implementsClause);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new AbstractlyUnmodifiedClassDeclarationNodeSetImplementsClausePropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), implementsClause.getNodeValue() == null ? null : implementsClause.getNodeValue().getUid()));
    }
    
    private void doSetImplementsClause(NodeUnion<? extends DeclaredTypeListNode> implementsClause)
    {
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
        checkBodyWrapped();
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
        checkBodyWrapped();
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
        checkBodyWrapped();
        this.setUnionForBody(new NormalNodeUnion<ClassBodyNode>(body));
    }
    
    /**
     * Changes the body of this class.
     * @param body The body of this class.
     */
    public void setUnionForBody(NodeUnion<? extends ClassBodyNode> body)
    {
        checkBodyWrapped();
        this.getManager().assertMutatable(this);
        this.doSetBody(body);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new AbstractlyUnmodifiedClassDeclarationNodeSetBodyPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), body.getNodeValue() == null ? null : body.getNodeValue().getUid()));
    }
    
    private void doSetBody(NodeUnion<? extends ClassBodyNode> body)
    {
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
        checkTypeParametersWrapped();
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
        checkTypeParametersWrapped();
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
        checkTypeParametersWrapped();
        this.setUnionForTypeParameters(new NormalNodeUnion<TypeParameterListNode>(typeParameters));
    }
    
    /**
     * Changes this class's type parameters.
     * @param typeParameters This class's type parameters.
     */
    public void setUnionForTypeParameters(NodeUnion<? extends TypeParameterListNode> typeParameters)
    {
        checkTypeParametersWrapped();
        this.getManager().assertMutatable(this);
        this.doSetTypeParameters(typeParameters);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new AbstractlyUnmodifiedClassDeclarationNodeSetTypeParametersPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), typeParameters.getNodeValue() == null ? null : typeParameters.getNodeValue().getUid()));
    }
    
    private void doSetTypeParameters(NodeUnion<? extends TypeParameterListNode> typeParameters)
    {
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
        checkIdentifierWrapped();
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
        checkIdentifierWrapped();
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
        checkIdentifierWrapped();
        this.setUnionForIdentifier(new NormalNodeUnion<IdentifierNode>(identifier));
    }
    
    /**
     * Changes the name of this declared type.
     * @param identifier The name of this declared type.
     */
    public void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier)
    {
        checkIdentifierWrapped();
        this.getManager().assertMutatable(this);
        this.doSetIdentifier(identifier);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new AbstractlyUnmodifiedClassDeclarationNodeSetIdentifierPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()));
    }
    
    private void doSetIdentifier(NodeUnion<? extends IdentifierNode> identifier)
    {
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
            super.recordEdit(new AbstractlyUnmodifiedClassDeclarationNodeSetJavadocPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()));
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
        if (this.getUnionForExtendsClause().getNodeValue() != null)
        {
            this.getUnionForExtendsClause().getNodeValue().receive(visitor);
        }
        if (this.getUnionForImplementsClause().getNodeValue() != null)
        {
            this.getUnionForImplementsClause().getNodeValue().receive(visitor);
        }
        if (this.getUnionForBody().getNodeValue() != null)
        {
            this.getUnionForBody().getNodeValue().receive(visitor);
        }
        if (this.getUnionForTypeParameters().getNodeValue() != null)
        {
            this.getUnionForTypeParameters().getNodeValue().receive(visitor);
        }
        if (this.getUnionForIdentifier().getNodeValue() != null)
        {
            this.getUnionForIdentifier().getNodeValue().receive(visitor);
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
        if (this.getUnionForExtendsClause().getNodeValue() != null)
        {
            this.getUnionForExtendsClause().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForImplementsClause().getNodeValue() != null)
        {
            this.getUnionForImplementsClause().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForBody().getNodeValue() != null)
        {
            this.getUnionForBody().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForTypeParameters().getNodeValue() != null)
        {
            this.getUnionForTypeParameters().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForIdentifier().getNodeValue() != null)
        {
            this.getUnionForIdentifier().getNodeValue().receiveTyped(visitor);
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
        list.add(getUnionForExtendsClause());
        list.add(getUnionForImplementsClause());
        list.add(getUnionForTypeParameters());
        list.add(getUnionForIdentifier());
        list.add(getUnionForJavadoc());
        list.add(getUnionForModifiers());
        list.add(getUnionForBody());
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
        sb.append('#');
        sb.append(this.getUid());
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
