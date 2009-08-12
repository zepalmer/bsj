package edu.jhu.cs.bsj.compiler;

import java.util.List;

public interface AnnotationNode extends ExpressionNode
{
    Node getAnnotationType();
    
    List<? extends ExpressionNode> getArguments();
}
