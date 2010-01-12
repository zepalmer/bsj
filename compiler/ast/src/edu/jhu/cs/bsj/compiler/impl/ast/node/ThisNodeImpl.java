package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.ThisNode;

public class ThisNodeImpl extends RestrictedPrimaryExpressionNodeImpl implements ThisNode
{
    /** The name of the qualifying type. */
    private NameNode type;

    /** General constructor. */
    public ThisNodeImpl(
            NameNode type)
    {
        super();
        this.type = type;
    }

    /**
     * Gets the name of the qualifying type.
     * @return The name of the qualifying type.
     */
    public NameNode getType()
    {
        return this.type;
    }

    /**
     * Changes the name of the qualifying type.
     * @param type The name of the qualifying type.
     */
    public void setType(NameNode type)
    {
        if (this.type instanceof NodeImpl)
        {
            ((NodeImpl)this.type).setParent(null);
        }
        this.type = type;
        if (this.type instanceof NodeImpl)
        {
            ((NodeImpl)this.type).setParent(this);
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
        this.type.receive(visitor);
    }
}
