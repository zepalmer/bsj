package edu.jhu.cs.bsj.compiler;

import java.util.List;

public interface MethodInvocationNode extends ExpressionNode
{
    List<? extends ExpressionNode> getArguments();
    
    ExpressionNode getMethodSelect();
              
    List<? extends Node> getTypeArguments();
}
