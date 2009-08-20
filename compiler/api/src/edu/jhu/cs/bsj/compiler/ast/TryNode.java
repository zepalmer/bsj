package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;

public interface TryNode extends StatementNode
{
    BlockStatementNode getBlock();
    
    List<? extends CatchNode> getCatches();
              
    BlockStatementNode getFinallyBlock();
}
