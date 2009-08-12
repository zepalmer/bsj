package edu.jhu.cs.bsj.compiler;

import java.util.List;

public interface BlockStatementNode extends StatementNode
{
    List<? extends StatementNode> getStatements();
}
