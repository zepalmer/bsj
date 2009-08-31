package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing the creation of a new array, as in:
 * <pre>
 * new <i>type</i>[]{<i>initializer...</i>}
 * </pre>
 * The resulting array contains one element for each initializer expression.
 */
public interface ArrayInitializerNode extends ExpressionNode
{
    /**
     * Gets the type of the elements in the array.
     * @return The type of the elements in the array.
     */
    public TypeNode getType();

    /**
     * Changes the type of the elements in the array.
     * @param type The type of the elements in the array.
     */
    public void setType(TypeNode type);

    /**
     * Gets the initializers for the array.
     * @return The initializers for the array.
     */
    public ListNode<? extends ExpressionNode> getInitializers();

    /**
     * Changes the initializers for the array.
     * @param initializers The initializers for the array.
     */
    public void setInitializers(ListNode<? extends ExpressionNode> initializers);

}
