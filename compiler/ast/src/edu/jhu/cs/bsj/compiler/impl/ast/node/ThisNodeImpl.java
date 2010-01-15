package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ThisNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;

public class ThisNodeImpl extends NodeImpl implements ThisNode
{
    /** The qualifying type. */
    private UnparameterizedTypeNode type;

    /** General constructor. */
    public ThisNodeImpl(
            UnparameterizedTypeNode type)
    {
        super();
        this.type = type;
    }

    /**
     * Gets the qualifying type.
     * @return The qualifying type.
     */
    public UnparameterizedTypeNode getType()
    {
        return this.type;
    }

    /**
     * Changes the qualifying type.
     * @param type The qualifying type.
     */
    public void setType(UnparameterizedTypeNode type)
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

    /**
     * Produces a mutable list of this node's children.  Modifying this list will have no
     * effect on this node.
     * @return A list of this node's children.
     */
    @Override
    public List<Object> getChildObjects()
    {
        List<Object> list = super.getChildObjects();
        list.add(this.type);
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
        sb.append("type=");
        sb.append(this.type == null? "null" : this.type.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
