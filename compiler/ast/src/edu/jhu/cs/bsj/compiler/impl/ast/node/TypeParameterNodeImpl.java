package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ReferenceTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;

public class TypeParameterNodeImpl extends NodeImpl implements TypeParameterNode
{
    /** The base type name for the parameter. */
    private IdentifierNode identifier;

    /** The bounds over the base type. */
    private ListNode<? extends ReferenceTypeNode> bounds;

    /** General constructor. */
    public TypeParameterNodeImpl(
            IdentifierNode identifier,
            ListNode<? extends ReferenceTypeNode> bounds)
    {
        super();
        this.identifier = identifier;
        this.bounds = bounds;
    }

    /**
     * Gets the base type name for the parameter.
     * @return The base type name for the parameter.
     */
    public IdentifierNode getIdentifier()
    {
        return this.identifier;
    }

    /**
     * Changes the base type name for the parameter.
     * @param identifier The base type name for the parameter.
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
     * Gets the bounds over the base type.
     * @return The bounds over the base type.
     */
    public ListNode<? extends ReferenceTypeNode> getBounds()
    {
        return this.bounds;
    }

    /**
     * Changes the bounds over the base type.
     * @param bounds The bounds over the base type.
     */
    public void setBounds(ListNode<? extends ReferenceTypeNode> bounds)
    {
        if (this.bounds instanceof NodeImpl)
        {
            ((NodeImpl)this.bounds).setParent(null);
        }
        this.bounds = bounds;
        if (this.bounds instanceof NodeImpl)
        {
            ((NodeImpl)this.bounds).setParent(this);
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
        this.identifier.receive(visitor);
        this.bounds.receive(visitor);
    }
}
