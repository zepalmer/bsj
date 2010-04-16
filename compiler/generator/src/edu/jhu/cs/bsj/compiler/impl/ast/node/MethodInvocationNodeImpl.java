package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ReferenceTypeListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class MethodInvocationNodeImpl extends NodeImpl implements MethodInvocationNode
{
    /** The arguments to pass to the method. */
    private ExpressionListNode arguments;
    
    /** The type arguments for the method. */
    private ReferenceTypeListNode typeArguments;
    
    private static enum LocalAttribute implements edu.jhu.cs.bsj.compiler.impl.ast.Attribute
    {
        /** Attribute for the arguments property. */
        ARGUMENTS,
        /** Attribute for the typeArguments property. */
        TYPE_ARGUMENTS,
    }
    
    /** General constructor. */
    protected MethodInvocationNodeImpl(
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setArguments(arguments, false);
        setTypeArguments(typeArguments, false);
    }
    
    /**
     * Gets the arguments to pass to the method.
     * @return The arguments to pass to the method.
     */
    public ExpressionListNode getArguments()
    {
        recordAccess(LocalAttribute.ARGUMENTS, Attribute.AccessType.READ);
        return this.arguments;
    }
    
    /**
     * Changes the arguments to pass to the method.
     * @param arguments The arguments to pass to the method.
     */
    public void setArguments(ExpressionListNode arguments)
    {
            setArguments(arguments, true);
    }
    
    private void setArguments(ExpressionListNode arguments, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
        }
        recordAccess(LocalAttribute.ARGUMENTS, Attribute.AccessType.WRITE);
        if (this.arguments instanceof NodeImpl)
        {
            ((NodeImpl)this.arguments).setParent(null);
        }
        this.arguments = arguments;
        if (this.arguments instanceof NodeImpl)
        {
            ((NodeImpl)this.arguments).setParent(this);
        }
    }
    
    /**
     * Gets the type arguments for the method.
     * @return The type arguments for the method.
     */
    public ReferenceTypeListNode getTypeArguments()
    {
        recordAccess(LocalAttribute.TYPE_ARGUMENTS, Attribute.AccessType.READ);
        return this.typeArguments;
    }
    
    /**
     * Changes the type arguments for the method.
     * @param typeArguments The type arguments for the method.
     */
    public void setTypeArguments(ReferenceTypeListNode typeArguments)
    {
            setTypeArguments(typeArguments, true);
    }
    
    private void setTypeArguments(ReferenceTypeListNode typeArguments, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
        }
        recordAccess(LocalAttribute.TYPE_ARGUMENTS, Attribute.AccessType.WRITE);
        if (this.typeArguments instanceof NodeImpl)
        {
            ((NodeImpl)this.typeArguments).setParent(null);
        }
        this.typeArguments = typeArguments;
        if (this.typeArguments instanceof NodeImpl)
        {
            ((NodeImpl)this.typeArguments).setParent(this);
        }
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
        if (this.arguments != null)
        {
            this.arguments.receive(visitor);
        }
        if (this.typeArguments != null)
        {
            this.typeArguments.receive(visitor);
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
        if (this.arguments != null)
        {
            this.arguments.receiveTyped(visitor);
        }
        if (this.typeArguments != null)
        {
            this.typeArguments.receiveTyped(visitor);
        }
    }
    
    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitMethodInvocationNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitRestrictedPrimaryExpressionNodeStart(this);
        visitor.visitStatementExpressionNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitRestrictedPrimaryExpressionNodeStop(this);
        visitor.visitStatementExpressionNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitMethodInvocationNodeStop(this);
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
        list.add(getArguments());
        list.add(getTypeArguments());
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
        sb.append("arguments=");
        sb.append(this.getArguments() == null? "null" : this.getArguments().getClass().getSimpleName());
        sb.append(',');
        sb.append("typeArguments=");
        sb.append(this.getTypeArguments() == null? "null" : this.getTypeArguments().getClass().getSimpleName());
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
