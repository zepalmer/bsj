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
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeArgumentListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.NormalNodeUnion;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class ClassInstantiationNodeImpl extends NodeImpl implements ClassInstantiationNode
{
    /** The type arguments for the constructor. */
    private NodeUnion<? extends TypeArgumentListNode> constructorTypeArguments;
    
    /** The arguments to the constructor. */
    private NodeUnion<? extends ExpressionListNode> arguments;
    
    /** The body of the anonymous class. */
    private NodeUnion<? extends AnonymousClassBodyNode> body;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(ClassInstantiationNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the constructorTypeArguments property. */
        CONSTRUCTOR_TYPE_ARGUMENTS,
        /** Attribute identifier for the arguments property. */
        ARGUMENTS,
        /** Attribute identifier for the body property. */
        BODY,
    }
    
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
        setUnionForConstructorTypeArguments(constructorTypeArguments, false);
        setUnionForArguments(arguments, false);
        setUnionForBody(body, false);
    }
    
    /**
     * Gets the type arguments for the constructor.  This property's value is assumed to be a normal node.
     * @return The type arguments for the constructor.
     * @throws ClassCastException If this property's value is not a normal node.
     */
    public TypeArgumentListNode getConstructorTypeArguments()
    {
        getAttribute(LocalAttribute.CONSTRUCTOR_TYPE_ARGUMENTS).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        getAttribute(LocalAttribute.CONSTRUCTOR_TYPE_ARGUMENTS).recordAccess(ReadWriteAttribute.AccessType.READ);
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
            setConstructorTypeArguments(constructorTypeArguments, true);
            getManager().notifyChange(this);
    }
    
    private void setConstructorTypeArguments(TypeArgumentListNode constructorTypeArguments, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.CONSTRUCTOR_TYPE_ARGUMENTS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.constructorTypeArguments != null)
        {
            setAsChild(this.constructorTypeArguments.getNodeValue(), false);
        }
        this.constructorTypeArguments = new NormalNodeUnion<TypeArgumentListNode>(constructorTypeArguments);
        setAsChild(constructorTypeArguments, true);
    }
    
    /**
     * Changes the type arguments for the constructor.
     * @param constructorTypeArguments The type arguments for the constructor.
     */
    public void setUnionForConstructorTypeArguments(NodeUnion<? extends TypeArgumentListNode> constructorTypeArguments)
    {
            setUnionForConstructorTypeArguments(constructorTypeArguments, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForConstructorTypeArguments(NodeUnion<? extends TypeArgumentListNode> constructorTypeArguments, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.CONSTRUCTOR_TYPE_ARGUMENTS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
        getAttribute(LocalAttribute.ARGUMENTS).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        getAttribute(LocalAttribute.ARGUMENTS).recordAccess(ReadWriteAttribute.AccessType.READ);
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
            setArguments(arguments, true);
            getManager().notifyChange(this);
    }
    
    private void setArguments(ExpressionListNode arguments, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.ARGUMENTS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
        if (this.arguments != null)
        {
            setAsChild(this.arguments.getNodeValue(), false);
        }
        this.arguments = new NormalNodeUnion<ExpressionListNode>(arguments);
        setAsChild(arguments, true);
    }
    
    /**
     * Changes the arguments to the constructor.
     * @param arguments The arguments to the constructor.
     */
    public void setUnionForArguments(NodeUnion<? extends ExpressionListNode> arguments)
    {
            setUnionForArguments(arguments, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForArguments(NodeUnion<? extends ExpressionListNode> arguments, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.ARGUMENTS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
     * Gets the body of the anonymous class.
     * @return The body of the anonymous class.
     */
    public NodeUnion<? extends AnonymousClassBodyNode> getUnionForBody()
    {
        getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.READ);
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
            setBody(body, true);
            getManager().notifyChange(this);
    }
    
    private void setBody(AnonymousClassBodyNode body, boolean checkPermissions)
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
        this.body = new NormalNodeUnion<AnonymousClassBodyNode>(body);
        setAsChild(body, true);
    }
    
    /**
     * Changes the body of the anonymous class.
     * @param body The body of the anonymous class.
     */
    public void setUnionForBody(NodeUnion<? extends AnonymousClassBodyNode> body)
    {
            setUnionForBody(body, true);
            getManager().notifyChange(this);
    }
    
    private void setUnionForBody(NodeUnion<? extends AnonymousClassBodyNode> body, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        
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
        if (this.constructorTypeArguments.getNodeValue() != null)
        {
            this.constructorTypeArguments.getNodeValue().receive(visitor);
        }
        if (this.arguments.getNodeValue() != null)
        {
            this.arguments.getNodeValue().receive(visitor);
        }
        if (this.body.getNodeValue() != null)
        {
            this.body.getNodeValue().receive(visitor);
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
        if (this.constructorTypeArguments.getNodeValue() != null)
        {
            this.constructorTypeArguments.getNodeValue().receiveTyped(visitor);
        }
        if (this.arguments.getNodeValue() != null)
        {
            this.arguments.getNodeValue().receiveTyped(visitor);
        }
        if (this.body.getNodeValue() != null)
        {
            this.body.getNodeValue().receiveTyped(visitor);
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
