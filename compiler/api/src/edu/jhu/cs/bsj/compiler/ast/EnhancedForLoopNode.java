package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for for loops of the form:
 * 
 * for (variable : expression)
 * {
 *    ...
 * }
 */
public interface EnhancedForLoopNode extends StatementNode
{
    ExpressionNode getExpression();
    
    StatementNode getStatement();
              
    VariableNode getVariable();              
}
