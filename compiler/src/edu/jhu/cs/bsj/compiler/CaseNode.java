package edu.jhu.cs.bsj.compiler;

import java.util.List;

public interface CaseNode extends Node
{
    ExpressionNode  getExpression();
    
    List<? extends StatementNode> getStatements();
}
