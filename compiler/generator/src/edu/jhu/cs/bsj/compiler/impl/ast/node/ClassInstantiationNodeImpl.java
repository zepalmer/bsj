package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeArgumentListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class ClassInstantiationNodeImpl extends NodeImpl implements ClassInstantiationNode
{
    /** The type arguments for the constructor. */
    private TypeArgumentListNode constructorTypeArguments;
    
    /** The arguments to the constructor. */
    private ExpressionListNode arguments;
    
    /** The body of the anonymous class. */
    private AnonymousClassBodyNode body;
    
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
            TypeArgumentListNode constructorTypeArguments,
            ExpressionListNode arguments,
            AnonymousClassBodyNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setConstructorTypeArguments(constructorTypeArguments, false);
        setArguments(arguments, false);
        setBody(body, false);
    }
    
    /**
     * Gets the type arguments for the constructor.
     * @return The type arguments for the constructor.
     */
    public TypeArgumentListNode getConstructorTypeArguments()
    {
        getAttribute(LocalAttribute.CONSTRUCTOR_TYPE_ARGUMENTS).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        setAsChild(this.constructorTypeArguments, false);
        this.constructorTypeArguments = constructorTypeArguments;
        setAsChild(constructorTypeArguments, true);
    }
    
    /**
     * Gets the arguments to the constructor.
     * @return The arguments to the constructor.
     */
    public ExpressionListNode getArguments()
    {
        getAttribute(LocalAttribute.ARGUMENTS).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        setAsChild(this.arguments, false);
        this.arguments = arguments;
        setAsChild(arguments, true);
    }
    
    /**
     * Gets the body of the anonymous class.
     * @return The body of the anonymous class.
     */
    public AnonymousClassBodyNode getBody()
    {
        getAttribute(LocalAttribute.BODY).recordAccess(ReadWriteAttribute.AccessType.READ);
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
        setAsChild(this.body, false);
        this.body = body;
        setAsChild(body, true);
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
        if (this.constructorTypeArguments != null)
        {
            this.constructorTypeArguments.receive(visitor);
        }
        if (this.arguments != null)
        {
            this.arguments.receive(visitor);
        }
        if (this.body != null)
        {
            this.body.receive(visitor);
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
        if (this.constructorTypeArguments != null)
        {
            this.constructorTypeArguments.receiveTyped(visitor);
        }
        if (this.arguments != null)
        {
            this.arguments.receiveTyped(visitor);
        }
        if (this.body != null)
        {
            this.body.receiveTyped(visitor);
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
        list.add(getConstructorTypeArguments());
        list.add(getArguments());
        list.add(getBody());
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
        sb.append(this.getConstructorTypeArguments() == null? "null" : this.getConstructorTypeArguments().getClass().getSimpleName());
        sb.append(',');
        sb.append("arguments=");
        sb.append(this.getArguments() == null? "null" : this.getArguments().getClass().getSimpleName());
        sb.append(',');
        sb.append("body=");
        sb.append(this.getBody() == null? "null" : this.getBody().getClass().getSimpleName());
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
