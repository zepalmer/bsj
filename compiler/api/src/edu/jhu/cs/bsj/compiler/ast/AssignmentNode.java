package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for assigning expressions to variables.
 */
public interface AssignmentNode extends ExpressionNode
{
    ExpressionNode getExpression();
    
    ExpressionNode getVariable();
}
