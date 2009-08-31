package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.InterfaceDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;

public class InterfaceDeclarationNodeImpl extends TypeDeclarationNodeImpl implements InterfaceDeclarationNode
{
    /** The extends clause. */
    private ListNode<? extends TypeNode> extendsClause;

    /** This interface's body. */
    private InterfaceBodyNode body;

    /** This class's type parameters. */
    private ListNode<? extends TypeParameterNode> typeParameters;

    /** General constructor. */
    public InterfaceDeclarationNodeImpl(
            ListNode<? extends TypeNode> extendsClause,
            InterfaceBodyNode body,
            ListNode<? extends TypeParameterNode> typeParameters,
            IdentifierNode simpleName,
            ModifiersNode modifiers)
    {
        super(simpleName, modifiers);
        this.extendsClause = extendsClause;
        this.body = body;
        this.typeParameters = typeParameters;
    }

    /**
     * Gets the extends clause.
     * @return The extends clause.
     */
    public ListNode<? extends TypeNode> getExtendsClause()
    {
        return this.extendsClause;
    }

    /**
     * Changes the extends clause.
     * @param extendsClause The extends clause.
     */
    public void setExtendsClause(ListNode<? extends TypeNode> extendsClause)
    {
        this.extendsClause = extendsClause;
    }

    /**
     * Gets this interface's body.
     * @return This interface's body.
     */
    public InterfaceBodyNode getBody()
    {
        return this.body;
    }

    /**
     * Changes this interface's body.
     * @param body This interface's body.
     */
    public void setBody(InterfaceBodyNode body)
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
