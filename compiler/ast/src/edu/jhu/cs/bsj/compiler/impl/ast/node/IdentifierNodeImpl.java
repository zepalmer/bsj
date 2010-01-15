package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
public class IdentifierNodeImpl extends NodeImpl implements IdentifierNode
{
    /** The identifier contained in this node. */
    private String identifier;

    /** General constructor. */
    public IdentifierNodeImpl(
            String identifier)
    {
        super();
        this.identifier = identifier;
    }

    /**
     * Gets the identifier contained in this node.
     * @return The identifier contained in this node.
     */
    public String getIdentifier()
    {
        return this.identifier;
    }

    /**
     * Changes the identifier contained in this node.
     * @param identifier The identifier contained in this node.
     */
    public void setIdentifier(String identifier)
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

    /**
     * Produces a mutable list of this node's children.  Modifying this list will have no
     * effect on this node.
     * @return A list of this node's children.
     */
    @Override
    public List<Object> getChildObjects()
    {
        List<Object> list = super.getChildObjects();
        list.add(this.identifier);
        return list;
    }

    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Identifier[" + this.identifier + "]");
        return sb.toString();
    }
}
