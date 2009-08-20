package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;

/**
 * A node for annotations.
 */
public interface AnnotationNode extends ExpressionNode
{
    Node getAnnotationType();
    
    List<? extends ExpressionNode> getArguments();
}
