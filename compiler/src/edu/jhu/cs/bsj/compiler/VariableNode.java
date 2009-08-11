package edu.jhu.cs.bsj.compiler;

public interface VariableNode extends StatementNode
{
    ExpressionNode getInitializer();
    
    Identifier getName();
    
    Node getType();
}
