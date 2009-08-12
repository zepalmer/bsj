package edu.jhu.cs.bsj.compiler.ast;

import java.util.List;

public interface NewArrayNode extends ExpressionNode
{
    List<? extends ExpressionNode> getDimensions();
    
    List<? extends ExpressionNode> getInitializers();
              
    Node getType();
}
