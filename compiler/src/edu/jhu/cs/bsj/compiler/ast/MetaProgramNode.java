package edu.jhu.cs.bsj.compiler;

import java.util.List;

/**
 * Main interface for meta-programs.
 */
public interface MetaProgramNode extends Node
{
    /**
     * Gets the actual content of this meta-program.
     * @return a list of StatementNodes.
     */
    List<? extends StatementNode> getStatements();
    
    /**
     * Gets an object containing supporting information for this meta-program:
     * contains imports, dependency information, etc.
     * @return a MetaPreambleTree.
     */
    MetaPreambleNode getPreamble();
}
