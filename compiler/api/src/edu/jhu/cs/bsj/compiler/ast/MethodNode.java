package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;

/**
 * A node for defining a method.
 */
public interface MethodNode extends Node
{
    BlockStatementNode getBody();
    
    Node getDefaultValue();
              
    ModifiersNode getModifiers();
              
    Identifier getName();
              
    List<? extends VariableNode> getParameters();
              
    Node getReturnType();
              
    List<? extends ExpressionNode> getThrows();
              
    List<? extends TypeParameterNode> getTypeParameters();
}
