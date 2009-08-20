package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for accessing a member of a class, as in:
 * 
 * expression.identifier
 */
public interface MemberSelectNode extends ExpressionNode
{
    ExpressionNode getExpression();
    
    Identifier getIdentifier(); 
}
