package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public class ClassDeclarationNodeImpl extends NamedTypeDeclarationNodeImpl implements ClassDeclarationNode
{
    /** The extends clause. */
    private TypeNode extendsClause;

    /** The implements clause. */
    private ListNode<TypeNode> implementsClause;

    /** The body of this class. */
    private ClassBodyNode body;

    /** This class's type parameters. */
    private ListNode<TypeParameterNode> typeParameters;

    /** General constructor. */
    public ClassDeclarationNodeImpl(
            TypeNode extendsClause,
            ListNode<TypeNode> implementsClause,
            ClassBodyNode body,
            ListNode<TypeParameterNode> typeParameters,
            IdentifierNode identifier,
            ModifiersNode modifiers)
    {
        super(identifier, modifiers);
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
    public ListNode<TypeNode> getImplementsClause()
    {
        return this.implementsClause;
    }

    /**
     * Changes the implements clause.
     * @param implementsClause The implements clause.
     */
    public void setImplementsClause(ListNode<TypeNode> implementsClause)
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
    public ListNode<TypeParameterNode> getTypeParameters()
    {
        return this.typeParameters;
    }

    /**
     * Changes this class's type parameters.
     * @param typeParameters This class's type parameters.
     */
    public void setTypeParameters(ListNode<TypeParameterNode> typeParameters)
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
        this.extendsClause.receiveTyped(visitor);
        this.implementsClause.receiveTyped(visitor);
        this.body.receiveTyped(visitor);
        this.typeParameters.receiveTyped(visitor);
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitClassDeclarationNodeStart(this, true);
        visitor.visitNamedTypeDeclarationNodeStart(this);
        visitor.visitNodeStart(this);
        visitor.visitInlineTypeDeclarableNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitInlineTypeDeclarableNodeStop(this);
        visitor.visitNodeStart(this);
        visitor.visitNamedTypeDeclarationNodeStart(this);
        visitor.visitClassDeclarationNodeStart(this, true);
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
        list.add(this.extendsClause);
        list.add(this.implementsClause);
        list.add(this.body);
        list.add(this.typeParameters);
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
        sb.append("extendsClause=");
        sb.append(this.extendsClause == null? "null" : this.extendsClause.getClass().getSimpleName());
        sb.append(',');
        sb.append("implementsClause=");
        sb.append(this.implementsClause == null? "null" : this.implementsClause.getClass().getSimpleName());
        sb.append(',');
        sb.append("body=");
        sb.append(this.body == null? "null" : this.body.getClass().getSimpleName());
        sb.append(',');
        sb.append("typeParameters=");
        sb.append(this.typeParameters == null? "null" : this.typeParameters.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
