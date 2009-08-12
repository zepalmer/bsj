package edu.jhu.cs.bsj.compiler.ast;

public interface MemberSelectNode extends ExpressionNode
{
    ExpressionNode getExpression();
    
    Identifier getIdentifier(); 
}
