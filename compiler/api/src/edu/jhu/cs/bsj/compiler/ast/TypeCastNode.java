package edu.jhu.cs.bsj.compiler.ast;

public interface TypeCastNode extends ExpressionNode
{
    ExpressionNode getExpression();
    
    Node getType();
}
