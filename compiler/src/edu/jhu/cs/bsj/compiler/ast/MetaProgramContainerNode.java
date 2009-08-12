package edu.jhu.cs.bsj.compiler.ast;

/**
 * Container interface for meta-programs.
 */
public interface MetaProgramContainerNode extends StatementNode
{
    /**
     * Retrieves the meta-program contained.
     * @return a MetaProgramNode.
     */
    MetaProgramNode getMetaProgramNode();
}
