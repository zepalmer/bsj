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
import edu.jhu.cs.bsj.compiler.ast.node.JavadocNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.BlockStatementListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.UnparameterizedTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MethodDeclarationNodeSetBodyPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MethodDeclarationNodeSetIdentifierPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MethodDeclarationNodeSetJavadocPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MethodDeclarationNodeSetModifiersPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MethodDeclarationNodeSetParametersPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MethodDeclarationNodeSetReturnTypePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MethodDeclarationNodeSetThrowTypesPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MethodDeclarationNodeSetTypeParametersPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.MethodDeclarationNodeSetVarargParameterPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.MethodDeclarationNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MethodDeclarationNodeImpl extends NodeImpl implements MethodDeclarationNode
{
    /** The body of this method. */
    private NodeUnion<? extends BlockStatementListNode> body;
    
    /** The modifiers for this method. */
    private NodeUnion<? extends MethodModifiersNode> modifiers;
    
    /** This method's name. */
    private NodeUnion<? extends IdentifierNode> identifier;
    
    /** The parameters declared by this method. */
    private NodeUnion<? extends VariableListNode> parameters;
    
    /** The vararg parameter declared by this method. */
    private NodeUnion<? extends VariableNode> varargParameter;
    
    /** The type of value returned. */
    private NodeUnion<? extends TypeNode> returnType;
    
    /** The types of exceptions thrown by this method. */
    private NodeUnion<? extends UnparameterizedTypeListNode> throwTypes;
    
    /** This method's applicable type parameters. */
    private NodeUnion<? extends TypeParameterListNode> typeParameters;
    
    /** The associated javadoc comment for this node. */
    private NodeUnion<? extends JavadocNode> javadoc;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<MethodDeclarationNodeProperties> populatedProperties;
    
    /** General constructor. */
    public MethodDeclarationNodeImpl(
            NodeUnion<? extends BlockStatementListNode> body,
            NodeUnion<? extends MethodModifiersNode> modifiers,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends VariableListNode> parameters,
            NodeUnion<? extends VariableNode> varargParameter,
            NodeUnion<? extends TypeNode> returnType,
            NodeUnion<? extends UnparameterizedTypeListNode> throwTypes,
            NodeUnion<? extends TypeParameterListNode> typeParameters,
            NodeUnion<? extends JavadocNode> javadoc,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetBody(body);
        doSetModifiers(modifiers);
        doSetIdentifier(identifier);
        doSetParameters(parameters);
        doSetVarargParameter(varargParameter);
        doSetReturnType(returnType);
        doSetThrowTypes(throwTypes);
        doSetTypeParameters(typeParameters);
        doSetJavadoc(javadoc);
    }
    
    /** Proxy constructor. */
    public MethodDeclarationNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, MethodDeclarationNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(MethodDeclarationNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected MethodDeclarationNode getBackingNode()
    {
        return (MethodDeclarationNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the body value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkBodyWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MethodDeclarationNodeProperties.BODY))
            return;
        this.populatedProperties.add(MethodDeclarationNodeProperties.BODY);
        NodeUnion<? extends BlockStatementListNode> union = this.getBackingNode().getUnionForBody();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeBlockStatementListNode(union.getNormalNode()));
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
     * Ensures that the modifiers value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkModifiersWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MethodDeclarationNodeProperties.MODIFIERS))
            return;
        this.populatedProperties.add(MethodDeclarationNodeProperties.MODIFIERS);
        NodeUnion<? extends MethodModifiersNode> union = this.getBackingNode().getUnionForModifiers();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeMethodModifiersNode(union.getNormalNode()));
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
     * Ensures that the identifier value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkIdentifierWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MethodDeclarationNodeProperties.IDENTIFIER))
            return;
        this.populatedProperties.add(MethodDeclarationNodeProperties.IDENTIFIER);
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
     * Ensures that the parameters value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkParametersWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MethodDeclarationNodeProperties.PARAMETERS))
            return;
        this.populatedProperties.add(MethodDeclarationNodeProperties.PARAMETERS);
        NodeUnion<? extends VariableListNode> union = this.getBackingNode().getUnionForParameters();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeVariableListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.parameters = union;
    }
    
    /**
     * Ensures that the varargParameter value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkVarargParameterWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MethodDeclarationNodeProperties.VARARG_PARAMETER))
            return;
        this.populatedProperties.add(MethodDeclarationNodeProperties.VARARG_PARAMETER);
        NodeUnion<? extends VariableNode> union = this.getBackingNode().getUnionForVarargParameter();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeVariableNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.varargParameter = union;
    }
    
    /**
     * Ensures that the returnType value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkReturnTypeWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MethodDeclarationNodeProperties.RETURN_TYPE))
            return;
        this.populatedProperties.add(MethodDeclarationNodeProperties.RETURN_TYPE);
        NodeUnion<? extends TypeNode> union = this.getBackingNode().getUnionForReturnType();
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
        this.returnType = union;
    }
    
    /**
     * Ensures that the throwTypes value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkThrowTypesWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MethodDeclarationNodeProperties.THROW_TYPES))
            return;
        this.populatedProperties.add(MethodDeclarationNodeProperties.THROW_TYPES);
        NodeUnion<? extends UnparameterizedTypeListNode> union = this.getBackingNode().getUnionForThrowTypes();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeUnparameterizedTypeListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.throwTypes = union;
    }
    
    /**
     * Ensures that the typeParameters value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkTypeParametersWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MethodDeclarationNodeProperties.TYPE_PARAMETERS))
            return;
        this.populatedProperties.add(MethodDeclarationNodeProperties.TYPE_PARAMETERS);
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
     * Ensures that the javadoc value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkJavadocWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                MethodDeclarationNodeProperties.JAVADOC))
            return;
        this.populatedProperties.add(MethodDeclarationNodeProperties.JAVADOC);
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
     * Gets the body of this method.  This property's value is assumed to be a normal node.
     * @return The body of this method.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public BlockStatementListNode getBody()
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
     * Gets the body of this method.
     * @return The body of this method.
     */
    public NodeUnion<? extends BlockStatementListNode> getUnionForBody()
    {
        checkBodyWrapped();
        if (this.body == null)
        {
            this.body = new NormalNodeUnion<BlockStatementListNode>(null);
        }
        return this.body;
    }
    
    /**
     * Changes the body of this method.
     * @param body The body of this method.
     */
    public void setBody(BlockStatementListNode body)
    {
        checkBodyWrapped();
        this.setUnionForBody(new NormalNodeUnion<BlockStatementListNode>(body));
    }
    
    /**
     * Changes the body of this method.
     * @param body The body of this method.
     */
    public void setUnionForBody(NodeUnion<? extends BlockStatementListNode> body)
    {
        checkBodyWrapped();
        this.getManager().assertMutatable(this);
        this.doSetBody(body);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MethodDeclarationNodeSetBodyPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), body.getNodeValue() == null ? null : body.getNodeValue().getUid()));
    }
    
    private void doSetBody(NodeUnion<? extends BlockStatementListNode> body)
    {
        if (body == null)
        {
            body = new NormalNodeUnion<BlockStatementListNode>(null);
        }
        if (this.body != null)
        {
            setAsChild(this.body.getNodeValue(), false);
        }
        this.body = body;
        setAsChild(body.getNodeValue(), true);
    }
    
    /**
     * Gets the modifiers for this method.  This property's value is assumed to be a normal node.
     * @return The modifiers for this method.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public MethodModifiersNode getModifiers()
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
     * Gets the modifiers for this method.
     * @return The modifiers for this method.
     */
    public NodeUnion<? extends MethodModifiersNode> getUnionForModifiers()
    {
        checkModifiersWrapped();
        if (this.modifiers == null)
        {
            this.modifiers = new NormalNodeUnion<MethodModifiersNode>(null);
        }
        return this.modifiers;
    }
    
    /**
     * Changes the modifiers for this method.
     * @param modifiers The modifiers for this method.
     */
    public void setModifiers(MethodModifiersNode modifiers)
    {
        checkModifiersWrapped();
        this.setUnionForModifiers(new NormalNodeUnion<MethodModifiersNode>(modifiers));
    }
    
    /**
     * Changes the modifiers for this method.
     * @param modifiers The modifiers for this method.
     */
    public void setUnionForModifiers(NodeUnion<? extends MethodModifiersNode> modifiers)
    {
        checkModifiersWrapped();
        this.getManager().assertMutatable(this);
        this.doSetModifiers(modifiers);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MethodDeclarationNodeSetModifiersPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), modifiers.getNodeValue() == null ? null : modifiers.getNodeValue().getUid()));
    }
    
    private void doSetModifiers(NodeUnion<? extends MethodModifiersNode> modifiers)
    {
        if (modifiers == null)
        {
            modifiers = new NormalNodeUnion<MethodModifiersNode>(null);
        }
        if (this.modifiers != null)
        {
            setAsChild(this.modifiers.getNodeValue(), false);
        }
        this.modifiers = modifiers;
        setAsChild(modifiers.getNodeValue(), true);
    }
    
    /**
     * Gets this method's name.  This property's value is assumed to be a normal node.
     * @return This method's name.
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
     * Gets this method's name.
     * @return This method's name.
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
     * Changes this method's name.
     * @param identifier This method's name.
     */
    public void setIdentifier(IdentifierNode identifier)
    {
        checkIdentifierWrapped();
        this.setUnionForIdentifier(new NormalNodeUnion<IdentifierNode>(identifier));
    }
    
    /**
     * Changes this method's name.
     * @param identifier This method's name.
     */
    public void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier)
    {
        checkIdentifierWrapped();
        this.getManager().assertMutatable(this);
        this.doSetIdentifier(identifier);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MethodDeclarationNodeSetIdentifierPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()));
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
     * Gets the parameters declared by this method.  This property's value is assumed to be a normal node.
     * @return The parameters declared by this method.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public VariableListNode getParameters()
    {
        checkParametersWrapped();
        if (this.parameters == null)
        {
            return null;
        } else
        {
            return this.parameters.getNormalNode();
        }
    }
    
    /**
     * Gets the parameters declared by this method.
     * @return The parameters declared by this method.
     */
    public NodeUnion<? extends VariableListNode> getUnionForParameters()
    {
        checkParametersWrapped();
        if (this.parameters == null)
        {
            this.parameters = new NormalNodeUnion<VariableListNode>(null);
        }
        return this.parameters;
    }
    
    /**
     * Changes the parameters declared by this method.
     * @param parameters The parameters declared by this method.
     */
    public void setParameters(VariableListNode parameters)
    {
        checkParametersWrapped();
        this.setUnionForParameters(new NormalNodeUnion<VariableListNode>(parameters));
    }
    
    /**
     * Changes the parameters declared by this method.
     * @param parameters The parameters declared by this method.
     */
    public void setUnionForParameters(NodeUnion<? extends VariableListNode> parameters)
    {
        checkParametersWrapped();
        this.getManager().assertMutatable(this);
        this.doSetParameters(parameters);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MethodDeclarationNodeSetParametersPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), parameters.getNodeValue() == null ? null : parameters.getNodeValue().getUid()));
    }
    
    private void doSetParameters(NodeUnion<? extends VariableListNode> parameters)
    {
        if (parameters == null)
        {
            parameters = new NormalNodeUnion<VariableListNode>(null);
        }
        if (this.parameters != null)
        {
            setAsChild(this.parameters.getNodeValue(), false);
        }
        this.parameters = parameters;
        setAsChild(parameters.getNodeValue(), true);
    }
    
    /**
     * Gets the vararg parameter declared by this method.  This property's value is assumed to be a normal node.
     * @return The vararg parameter declared by this method.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public VariableNode getVarargParameter()
    {
        checkVarargParameterWrapped();
        if (this.varargParameter == null)
        {
            return null;
        } else
        {
            return this.varargParameter.getNormalNode();
        }
    }
    
    /**
     * Gets the vararg parameter declared by this method.
     * @return The vararg parameter declared by this method.
     */
    public NodeUnion<? extends VariableNode> getUnionForVarargParameter()
    {
        checkVarargParameterWrapped();
        if (this.varargParameter == null)
        {
            this.varargParameter = new NormalNodeUnion<VariableNode>(null);
        }
        return this.varargParameter;
    }
    
    /**
     * Changes the vararg parameter declared by this method.
     * @param varargParameter The vararg parameter declared by this method.
     */
    public void setVarargParameter(VariableNode varargParameter)
    {
        checkVarargParameterWrapped();
        this.setUnionForVarargParameter(new NormalNodeUnion<VariableNode>(varargParameter));
    }
    
    /**
     * Changes the vararg parameter declared by this method.
     * @param varargParameter The vararg parameter declared by this method.
     */
    public void setUnionForVarargParameter(NodeUnion<? extends VariableNode> varargParameter)
    {
        checkVarargParameterWrapped();
        this.getManager().assertMutatable(this);
        this.doSetVarargParameter(varargParameter);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MethodDeclarationNodeSetVarargParameterPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), varargParameter.getNodeValue() == null ? null : varargParameter.getNodeValue().getUid()));
    }
    
    private void doSetVarargParameter(NodeUnion<? extends VariableNode> varargParameter)
    {
        if (varargParameter == null)
        {
            varargParameter = new NormalNodeUnion<VariableNode>(null);
        }
        if (this.varargParameter != null)
        {
            setAsChild(this.varargParameter.getNodeValue(), false);
        }
        this.varargParameter = varargParameter;
        setAsChild(varargParameter.getNodeValue(), true);
    }
    
    /**
     * Gets the type of value returned.  This property's value is assumed to be a normal node.
     * @return The type of value returned.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public TypeNode getReturnType()
    {
        checkReturnTypeWrapped();
        if (this.returnType == null)
        {
            return null;
        } else
        {
            return this.returnType.getNormalNode();
        }
    }
    
    /**
     * Gets the type of value returned.
     * @return The type of value returned.
     */
    public NodeUnion<? extends TypeNode> getUnionForReturnType()
    {
        checkReturnTypeWrapped();
        if (this.returnType == null)
        {
            this.returnType = new NormalNodeUnion<TypeNode>(null);
        }
        return this.returnType;
    }
    
    /**
     * Changes the type of value returned.
     * @param returnType The type of value returned.
     */
    public void setReturnType(TypeNode returnType)
    {
        checkReturnTypeWrapped();
        this.setUnionForReturnType(new NormalNodeUnion<TypeNode>(returnType));
    }
    
    /**
     * Changes the type of value returned.
     * @param returnType The type of value returned.
     */
    public void setUnionForReturnType(NodeUnion<? extends TypeNode> returnType)
    {
        checkReturnTypeWrapped();
        this.getManager().assertMutatable(this);
        this.doSetReturnType(returnType);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MethodDeclarationNodeSetReturnTypePropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), returnType.getNodeValue() == null ? null : returnType.getNodeValue().getUid()));
    }
    
    private void doSetReturnType(NodeUnion<? extends TypeNode> returnType)
    {
        if (returnType == null)
        {
            returnType = new NormalNodeUnion<TypeNode>(null);
        }
        if (this.returnType != null)
        {
            setAsChild(this.returnType.getNodeValue(), false);
        }
        this.returnType = returnType;
        setAsChild(returnType.getNodeValue(), true);
    }
    
    /**
     * Gets the types of exceptions thrown by this method.  This property's value is assumed to be a normal node.
     * @return The types of exceptions thrown by this method.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public UnparameterizedTypeListNode getThrowTypes()
    {
        checkThrowTypesWrapped();
        if (this.throwTypes == null)
        {
            return null;
        } else
        {
            return this.throwTypes.getNormalNode();
        }
    }
    
    /**
     * Gets the types of exceptions thrown by this method.
     * @return The types of exceptions thrown by this method.
     */
    public NodeUnion<? extends UnparameterizedTypeListNode> getUnionForThrowTypes()
    {
        checkThrowTypesWrapped();
        if (this.throwTypes == null)
        {
            this.throwTypes = new NormalNodeUnion<UnparameterizedTypeListNode>(null);
        }
        return this.throwTypes;
    }
    
    /**
     * Changes the types of exceptions thrown by this method.
     * @param throwTypes The types of exceptions thrown by this method.
     */
    public void setThrowTypes(UnparameterizedTypeListNode throwTypes)
    {
        checkThrowTypesWrapped();
        this.setUnionForThrowTypes(new NormalNodeUnion<UnparameterizedTypeListNode>(throwTypes));
    }
    
    /**
     * Changes the types of exceptions thrown by this method.
     * @param throwTypes The types of exceptions thrown by this method.
     */
    public void setUnionForThrowTypes(NodeUnion<? extends UnparameterizedTypeListNode> throwTypes)
    {
        checkThrowTypesWrapped();
        this.getManager().assertMutatable(this);
        this.doSetThrowTypes(throwTypes);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MethodDeclarationNodeSetThrowTypesPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), throwTypes.getNodeValue() == null ? null : throwTypes.getNodeValue().getUid()));
    }
    
    private void doSetThrowTypes(NodeUnion<? extends UnparameterizedTypeListNode> throwTypes)
    {
        if (throwTypes == null)
        {
            throwTypes = new NormalNodeUnion<UnparameterizedTypeListNode>(null);
        }
        if (this.throwTypes != null)
        {
            setAsChild(this.throwTypes.getNodeValue(), false);
        }
        this.throwTypes = throwTypes;
        setAsChild(throwTypes.getNodeValue(), true);
    }
    
    /**
     * Gets this method's applicable type parameters.  This property's value is assumed to be a normal node.
     * @return This method's applicable type parameters.
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
     * Gets this method's applicable type parameters.
     * @return This method's applicable type parameters.
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
     * Changes this method's applicable type parameters.
     * @param typeParameters This method's applicable type parameters.
     */
    public void setTypeParameters(TypeParameterListNode typeParameters)
    {
        checkTypeParametersWrapped();
        this.setUnionForTypeParameters(new NormalNodeUnion<TypeParameterListNode>(typeParameters));
    }
    
    /**
     * Changes this method's applicable type parameters.
     * @param typeParameters This method's applicable type parameters.
     */
    public void setUnionForTypeParameters(NodeUnion<? extends TypeParameterListNode> typeParameters)
    {
        checkTypeParametersWrapped();
        this.getManager().assertMutatable(this);
        this.doSetTypeParameters(typeParameters);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new MethodDeclarationNodeSetTypeParametersPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), typeParameters.getNodeValue() == null ? null : typeParameters.getNodeValue().getUid()));
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
            super.recordEdit(new MethodDeclarationNodeSetJavadocPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), javadoc.getNodeValue() == null ? null : javadoc.getNodeValue().getUid()));
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
        if (this.getUnionForBody().getNodeValue() != null)
        {
            this.getUnionForBody().getNodeValue().receive(visitor);
        }
        if (this.getUnionForModifiers().getNodeValue() != null)
        {
            this.getUnionForModifiers().getNodeValue().receive(visitor);
        }
        if (this.getUnionForIdentifier().getNodeValue() != null)
        {
            this.getUnionForIdentifier().getNodeValue().receive(visitor);
        }
        if (this.getUnionForParameters().getNodeValue() != null)
        {
            this.getUnionForParameters().getNodeValue().receive(visitor);
        }
        if (this.getUnionForVarargParameter().getNodeValue() != null)
        {
            this.getUnionForVarargParameter().getNodeValue().receive(visitor);
        }
        if (this.getUnionForReturnType().getNodeValue() != null)
        {
            this.getUnionForReturnType().getNodeValue().receive(visitor);
        }
        if (this.getUnionForThrowTypes().getNodeValue() != null)
        {
            this.getUnionForThrowTypes().getNodeValue().receive(visitor);
        }
        if (this.getUnionForTypeParameters().getNodeValue() != null)
        {
            this.getUnionForTypeParameters().getNodeValue().receive(visitor);
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
        if (this.getUnionForBody().getNodeValue() != null)
        {
            this.getUnionForBody().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForModifiers().getNodeValue() != null)
        {
            this.getUnionForModifiers().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForIdentifier().getNodeValue() != null)
        {
            this.getUnionForIdentifier().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForParameters().getNodeValue() != null)
        {
            this.getUnionForParameters().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForVarargParameter().getNodeValue() != null)
        {
            this.getUnionForVarargParameter().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForReturnType().getNodeValue() != null)
        {
            this.getUnionForReturnType().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForThrowTypes().getNodeValue() != null)
        {
            this.getUnionForThrowTypes().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForTypeParameters().getNodeValue() != null)
        {
            this.getUnionForTypeParameters().getNodeValue().receiveTyped(visitor);
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
        visitor.visitMethodDeclarationNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitInterfaceMemberNodeStart(this);
        visitor.visitAnonymousClassMemberNodeStart(this);
        visitor.visitAbstractInvokableDeclarationNodeStart(this);
        visitor.visitInvokableNameBindingNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitInterfaceMemberNodeStop(this);
        visitor.visitAnonymousClassMemberNodeStop(this);
        visitor.visitAbstractInvokableDeclarationNodeStop(this);
        visitor.visitInvokableNameBindingNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitMethodDeclarationNodeStop(this, true);
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
        list.add(getUnionForBody());
        list.add(getUnionForReturnType());
        list.add(getUnionForIdentifier());
        list.add(getUnionForParameters());
        list.add(getUnionForVarargParameter());
        list.add(getUnionForThrowTypes());
        list.add(getUnionForTypeParameters());
        list.add(getUnionForJavadoc());
        list.add(getUnionForModifiers());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForBody().getNodeValue(), getUnionForModifiers().getNodeValue(), getUnionForIdentifier().getNodeValue(), getUnionForParameters().getNodeValue(), getUnionForVarargParameter().getNodeValue(), getUnionForReturnType().getNodeValue(), getUnionForThrowTypes().getNodeValue(), getUnionForTypeParameters().getNodeValue(), getUnionForJavadoc().getNodeValue()});
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
        sb.append("body=");
        sb.append(this.getUnionForBody().getNodeValue() == null? "null" : this.getUnionForBody().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("modifiers=");
        sb.append(this.getUnionForModifiers().getNodeValue() == null? "null" : this.getUnionForModifiers().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("identifier=");
        sb.append(this.getUnionForIdentifier().getNodeValue() == null? "null" : this.getUnionForIdentifier().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("parameters=");
        sb.append(this.getUnionForParameters().getNodeValue() == null? "null" : this.getUnionForParameters().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("varargParameter=");
        sb.append(this.getUnionForVarargParameter().getNodeValue() == null? "null" : this.getUnionForVarargParameter().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("returnType=");
        sb.append(this.getUnionForReturnType().getNodeValue() == null? "null" : this.getUnionForReturnType().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("throwTypes=");
        sb.append(this.getUnionForThrowTypes().getNodeValue() == null? "null" : this.getUnionForThrowTypes().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("typeParameters=");
        sb.append(this.getUnionForTypeParameters().getNodeValue() == null? "null" : this.getUnionForTypeParameters().getNodeValue().getClass().getSimpleName());
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
        return operation.executeMethodDeclarationNode(this, p);
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
        return operation.executeMethodDeclarationNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MethodDeclarationNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends BlockStatementListNode> bodyCopy;
        switch (getUnionForBody().getType())
        {
            case NORMAL:
                if (getUnionForBody().getNormalNode() == null)
                {
                    bodyCopy = factory.<BlockStatementListNode>makeNormalNodeUnion(null);
                } else
                {
                    bodyCopy = factory.makeNormalNodeUnion(getUnionForBody().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForBody().getSpliceNode() == null)
                {
                    bodyCopy = factory.<BlockStatementListNode>makeSpliceNodeUnion(null);
                } else
                {
                    bodyCopy = factory.makeSpliceNodeUnion(getUnionForBody().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForBody().getType());
        }
        NodeUnion<? extends MethodModifiersNode> modifiersCopy;
        switch (getUnionForModifiers().getType())
        {
            case NORMAL:
                if (getUnionForModifiers().getNormalNode() == null)
                {
                    modifiersCopy = factory.<MethodModifiersNode>makeNormalNodeUnion(null);
                } else
                {
                    modifiersCopy = factory.makeNormalNodeUnion(getUnionForModifiers().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForModifiers().getSpliceNode() == null)
                {
                    modifiersCopy = factory.<MethodModifiersNode>makeSpliceNodeUnion(null);
                } else
                {
                    modifiersCopy = factory.makeSpliceNodeUnion(getUnionForModifiers().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForModifiers().getType());
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
        NodeUnion<? extends VariableListNode> parametersCopy;
        switch (getUnionForParameters().getType())
        {
            case NORMAL:
                if (getUnionForParameters().getNormalNode() == null)
                {
                    parametersCopy = factory.<VariableListNode>makeNormalNodeUnion(null);
                } else
                {
                    parametersCopy = factory.makeNormalNodeUnion(getUnionForParameters().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForParameters().getSpliceNode() == null)
                {
                    parametersCopy = factory.<VariableListNode>makeSpliceNodeUnion(null);
                } else
                {
                    parametersCopy = factory.makeSpliceNodeUnion(getUnionForParameters().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForParameters().getType());
        }
        NodeUnion<? extends VariableNode> varargParameterCopy;
        switch (getUnionForVarargParameter().getType())
        {
            case NORMAL:
                if (getUnionForVarargParameter().getNormalNode() == null)
                {
                    varargParameterCopy = factory.<VariableNode>makeNormalNodeUnion(null);
                } else
                {
                    varargParameterCopy = factory.makeNormalNodeUnion(getUnionForVarargParameter().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForVarargParameter().getSpliceNode() == null)
                {
                    varargParameterCopy = factory.<VariableNode>makeSpliceNodeUnion(null);
                } else
                {
                    varargParameterCopy = factory.makeSpliceNodeUnion(getUnionForVarargParameter().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForVarargParameter().getType());
        }
        NodeUnion<? extends TypeNode> returnTypeCopy;
        switch (getUnionForReturnType().getType())
        {
            case NORMAL:
                if (getUnionForReturnType().getNormalNode() == null)
                {
                    returnTypeCopy = factory.<TypeNode>makeNormalNodeUnion(null);
                } else
                {
                    returnTypeCopy = factory.makeNormalNodeUnion(getUnionForReturnType().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForReturnType().getSpliceNode() == null)
                {
                    returnTypeCopy = factory.<TypeNode>makeSpliceNodeUnion(null);
                } else
                {
                    returnTypeCopy = factory.makeSpliceNodeUnion(getUnionForReturnType().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForReturnType().getType());
        }
        NodeUnion<? extends UnparameterizedTypeListNode> throwTypesCopy;
        switch (getUnionForThrowTypes().getType())
        {
            case NORMAL:
                if (getUnionForThrowTypes().getNormalNode() == null)
                {
                    throwTypesCopy = factory.<UnparameterizedTypeListNode>makeNormalNodeUnion(null);
                } else
                {
                    throwTypesCopy = factory.makeNormalNodeUnion(getUnionForThrowTypes().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForThrowTypes().getSpliceNode() == null)
                {
                    throwTypesCopy = factory.<UnparameterizedTypeListNode>makeSpliceNodeUnion(null);
                } else
                {
                    throwTypesCopy = factory.makeSpliceNodeUnion(getUnionForThrowTypes().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForThrowTypes().getType());
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
        return factory.makeMethodDeclarationNodeWithUnions(
                bodyCopy,
                modifiersCopy,
                identifierCopy,
                parametersCopy,
                varargParameterCopy,
                returnTypeCopy,
                throwTypesCopy,
                typeParametersCopy,
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
        
        if (before.equals(this.getUnionForBody().getNodeValue()))
        {
            setBody((BlockStatementListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForModifiers().getNodeValue()))
        {
            setModifiers((MethodModifiersNode)after);
            return true;
        }
        if (before.equals(this.getUnionForIdentifier().getNodeValue()))
        {
            setIdentifier((IdentifierNode)after);
            return true;
        }
        if (before.equals(this.getUnionForParameters().getNodeValue()))
        {
            setParameters((VariableListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForVarargParameter().getNodeValue()))
        {
            setVarargParameter((VariableNode)after);
            return true;
        }
        if (before.equals(this.getUnionForReturnType().getNodeValue()))
        {
            setReturnType((TypeNode)after);
            return true;
        }
        if (before.equals(this.getUnionForThrowTypes().getNodeValue()))
        {
            setThrowTypes((UnparameterizedTypeListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForTypeParameters().getNodeValue()))
        {
            setTypeParameters((TypeParameterListNode)after);
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
