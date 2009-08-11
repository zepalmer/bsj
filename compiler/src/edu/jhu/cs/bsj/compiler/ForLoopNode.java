package edu.jhu.cs.bsj.compiler;

import java.util.List;

public interface ForLoopNode extends StatementNode
{
    ExpressionNode getCondition();
    
    StatementNode getStatement();
    
    List<? extends StatementNode> getInitializer();
    
    List<? extends ExpressionStatementNode> getUpdate();
}
