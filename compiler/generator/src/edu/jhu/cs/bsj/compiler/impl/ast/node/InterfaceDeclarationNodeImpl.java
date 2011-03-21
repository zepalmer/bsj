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
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.NamedTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PackageNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.InterfaceDeclarationNodeSetBodyPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.InterfaceDeclarationNodeSetExtendsClausePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.InterfaceDeclarationNodeSetIdentifierPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.InterfaceDeclarationNodeSetJavadocPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.InterfaceDeclarationNodeSetModifiersPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.InterfaceDeclarationNodeSetTypeParametersPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.InterfaceDeclarationNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class InterfaceDeclarationNodeImpl extends NodeImpl implements InterfaceDeclarationNode
{
    /** The modifiers for this type. */
    private NodeUnion<? extends InterfaceModifiersNode> modifiers;
    
    /** The extends clause. */
    private NodeUnion<? extends DeclaredTypeListNode> extendsClause;
    
    /** This interface's body. */
    private NodeUnion<? extends InterfaceBodyNode> body;
    
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
    private Set<InterfaceDeclarationNodeProperties> populatedProperties;
    
    /** General constructor. */
    public InterfaceDeclarationNodeImpl(
            NodeUnion<? extends InterfaceModifiersNode> modifiers,
            NodeUnion<? extends DeclaredTypeListNode> extendsClause,
            NodeUnion<? extends InterfaceBodyNode> body,
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
        doSetBody(body);
        doSetTypeParameters(typeParameters);
        doSetIdentifier(identifier);
        doSetJavadoc(javadoc);
    }
    
    /** Proxy constructor. */
    public InterfaceDeclarationNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, InterfaceDeclarationNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(InterfaceDeclarationNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected InterfaceDeclarationNode getBackingNode()
    {
        return (InterfaceDeclarationNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the modifiers value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkModifiersWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                InterfaceDeclarationNodeProperties.MODIFIERS))
            return;
        this.populatedProperties.add(InterfaceDeclarationNodeProperties.MODIFIERS);
        NodeUnion<? extends InterfaceModifiersNode> union = this.getBackingNode().getUnionForModifiers();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeInterfaceModifiersNode(union.getNormalNode()));
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
                InterfaceDeclarationNodeProperties.EXTENDS_CLAUSE))
            return;
        this.populatedProperties.add(InterfaceDeclarationNodeProperties.EXTENDS_CLAUSE);
        NodeUnion<? extends DeclaredTypeListNode> union = this.getBackingNode().getUnionForExtendsClause();
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
        this.extendsClause = union;
    }
    
    /**
     * Ensures that the body value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkBodyWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                InterfaceDeclarationNodeProperties.BODY))
            return;
        this.populatedProperties.add(InterfaceDeclarationNodeProperties.BODY);
        NodeUnion<? extends InterfaceBodyNode> union = this.getBackingNode().getUnionForBody();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeInterfaceBodyNode(union.getNormalNode()));
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
                InterfaceDeclarationNodeProperties.TYPE_PARAMETERS))
            return;
        this.populatedProperties.add(InterfaceDeclarationNodeProperties.TYPE_PARAMETERS);
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
                InterfaceDeclarationNodeProperties.IDENTIFIER))
            return;
        this.populatedProperties.add(InterfaceDeclarationNodeProperties.IDENTIFIER);
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
                InterfaceDeclarationNodeProperties.JAVADOC))
            return;
        this.populatedProperties.add(InterfaceDeclarationNodeProperties.JAVADOC);
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
    public InterfaceModifiersNode getModifiers()
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
    public NodeUnion<? extends InterfaceModifiersNode> getUnionForModifiers()
    {
        checkModifiersWrapped();
        if (this.modifiers == null)
        {
            this.modifiers = new NormalNodeUnion<InterfaceModifiersNode>(null);
        }
        return this.modifiers;
    }
    
    /**
     * Changes the modifiers for this type.
     * @param modifiers The modifiers for this type.
     */
    public void setModifiers(InterfaceModifiersNode modifiers)
    {
        checkModifiersWrapped();
        this.setUnionForModifiers(new NormalNodeUnion<InterfaceModifiersNode>(modifiers));
    }
    
    /**
     * Changes the modifiers for this type.
     * @param modifiers The modifiers for this type.
     */
    public void setUnionForModifiers(NodeUnion<? extends InterfaceModifiersNode> modifiers)
    {
        checkModifiersWrapped();
        this.getManager().assertMutatable(this);
        this.doSetModifiers(modifiers);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new InterfaceDeclarationNodeSetModifiersPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()));
    }
    
    private void doSetModifiers(NodeUnion<? extends InterfaceModifiersNode> modifiers)
    {
        if (modifiers == null)
        {
            modifiers = new NormalNodeUnion<InterfaceModifiersNode>(null);
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
    public DeclaredTypeListNode getExtendsClause()
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
    public NodeUnion<? extends DeclaredTypeListNode> getUnionForExtendsClause()
    {
        checkExtendsClauseWrapped();
        if (this.extendsClause == null)
        {
            this.extendsClause = new NormalNodeUnion<DeclaredTypeListNode>(null);
        }
        return this.extendsClause;
    }
    
    /**
     * Changes the extends clause.
     * @param extendsClause The extends clause.
     */
    public void setExtendsClause(DeclaredTypeListNode extendsClause)
    {
        checkExtendsClauseWrapped();
        this.setUnionForExtendsClause(new NormalNodeUnion<DeclaredTypeListNode>(extendsClause));
    }
    
    /**
     * Changes the extends clause.
     * @param extendsClause The extends clause.
     */
    public void setUnionForExtendsClause(NodeUnion<? extends DeclaredTypeListNode> extendsClause)
    {
        checkExtendsClauseWrapped();
        this.getManager().assertMutatable(this);
        this.doSetExtendsClause(extendsClause);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new InterfaceDeclarationNodeSetExtendsClausePropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), extendsClause.getNodeValue() == null ? null : extendsClause.getNodeValue().getUid()));
    }
    
    private void doSetExtendsClause(NodeUnion<? extends DeclaredTypeListNode> extendsClause)
    {
        if (extendsClause == null)
        {
            extendsClause = new NormalNodeUnion<DeclaredTypeListNode>(null);
        }
        if (this.extendsClause != null)
        {
            setAsChild(this.extendsClause.getNodeValue(), false);
        }
        this.extendsClause = extendsClause;
        setAsChild(extendsClause.getNodeValue(), true);
    }
    
    /**
     * Gets this interface's body.  This property's value is assumed to be a normal node.
     * @return This interface's body.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public InterfaceBodyNode getBody()
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
     * Gets this interface's body.
     * @return This interface's body.
     */
    public NodeUnion<? extends InterfaceBodyNode> getUnionForBody()
    {
        checkBodyWrapped();
        if (this.body == null)
        {
            this.body = new NormalNodeUnion<InterfaceBodyNode>(null);
        }
        return this.body;
    }
    
    /**
     * Changes this interface's body.
     * @param body This interface's body.
     */
    public void setBody(InterfaceBodyNode body)
    {
        checkBodyWrapped();
        this.setUnionForBody(new NormalNodeUnion<InterfaceBodyNode>(body));
    }
    
    /**
     * Changes this interface's body.
     * @param body This interface's body.
     */
    public void setUnionForBody(NodeUnion<? extends InterfaceBodyNode> body)
    {
        checkBodyWrapped();
        this.getManager().assertMutatable(this);
        this.doSetBody(body);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new InterfaceDeclarationNodeSetBodyPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), body.getNodeValue() == null ? null : body.getNodeValue().getUid()));
    }
    
    private void doSetBody(NodeUnion<? extends InterfaceBodyNode> body)
    {
        if (body == null)
        {
            body = new NormalNodeUnion<InterfaceBodyNode>(null);
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
            super.recordEdit(new InterfaceDeclarationNodeSetTypeParametersPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), typeParameters.getNodeValue() == null ? null : typeParameters.getNodeValue().getUid()));
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
            super.recordEdit(new InterfaceDeclarationNodeSetIdentifierPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()));
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
            super.recordEdit(new InterfaceDeclarationNodeSetJavadocPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()));
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
        visitor.visitInterfaceDeclarationNodeStart(this, true);
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
        visitor.visitInterfaceDeclarationNodeStop(this, true);
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
        list.add(getUnionForTypeParameters());
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
        return Arrays.asList(new Node[]{getUnionForModifiers().getNodeValue(), getUnionForExtendsClause().getNodeValue(), getUnionForBody().getNodeValue(), getUnionForTypeParameters().getNodeValue(), getUnionForIdentifier().getNodeValue(), getUnionForJavadoc().getNodeValue()});
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
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P,R,X extends Exception> R executeOperation(BsjAbortableNodeOperation<P,R,X> operation, P p) throws X
    {
        return operation.executeInterfaceDeclarationNode(this, p);
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
        return operation.executeInterfaceDeclarationNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public InterfaceDeclarationNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends InterfaceModifiersNode> modifiersCopy;
        switch (getUnionForModifiers().getType())
        {
            case NORMAL:
                if (getUnionForModifiers().getNormalNode() == null)
                {
                    modifiersCopy = factory.<InterfaceModifiersNode>makeNormalNodeUnion(null);
                } else
                {
                    modifiersCopy = factory.makeNormalNodeUnion(getUnionForModifiers().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForModifiers().getSpliceNode() == null)
                {
                    modifiersCopy = factory.<InterfaceModifiersNode>makeSpliceNodeUnion(null);
                } else
                {
                    modifiersCopy = factory.makeSpliceNodeUnion(getUnionForModifiers().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForModifiers().getType());
        }
        NodeUnion<? extends DeclaredTypeListNode> extendsClauseCopy;
        switch (getUnionForExtendsClause().getType())
        {
            case NORMAL:
                if (getUnionForExtendsClause().getNormalNode() == null)
                {
                    extendsClauseCopy = factory.<DeclaredTypeListNode>makeNormalNodeUnion(null);
                } else
                {
                    extendsClauseCopy = factory.makeNormalNodeUnion(getUnionForExtendsClause().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForExtendsClause().getSpliceNode() == null)
                {
                    extendsClauseCopy = factory.<DeclaredTypeListNode>makeSpliceNodeUnion(null);
                } else
                {
                    extendsClauseCopy = factory.makeSpliceNodeUnion(getUnionForExtendsClause().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForExtendsClause().getType());
        }
        NodeUnion<? extends InterfaceBodyNode> bodyCopy;
        switch (getUnionForBody().getType())
        {
            case NORMAL:
                if (getUnionForBody().getNormalNode() == null)
                {
                    bodyCopy = factory.<InterfaceBodyNode>makeNormalNodeUnion(null);
                } else
                {
                    bodyCopy = factory.makeNormalNodeUnion(getUnionForBody().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForBody().getSpliceNode() == null)
                {
                    bodyCopy = factory.<InterfaceBodyNode>makeSpliceNodeUnion(null);
                } else
                {
                    bodyCopy = factory.makeSpliceNodeUnion(getUnionForBody().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForBody().getType());
        }
        NodeUnion<? extends TypeParameterListNode> typeParametersCopy;
        switch (getUnionForTypeParameters().getType())
        {
            case NORMAL:
                if (getUnionForTypeParameters().getNormalNode() == null)
                {
                    typeParametersCopy = factory.<TypeParameterListNode>makeNormalNodeUnion(null);
                } else
                {
                    typeParametersCopy = factory.makeNormalNodeUnion(getUnionForTypeParameters().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForTypeParameters().getSpliceNode() == null)
                {
                    typeParametersCopy = factory.<TypeParameterListNode>makeSpliceNodeUnion(null);
                } else
                {
                    typeParametersCopy = factory.makeSpliceNodeUnion(getUnionForTypeParameters().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForTypeParameters().getType());
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
        return factory.makeInterfaceDeclarationNodeWithUnions(
                modifiersCopy,
                extendsClauseCopy,
                bodyCopy,
                typeParametersCopy,
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
            setModifiers((InterfaceModifiersNode)after);
            return true;
        }
        if (before.equals(this.getUnionForExtendsClause().getNodeValue()))
        {
            setExtendsClause((DeclaredTypeListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForBody().getNodeValue()))
        {
            setBody((InterfaceBodyNode)after);
            return true;
        }
        if (before.equals(this.getUnionForTypeParameters().getNodeValue()))
        {
            setTypeParameters((TypeParameterListNode)after);
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
