package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing any declared type.  In the BSJ API, a "declared type" refers to any type which has been
 * created by a declaration statement.  Arrays and primitives are not declared types because they are not declared.
 */
public interface DeclaredTypeNode extends ReferenceTypeNode, BaseType
{
}
