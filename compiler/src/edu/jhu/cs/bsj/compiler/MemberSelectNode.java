package edu.jhu.cs.bsj.compiler;

public interface MemberSelectNode extends ExpressionNode
{
    ExpressionNode getExpression();
    
    Identifier getIdentifier(); 
}
