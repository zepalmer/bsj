package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.tags.AnnotationMember;
import edu.jhu.cs.bsj.compiler.ast.tags.ClassMember;
import edu.jhu.cs.bsj.compiler.ast.tags.InterfaceMember;

/**
 * Acts as a superclass for all type declarations.
 */
public interface TypeDeclarationNode extends Node, ClassMember,  InterfaceMember,  AnnotationMember
{
}
