package edu.jhu.cs.bsj.compiler.ast;

public interface VariableNode extends StatementNode
{
    ExpressionNode getInitializer();
    
    Identifier getName();
    
    Node getType();
}
