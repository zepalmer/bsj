package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation2Arguments;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.MethodInvocationNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.PrimaryExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ReferenceTypeListNode;
import edu.jhu.cs.bsj.compiler.impl.ast.BsjNodeManager;
import edu.jhu.cs.bsj.compiler.impl.ast.attribute.ReadWriteAttribute;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class MethodInvocationNodeImpl extends NodeImpl implements MethodInvocationNode
{
    /** The expression against which to invoke the method. */
    private PrimaryExpressionNode expression;
    
    /** The name of the method to invoke. */
    private IdentifierNode identifier;
    
    /** The arguments to pass to the method. */
    private ExpressionListNode arguments;
    
    /** The type arguments for the method. */
    private ReferenceTypeListNode typeArguments;
    
    private Map<LocalAttribute,ReadWriteAttribute> localAttributes = new EnumMap<LocalAttribute,ReadWriteAttribute>(LocalAttribute.class);
    private ReadWriteAttribute getAttribute(LocalAttribute attributeName)
    {
        ReadWriteAttribute attribute = localAttributes.get(attributeName);
        if (attribute == null)
        {
            attribute = new ReadWriteAttribute(MethodInvocationNodeImpl.this);
            localAttributes.put(attributeName, attribute);
        }
        return attribute;
    }
    private static enum LocalAttribute
    {
        /** Attribute identifier for the expression property. */
        EXPRESSION,
        /** Attribute identifier for the identifier property. */
        IDENTIFIER,
        /** Attribute identifier for the arguments property. */
        ARGUMENTS,
        /** Attribute identifier for the typeArguments property. */
        TYPE_ARGUMENTS,
    }
    
    /** General constructor. */
    public MethodInvocationNodeImpl(
            PrimaryExpressionNode expression,
            IdentifierNode identifier,
            ExpressionListNode arguments,
            ReferenceTypeListNode typeArguments,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation,
            BsjNodeManager manager,
            boolean binary)
    {
        super(startLocation, stopLocation, manager, binary);
        setExpression(expression, false);
        setIdentifier(identifier, false);
        setArguments(arguments, false);
        setTypeArguments(typeArguments, false);
    }
    
    /**
     * Gets the expression against which to invoke the method.
     * @return The expression against which to invoke the method.
     */
    public PrimaryExpressionNode getExpression()
    {
        getAttribute(LocalAttribute.EXPRESSION).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.expression;
    }
    
    /**
     * Changes the expression against which to invoke the method.
     * @param expression The expression against which to invoke the method.
     */
    public void setExpression(PrimaryExpressionNode expression)
    {
            setExpression(expression, true);
            getManager().notifyChange(this);
    }
    
    private void setExpression(PrimaryExpressionNode expression, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.EXPRESSION).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(expression, false);
        this.expression = expression;
        setAsChild(expression, true);
    }
    
    /**
     * Gets the name of the method to invoke.
     * @return The name of the method to invoke.
     */
    public IdentifierNode getIdentifier()
    {
        getAttribute(LocalAttribute.IDENTIFIER).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.identifier;
    }
    
    /**
     * Changes the name of the method to invoke.
     * @param identifier The name of the method to invoke.
     */
    public void setIdentifier(IdentifierNode identifier)
    {
            setIdentifier(identifier, true);
            getManager().notifyChange(this);
    }
    
    private void setIdentifier(IdentifierNode identifier, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.IDENTIFIER).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(identifier, false);
        this.identifier = identifier;
        setAsChild(identifier, true);
    }
    
    /**
     * Gets the arguments to pass to the method.
     * @return The arguments to pass to the method.
     */
    public ExpressionListNode getArguments()
    {
        getAttribute(LocalAttribute.ARGUMENTS).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.arguments;
    }
    
    /**
     * Changes the arguments to pass to the method.
     * @param arguments The arguments to pass to the method.
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
        setAsChild(arguments, false);
        this.arguments = arguments;
        setAsChild(arguments, true);
    }
    
    /**
     * Gets the type arguments for the method.
     * @return The type arguments for the method.
     */
    public ReferenceTypeListNode getTypeArguments()
    {
        getAttribute(LocalAttribute.TYPE_ARGUMENTS).recordAccess(ReadWriteAttribute.AccessType.READ);
        return this.typeArguments;
    }
    
    /**
     * Changes the type arguments for the method.
     * @param typeArguments The type arguments for the method.
     */
    public void setTypeArguments(ReferenceTypeListNode typeArguments)
    {
            setTypeArguments(typeArguments, true);
            getManager().notifyChange(this);
    }
    
    private void setTypeArguments(ReferenceTypeListNode typeArguments, boolean checkPermissions)
    {
        if (checkPermissions)
        {
            getManager().assertMutatable(this);
            getAttribute(LocalAttribute.TYPE_ARGUMENTS).recordAccess(ReadWriteAttribute.AccessType.WRITE);
        }
        setAsChild(typeArguments, false);
        this.typeArguments = typeArguments;
        setAsChild(typeArguments, true);
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
        if (this.expression != null)
        {
            this.expression.receive(visitor);
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
        if (this.expression != null)
        {
            this.expression.receiveTyped(visitor);
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
        visitor.visitMethodInvocationNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitRestrictedPrimaryExpressionNodeStart(this);
        visitor.visitStatementExpressionNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitRestrictedPrimaryExpressionNodeStop(this);
        visitor.visitStatementExpressionNodeStop(this);
        visitor.visitNodeStop(this);
        visitor.visitMethodInvocationNodeStop(this, true);
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
        list.add(getExpression());
        list.add(getIdentifier());
        list.add(getArguments());
        list.add(getTypeArguments());
        return list;
    }
    
    /**
     * Returns an iterator over the children of this node.
     * @see Node#getChildIterator()
     */
    @Override
    public Iterable<? extends Node> getChildIterable()
    {
        return Arrays.asList(new Node[]{getExpression(), getIdentifier(), getArguments(), getTypeArguments()});
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
        sb.append("expression=");
        sb.append(this.getExpression() == null? "null" : this.getExpression().getClass().getSimpleName());
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
        return operation.executeMethodInvocationNode(this, p);
    }
    
    /**
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p1 The parameter to pass to the operation.
     * @param p2 The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P1,P2,R> R executeOperation(BsjNodeOperation2Arguments<P1,P2,R> operation, P1 p1, P2 p2)
    {
        return operation.executeMethodInvocationNode(this, p1, p2);
    }
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MethodInvocationNode deepCopy(BsjNodeFactory factory)
    {
        return factory.makeMethodInvocationNode(
                getExpression()==null?null:getExpression().deepCopy(factory),
                getIdentifier()==null?null:getIdentifier().deepCopy(factory),
                getArguments()==null?null:getArguments().deepCopy(factory),
                getTypeArguments()==null?null:getTypeArguments().deepCopy(factory),
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
        
        if (before.equals(this.getExpression()) && (after instanceof PrimaryExpressionNode))
        {
            setExpression((PrimaryExpressionNode)after);
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
