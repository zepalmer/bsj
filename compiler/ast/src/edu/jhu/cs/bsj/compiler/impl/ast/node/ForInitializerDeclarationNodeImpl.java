package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ForInitializerDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclarationNode;

public class ForInitializerDeclarationNodeImpl extends ForInitializerNodeImpl implements ForInitializerDeclarationNode
{
    /** The variables declared in this initializer. */
    private VariableDeclarationNode declaration;

    /** General constructor. */
    public ForInitializerDeclarationNodeImpl(
            VariableDeclarationNode declaration)
    {
        super();
        this.declaration = declaration;
    }

    /**
     * Gets the variables declared in this initializer.
     * @return The variables declared in this initializer.
     */
    public VariableDeclarationNode getDeclaration()
    {
        return this.declaration;
    }

    /**
     * Changes the variables declared in this initializer.
     * @param declaration The variables declared in this initializer.
     */
    public void setDeclaration(VariableDeclarationNode declaration)
    {
        if (this.declaration instanceof NodeImpl)
        {
            ((NodeImpl)this.declaration).setParent(null);
        }
        this.declaration = declaration;
        if (this.declaration instanceof NodeImpl)
        {
            ((NodeImpl)this.declaration).setParent(this);
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
        this.declaration.receive(visitor);
    }
}
