package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for an instanceof check.
 */
public interface InstanceOfNode extends ExpressionNode
{
    ExpressionNode getExpression();
    
    Node getType();
}
