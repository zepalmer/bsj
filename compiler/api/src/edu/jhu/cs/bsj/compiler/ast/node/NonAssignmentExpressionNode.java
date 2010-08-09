package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * This tagging interface describes expressions which are not assignment expressions.  In some contexts, assignment
 * expressions are not permitted (such as in the initializers of annotation values).
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface NonAssignmentExpressionNode extends Node, ExpressionNode
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public NonAssignmentExpressionNode deepCopy(BsjNodeFactory factory);
    
}
