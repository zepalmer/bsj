package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for long literals.
 */
public interface LongLiteralNode extends LiteralNode
{
    long getValue();
}
