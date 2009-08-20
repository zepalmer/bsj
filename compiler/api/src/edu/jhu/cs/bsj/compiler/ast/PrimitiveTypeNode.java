package edu.jhu.cs.bsj.compiler.ast;

/**
 * A node for a primitive type.
 */
public interface PrimitiveTypeNode extends Node
{
    TypeKind getPrimitiveTypeKind();
}
