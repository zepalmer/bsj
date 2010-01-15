package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * A node representing the initialization of an array, as in:
 * <pre>
 * {<i>initializer</i>,...}
 * </pre>
 * The resulting array contains one element for each initializer expression.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
public interface ArrayInitializerNode extends Node, VariableInitializerNode
{
    /**
     * Gets the initializers for the array.
     * @return The initializers for the array.
     */
    public ListNode<VariableInitializerNode> getInitializers();

    /**
     * Changes the initializers for the array.
     * @param initializers The initializers for the array.
     */
    public void setInitializers(ListNode<VariableInitializerNode> initializers);

}
