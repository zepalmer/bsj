package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for a statement with a label.
 */
public interface LabeledStatementNode extends StatementNode
{
    Identifier getLabel();
    
    StatementNode getStatement();
}
