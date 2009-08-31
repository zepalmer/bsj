package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing the creation of a new array, as in:
 * <pre>
 * new <i>type</i>[<i>dim</i>]<i>...</i>
 * </pre>
 * The resulting array contains default values based upon the array's type (0, false, or null).
 */
public interface ArrayInstantiatonNode extends ExpressionNode
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
     * Gets the dimensions of the array to create.
     * @return The dimensions of the array to create.
     */
    public ListNode<? extends ExpressionNode> getDimensions();

    /**
     * Changes the dimensions of the array to create.
     * @param dimensions The dimensions of the array to create.
     */
    public void setDimensions(ListNode<? extends ExpressionNode> dimensions);

}
