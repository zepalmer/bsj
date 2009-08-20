package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;

/**
 * A node for cases in switch statements.
 */
public interface CaseNode extends Node
{
    ExpressionNode  getExpression();
    
    List<? extends StatementNode> getStatements();
}
