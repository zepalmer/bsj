package edu.jhu.cs.bsj.compiler;

import java.util.List;

public interface ErroneousNode extends ExpressionNode
{
    List<? extends Node> getErrorTrees();
}
