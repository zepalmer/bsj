package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassInstantiationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;

public class ClassInstantiationNodeImpl extends ExpressionNodeImpl implements ClassInstantiationNode
{
    /** The type arguments of the instantiation. */
    private ListNode<? extends TypeNode> typeArguments;

    /** The identifier of the class. */
    private NameNode identifier;

    /** The arguments to the constructor. */
    private ListNode<? extends ExpressionNode> arguments;

    /** The body of the anonymous class. */
    private ClassDeclarationNode classBody;

    /** The expression enclosing the non-static inner class. */
    private ExpressionNode enclosingExpression;

    /** General constructor. */
    public ClassInstantiationNodeImpl(
            ListNode<? extends TypeNode> typeArguments,
            NameNode identifier,
            ListNode<? extends ExpressionNode> arguments,
            ClassDeclarationNode classBody,
            ExpressionNode enclosingExpression)
    {
        super();
        this.typeArguments = typeArguments;
        this.identifier = identifier;
        this.arguments = arguments;
        this.classBody = classBody;
        this.enclosingExpression = enclosingExpression;
    }

    /**
     * Gets the type arguments of the instantiation.
     * @return The type arguments of the instantiation.
     */
    public ListNode<? extends TypeNode> getTypeArguments()
    {
        return this.typeArguments;
    }

    /**
     * Changes the type arguments of the instantiation.
     * @param typeArguments The type arguments of the instantiation.
     */
    public void setTypeArguments(ListNode<? extends TypeNode> typeArguments)
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
     * Gets the identifier of the class.
     * @return The identifier of the class.
     */
    public NameNode getIdentifier()
    {
        return this.identifier;
    }

    /**
     * Changes the identifier of the class.
     * @param identifier The identifier of the class.
     */
    public void setIdentifier(NameNode identifier)
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
     * Gets the arguments to the constructor.
     * @return The arguments to the constructor.
     */
    public ListNode<? extends ExpressionNode> getArguments()
    {
        return this.arguments;
    }

    /**
     * Changes the arguments to the constructor.
     * @param arguments The arguments to the constructor.
     */
    public void setArguments(ListNode<? extends ExpressionNode> arguments)
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
    public ClassDeclarationNode getClassBody()
    {
        return this.classBody;
    }

    /**
     * Changes the body of the anonymous class.
     * @param classBody The body of the anonymous class.
     */
    public void setClassBody(ClassDeclarationNode classBody)
    {
        if (this.classBody instanceof NodeImpl)
        {
            ((NodeImpl)this.classBody).setParent(null);
        }
        this.classBody = classBody;
        if (this.classBody instanceof NodeImpl)
        {
            ((NodeImpl)this.classBody).setParent(this);
        }
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
     * Performs visitation for this node's children.
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        
    }
}
