package edu.jhu.cs.bsj.compiler;

import java.util.List;

public interface SwitchNode extends StatementNode
{
    List<? extends CaseNode> getCases();
    
    ExpressionNode getExpression();
}
