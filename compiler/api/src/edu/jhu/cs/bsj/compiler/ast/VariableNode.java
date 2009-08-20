package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for a variable declaration.
 */
public interface VariableNode extends StatementNode
{
    ExpressionNode getInitializer();
    
    Identifier getName();
    
    Node getType();
}
