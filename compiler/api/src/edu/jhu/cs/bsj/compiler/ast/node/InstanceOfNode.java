package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * Represents the invocation of the <tt>instanceof</tt> operator, as in:
 * <pre>
 * <i>expression</i> instanceof <i>type</i>
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InstanceOfNode extends Node, NonAssignmentExpressionNode
{
    /**
     * Gets the expression being evaluated.
     * @return The expression being evaluated.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionNode getExpression()throws ClassCastException;
    
    /**
     * Gets the union object for the expression being evaluated.
     * @return A union object representing The expression being evaluated.
     */
    public NodeUnion<? extends ExpressionNode> getUnionForExpression();
    
    /**
     * Changes the expression being evaluated.
     * @param expression The expression being evaluated.
     */
    public void setExpression(ExpressionNode expression);
    
    /**
     * Changes the expression being evaluated.
     * @param expression The expression being evaluated.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForExpression(NodeUnion<? extends ExpressionNode> expression) throws NullPointerException;
    
    /**
     * Gets the type being checked.
     * @return The type being checked.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public TypeNode getType()throws ClassCastException;
    
    /**
     * Gets the union object for the type being checked.
     * @return A union object representing The type being checked.
     */
    public NodeUnion<? extends TypeNode> getUnionForType();
    
    /**
     * Changes the type being checked.
     * @param type The type being checked.
     */
    public void setType(TypeNode type);
    
    /**
     * Changes the type being checked.
     * @param type The type being checked.
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
    public InstanceOfNode deepCopy(BsjNodeFactory factory);
    
}
