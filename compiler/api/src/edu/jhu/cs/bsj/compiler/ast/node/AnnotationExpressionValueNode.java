package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A value in an annotation which is an expression.  This value may not be an assignment expression.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AnnotationExpressionValueNode extends Node, AnnotationValueNode
{
    /**
     * Gets the expression.
     * @return The expression.
     */
    public NonAssignmentExpressionNode getExpression();
    
    /**
     * Changes the expression.
     * @param expression The expression.
     */
    public void setExpression(NonAssignmentExpressionNode expression);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AnnotationExpressionValueNode deepCopy(BsjNodeFactory factory);
}
