package edu.jhu.cs.bsj.compiler;

public interface ArrayAccessNode extends ExpressionNode
{
    ExpressionNode getExpression();
    
    ExpressionNode getIndex();
}
