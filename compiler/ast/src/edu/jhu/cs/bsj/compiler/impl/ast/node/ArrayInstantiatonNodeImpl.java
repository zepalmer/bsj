package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInstantiatonNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;

public class ArrayInstantiatonNodeImpl extends ExpressionNodeImpl implements ArrayInstantiatonNode
{
    /** The type of the elements in the array. */
    private TypeNode type;

    /** The dimensions of the array to create. */
    private ListNode<? extends ExpressionNode> dimensions;

    /** General constructor. */
    public ArrayInstantiatonNodeImpl(
            TypeNode type,
            ListNode<? extends ExpressionNode> dimensions)
    {
        super();
        this.type = type;
        this.dimensions = dimensions;
    }

    /**
     * Gets the type of the elements in the array.
     * @return The type of the elements in the array.
     */
    public TypeNode getType()
    {
        return this.type;
    }

    /**
     * Changes the type of the elements in the array.
     * @param type The type of the elements in the array.
     */
    public void setType(TypeNode type)
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
     * Gets the dimensions of the array to create.
     * @return The dimensions of the array to create.
     */
    public ListNode<? extends ExpressionNode> getDimensions()
    {
        return this.dimensions;
    }

    /**
     * Changes the dimensions of the array to create.
     * @param dimensions The dimensions of the array to create.
     */
    public void setDimensions(ListNode<? extends ExpressionNode> dimensions)
    {
        if (this.dimensions instanceof NodeImpl)
        {
            ((NodeImpl)this.dimensions).setParent(null);
        }
        this.dimensions = dimensions;
        if (this.dimensions instanceof NodeImpl)
        {
            ((NodeImpl)this.dimensions).setParent(this);
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
        this.dimensions.receive(visitor);
    }
}
