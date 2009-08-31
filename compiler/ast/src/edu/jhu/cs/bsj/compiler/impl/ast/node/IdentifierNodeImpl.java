package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.Identifier;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;

public class IdentifierNodeImpl extends NameNodeImpl implements IdentifierNode
{
    /** The identifier contained in this node. */
    private Identifier identifier;

    /** General constructor. */
    public IdentifierNodeImpl(
            Identifier identifier)
    {
        super();
        this.identifier = identifier;
    }

    /**
     * Gets the identifier contained in this node.
     * @return The identifier contained in this node.
     */
    public Identifier getIdentifier()
    {
        return this.identifier;
    }

    /**
     * Changes the identifier contained in this node.
     * @param identifier The identifier contained in this node.
     */
    public void setIdentifier(Identifier identifier)
    {
        this.identifier = identifier;
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
