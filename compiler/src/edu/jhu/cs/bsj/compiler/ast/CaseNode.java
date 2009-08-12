package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;

public interface CaseNode extends Node
{
    ExpressionNode  getExpression();
    
    List<? extends StatementNode> getStatements();
}
