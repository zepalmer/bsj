package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;

/**
 * A node to be used as a substitute for malformed expressions.
 */
public interface ErroneousNode extends ExpressionNode
{
    List<? extends Node> getErrorTrees();
}
