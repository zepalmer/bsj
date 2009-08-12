package edu.jhu.cs.bsj.compiler.ast;

public interface ArrayAccessNode extends ExpressionNode
{
    ExpressionNode getExpression();
    
    ExpressionNode getIndex();
}
