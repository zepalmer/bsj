package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A node representing any declared type.  In the BSJ API, a "declared type" refers to any type which has been
 * created by a declaration statement.  Arrays and primitives are not declared types because they are not declared.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface DeclaredTypeNode extends Node, ReferenceTypeNode, BaseTypeNode
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public DeclaredTypeNode deepCopy(BsjNodeFactory factory);
}
