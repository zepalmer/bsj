package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.DeclaredTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;

public class DeclaredTypeNodeImpl extends TypeNodeImpl implements DeclaredTypeNode
{
    /** The identifier naming this type. */
    private IdentifierNode name;

    /** General constructor. */
    public DeclaredTypeNodeImpl(
            IdentifierNode name)
    {
        super();
        this.name = name;
    }

    /**
     * Gets the identifier naming this type.
     * @return The identifier naming this type.
     */
    public IdentifierNode getName()
    {
        return this.name;
    }

    /**
     * Changes the identifier naming this type.
     * @param name The identifier naming this type.
     */
    public void setName(IdentifierNode name)
    {
        if (this.name instanceof NodeImpl)
        {
            ((NodeImpl)this.name).setParent(null);
        }
        this.name = name;
        if (this.name instanceof NodeImpl)
        {
            ((NodeImpl)this.name).setParent(this);
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
        this.name.receive(visitor);
    }
}
