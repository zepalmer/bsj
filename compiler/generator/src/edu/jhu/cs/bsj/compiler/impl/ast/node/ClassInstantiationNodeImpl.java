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
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeArgumentListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeProxyFactory;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ClassInstantiationNodeSetArgumentsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ClassInstantiationNodeSetBodyPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.delta.property.ClassInstantiationNodeSetConstructorTypeArgumentsPropertyEditScriptElementImpl;
import edu.jhu.cs.bsj.compiler.impl.ast.properties.ClassInstantiationNodeProperties;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class ClassInstantiationNodeImpl extends NodeImpl implements ClassInstantiationNode
{
    /** The type arguments for the constructor. */
    private NodeUnion<? extends TypeArgumentListNode> constructorTypeArguments;
    
    /** The arguments to the constructor. */
    private NodeUnion<? extends ExpressionListNode> arguments;
    
    /** The body of the anonymous class. */
    private NodeUnion<? extends AnonymousClassBodyNode> body;
    
    /**
     * A set of those properties which have been populated from the backing node.
     * This field is <code>null</code> if <tt>backingNode</tt> is <code>null</code>.
     */
    private Set<ClassInstantiationNodeProperties> populatedProperties;
    
    /** General constructor. */
    protected ClassInstantiationNodeImpl(
            NodeUnion<? extends TypeArgumentListNode> constructorTypeArguments,
            NodeUnion<? extends ExpressionListNode> arguments,
            NodeUnion<? extends AnonymousClassBodyNode> body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        this.populatedProperties = null;
        doSetConstructorTypeArguments(constructorTypeArguments);
        doSetArguments(arguments);
        doSetBody(body);
    }
    
    /** Proxy constructor. */
    protected ClassInstantiationNodeImpl(BsjNodeManager manager, BsjNodeProxyFactory proxyFactory, ClassInstantiationNode backingNode)
    {
        super(manager, proxyFactory, backingNode);
        this.populatedProperties = EnumSet.noneOf(ClassInstantiationNodeProperties.class);
    }
    
    /** Retrieves this node's backing node (if one exists). */
    protected ClassInstantiationNode getBackingNode()
    {
        return (ClassInstantiationNode)super.getBackingNode();
    }
    
    /**
     * Ensures that the constructorTypeArguments value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkConstructorTypeArgumentsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ClassInstantiationNodeProperties.CONSTRUCTOR_TYPE_ARGUMENTS))
            return;
        this.populatedProperties.add(ClassInstantiationNodeProperties.CONSTRUCTOR_TYPE_ARGUMENTS);
        NodeUnion<? extends TypeArgumentListNode> union = this.getBackingNode().getUnionForConstructorTypeArguments();
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
        this.constructorTypeArguments = union;
    }
    
    /**
     * Ensures that the arguments value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkArgumentsWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ClassInstantiationNodeProperties.ARGUMENTS))
            return;
        this.populatedProperties.add(ClassInstantiationNodeProperties.ARGUMENTS);
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
     * Ensures that the body value has been populated from proxy.
     * If this node is not backed by a proxy or if the value has already been
     * populated, this method does nothing.
     */
    private void checkBodyWrapped()
    {
        if (this.populatedProperties == null || this.populatedProperties.contains(
                ClassInstantiationNodeProperties.BODY))
            return;
        this.populatedProperties.add(ClassInstantiationNodeProperties.BODY);
        NodeUnion<? extends AnonymousClassBodyNode> union = this.getBackingNode().getUnionForBody();
        switch (union.getType())
        {
            case NORMAL:
                union = this.getProxyFactory().makeNormalNodeUnion(
                        this.getProxyFactory().makeAnonymousClassBodyNode(union.getNormalNode()));
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
     * Gets the type arguments for the constructor.  This property's value is assumed to be a normal node.
     * @return The type arguments for the constructor.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public TypeArgumentListNode getConstructorTypeArguments()
    {
        checkConstructorTypeArgumentsWrapped();
        if (this.constructorTypeArguments == null)
        {
            return null;
        } else
        {
            return this.constructorTypeArguments.getNormalNode();
        }
    }
    
    /**
     * Gets the type arguments for the constructor.
     * @return The type arguments for the constructor.
     */
    public NodeUnion<? extends TypeArgumentListNode> getUnionForConstructorTypeArguments()
    {
        checkConstructorTypeArgumentsWrapped();
        if (this.constructorTypeArguments == null)
        {
            this.constructorTypeArguments = new NormalNodeUnion<TypeArgumentListNode>(null);
        }
        return this.constructorTypeArguments;
    }
    
    /**
     * Changes the type arguments for the constructor.
     * @param constructorTypeArguments The type arguments for the constructor.
     */
    public void setConstructorTypeArguments(TypeArgumentListNode constructorTypeArguments)
    {
        checkConstructorTypeArgumentsWrapped();
        this.setUnionForConstructorTypeArguments(new NormalNodeUnion<TypeArgumentListNode>(constructorTypeArguments));
    }
    
    /**
     * Changes the type arguments for the constructor.
     * @param constructorTypeArguments The type arguments for the constructor.
     */
    public void setUnionForConstructorTypeArguments(NodeUnion<? extends TypeArgumentListNode> constructorTypeArguments)
    {
        checkConstructorTypeArgumentsWrapped();
        this.getManager().assertMutatable(this);
        this.doSetConstructorTypeArguments(constructorTypeArguments);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ClassInstantiationNodeSetConstructorTypeArgumentsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), constructorTypeArguments.getNodeValue() == null ? null : constructorTypeArguments.getNodeValue().getUid()));
    }
    
    private void doSetConstructorTypeArguments(NodeUnion<? extends TypeArgumentListNode> constructorTypeArguments)
    {
        if (constructorTypeArguments == null)
        {
            constructorTypeArguments = new NormalNodeUnion<TypeArgumentListNode>(null);
        }
        if (this.constructorTypeArguments != null)
        {
            setAsChild(this.constructorTypeArguments.getNodeValue(), false);
        }
        this.constructorTypeArguments = constructorTypeArguments;
        setAsChild(constructorTypeArguments.getNodeValue(), true);
    }
    
    /**
     * Gets the arguments to the constructor.  This property's value is assumed to be a normal node.
     * @return The arguments to the constructor.
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
     * Gets the arguments to the constructor.
     * @return The arguments to the constructor.
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
     * Changes the arguments to the constructor.
     * @param arguments The arguments to the constructor.
     */
    public void setArguments(ExpressionListNode arguments)
    {
        checkArgumentsWrapped();
        this.setUnionForArguments(new NormalNodeUnion<ExpressionListNode>(arguments));
    }
    
    /**
     * Changes the arguments to the constructor.
     * @param arguments The arguments to the constructor.
     */
    public void setUnionForArguments(NodeUnion<? extends ExpressionListNode> arguments)
    {
        checkArgumentsWrapped();
        this.getManager().assertMutatable(this);
        this.doSetArguments(arguments);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ClassInstantiationNodeSetArgumentsPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), arguments.getNodeValue() == null ? null : arguments.getNodeValue().getUid()));
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
     * Gets the body of the anonymous class.  This property's value is assumed to be a normal node.
     * @return The body of the anonymous class.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public AnonymousClassBodyNode getBody()
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
     * Gets the body of the anonymous class.
     * @return The body of the anonymous class.
     */
    public NodeUnion<? extends AnonymousClassBodyNode> getUnionForBody()
    {
        checkBodyWrapped();
        if (this.body == null)
        {
            this.body = new NormalNodeUnion<AnonymousClassBodyNode>(null);
        }
        return this.body;
    }
    
    /**
     * Changes the body of the anonymous class.
     * @param body The body of the anonymous class.
     */
    public void setBody(AnonymousClassBodyNode body)
    {
        checkBodyWrapped();
        this.setUnionForBody(new NormalNodeUnion<AnonymousClassBodyNode>(body));
    }
    
    /**
     * Changes the body of the anonymous class.
     * @param body The body of the anonymous class.
     */
    public void setUnionForBody(NodeUnion<? extends AnonymousClassBodyNode> body)
    {
        checkBodyWrapped();
        this.getManager().assertMutatable(this);
        this.doSetBody(body);
        if (this.getManager().isRecordingEdits())
            super.recordEdit(new ClassInstantiationNodeSetBodyPropertyEditScriptElementImpl(this.getManager().getCurrentMetaprogramId(), this.getUid(), body.getNodeValue() == null ? null : body.getNodeValue().getUid()));
    }
    
    private void doSetBody(NodeUnion<? extends AnonymousClassBodyNode> body)
    {
        if (body == null)
        {
            body = new NormalNodeUnion<AnonymousClassBodyNode>(null);
        }
        if (this.body != null)
        {
            setAsChild(this.body.getNodeValue(), false);
        }
        this.body = body;
        setAsChild(body.getNodeValue(), true);
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
        if (this.getUnionForConstructorTypeArguments().getNodeValue() != null)
        {
            this.getUnionForConstructorTypeArguments().getNodeValue().receive(visitor);
        }
        if (this.getUnionForArguments().getNodeValue() != null)
        {
            this.getUnionForArguments().getNodeValue().receive(visitor);
        }
        if (this.getUnionForBody().getNodeValue() != null)
        {
            this.getUnionForBody().getNodeValue().receive(visitor);
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
        if (this.getUnionForConstructorTypeArguments().getNodeValue() != null)
        {
            this.getUnionForConstructorTypeArguments().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForArguments().getNodeValue() != null)
        {
            this.getUnionForArguments().getNodeValue().receiveTyped(visitor);
        }
        if (this.getUnionForBody().getNodeValue() != null)
        {
            this.getUnionForBody().getNodeValue().receiveTyped(visitor);
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
        visitor.visitClassInstantiationNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitRestrictedPrimaryExpressionNodeStart(this);
        visitor.visitStatementExpressionNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitRestrictedPrimaryExpressionNodeStop(this);
        visitor.visitStatementExpressionNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitClassInstantiationNodeStop(this);
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
        list.add(getUnionForConstructorTypeArguments());
        list.add(getUnionForArguments());
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
    
    
    
}
