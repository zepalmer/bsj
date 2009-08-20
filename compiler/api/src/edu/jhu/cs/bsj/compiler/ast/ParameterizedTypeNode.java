package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;

/**
 * A node for an expression involving type parameters.
 */
public interface ParameterizedTypeNode extends Node
{
    Node getType();
    
    List<? extends Node> getTypeArguments();
}
