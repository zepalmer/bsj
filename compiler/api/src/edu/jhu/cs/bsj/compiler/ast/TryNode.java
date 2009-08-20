package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;

/**
 * A node for try/catch blocks.
 */
public interface TryNode extends StatementNode
{
    BlockStatementNode getBlock();
    
    List<? extends CatchNode> getCatches();
              
    BlockStatementNode getFinallyBlock();
}
