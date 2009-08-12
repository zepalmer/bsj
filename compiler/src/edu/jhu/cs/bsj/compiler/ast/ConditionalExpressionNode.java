package edu.jhu.cs.bsj.compiler.ast;

public interface ConditionalExpressionNode extends ExpressionNode
{
    ExpressionNode getCondition();
    
    ExpressionNode getFalseExpression();
              
    ExpressionNode getTrueExpression();
}
