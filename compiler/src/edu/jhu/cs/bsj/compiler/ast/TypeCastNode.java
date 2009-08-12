package edu.jhu.cs.bsj.compiler;

public interface TypeCastNode extends ExpressionNode
{
    ExpressionNode getExpression();
    
    Node getType();
}
