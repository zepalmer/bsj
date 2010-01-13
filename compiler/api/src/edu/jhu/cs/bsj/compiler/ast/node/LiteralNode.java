package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A superclass for all types of literal nodes.
 */
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
