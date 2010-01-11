package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.tags.BoundType;
import edu.jhu.cs.bsj.compiler.ast.tags.TypeArgument;

/**
 * A node representing a reference type.  A reference type in Java is any non-primitive type.
 */
public interface ReferenceTypeNode extends TypeNode, TypeArgument,  BoundType
{
}
