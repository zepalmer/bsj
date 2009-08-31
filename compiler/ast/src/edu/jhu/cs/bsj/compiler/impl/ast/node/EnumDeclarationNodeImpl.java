package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.EnumBodyNode;
import edu.jhu.cs.bsj.compiler.ast.node.EnumDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;

public class EnumDeclarationNodeImpl extends TypeDeclarationNodeImpl implements EnumDeclarationNode
{
    /** The implements clause. */
    private ListNode<? extends TypeNode> implementsClause;

    /** This enum's body. */
    private EnumBodyNode body;

    /** General constructor. */
    public EnumDeclarationNodeImpl(
            ListNode<? extends TypeNode> implementsClause,
            EnumBodyNode body,
            IdentifierNode simpleName,
            ModifiersNode modifiers)
    {
        super(simpleName, modifiers);
        this.implementsClause = implementsClause;
        this.body = body;
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
     * Gets this enum's body.
     * @return This enum's body.
     */
    public EnumBodyNode getBody()
    {
        return this.body;
    }

    /**
     * Changes this enum's body.
     * @param body This enum's body.
     */
    public void setBody(EnumBodyNode body)
    {
        this.body = body;
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
