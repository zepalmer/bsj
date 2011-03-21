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
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.SuperMethodInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ReferenceTypeListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.SuperMethodInvocationNodeSetArgumentsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.SuperMethodInvocationNodeSetIdentifierPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.SuperMethodInvocationNodeSetTypeArgumentsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.SuperMethodInvocationNodeSetTypePropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.SuperMethodInvocationNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class SuperMethodInvocationNodeImpl extends NodeImpl implements SuperMethodInvocationNode
{
    /** The qualifying type. */
    private NodeUnion<? extends UnparameterizedTypeNode> type;
    
    /** The identifier of the method being invoked. */
    private NodeUnion<? extends IdentifierNode> identifier;
    
    /** The arguments to pass to the method. */
    private NodeUnion<? extends ExpressionListNode> arguments;
    
    /** The type arguments for the method. */
    private NodeUnion<? extends ReferenceTypeListNode> typeArguments;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<SuperMethodInvocationNodeProperties> populatedProperties;
    
    /** General constructor. */
    public SuperMethodInvocationNodeImpl(
            NodeUnion<? extends UnparameterizedTypeNode> type,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends ExpressionListNode> arguments,
            NodeUnion<? extends ReferenceTypeListNode> typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetType(type);
        doSetIdentifier(identifier);
        doSetArguments(arguments);
        doSetTypeArguments(typeArguments);
    }
    
    /** Proxy constructor. */
    public SuperMethodInvocationNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, SuperMethodInvocationNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(SuperMethodInvocationNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected SuperMethodInvocationNode getBackingNode()
    {
        return (SuperMethodInvocationNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the type value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkTypeWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                SuperMethodInvocationNodeProperties.TYPE))
            return;
        this.populatedProperties.add(SuperMethodInvocationNodeProperties.TYPE);
        NodeUnion<? extends UnparameterizedTypeNode> union = this.getBackingNode().getUnionForType();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeUnparameterizedTypeNode(union.getNormalNode()));
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
     * Ensures that the identifier value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkIdentifierWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                SuperMethodInvocationNodeProperties.IDENTIFIER))
            return;
        this.populatedProperties.add(SuperMethodInvocationNodeProperties.IDENTIFIER);
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
     * Ensures that the arguments value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkArgumentsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                SuperMethodInvocationNodeProperties.ARGUMENTS))
            return;
        this.populatedProperties.add(SuperMethodInvocationNodeProperties.ARGUMENTS);
        NodeUnion<? extends ExpressionListNode> union = this.getBackingNode().getUnionForArguments();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeExpressionListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.arguments = union;
    }
    
    /**
     * Ensures that the typeArguments value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkTypeArgumentsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                SuperMethodInvocationNodeProperties.TYPE_ARGUMENTS))
            return;
        this.populatedProperties.add(SuperMethodInvocationNodeProperties.TYPE_ARGUMENTS);
        NodeUnion<? extends ReferenceTypeListNode> union = this.getBackingNode().getUnionForTypeArguments();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeReferenceTypeListNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.typeArguments = union;
    }
    
    /**
     * Gets the qualifying type.  This property's value is assumed to be a normal node.
     * @return The qualifying type.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public UnparameterizedTypeNode getType()
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
     * Gets the qualifying type.
     * @return The qualifying type.
     */
    public NodeUnion<? extends UnparameterizedTypeNode> getUnionForType()
    {
        checkTypeWrapped();
        if (this.type == null)
        {
            this.type = new NormalNodeUnion<UnparameterizedTypeNode>(null);
        }
        return this.type;
    }
    
    /**
     * Changes the qualifying type.
     * @param type The qualifying type.
     */
    public void setType(UnparameterizedTypeNode type)
    {
        checkTypeWrapped();
        this.setUnionForType(new NormalNodeUnion<UnparameterizedTypeNode>(type));
    }
    
    /**
     * Changes the qualifying type.
     * @param type The qualifying type.
     */
    public void setUnionForType(NodeUnion<? extends UnparameterizedTypeNode> type)
    {
        checkTypeWrapped();
        this.getManager().assertMutatable(this);
        this.doSetType(type);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new SuperMethodInvocationNodeSetTypePropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), type.getNodeValue() == null ? null : type.getNodeValue().getUid()));
    }
    
    private void doSetType(NodeUnion<? extends UnparameterizedTypeNode> type)
    {
        if (type == null)
        {
            type = new NormalNodeUnion<UnparameterizedTypeNode>(null);
        }
        if (this.type != null)
        {
            setAsChild(this.type.getNodeValue(), false);
        }
        this.type = type;
        setAsChild(type.getNodeValue(), true);
    }
    
    /**
     * Gets the identifier of the method being invoked.  This property's value is assumed to be a normal node.
     * @return The identifier of the method being invoked.
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
     * Gets the identifier of the method being invoked.
     * @return The identifier of the method being invoked.
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
     * Changes the identifier of the method being invoked.
     * @param identifier The identifier of the method being invoked.
     */
    public void setIdentifier(IdentifierNode identifier)
    {
        checkIdentifierWrapped();
        this.setUnionForIdentifier(new NormalNodeUnion<IdentifierNode>(identifier));
    }
    
    /**
     * Changes the identifier of the method being invoked.
     * @param identifier The identifier of the method being invoked.
     */
    public void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier)
    {
        checkIdentifierWrapped();
        this.getManager().assertMutatable(this);
        this.doSetIdentifier(identifier);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new SuperMethodInvocationNodeSetIdentifierPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()));
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
     * Gets the arguments to pass to the method.  This property's value is assumed to be a normal node.
     * @return The arguments to pass to the method.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ExpressionListNode getArguments()
    {
        checkArgumentsWrapped();
        if (this.arguments == null)
        {
            return null;
        } else
        {
            return this.arguments.getNormalNode();
        }
    }
    
    /**
     * Gets the arguments to pass to the method.
     * @return The arguments to pass to the method.
     */
    public NodeUnion<? extends ExpressionListNode> getUnionForArguments()
    {
        checkArgumentsWrapped();
        if (this.arguments == null)
        {
            this.arguments = new NormalNodeUnion<ExpressionListNode>(null);
        }
        return this.arguments;
    }
    
    /**
     * Changes the arguments to pass to the method.
     * @param arguments The arguments to pass to the method.
     */
    public void setArguments(ExpressionListNode arguments)
    {
        checkArgumentsWrapped();
        this.setUnionForArguments(new NormalNodeUnion<ExpressionListNode>(arguments));
    }
    
    /**
     * Changes the arguments to pass to the method.
     * @param arguments The arguments to pass to the method.
     */
    public void setUnionForArguments(NodeUnion<? extends ExpressionListNode> arguments)
    {
        checkArgumentsWrapped();
        this.getManager().assertMutatable(this);
        this.doSetArguments(arguments);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new SuperMethodInvocationNodeSetArgumentsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), arguments.getNodeValue() == null ? null : arguments.getNodeValue().getUid()));
    }
    
    private void doSetArguments(NodeUnion<? extends ExpressionListNode> arguments)
    {
        if (arguments == null)
        {
            arguments = new NormalNodeUnion<ExpressionListNode>(null);
        }
        if (this.arguments != null)
        {
            setAsChild(this.arguments.getNodeValue(), false);
        }
        this.arguments = arguments;
        setAsChild(arguments.getNodeValue(), true);
    }
    
    /**
     * Gets the type arguments for the method.  This property's value is assumed to be a normal node.
     * @return The type arguments for the method.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ReferenceTypeListNode getTypeArguments()
    {
        checkTypeArgumentsWrapped();
        if (this.typeArguments == null)
        {
            return null;
        } else
        {
            return this.typeArguments.getNormalNode();
        }
    }
    
    /**
     * Gets the type arguments for the method.
     * @return The type arguments for the method.
     */
    public NodeUnion<? extends ReferenceTypeListNode> getUnionForTypeArguments()
    {
        checkTypeArgumentsWrapped();
        if (this.typeArguments == null)
        {
            this.typeArguments = new NormalNodeUnion<ReferenceTypeListNode>(null);
        }
        return this.typeArguments;
    }
    
    /**
     * Changes the type arguments for the method.
     * @param typeArguments The type arguments for the method.
     */
    public void setTypeArguments(ReferenceTypeListNode typeArguments)
    {
        checkTypeArgumentsWrapped();
        this.setUnionForTypeArguments(new NormalNodeUnion<ReferenceTypeListNode>(typeArguments));
    }
    
    /**
     * Changes the type arguments for the method.
     * @param typeArguments The type arguments for the method.
     */
    public void setUnionForTypeArguments(NodeUnion<? extends ReferenceTypeListNode> typeArguments)
    {
        checkTypeArgumentsWrapped();
        this.getManager().assertMutatable(this);
        this.doSetTypeArguments(typeArguments);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new SuperMethodInvocationNodeSetTypeArgumentsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), typeArguments.getNodeValue() == null ? null : typeArguments.getNodeValue().getUid()));
    }
    
    private void doSetTypeArguments(NodeUnion<? extends ReferenceTypeListNode> typeArguments)
    {
        if (typeArguments == null)
        {
            typeArguments = new NormalNodeUnion<ReferenceTypeListNode>(null);
        }
        if (this.typeArguments != null)
        {
            setAsChild(this.typeArguments.getNodeValue(), false);
        }
        this.typeArguments = typeArguments;
        setAsChild(typeArguments.getNodeValue(), true);
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
        if (this.getUnionForType().getNodeValue() != null)
        {
            this.getUnionForType().getNodeValue().receive(visitor);
        }
        if (this.getUnionForIdentifier().getNodeValue() != null)
        {
            this.getUnionForIdentifier().getNodeValue().receive(visitor);
        }
        if (this.getUnionForArguments().getNodeValue() != null)
        {
            this.getUnionForArguments().getNodeValue().receive(visitor);
        }
        if (this.getUnionForTypeArguments().getNodeValue() != null)
        {
            this.getUnionForTypeArguments().getNodeValue().receive(visitor);
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
        if (this.getUnionForType().getNodeValue() != null)
        {
            this.getUnionForType().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForIdentifier().getNodeValue() != null)
        {
            this.getUnionForIdentifier().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForArguments().getNodeValue() != null)
        {
            this.getUnionForArguments().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForTypeArguments().getNodeValue() != null)
        {
            this.getUnionForTypeArguments().getNodeValue().receiveTyped(visitor);
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
        visitor.visitSuperMethodInvocationNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitRestrictedPrimaryExpressionNodeStart(this);
        visitor.visitStatementExpressionNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitRestrictedPrimaryExpressionNodeStop(this);
        visitor.visitStatementExpressionNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitSuperMethodInvocationNodeStop(this, true);
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
        list.add(getUnionForIdentifier());
        list.add(getUnionForArguments());
        list.add(getUnionForTypeArguments());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getUnionForType().getNodeValue(), getUnionForIdentifier().getNodeValue(), getUnionForArguments().getNodeValue(), getUnionForTypeArguments().getNodeValue()});
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
        sb.append("type=");
        sb.append(this.getUnionForType().getNodeValue() == null? "null" : this.getUnionForType().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("identifier=");
        sb.append(this.getUnionForIdentifier().getNodeValue() == null? "null" : this.getUnionForIdentifier().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("arguments=");
        sb.append(this.getUnionForArguments().getNodeValue() == null? "null" : this.getUnionForArguments().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("typeArguments=");
        sb.append(this.getUnionForTypeArguments().getNodeValue() == null? "null" : this.getUnionForTypeArguments().getNodeValue().getClass().getSimpleName());
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
        return operation.executeSuperMethodInvocationNode(this, p);
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
        return operation.executeSuperMethodInvocationNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public SuperMethodInvocationNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends UnparameterizedTypeNode> typeCopy;
        switch (getUnionForType().getType())
        {
            case NORMAL:
                if (getUnionForType().getNormalNode() == null)
                {
                    typeCopy = factory.<UnparameterizedTypeNode>makeNormalNodeUnion(null);
                } else
                {
                    typeCopy = factory.makeNormalNodeUnion(getUnionForType().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForType().getSpliceNode() == null)
                {
                    typeCopy = factory.<UnparameterizedTypeNode>makeSpliceNodeUnion(null);
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
        NodeUnion<? extends ExpressionListNode> argumentsCopy;
        switch (getUnionForArguments().getType())
        {
            case NORMAL:
                if (getUnionForArguments().getNormalNode() == null)
                {
                    argumentsCopy = factory.<ExpressionListNode>makeNormalNodeUnion(null);
                } else
                {
                    argumentsCopy = factory.makeNormalNodeUnion(getUnionForArguments().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForArguments().getSpliceNode() == null)
                {
                    argumentsCopy = factory.<ExpressionListNode>makeSpliceNodeUnion(null);
                } else
                {
                    argumentsCopy = factory.makeSpliceNodeUnion(getUnionForArguments().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForArguments().getType());
        }
        NodeUnion<? extends ReferenceTypeListNode> typeArgumentsCopy;
        switch (getUnionForTypeArguments().getType())
        {
            case NORMAL:
                if (getUnionForTypeArguments().getNormalNode() == null)
                {
                    typeArgumentsCopy = factory.<ReferenceTypeListNode>makeNormalNodeUnion(null);
                } else
                {
                    typeArgumentsCopy = factory.makeNormalNodeUnion(getUnionForTypeArguments().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForTypeArguments().getSpliceNode() == null)
                {
                    typeArgumentsCopy = factory.<ReferenceTypeListNode>makeSpliceNodeUnion(null);
                } else
                {
                    typeArgumentsCopy = factory.makeSpliceNodeUnion(getUnionForTypeArguments().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForTypeArguments().getType());
        }
        return factory.makeSuperMethodInvocationNodeWithUnions(
                typeCopy,
                identifierCopy,
                argumentsCopy,
                typeArgumentsCopy,
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
        
        if (before.equals(this.getUnionForType().getNodeValue()))
        {
            setType((UnparameterizedTypeNode)after);
            return true;
        }
        if (before.equals(this.getUnionForIdentifier().getNodeValue()))
        {
            setIdentifier((IdentifierNode)after);
            return true;
        }
        if (before.equals(this.getUnionForArguments().getNodeValue()))
        {
            setArguments((ExpressionListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForTypeArguments().getNodeValue()))
        {
            setTypeArguments((ReferenceTypeListNode)after);
            return true;
        }
        return false;
    }
    
}
