package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for break labels.
 */
public interface BreakNode extends StatementNode
{
    Identifier getLabel();
}
