package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for typecasting.
 */
public interface TypeCastNode extends ExpressionNode
{
    ExpressionNode getExpression();
    
    Node getType();
}
