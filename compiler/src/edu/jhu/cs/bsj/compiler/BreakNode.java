package edu.jhu.cs.bsj.compiler;

public interface BreakNode extends StatementNode
{
    Identifier getLabel();
}
