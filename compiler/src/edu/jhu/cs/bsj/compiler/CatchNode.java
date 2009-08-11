package edu.jhu.cs.bsj.compiler;

public interface CatchNode extends Node
{
    BlockStatementNode getBlock();
    
    VariableNode getParameter();
}
