package edu.jhu.cs.bsj.compiler.ast;

public interface ContinueNode extends StatementNode
{
    Identifier getLabel();
}
