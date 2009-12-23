package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.tags.AnnotationMember;
import edu.jhu.cs.bsj.compiler.ast.tags.ClassMember;
import edu.jhu.cs.bsj.compiler.ast.tags.InterfaceMember;

/**
 * Acts as a superclass for all type declarations.
 */
public interface TypeDeclarationNode extends Node, ClassMember,  InterfaceMember,  AnnotationMember
{
    /**
     * Gets the name of this declared type.
     * @return The name of this declared type.
     */
    public IdentifierNode getSimpleName();

    /**
     * Changes the name of this declared type.
     * @param simpleName The name of this declared type.
     */
    public void setSimpleName(IdentifierNode simpleName);

    /**
     * Gets the modifiers for this declared type.
     * @return The modifiers for this declared type.
     */
    public ModifiersNode getModifiers();

    /**
     * Changes the modifiers for this declared type.
     * @param modifiers The modifiers for this declared type.
     */
    public void setModifiers(ModifiersNode modifiers);

}
