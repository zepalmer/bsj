package edu.jhu.cs.bsj.compiler.ast;

public interface CatchNode extends Node
{
    BlockStatementNode getBlock();
    
    VariableNode getParameter();
}
