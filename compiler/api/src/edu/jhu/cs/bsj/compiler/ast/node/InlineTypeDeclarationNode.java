package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.tags.InlineTypeDeclarable;

/**
 * A node representing an inline type declaration.  This is used to allow classes and enums to be declared
 * within a method body or similar environment.
 */
public interface InlineTypeDeclarationNode extends StatementNode
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
