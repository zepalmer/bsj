package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;

public interface TypeParameterNode extends Node
{
    List<? extends Node> getBounds();
    
    Identifier getName(); 
}