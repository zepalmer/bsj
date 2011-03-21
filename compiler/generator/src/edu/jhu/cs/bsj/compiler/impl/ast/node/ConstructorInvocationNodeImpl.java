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
import edu.jhu.cs.bsj.compiler.ast.node.ConstructorInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ReferenceTypeListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ConstructorInvocationNodeSetArgumentsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ConstructorInvocationNodeSetTypeArgumentsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.ConstructorInvocationNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class ConstructorInvocationNodeImpl extends NodeImpl implements ConstructorInvocationNode
{
    /** The arguments to pass to the method. */
    private NodeUnion<? extends ExpressionListNode> arguments;
    
    /** The type arguments for the method. */
    private NodeUnion<? extends ReferenceTypeListNode> typeArguments;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<ConstructorInvocationNodeProperties> populatedProperties;
    
    /** General constructor. */
    protected ConstructorInvocationNodeImpl(
            NodeUnion<? extends ExpressionListNode> arguments,
            NodeUnion<? extends ReferenceTypeListNode> typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetArguments(arguments);
        doSetTypeArguments(typeArguments);
    }
    
    /** Proxy constructor. */
    protected ConstructorInvocationNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, ConstructorInvocationNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(ConstructorInvocationNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected ConstructorInvocationNode getBackingNode()
    {
        return (ConstructorInvocationNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the arguments value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkArgumentsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ConstructorInvocationNodeProperties.ARGUMENTS))
            return;
        this.populatedProperties.add(ConstructorInvocationNodeProperties.ARGUMENTS);
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
                ConstructorInvocationNodeProperties.TYPE_ARGUMENTS))
            return;
        this.populatedProperties.add(ConstructorInvocationNodeProperties.TYPE_ARGUMENTS);
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
            super.recordEdit(new ConstructorInvocationNodeSetArgumentsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), arguments.getNodeValue() == null ? null : arguments.getNodeValue().getUid()));
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
            super.recordEdit(new ConstructorInvocationNodeSetTypeArgumentsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), typeArguments.getNodeValue() == null ? null : typeArguments.getNodeValue().getUid()));
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
        visitor.visitConstructorInvocationNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitNodeStop(this);
        visitor.visitConstructorInvocationNodeStop(this);
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
        list.add(getUnionForArguments());
        list.add(getUnionForTypeArguments());
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
    
    
    
}
