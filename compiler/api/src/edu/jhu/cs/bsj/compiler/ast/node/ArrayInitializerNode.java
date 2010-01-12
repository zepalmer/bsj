package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing the initialization of an array, as in:
 * <pre>
 * {<i>initializer</i>,...}
 * </pre>
 * The resulting array contains one element for each initializer expression.
 */
public interface ArrayInitializerNode extends VariableInitializerNode
{
    /**
     * Gets the initializers for the array.
     * @return The initializers for the array.
     */
    public ListNode<? extends VariableInitializerNode> getInitializers();

    /**
     * Changes the initializers for the array.
     * @param initializers The initializers for the array.
     */
    public void setInitializers(ListNode<? extends VariableInitializerNode> initializers);

}
