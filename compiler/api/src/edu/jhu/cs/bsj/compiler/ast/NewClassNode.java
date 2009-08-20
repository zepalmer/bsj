package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;

/**
 * A node for creating a new instance of a class.
 */
public interface NewClassNode extends ExpressionNode
{
    List<? extends ExpressionNode> getArguments();
    
    ClassNode getClassBody();
              
    ExpressionNode getEnclosingExpression();
              
    ExpressionNode getIdentifier();
              
    List<? extends Node> getTypeArguments();
}
