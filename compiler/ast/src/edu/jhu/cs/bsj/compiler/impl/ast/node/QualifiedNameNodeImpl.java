package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.NameCategory;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;

public class QualifiedNameNodeImpl extends NameNodeImpl implements QualifiedNameNode
{
    /** The name being qualified. */
    private NameNode base;

    /** The identifier used to qualify the base name. */
    private IdentifierNode identifier;

    /** General constructor. */
    public QualifiedNameNodeImpl(
            NameNode base,
            IdentifierNode identifier,
            NameCategory category)
    {
        super(category);
        this.base = base;
        this.identifier = identifier;
    }

    /**
     * Gets the name being qualified.
     * @return The name being qualified.
     */
    public NameNode getBase()
    {
        return this.base;
    }

    /**
     * Changes the name being qualified.
     * @param base The name being qualified.
     */
    public void setBase(NameNode base)
    {
        if (this.base instanceof NodeImpl)
        {
            ((NodeImpl)this.base).setParent(null);
        }
        this.base = base;
        if (this.base instanceof NodeImpl)
        {
            ((NodeImpl)this.base).setParent(this);
        }
    }

    /**
     * Gets the identifier used to qualify the base name.
     * @return The identifier used to qualify the base name.
     */
    public IdentifierNode getIdentifier()
    {
        return this.identifier;
    }

    /**
     * Changes the identifier used to qualify the base name.
     * @param identifier The identifier used to qualify the base name.
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
        this.base.receive(visitor);
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
        list.add(this.base);
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
        sb.append(this.base.toString());
        sb.append('.');
        sb.append(identifier.getIdentifier());
        sb.append('[');
        sb.append(this.getCategory());
        sb.append(']');
        return sb.toString();
    }
}
