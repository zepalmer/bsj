package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A superclass for all types of literal nodes.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface LiteralNode<T> extends Node, RestrictedPrimaryExpressionNode
{
    /**
     * Gets the literal value for this node.
     * @return The literal value for this node.
     */
    public T getValue();

    /**
     * Changes the literal value for this node.
     * @param value The literal value for this node.
     */
    public void setValue(T value);

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public LiteralNode<T> deepCopy(BsjNodeFactory factory);
}
