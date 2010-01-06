package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;

public class ClassDeclarationNodeImpl extends NamedTypeDeclarationNodeImpl implements ClassDeclarationNode
{
    /** The extends clause. */
    private TypeNode extendsClause;

    /** The implements clause. */
    private ListNode<? extends TypeNode> implementsClause;

    /** The body of this class. */
    private ClassBodyNode body;

    /** This class's type parameters. */
    private ListNode<? extends TypeParameterNode> typeParameters;

    /** General constructor. */
    public ClassDeclarationNodeImpl(
            TypeNode extendsClause,
            ListNode<? extends TypeNode> implementsClause,
            ClassBodyNode body,
            ListNode<? extends TypeParameterNode> typeParameters,
            IdentifierNode simpleName,
            ModifiersNode modifiers)
    {
        super(simpleName, modifiers);
        this.extendsClause = extendsClause;
        this.implementsClause = implementsClause;
        this.body = body;
        this.typeParameters = typeParameters;
    }

    /**
     * Gets the extends clause.
     * @return The extends clause.
     */
    public TypeNode getExtendsClause()
    {
        return this.extendsClause;
    }

    /**
     * Changes the extends clause.
     * @param extendsClause The extends clause.
     */
    public void setExtendsClause(TypeNode extendsClause)
    {
        if (this.extendsClause instanceof NodeImpl)
        {
            ((NodeImpl)this.extendsClause).setParent(null);
        }
        this.extendsClause = extendsClause;
        if (this.extendsClause instanceof NodeImpl)
        {
            ((NodeImpl)this.extendsClause).setParent(this);
        }
    }

    /**
     * Gets the implements clause.
     * @return The implements clause.
     */
    public ListNode<? extends TypeNode> getImplementsClause()
    {
        return this.implementsClause;
    }

    /**
     * Changes the implements clause.
     * @param implementsClause The implements clause.
     */
    public void setImplementsClause(ListNode<? extends TypeNode> implementsClause)
    {
        if (this.implementsClause instanceof NodeImpl)
        {
            ((NodeImpl)this.implementsClause).setParent(null);
        }
        this.implementsClause = implementsClause;
        if (this.implementsClause instanceof NodeImpl)
        {
            ((NodeImpl)this.implementsClause).setParent(this);
        }
    }

    /**
     * Gets the body of this class.
     * @return The body of this class.
     */
    public ClassBodyNode getBody()
    {
        return this.body;
    }

    /**
     * Changes the body of this class.
     * @param body The body of this class.
     */
    public void setBody(ClassBodyNode body)
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
     * Gets this class's type parameters.
     * @return This class's type parameters.
     */
    public ListNode<? extends TypeParameterNode> getTypeParameters()
    {
        return this.typeParameters;
    }

    /**
     * Changes this class's type parameters.
     * @param typeParameters This class's type parameters.
     */
    public void setTypeParameters(ListNode<? extends TypeParameterNode> typeParameters)
    {
        if (this.typeParameters instanceof NodeImpl)
        {
            ((NodeImpl)this.typeParameters).setParent(null);
        }
        this.typeParameters = typeParameters;
        if (this.typeParameters instanceof NodeImpl)
        {
            ((NodeImpl)this.typeParameters).setParent(this);
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
        this.extendsClause.receive(visitor);
        this.implementsClause.receive(visitor);
        this.body.receive(visitor);
        this.typeParameters.receive(visitor);
    }
}
