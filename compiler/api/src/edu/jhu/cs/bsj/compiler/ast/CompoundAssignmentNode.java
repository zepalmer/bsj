package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for compound assignments.
 */
public interface CompoundAssignmentNode extends ExpressionNode
{
    ExpressionNode getExpression();
    
    ExpressionNode getVariable();
}
