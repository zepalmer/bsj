package edu.jhu.cs.bsj.compiler;

public interface InstanceOfNode extends ExpressionNode
{
    ExpressionNode getExpression();
    
    Node getType();
}
