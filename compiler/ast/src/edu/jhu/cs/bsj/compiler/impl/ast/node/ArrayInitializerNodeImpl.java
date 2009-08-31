package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;

public class ArrayInitializerNodeImpl extends ExpressionNodeImpl implements ArrayInitializerNode
{
    /** The type of the elements in the array. */
    private TypeNode type;

    /** The initializers for the array. */
    private ListNode<? extends ExpressionNode> initializers;

    /** General constructor. */
    public ArrayInitializerNodeImpl(
            TypeNode type,
            ListNode<? extends ExpressionNode> initializers)
    {
        super();
        this.type = type;
        this.initializers = initializers;
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
     * Gets the initializers for the array.
     * @return The initializers for the array.
     */
    public ListNode<? extends ExpressionNode> getInitializers()
    {
        return this.initializers;
    }

    /**
     * Changes the initializers for the array.
     * @param initializers The initializers for the array.
     */
    public void setInitializers(ListNode<? extends ExpressionNode> initializers)
    {
        if (this.initializers instanceof NodeImpl)
        {
            ((NodeImpl)this.initializers).setParent(null);
        }
        this.initializers = initializers;
        if (this.initializers instanceof NodeImpl)
        {
            ((NodeImpl)this.initializers).setParent(this);
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
        this.initializers.receive(visitor);
    }
}
