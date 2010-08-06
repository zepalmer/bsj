package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
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
    public MetaAnnotationExpressionValueNode deepCopy(BsjNodeFactory factory);
}
