package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for continue labels.
 */
public interface ContinueNode extends StatementNode
{
    Identifier getLabel();
}
