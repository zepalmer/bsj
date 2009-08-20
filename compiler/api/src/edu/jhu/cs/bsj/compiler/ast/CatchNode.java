package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for catch clauses.
 */
public interface CatchNode extends Node
{
    BlockStatementNode getBlock();
    
    VariableNode getParameter();
}
