package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A superclass for restricted primary expressions.  This maps to the <i>PrimaryNoNewArray</i> parse target in the
 * JLS.
 */
public interface RestrictedPrimaryExpressionNode extends ExpressionNode, ArrayIndexable
{
}
