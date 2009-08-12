package edu.jhu.cs.bsj.compiler.ast;

/**
 * Interface for meta-program import.
 */
public interface MetaImportNode extends Node
{
    /**
     * Getter for the actual import node.
     * @return an ImportNode.
     */
    ImportNode getImport();
}
