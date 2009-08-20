package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;

/**
 * A node for switch statements.
 */
public interface SwitchNode extends StatementNode
{
    List<? extends CaseNode> getCases();
    
    ExpressionNode getExpression();
}
