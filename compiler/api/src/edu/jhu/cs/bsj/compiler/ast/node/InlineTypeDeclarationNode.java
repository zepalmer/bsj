package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing an inline type declaration.  This is used to allow classes and enums to be declared
 * within a method body or similar environment.
 */
public interface InlineTypeDeclarationNode extends Node, StatementNode
{
    /**
     * Gets the type declaration.
     * @return The type declaration.
     */
    public InlineTypeDeclarable getDeclaration();

    /**
     * Changes the type declaration.
     * @param declaration The type declaration.
     */
    public void setDeclaration(InlineTypeDeclarable declaration);

}
