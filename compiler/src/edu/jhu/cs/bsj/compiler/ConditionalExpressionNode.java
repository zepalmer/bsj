package edu.jhu.cs.bsj.compiler;

public interface ConditionalExpressionNode extends ExpressionNode
{
    ExpressionNode getCondition();
    
    ExpressionNode getFalseExpression();
              
    ExpressionNode getTrueExpression();
}
