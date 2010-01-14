package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.FieldAccessByNameNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;

public class FieldAccessByNameNodeImpl extends NodeImpl implements FieldAccessByNameNode
{
    /** The name of the field to access. */
    private NameNode name;

    /** General constructor. */
    public FieldAccessByNameNodeImpl(
            NameNode name)
    {
        super();
        this.name = name;
    }

    /**
     * Gets the name of the field to access.
     * @return The name of the field to access.
     */
    public NameNode getName()
    {
        return this.name;
    }

    /**
     * Changes the name of the field to access.
     * @param name The name of the field to access.
     */
    public void setName(NameNode name)
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
