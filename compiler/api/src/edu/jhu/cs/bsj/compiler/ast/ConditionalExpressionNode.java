package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for conditionals of the form:
 * 
 * condition ? trueExpression : falseExpression
 */
public interface ConditionalExpressionNode extends ExpressionNode
{
    ExpressionNode getCondition();
    
    ExpressionNode getFalseExpression();
              
    ExpressionNode getTrueExpression();
}
