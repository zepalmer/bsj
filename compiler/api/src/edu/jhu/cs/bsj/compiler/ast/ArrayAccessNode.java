package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for accessing arrays.
 */
public interface ArrayAccessNode extends ExpressionNode
{
    ExpressionNode getExpression();
    
    ExpressionNode getIndex();
}
