package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeArgumentListNode;

/**
 * Acts as a parent to class instantiation nodes. 
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ClassInstantiationNode extends Node, RestrictedPrimaryExpressionNode, StatementExpressionNode
{
    /**
     * Gets the type arguments for the constructor.
     * @return The type arguments for the constructor.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public TypeArgumentListNode getConstructorTypeArguments()throws ClassCastException;
    
    /**
     * Gets the union object for the type arguments for the constructor.
     * @return A union object representing The type arguments for the constructor.
     */
    public NodeUnion<? extends TypeArgumentListNode> getUnionForConstructorTypeArguments();
    
    /**
     * Changes the type arguments for the constructor.
     * @param constructorTypeArguments The type arguments for the constructor.
     */
    public void setConstructorTypeArguments(TypeArgumentListNode constructorTypeArguments);
    
    /**
     * Changes the type arguments for the constructor.
     * @param constructorTypeArguments The type arguments for the constructor.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForConstructorTypeArguments(NodeUnion<? extends TypeArgumentListNode> constructorTypeArguments) throws NullPointerException;
    
    /**
     * Gets the arguments to the constructor.
     * @return The arguments to the constructor.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionListNode getArguments()throws ClassCastException;
    
    /**
     * Gets the union object for the arguments to the constructor.
     * @return A union object representing The arguments to the constructor.
     */
    public NodeUnion<? extends ExpressionListNode> getUnionForArguments();
    
    /**
     * Changes the arguments to the constructor.
     * @param arguments The arguments to the constructor.
     */
    public void setArguments(ExpressionListNode arguments);
    
    /**
     * Changes the arguments to the constructor.
     * @param arguments The arguments to the constructor.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForArguments(NodeUnion<? extends ExpressionListNode> arguments) throws NullPointerException;
    
    /**
     * Gets the body of the anonymous class.
     * @return The body of the anonymous class.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public AnonymousClassBodyNode getBody()throws ClassCastException;
    
    /**
     * Gets the union object for the body of the anonymous class.
     * @return A union object representing The body of the anonymous class.
     */
    public NodeUnion<? extends AnonymousClassBodyNode> getUnionForBody();
    
    /**
     * Changes the body of the anonymous class.
     * @param body The body of the anonymous class.
     */
    public void setBody(AnonymousClassBodyNode body);
    
    /**
     * Changes the body of the anonymous class.
     * @param body The body of the anonymous class.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForBody(NodeUnion<? extends AnonymousClassBodyNode> body) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ClassInstantiationNode deepCopy(BsjNodeFactory factory);
    
}
