package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for an import statement.
 */
public interface ImportNode extends Node
{
    Node getQualifiedIdentifier();
    
    boolean isStatic();
}
