package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.VariableInitializerListNode;

/**
 * A node representing the initialization of an array, as in:
 * <pre>
 * {<i>initializer</i>,...}
 * </pre>
 * The resulting array contains one element for each initializer expression.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ArrayInitializerNode extends Node, VariableInitializerNode
{
    /**
     * Gets the initializers for the array.
     * @return The initializers for the array.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public VariableInitializerListNode getInitializers()throws ClassCastException;
    
    /**
     * Gets the union object for the initializers for the array.
     * @return A union object representing The initializers for the array.
     */
    public NodeUnion<? extends VariableInitializerListNode> getUnionForInitializers();
    
    /**
     * Changes the initializers for the array.
     * @param initializers The initializers for the array.
     */
    public void setInitializers(VariableInitializerListNode initializers);
    
    /**
     * Changes the initializers for the array.
     * @param initializers The initializers for the array.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForInitializers(NodeUnion<? extends VariableInitializerListNode> initializers) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ArrayInitializerNode deepCopy(BsjNodeFactory factory);
    
}
