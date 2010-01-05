package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.InlineTypeDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.tags.InlineTypeDeclarable;

public class InlineTypeDeclarationNodeImpl extends StatementNodeImpl implements InlineTypeDeclarationNode
{
    /** The type declaration. */
    private InlineTypeDeclarable declaration;

    /** General constructor. */
    public InlineTypeDeclarationNodeImpl(
            InlineTypeDeclarable declaration)
    {
        super();
        this.declaration = declaration;
    }

    /**
     * Gets the type declaration.
     * @return The type declaration.
     */
    public InlineTypeDeclarable getDeclaration()
    {
        return this.declaration;
    }

    /**
     * Changes the type declaration.
     * @param declaration The type declaration.
     */
    public void setDeclaration(InlineTypeDeclarable declaration)
    {
        this.declaration = declaration;
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
    }
}
