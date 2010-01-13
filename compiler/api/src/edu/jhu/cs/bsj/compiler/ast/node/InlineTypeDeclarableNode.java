package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * This tagging interface is used to denote AST nodes which represent type declarations and can be declared inline
 * as a statement.
 */
public interface InlineTypeDeclarableNode extends Node, TypeDeclarationNode
{
}
