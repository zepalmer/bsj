package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;

/**
 * A node for a statement block of the following form:
 * {
 *    ...statements...
 * }
 */
public interface BlockStatementNode extends StatementNode
{
    List<? extends StatementNode> getStatements();
}
