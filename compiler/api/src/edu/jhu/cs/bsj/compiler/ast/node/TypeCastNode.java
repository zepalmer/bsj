package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * A node for typecast expressions, as in:
 * <pre>
 * (<i>type</i>) <i>expr</i>
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface TypeCastNode extends Node, NonAssignmentExpressionNode
{
    /**
     * Gets the expression to cast.
     * @return The expression to cast.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getExpression() throws ClassCastException;
    
    /**
     * Gets the union object for the expression to cast.
     * @return A union object representing The expression to cast.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForExpression();
    
    /**
     * Changes the expression to cast.
     * @param expression The expression to cast.
     */
    public void setExpression(ExpressionNode expression);
    
    /**
     * Changes the expression to cast.
     * @param expression The expression to cast.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForExpression(NodeUnion<? extends ExpressionNode> expression) throws NullPointerException;
    
    /**
     * Gets the type to which to cast.
     * @return The type to which to cast.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public TypeNode getType() throws ClassCastException;
    
    /**
     * Gets the union object for the type to which to cast.
     * @return A union object representing The type to which to cast.
     */
    public NodeUnion<? extends TypeNode> getUnionForType();
    
    /**
     * Changes the type to which to cast.
     * @param type The type to which to cast.
     */
    public void setType(TypeNode type);
    
    /**
     * Changes the type to which to cast.
     * @param type The type to which to cast.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForType(NodeUnion<? extends TypeNode> type) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public TypeCastNode deepCopy(BsjNodeFactory factory);
    
}
