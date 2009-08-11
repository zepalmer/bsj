package edu.jhu.cs.bsj.compiler;

import java.util.List;
import java.util.Set;

public interface ModifiersNode extends Node
{
    List<? extends AnnotationNode> getAnnotations();
    
    Set<Modifier> getFlags();
}
