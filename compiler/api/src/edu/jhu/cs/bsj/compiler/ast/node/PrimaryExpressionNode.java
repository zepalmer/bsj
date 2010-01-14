package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A tagging interface for all nodes considered "primary expressions" by the Java Language Specification.  Primary
 * expressions include the basic building blocks of more complex expressions.
 */
public interface PrimaryExpressionNode extends Node, NonAssignmentExpressionNode
{
}
