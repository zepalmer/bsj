package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;

/**
 * A node for creating a new array.
 */
public interface NewArrayNode extends ExpressionNode
{
    List<? extends ExpressionNode> getDimensions();
    
    List<? extends ExpressionNode> getInitializers();
              
    Node getType();
}
