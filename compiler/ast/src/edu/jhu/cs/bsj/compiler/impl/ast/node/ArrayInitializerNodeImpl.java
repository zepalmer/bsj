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
        this.type = type;
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
        this.initializers = initializers;
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
