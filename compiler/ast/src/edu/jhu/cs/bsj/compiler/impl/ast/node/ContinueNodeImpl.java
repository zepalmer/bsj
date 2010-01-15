package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ContinueNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;

public class ContinueNodeImpl extends NodeImpl implements ContinueNode
{
    /** The continue label. */
    private IdentifierNode label;

    /** General constructor. */
    public ContinueNodeImpl(
            IdentifierNode label)
    {
        super();
        this.label = label;
    }

    /**
     * Gets the continue label.
     * @return The continue label.
     */
    public IdentifierNode getLabel()
    {
        return this.label;
    }

    /**
     * Changes the continue label.
     * @param label The continue label.
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

    /**
     * Produces a mutable list of this node's children.  Modifying this list will have no
     * effect on this node.
     * @return A list of this node's children.
     */
    @Override
    public List<Object> getChildObjects()
    {
        List<Object> list = super.getChildObjects();
        list.add(this.label);
        return list;
    }

    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append('[');
        sb.append("label=");
        sb.append(this.label == null? "null" : this.label.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
