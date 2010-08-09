package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A tagging interface for restricted primary expressions.  This maps to the <i>PrimaryNoNewArray</i> parse target
 * in the JLS.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface RestrictedPrimaryExpressionNode extends Node, PrimaryExpressionNode
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public RestrictedPrimaryExpressionNode deepCopy(BsjNodeFactory factory);
    
}
