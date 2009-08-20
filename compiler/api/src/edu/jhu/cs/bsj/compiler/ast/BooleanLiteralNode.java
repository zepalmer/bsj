package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for true and false.
 */
public interface BooleanLiteralNode extends LiteralNode
{
    boolean getValue();
}
