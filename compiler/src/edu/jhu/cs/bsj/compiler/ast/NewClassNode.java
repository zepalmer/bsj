package edu.jhu.cs.bsj.compiler;

import java.util.List;

public interface NewClassNode extends ExpressionNode
{
    List<? extends ExpressionNode> getArguments();
    
    ClassNode getClassBody();
              
    ExpressionNode getEnclosingExpression();
              
    ExpressionNode getIdentifier();
              
    List<? extends Node> getTypeArguments();
}
