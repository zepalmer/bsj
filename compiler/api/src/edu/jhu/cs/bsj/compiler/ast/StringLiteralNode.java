package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for string literals.
 */
public interface StringLiteralNode extends LiteralNode
{
    String getValue();
}
