package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.ReferenceTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.SuperMethodInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.impl.ast.Attribute;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class SuperMethodInvocationNodeImpl extends NodeImpl implements SuperMethodInvocationNode
{
    /** The qualifying type. */
    private UnparameterizedTypeNode type;
    
    /** The identifier of the method being invoked. */
    private IdentifierNode identifier;
    
    /** The arguments to pass to the method. */
    private ExpressionListNode arguments;
    
    /** The type arguments for the method. */
    private ReferenceTypeListNode typeArguments;
    
    private static enum LocalAttribute implements edu.jhu.cs.bsj.compiler.impl.ast.Attribute
    {
        /** Attribute for the type property. */
        TYPE,
        /** Attribute for the identifier property. */
        IDENTIFIER,
        /** Attribute for the arguments property. */
        ARGUMENTS,
        /** Attribute for the typeArguments property. */
        TYPE_ARGUMENTS,
    }
    
    /** General constructor. */
    public SuperMethodInvocationNodeImpl(
            UnparameterizedTypeNode type,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setType(type, false);
        setIdentifier(identifier, false);
        setArguments(arguments, false);
        setTypeArguments(typeArguments, false);
    }
    
    /**
     * Gets the qualifying type.
     * @return The qualifying type.
     */
    public UnparameterizedTypeNode getType()
    {
        recordAccess(LocalAttribute.TYPE, Attribute.AccessType.READ);
        return this.type;
    }
    
    /**
     * Changes the qualifying type.
     * @param type The qualifying type.
     */
    public void setType(UnparameterizedTypeNode type)
    {
            setType(type, true);
    }
    
    private void setType(UnparameterizedTypeNode type, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
        }
        recordAccess(LocalAttribute.TYPE, Attribute.AccessType.STRONG_WRITE);
        if (this.type instanceof NodeImpl)
        {
            ((NodeImpl)this.type).setParent(null);
        }
        this.type = type;
        if (this.type instanceof NodeImpl)
        {
            ((NodeImpl)this.type).setParent(this);
        }
    }
    
    /**
     * Gets the identifier of the method being invoked.
     * @return The identifier of the method being invoked.
     */
    public IdentifierNode getIdentifier()
    {
        recordAccess(LocalAttribute.IDENTIFIER, Attribute.AccessType.READ);
        return this.identifier;
    }
    
    /**
     * Changes the identifier of the method being invoked.
     * @param identifier The identifier of the method being invoked.
     */
    public void setIdentifier(IdentifierNode identifier)
    {
            setIdentifier(identifier, true);
    }
    
    private void setIdentifier(IdentifierNode identifier, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
        }
        recordAccess(LocalAttribute.IDENTIFIER, Attribute.AccessType.STRONG_WRITE);
        if (this.identifier instanceof NodeImpl)
        {
            ((NodeImpl)this.identifier).setParent(null);
        }
        this.identifier = identifier;
        if (this.identifier instanceof NodeImpl)
        {
            ((NodeImpl)this.identifier).setParent(this);
        }
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
        recordAccess(LocalAttribute.ARGUMENTS, Attribute.AccessType.STRONG_WRITE);
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
        recordAccess(LocalAttribute.TYPE_ARGUMENTS, Attribute.AccessType.STRONG_WRITE);
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
        if (this.type != null)
        {
            this.type.receive(visitor);
        }
        if (this.identifier != null)
        {
            this.identifier.receive(visitor);
        }
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
        if (this.type != null)
        {
            this.type.receiveTyped(visitor);
        }
        if (this.identifier != null)
        {
            this.identifier.receiveTyped(visitor);
        }
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
        list.add(getType());
        list.add(getIdentifier());
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
        sb.append("type=");
        sb.append(this.getType() == null? "null" : this.getType().getClass().getSimpleName());
        sb.append(',');
        sb.append("identifier=");
        sb.append(this.getIdentifier() == null? "null" : this.getIdentifier().getClass().getSimpleName());
        sb.append(',');
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
    
    /**
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p)
    {
        return operation.executeSuperMethodInvocationNode(this, p);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public SuperMethodInvocationNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeSuperMethodInvocationNode(
                getType().deepCopy(factory),
                getIdentifier().deepCopy(factory),
                getArguments().deepCopy(factory),
                getTypeArguments().deepCopy(factory),
                getStartLocation() == null ? null : (BsjSourceLocation)(getStartLocation().clone()),
                getStopLocation() == null ? null : (BsjSourceLocation)(getStopLocation().clone()));
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
        
        if (before.equals(this.getType()) && (after instanceof UnparameterizedTypeNode))
        {
            setType((UnparameterizedTypeNode)after);
            return true;
        }
        if (before.equals(this.getIdentifier()) && (after instanceof IdentifierNode))
        {
            setIdentifier((IdentifierNode)after);
            return true;
        }
        if (before.equals(this.getArguments()) && (after instanceof ExpressionListNode))
        {
            setArguments((ExpressionListNode)after);
            return true;
        }
        if (before.equals(this.getTypeArguments()) && (after instanceof ReferenceTypeListNode))
        {
            setTypeArguments((ReferenceTypeListNode)after);
            return true;
        }
        return false;
    }
    
}
