package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;

/**
 * A node for a type parameter.
 */
public interface TypeParameterNode extends Node
{
    List<? extends Node> getBounds();
    
    Identifier getName(); 
}
