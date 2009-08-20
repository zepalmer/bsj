package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for an if statement, such as:
 * 
 * if (condition)
 *    thenStatement
 *    
 * OR
 * 
 * if (condition)
 *    thenStatement
 * else
 *    elseStatement 
 */
public interface IfNode extends StatementNode
{
    ExpressionNode getCondition();
    
    StatementNode getElseStatement();
    
    StatementNode getThenStatement();
}
