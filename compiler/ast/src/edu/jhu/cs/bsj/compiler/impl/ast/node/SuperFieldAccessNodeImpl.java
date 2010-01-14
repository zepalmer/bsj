package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.SuperFieldAccessNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;

public class SuperFieldAccessNodeImpl extends NodeImpl implements SuperFieldAccessNode
{
    /** The qualifying type. */
    private UnparameterizedTypeNode type;

    /** The identifier of the field being accessed. */
    private IdentifierNode identifier;

    /** General constructor. */
    public SuperFieldAccessNodeImpl(
            UnparameterizedTypeNode type,
            IdentifierNode identifier)
    {
        super();
        this.type = type;
        this.identifier = identifier;
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
     * Gets the identifier of the field being accessed.
     * @return The identifier of the field being accessed.
     */
    public IdentifierNode getIdentifier()
    {
        return this.identifier;
    }

    /**
     * Changes the identifier of the field being accessed.
     * @param identifier The identifier of the field being accessed.
     */
    public void setIdentifier(IdentifierNode identifier)
    {
        if (this.identifier instanceof NodeImpl)
        {
            ((NodeImpl)this.identifier).setParent(null);
        }
        this.identifier = identifier;
        if (this.identifier instanceof NodeImpl)
        {
            ((NodeImpl)this.identifier).setParent(this);
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
        this.identifier.receive(visitor);
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
        list.add(this.identifier);
        return list;
    }
}
