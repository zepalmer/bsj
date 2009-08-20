package edu.jhu.cs.bsj.compiler.ast;

public interface InstanceOfNode extends ExpressionNode
{
    ExpressionNode getExpression();
    
    Node getType();
}
