package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;

public interface ParameterizedTypeNode extends Node
{
    Node getType();
    
    List<? extends Node> getTypeArguments();
}
