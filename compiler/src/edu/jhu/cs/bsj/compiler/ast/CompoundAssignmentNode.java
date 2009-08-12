package edu.jhu.cs.bsj.compiler.ast;

public interface CompoundAssignmentNode extends ExpressionNode
{
    ExpressionNode getExpression();
    
    ExpressionNode getVariable();
}
