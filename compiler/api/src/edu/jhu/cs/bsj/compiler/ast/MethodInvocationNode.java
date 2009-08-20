package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;

/**
 * A node for calling a method of a class.
 */
public interface MethodInvocationNode extends ExpressionNode
{
    List<? extends ExpressionNode> getArguments();
    
    ExpressionNode getMethodSelect();
              
    List<? extends Node> getTypeArguments();
}
