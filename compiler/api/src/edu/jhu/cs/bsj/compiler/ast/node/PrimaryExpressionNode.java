package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A tagging interface for all nodes considered "primary expressions" by the Java Language Specification.  Primary
 * expressions include the basic building blocks of more complex expressions.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface PrimaryExpressionNode extends Node, NonAssignmentExpressionNode
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public PrimaryExpressionNode deepCopy(BsjNodeFactory factory);
}
