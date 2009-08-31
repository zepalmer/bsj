package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ClassBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.ClassDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;

public class ClassDeclarationNodeImpl extends TypeDeclarationNodeImpl implements ClassDeclarationNode
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
        this.extendsClause = extendsClause;
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
        this.implementsClause = implementsClause;
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
        this.body = body;
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
        this.typeParameters = typeParameters;
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
