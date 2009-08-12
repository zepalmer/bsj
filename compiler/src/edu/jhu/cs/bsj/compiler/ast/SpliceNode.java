package edu.jhu.cs.bsj.compiler;

/**
 * Interface for meta-program splice construct.
 */
public interface SpliceNode extends ExpressionNode
{
    //TODO - correct?
    ExpressionNode getContent();
}
