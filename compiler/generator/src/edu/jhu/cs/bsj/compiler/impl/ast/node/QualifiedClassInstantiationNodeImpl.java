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
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeArgumentListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.QualifiedClassInstantiationNodeSetEnclosingExpressionPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.QualifiedClassInstantiationNodeSetIdentifierPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.QualifiedClassInstantiationNodeSetTypeArgumentsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.QualifiedClassInstantiationNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class QualifiedClassInstantiationNodeImpl extends ClassInstantiationNodeImpl implements QualifiedClassInstantiationNode
{
    /** The expression enclosing the non-static inner class. */
    private NodeUnion<? extends ExpressionNode> enclosingExpression;
    
    /** The name of the class being instantiated. */
    private NodeUnion<? extends IdentifierNode> identifier;
    
    /** The type arguments to apply to the class being instantiated. */
    private NodeUnion<? extends TypeArgumentListNode> typeArguments;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<QualifiedClassInstantiationNodeProperties> populatedProperties;
    
    /** General constructor. */
    public QualifiedClassInstantiationNodeImpl(
            NodeUnion<? extends ExpressionNode> enclosingExpression,
            NodeUnion<? extends IdentifierNode> identifier,
            NodeUnion<? extends TypeArgumentListNode> typeArguments,
            NodeUnion<? extends TypeArgumentListNode> constructorTypeArguments,
            NodeUnion<? extends ExpressionListNode> arguments,
            NodeUnion<? extends AnonymousClassBodyNode> body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(constructorTypeArguments, arguments, body, startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetEnclosingExpression(enclosingExpression);
        doSetIdentifier(identifier);
        doSetTypeArguments(typeArguments);
    }
    
    /** Proxy constructor. */
    public QualifiedClassInstantiationNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, QualifiedClassInstantiationNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(QualifiedClassInstantiationNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected QualifiedClassInstantiationNode getBackingNode()
    {
        return (QualifiedClassInstantiationNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the enclosingExpression value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkEnclosingExpressionWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                QualifiedClassInstantiationNodeProperties.ENCLOSING_EXPRESSION))
            return;
        this.populatedProperties.add(QualifiedClassInstantiationNodeProperties.ENCLOSING_EXPRESSION);
        NodeUnion<? extends ExpressionNode> union = this.getBackingNode().getUnionForEnclosingExpression();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeExpressionNode(union.getNormalNode()));
                break;
            case SPLICE:
                union = this.getProxyFactory().makeSpliceNodeUnion(
                        this.getProxyFactory().makeSpliceNode(union.getSpliceNode()));
                break;
            default:
                throw new IllegalStateException("Unrecognized union type: " + union.getType());
        }
        this.enclosingExpression = union;
    }
    
    /**
     * Ensures that the identifier value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkIdentifierWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                QualifiedClassInstantiationNodeProperties.IDENTIFIER))
            return;
        this.populatedProperties.add(QualifiedClassInstantiationNodeProperties.IDENTIFIER);
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
     * Ensures that the typeArguments value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkTypeArgumentsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                QualifiedClassInstantiationNodeProperties.TYPE_ARGUMENTS))
            return;
        this.populatedProperties.add(QualifiedClassInstantiationNodeProperties.TYPE_ARGUMENTS);
        NodeUnion<? extends TypeArgumentListNode> union = this.getBackingNode().getUnionForTypeArguments();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeTypeArgumentListNode(union.getNormalNode()));
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
     * Gets the expression enclosing the non-static inner class.  This property's value is assumed to be a normal node.
     * @return The expression enclosing the non-static inner class.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public ExpressionNode getEnclosingExpression()
    {
        checkEnclosingExpressionWrapped();
        if (this.enclosingExpression == null)
        {
            return null;
        } else
        {
            return this.enclosingExpression.getNormalNode();
        }
    }
    
    /**
     * Gets the expression enclosing the non-static inner class.
     * @return The expression enclosing the non-static inner class.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForEnclosingExpression()
    {
        checkEnclosingExpressionWrapped();
        if (this.enclosingExpression == null)
        {
            this.enclosingExpression = new NormalNodeUnion<ExpressionNode>(null);
        }
        return this.enclosingExpression;
    }
    
    /**
     * Changes the expression enclosing the non-static inner class.
     * @param enclosingExpression The expression enclosing the non-static inner class.
     */
    public void setEnclosingExpression(ExpressionNode enclosingExpression)
    {
        checkEnclosingExpressionWrapped();
        this.setUnionForEnclosingExpression(new NormalNodeUnion<ExpressionNode>(enclosingExpression));
    }
    
    /**
     * Changes the expression enclosing the non-static inner class.
     * @param enclosingExpression The expression enclosing the non-static inner class.
     */
    public void setUnionForEnclosingExpression(NodeUnion<? extends ExpressionNode> enclosingExpression)
    {
        checkEnclosingExpressionWrapped();
        this.getManager().assertMutatable(this);
        this.doSetEnclosingExpression(enclosingExpression);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new QualifiedClassInstantiationNodeSetEnclosingExpressionPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), enclosingExpression.getNodeValue() == null ? null : enclosingExpression.getNodeValue().getUid()));
    }
    
    private void doSetEnclosingExpression(NodeUnion<? extends ExpressionNode> enclosingExpression)
    {
        if (enclosingExpression == null)
        {
            enclosingExpression = new NormalNodeUnion<ExpressionNode>(null);
        }
        if (this.enclosingExpression != null)
        {
            setAsChild(this.enclosingExpression.getNodeValue(), false);
        }
        this.enclosingExpression = enclosingExpression;
        setAsChild(enclosingExpression.getNodeValue(), true);
    }
    
    /**
     * Gets the name of the class being instantiated.  This property's value is assumed to be a normal node.
     * @return The name of the class being instantiated.
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
     * Gets the name of the class being instantiated.
     * @return The name of the class being instantiated.
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
     * Changes the name of the class being instantiated.
     * @param identifier The name of the class being instantiated.
     */
    public void setIdentifier(IdentifierNode identifier)
    {
        checkIdentifierWrapped();
        this.setUnionForIdentifier(new NormalNodeUnion<IdentifierNode>(identifier));
    }
    
    /**
     * Changes the name of the class being instantiated.
     * @param identifier The name of the class being instantiated.
     */
    public void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier)
    {
        checkIdentifierWrapped();
        this.getManager().assertMutatable(this);
        this.doSetIdentifier(identifier);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new QualifiedClassInstantiationNodeSetIdentifierPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), identifier.getNodeValue() == null ? null : identifier.getNodeValue().getUid()));
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
     * Gets the type arguments to apply to the class being instantiated.  This property's value is assumed to be a normal node.
     * @return The type arguments to apply to the class being instantiated.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public TypeArgumentListNode getTypeArguments()
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
     * Gets the type arguments to apply to the class being instantiated.
     * @return The type arguments to apply to the class being instantiated.
     */
    public NodeUnion<? extends TypeArgumentListNode> getUnionForTypeArguments()
    {
        checkTypeArgumentsWrapped();
        if (this.typeArguments == null)
        {
            this.typeArguments = new NormalNodeUnion<TypeArgumentListNode>(null);
        }
        return this.typeArguments;
    }
    
    /**
     * Changes the type arguments to apply to the class being instantiated.
     * @param typeArguments The type arguments to apply to the class being instantiated.
     */
    public void setTypeArguments(TypeArgumentListNode typeArguments)
    {
        checkTypeArgumentsWrapped();
        this.setUnionForTypeArguments(new NormalNodeUnion<TypeArgumentListNode>(typeArguments));
    }
    
    /**
     * Changes the type arguments to apply to the class being instantiated.
     * @param typeArguments The type arguments to apply to the class being instantiated.
     */
    public void setUnionForTypeArguments(NodeUnion<? extends TypeArgumentListNode> typeArguments)
    {
        checkTypeArgumentsWrapped();
        this.getManager().assertMutatable(this);
        this.doSetTypeArguments(typeArguments);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new QualifiedClassInstantiationNodeSetTypeArgumentsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), typeArguments.getNodeValue() == null ? null : typeArguments.getNodeValue().getUid()));
    }
    
    private void doSetTypeArguments(NodeUnion<? extends TypeArgumentListNode> typeArguments)
    {
        if (typeArguments == null)
        {
            typeArguments = new NormalNodeUnion<TypeArgumentListNode>(null);
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
        if (this.getUnionForEnclosingExpression().getNodeValue() != null)
        {
            this.getUnionForEnclosingExpression().getNodeValue().receive(visitor);
        }
        if (this.getUnionForIdentifier().getNodeValue() != null)
        {
            this.getUnionForIdentifier().getNodeValue().receive(visitor);
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
        if (this.getUnionForEnclosingExpression().getNodeValue() != null)
        {
            this.getUnionForEnclosingExpression().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForIdentifier().getNodeValue() != null)
        {
            this.getUnionForIdentifier().getNodeValue().receiveTyped(visitor);
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
        visitor.visitQualifiedClassInstantiationNodeStart(this, true);
        visitor.visitClassInstantiationNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitClassInstantiationNodeStop(this);
        visitor.visitQualifiedClassInstantiationNodeStop(this, true);
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
        list.add(getUnionForEnclosingExpression());
        list.add(getUnionForIdentifier());
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
        return Arrays.asList(new Node[]{getUnionForEnclosingExpression().getNodeValue(), getUnionForIdentifier().getNodeValue(), getUnionForTypeArguments().getNodeValue(), getUnionForConstructorTypeArguments().getNodeValue(), getUnionForArguments().getNodeValue(), getUnionForBody().getNodeValue()});
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
        sb.append("enclosingExpression=");
        sb.append(this.getUnionForEnclosingExpression().getNodeValue() == null? "null" : this.getUnionForEnclosingExpression().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("identifier=");
        sb.append(this.getUnionForIdentifier().getNodeValue() == null? "null" : this.getUnionForIdentifier().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("typeArguments=");
        sb.append(this.getUnionForTypeArguments().getNodeValue() == null? "null" : this.getUnionForTypeArguments().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("constructorTypeArguments=");
        sb.append(this.getUnionForConstructorTypeArguments().getNodeValue() == null? "null" : this.getUnionForConstructorTypeArguments().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("arguments=");
        sb.append(this.getUnionForArguments().getNodeValue() == null? "null" : this.getUnionForArguments().getNodeValue().getClass().getSimpleName());
        sb.append(',');
        sb.append("body=");
        sb.append(this.getUnionForBody().getNodeValue() == null? "null" : this.getUnionForBody().getNodeValue().getClass().getSimpleName());
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
        return operation.executeQualifiedClassInstantiationNode(this, p);
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
        return operation.executeQualifiedClassInstantiationNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public QualifiedClassInstantiationNode deepCopy(BsjNodeFactory factory)
    {
        NodeUnion<? extends ExpressionNode> enclosingExpressionCopy;
        switch (getUnionForEnclosingExpression().getType())
        {
            case NORMAL:
                if (getUnionForEnclosingExpression().getNormalNode() == null)
                {
                    enclosingExpressionCopy = factory.<ExpressionNode>makeNormalNodeUnion(null);
                } else
                {
                    enclosingExpressionCopy = factory.makeNormalNodeUnion(getUnionForEnclosingExpression().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForEnclosingExpression().getSpliceNode() == null)
                {
                    enclosingExpressionCopy = factory.<ExpressionNode>makeSpliceNodeUnion(null);
                } else
                {
                    enclosingExpressionCopy = factory.makeSpliceNodeUnion(getUnionForEnclosingExpression().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForEnclosingExpression().getType());
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
        NodeUnion<? extends TypeArgumentListNode> typeArgumentsCopy;
        switch (getUnionForTypeArguments().getType())
        {
            case NORMAL:
                if (getUnionForTypeArguments().getNormalNode() == null)
                {
                    typeArgumentsCopy = factory.<TypeArgumentListNode>makeNormalNodeUnion(null);
                } else
                {
                    typeArgumentsCopy = factory.makeNormalNodeUnion(getUnionForTypeArguments().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForTypeArguments().getSpliceNode() == null)
                {
                    typeArgumentsCopy = factory.<TypeArgumentListNode>makeSpliceNodeUnion(null);
                } else
                {
                    typeArgumentsCopy = factory.makeSpliceNodeUnion(getUnionForTypeArguments().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForTypeArguments().getType());
        }
        NodeUnion<? extends TypeArgumentListNode> constructorTypeArgumentsCopy;
        switch (getUnionForConstructorTypeArguments().getType())
        {
            case NORMAL:
                if (getUnionForConstructorTypeArguments().getNormalNode() == null)
                {
                    constructorTypeArgumentsCopy = factory.<TypeArgumentListNode>makeNormalNodeUnion(null);
                } else
                {
                    constructorTypeArgumentsCopy = factory.makeNormalNodeUnion(getUnionForConstructorTypeArguments().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForConstructorTypeArguments().getSpliceNode() == null)
                {
                    constructorTypeArgumentsCopy = factory.<TypeArgumentListNode>makeSpliceNodeUnion(null);
                } else
                {
                    constructorTypeArgumentsCopy = factory.makeSpliceNodeUnion(getUnionForConstructorTypeArguments().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForConstructorTypeArguments().getType());
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
        NodeUnion<? extends AnonymousClassBodyNode> bodyCopy;
        switch (getUnionForBody().getType())
        {
            case NORMAL:
                if (getUnionForBody().getNormalNode() == null)
                {
                    bodyCopy = factory.<AnonymousClassBodyNode>makeNormalNodeUnion(null);
                } else
                {
                    bodyCopy = factory.makeNormalNodeUnion(getUnionForBody().getNormalNode().deepCopy(factory));
                }
                break;
            case SPLICE:
                if (getUnionForBody().getSpliceNode() == null)
                {
                    bodyCopy = factory.<AnonymousClassBodyNode>makeSpliceNodeUnion(null);
                } else
                {
                    bodyCopy = factory.makeSpliceNodeUnion(getUnionForBody().getSpliceNode().deepCopy(factory));
                }
                break;
            default:
                throw new IllegalStateException("Unrecognized union component type: " + getUnionForBody().getType());
        }
        return factory.makeQualifiedClassInstantiationNodeWithUnions(
                enclosingExpressionCopy,
                identifierCopy,
                typeArgumentsCopy,
                constructorTypeArgumentsCopy,
                argumentsCopy,
                bodyCopy,
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
        
        if (before.equals(this.getUnionForEnclosingExpression().getNodeValue()))
        {
            setEnclosingExpression((ExpressionNode)after);
            return true;
        }
        if (before.equals(this.getUnionForIdentifier().getNodeValue()))
        {
            setIdentifier((IdentifierNode)after);
            return true;
        }
        if (before.equals(this.getUnionForTypeArguments().getNodeValue()))
        {
            setTypeArguments((TypeArgumentListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForConstructorTypeArguments().getNodeValue()))
        {
            setConstructorTypeArguments((TypeArgumentListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForArguments().getNodeValue()))
        {
            setArguments((ExpressionListNode)after);
            return true;
        }
        if (before.equals(this.getUnionForBody().getNodeValue()))
        {
            setBody((AnonymousClassBodyNode)after);
            return true;
        }
        return false;
    }
    
}
