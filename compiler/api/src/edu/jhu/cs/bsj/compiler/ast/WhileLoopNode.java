package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for a while loop, as in:
 * 
 * while (condition)
 *    statement
 */
public interface WhileLoopNode extends StatementNode
{
    ExpressionNode getCondition();
    
    StatementNode getStatement();
}
