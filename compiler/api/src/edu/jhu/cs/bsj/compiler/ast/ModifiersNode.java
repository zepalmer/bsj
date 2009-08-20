package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;
import java.util.Set;

/**
 * A node for the modifiers of a declaration, including annotations.
 */
public interface ModifiersNode extends Node
{
    List<? extends AnnotationNode> getAnnotations();
    
    Set<Modifier> getFlags();
}
