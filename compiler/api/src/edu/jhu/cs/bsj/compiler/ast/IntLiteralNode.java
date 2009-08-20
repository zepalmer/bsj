package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for an int literal.
 */
public interface IntLiteralNode extends LiteralNode
{
    int getValue();
}
