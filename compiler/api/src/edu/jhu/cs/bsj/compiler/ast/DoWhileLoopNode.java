package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for do while loops.
 */
public interface DoWhileLoopNode extends StatementNode
{
    ExpressionNode getCondition();
    
    StatementNode getStatement();
}
