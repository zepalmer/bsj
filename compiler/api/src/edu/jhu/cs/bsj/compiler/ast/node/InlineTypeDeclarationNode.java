package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * A node representing an inline type declaration.  This is used to allow classes and enums to be declared
 * within a method body or similar environment.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InlineTypeDeclarationNode extends Node, BlockStatementNode
{
    /**
     * Gets the type declaration.
     * @return The type declaration.
     */
    public InlineTypeDeclarableNode getDeclaration();

    /**
     * Changes the type declaration.
     * @param declaration The type declaration.
     */
    public void setDeclaration(InlineTypeDeclarableNode declaration);

}
