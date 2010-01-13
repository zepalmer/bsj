package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.BreakNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;

public class BreakNodeImpl extends NodeImpl implements BreakNode
{
    /** The break label. */
    private IdentifierNode label;

    /** General constructor. */
    public BreakNodeImpl(
            IdentifierNode label)
    {
        super();
        this.label = label;
    }

    /**
     * Gets the break label.
     * @return The break label.
     */
    public IdentifierNode getLabel()
    {
        return this.label;
    }

    /**
     * Changes the break label.
     * @param label The break label.
     */
    public void setLabel(IdentifierNode label)
    {
        if (this.label instanceof NodeImpl)
        {
            ((NodeImpl)this.label).setParent(null);
        }
        this.label = label;
        if (this.label instanceof NodeImpl)
        {
            ((NodeImpl)this.label).setParent(this);
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
        this.label.receive(visitor);
    }
}
