package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeOperation;
import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeArgumentNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class QualifiedClassInstantiationNodeImpl extends ClassInstantiationNodeImpl implements QualifiedClassInstantiationNode
{
    /** The expression enclosing the non-static inner class. */
    private ExpressionNode enclosingExpression;

    /** The name of the class being instantiated. */
    private IdentifierNode identifier;

    /** The type arguments to apply to the class being instantiated. */
    private ListNode<TypeArgumentNode> typeArguments;

    /** General constructor. */
    public QualifiedClassInstantiationNodeImpl(
            ExpressionNode enclosingExpression,
            IdentifierNode identifier,
            ListNode<TypeArgumentNode> typeArguments,
            ListNode<TypeArgumentNode> constructorTypeArguments,
            ListNode<ExpressionNode> arguments,
            AnonymousClassBodyNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(constructorTypeArguments, arguments, body, startLocation, stopLocation);
        this.enclosingExpression = enclosingExpression;
        this.identifier = identifier;
        this.typeArguments = typeArguments;
    }

    /**
     * Gets the expression enclosing the non-static inner class.
     * @return The expression enclosing the non-static inner class.
     */
    public ExpressionNode getEnclosingExpression()
    {
        return this.enclosingExpression;
    }

    /**
     * Changes the expression enclosing the non-static inner class.
     * @param enclosingExpression The expression enclosing the non-static inner class.
     */
    public void setEnclosingExpression(ExpressionNode enclosingExpression)
    {
        if (this.enclosingExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.enclosingExpression).setParent(null);
        }
        this.enclosingExpression = enclosingExpression;
        if (this.enclosingExpression instanceof NodeImpl)
        {
            ((NodeImpl)this.enclosingExpression).setParent(this);
        }
    }

    /**
     * Gets the name of the class being instantiated.
     * @return The name of the class being instantiated.
     */
    public IdentifierNode getIdentifier()
    {
        return this.identifier;
    }

    /**
     * Changes the name of the class being instantiated.
     * @param identifier The name of the class being instantiated.
     */
    public void setIdentifier(IdentifierNode identifier)
    {
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
     * Gets the type arguments to apply to the class being instantiated.
     * @return The type arguments to apply to the class being instantiated.
     */
    public ListNode<TypeArgumentNode> getTypeArguments()
    {
        return this.typeArguments;
    }

    /**
     * Changes the type arguments to apply to the class being instantiated.
     * @param typeArguments The type arguments to apply to the class being instantiated.
     */
    public void setTypeArguments(ListNode<TypeArgumentNode> typeArguments)
    {
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
        this.enclosingExpression.receive(visitor);
        this.identifier.receive(visitor);
        this.typeArguments.receive(visitor);
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
        this.enclosingExpression.receiveTyped(visitor);
        this.identifier.receiveTyped(visitor);
        this.typeArguments.receiveTyped(visitor);
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
        visitor.visitNodeStart(this);
        visitor.visitClassInstantiationNodeStart(this);
        visitor.visitQualifiedClassInstantiationNodeStart(this, true);
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
        list.add(getEnclosingExpression());
        list.add(getIdentifier());
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
        sb.append("enclosingExpression=");
        sb.append(this.getEnclosingExpression() == null? "null" : this.getEnclosingExpression().getClass().getSimpleName());
        sb.append(',');
        sb.append("identifier=");
        sb.append(this.getIdentifier() == null? "null" : this.getIdentifier().getClass().getSimpleName());
        sb.append(',');
        sb.append("typeArguments=");
        sb.append(this.getTypeArguments() == null? "null" : this.getTypeArguments().getClass().getSimpleName());
        sb.append(',');
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

    /**
     * Executes an operation on this node.
     * @param operation The operation to perform.
     * @param p The parameter to pass to the operation.
     * @return The result of the operation.
     */
    @Override
    public <P,R> R executeOperation(BsjNodeOperation<P,R> operation, P p)
    {
        return operation.executeQualifiedClassInstantiationNode(this, p);
    }
}