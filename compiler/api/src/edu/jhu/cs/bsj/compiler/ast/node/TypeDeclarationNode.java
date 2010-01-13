package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * This tagging interface is used to denoate AST nodes which declare types.
 */
public interface TypeDeclarationNode extends Node, ClassMemberNode,  InterfaceMemberNode,  AnnotationMemberNode,  AnonymousClassMemberNode
{
}
