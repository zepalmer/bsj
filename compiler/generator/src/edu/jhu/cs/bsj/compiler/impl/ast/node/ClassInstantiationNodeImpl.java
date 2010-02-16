package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjSourceLocation;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.AnonymousClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeArgumentListNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public abstract class ClassInstantiationNodeImpl extends NodeImpl implements ClassInstantiationNode
{
    /** The type arguments for the constructor. */
    private TypeArgumentListNode constructorTypeArguments;

    /** The arguments to the constructor. */
    private ExpressionListNode arguments;

    /** The body of the anonymous class. */
    private AnonymousClassBodyNode body;

    /** General constructor. */
    protected ClassInstantiationNodeImpl(
            TypeArgumentListNode constructorTypeArguments,
            ExpressionListNode arguments,
            AnonymousClassBodyNode body,
            BsjSourceLocation startLocation,
            BsjSourceLocation stopLocation)
    {
        super(startLocation, stopLocation);
        setConstructorTypeArguments(constructorTypeArguments);
        setArguments(arguments);
        setBody(body);
    }

    /**
     * Gets the type arguments for the constructor.
     * @return The type arguments for the constructor.
     */
    public TypeArgumentListNode getConstructorTypeArguments()
    {
        return this.constructorTypeArguments;
    }

    /**
     * Changes the type arguments for the constructor.
     * @param constructorTypeArguments The type arguments for the constructor.
     */
    public void setConstructorTypeArguments(TypeArgumentListNode constructorTypeArguments)
    {
        if (this.constructorTypeArguments instanceof NodeImpl)
        {
            ((NodeImpl)this.constructorTypeArguments).setParent(null);
        }
        this.constructorTypeArguments = constructorTypeArguments;
        if (this.constructorTypeArguments instanceof NodeImpl)
        {
            ((NodeImpl)this.constructorTypeArguments).setParent(this);
        }
    }

    /**
     * Gets the arguments to the constructor.
     * @return The arguments to the constructor.
     */
    public ExpressionListNode getArguments()
    {
        return this.arguments;
    }

    /**
     * Changes the arguments to the constructor.
     * @param arguments The arguments to the constructor.
     */
    public void setArguments(ExpressionListNode arguments)
    {
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
     * Gets the body of the anonymous class.
     * @return The body of the anonymous class.
     */
    public AnonymousClassBodyNode getBody()
    {
        return this.body;
    }

    /**
     * Changes the body of the anonymous class.
     * @param body The body of the anonymous class.
     */
    public void setBody(AnonymousClassBodyNode body)
    {
        if (this.body instanceof NodeImpl)
        {
            ((NodeImpl)this.body).setParent(null);
        }
        this.body = body;
        if (this.body instanceof NodeImpl)
        {
            ((NodeImpl)this.body).setParent(this);
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
