package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for char literals.
 */
public interface CharLiteralNode extends LiteralNode
{
    char getValue();
}
