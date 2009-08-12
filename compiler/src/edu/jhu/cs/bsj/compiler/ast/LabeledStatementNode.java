package edu.jhu.cs.bsj.compiler;

public interface LabeledStatementNode extends StatementNode
{
    Identifier getLabel();
    
    StatementNode getStatement();
}
