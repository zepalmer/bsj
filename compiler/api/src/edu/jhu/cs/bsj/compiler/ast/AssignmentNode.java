package edu.jhu.cs.bsj.compiler.ast;

public interface AssignmentNode extends ExpressionNode
{
    ExpressionNode getExpression();
    
    ExpressionNode getVariable();
}
