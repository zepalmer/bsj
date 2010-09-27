package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.BsjSpecificNode;
import edu.jhu.cs.bsj.compiler.ast.node.Node;
import edu.jhu.cs.bsj.compiler.ast.node.NonAssignmentExpressionNode;

/**
 * A value in a meta-annotation which is an expression.  This value may not be an assignment expression.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface MetaAnnotationExpressionValueNode extends Node, MetaAnnotationValueNode, BsjSpecificNode
{
    /**
     * Gets the expression.
     * @return The expression.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public NonAssignmentExpressionNode getExpression() throws ClassCastException;
    
    /**
     * Gets the union object for the expression.
     * @return A union object representing The expression.
     */
    public NodeUnion<? extends NonAssignmentExpressionNode> getUnionForExpression();
    
    /**
     * Changes the expression.
     * @param expression The expression.
     */
    public void setExpression(NonAssignmentExpressionNode expression);
    
    /**
     * Changes the expression.
     * @param expression The expression.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForExpression(NodeUnion<? extends NonAssignmentExpressionNode> expression) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public MetaAnnotationExpressionValueNode deepCopy(BsjNodeFactory factory);
    
}
