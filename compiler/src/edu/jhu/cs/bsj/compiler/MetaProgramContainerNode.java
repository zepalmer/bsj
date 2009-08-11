package edu.jhu.cs.bsj.compiler;

import java.sql.Statement;

/**
 * Container interface for meta-programs.
 */
public interface MetaProgramContainerNode extends Statement
{
    /**
     * Retrieves the meta-program contained.
     * @return a MetaProgramNode.
     */
    MetaProgramNode getMetaProgramNode();
}
