package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.RawTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ThisNode;

public class ThisNodeImpl extends NodeImpl implements ThisNode
{
    /** The qualifying type. */
    private RawTypeNode type;

    /** General constructor. */
    public ThisNodeImpl(
            RawTypeNode type)
    {
        super();
        this.type = type;
    }

    /**
     * Gets the qualifying type.
     * @return The qualifying type.
     */
    public RawTypeNode getType()
    {
        return this.type;
    }

    /**
     * Changes the qualifying type.
     * @param type The qualifying type.
     */
    public void setType(RawTypeNode type)
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
