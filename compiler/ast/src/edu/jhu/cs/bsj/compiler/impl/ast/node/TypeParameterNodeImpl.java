package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeParameterNode;

public class TypeParameterNodeImpl extends NodeImpl implements TypeParameterNode
{
    /** The base type name for the parameter. */
    private IdentifierNode name;

    /** The bounds over the base type. */
    private ListNode<? extends TypeNode> bounds;

    /** General constructor. */
    public TypeParameterNodeImpl(
            IdentifierNode name,
            ListNode<? extends TypeNode> bounds)
    {
        super();
        this.name = name;
        this.bounds = bounds;
    }

    /**
     * Gets the base type name for the parameter.
     * @return The base type name for the parameter.
     */
    public IdentifierNode getName()
    {
        return this.name;
    }

    /**
     * Changes the base type name for the parameter.
     * @param name The base type name for the parameter.
     */
    public void setName(IdentifierNode name)
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
     * Gets the bounds over the base type.
     * @return The bounds over the base type.
     */
    public ListNode<? extends TypeNode> getBounds()
    {
        return this.bounds;
    }

    /**
     * Changes the bounds over the base type.
     * @param bounds The bounds over the base type.
     */
    public void setBounds(ListNode<? extends TypeNode> bounds)
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
     * Performs visitation for this node's children.
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        
    }
}
