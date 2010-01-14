package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * This tagging interface describes expressions which are not assignment expressions.  In some contexts, assignment
 * expressions are not permitted (such as in the initializers of annotation values).
 */
public interface NonAssignmentExpressionNode extends Node, ExpressionNode
{
}
