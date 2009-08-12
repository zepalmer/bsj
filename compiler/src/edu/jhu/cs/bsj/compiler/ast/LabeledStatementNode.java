package edu.jhu.cs.bsj.compiler.ast;

public interface LabeledStatementNode extends StatementNode
{
    Identifier getLabel();
    
    StatementNode getStatement();
}
