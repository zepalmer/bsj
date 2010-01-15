package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * A superclass for all types of literal nodes.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
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

}
