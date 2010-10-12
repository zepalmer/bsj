package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.ReferenceTypeListNode;

/**
 * This class is a common superclass to both types of explicit constructor invocations: alternate constructor
 * invocations (those using the <tt>this</tt> keyword) and superclass constructor invocations (those using the
 * <tt>super</tt> keyword).  This distinction is made because, despite their similarities in use and syntax, the
 * language specification treats these two entities as distinct (and there are some corner cases for the superclass
 * constructor syntax which are best contained
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ConstructorInvocationNode extends Node
{
    /**
     * Gets the arguments to pass to the method.
     * @return The arguments to pass to the method.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionListNode getArguments()throws ClassCastException;
    
    /**
     * Gets the union object for the arguments to pass to the method.
     * @return A union object representing The arguments to pass to the method.
     */
    public NodeUnion<? extends ExpressionListNode> getUnionForArguments();
    
    /**
     * Changes the arguments to pass to the method.
     * @param arguments The arguments to pass to the method.
     */
    public void setArguments(ExpressionListNode arguments);
    
    /**
     * Changes the arguments to pass to the method.
     * @param arguments The arguments to pass to the method.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForArguments(NodeUnion<? extends ExpressionListNode> arguments) throws NullPointerException;
    
    /**
     * Gets the type arguments for the method.
     * @return The type arguments for the method.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ReferenceTypeListNode getTypeArguments()throws ClassCastException;
    
    /**
     * Gets the union object for the type arguments for the method.
     * @return A union object representing The type arguments for the method.
     */
    public NodeUnion<? extends ReferenceTypeListNode> getUnionForTypeArguments();
    
    /**
     * Changes the type arguments for the method.
     * @param typeArguments The type arguments for the method.
     */
    public void setTypeArguments(ReferenceTypeListNode typeArguments);
    
    /**
     * Changes the type arguments for the method.
     * @param typeArguments The type arguments for the method.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForTypeArguments(NodeUnion<? extends ReferenceTypeListNode> typeArguments) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ConstructorInvocationNode deepCopy(BsjNodeFactory factory);
    
}
