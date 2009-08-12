package edu.jhu.cs.bsj.compiler.ast;

public interface BreakNode extends StatementNode
{
    Identifier getLabel();
}
