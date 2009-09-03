package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.NameNode;
import edu.jhu.cs.bsj.compiler.ast.node.QualifiedNameNode;

public class QualifiedNameNodeImpl extends NameNodeImpl implements QualifiedNameNode
{
    /** The name to qualify. */
    private NameNode name;

    /** The identifier to use. */
    private IdentifierNode identifier;

    /** General constructor. */
    public QualifiedNameNodeImpl(
            NameNode name,
            IdentifierNode identifier)
    {
        super();
        this.name = name;
        this.identifier = identifier;
    }

    /**
     * Gets the name to qualify.
     * @return The name to qualify.
     */
    public NameNode getName()
    {
        return this.name;
    }

    /**
     * Changes the name to qualify.
     * @param name The name to qualify.
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
     * Gets the identifier to use.
     * @return The identifier to use.
     */
    public IdentifierNode getIdentifier()
    {
        return this.identifier;
    }

    /**
     * Changes the identifier to use.
     * @param identifier The identifier to use.
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
        this.name.receive(visitor);
        this.identifier.receive(visitor);
    }
}
