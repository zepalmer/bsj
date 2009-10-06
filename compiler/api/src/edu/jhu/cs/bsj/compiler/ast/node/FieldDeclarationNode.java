package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.tags.AnnotationMember;
import edu.jhu.cs.bsj.compiler.ast.tags.ClassMember;
import edu.jhu.cs.bsj.compiler.ast.tags.InterfaceMember;

/**
 * A node representing a field declaration.  Constants are represented by this node as well.
 */
public interface FieldDeclarationNode extends Node, ClassMember,  InterfaceMember,  AnnotationMember
{
    /**
     * Gets the modifiers for this field.
     * @return The modifiers for this field.
     */
    public ModifiersNode getModifiers();

    /**
     * Changes the modifiers for this field.
     * @param modifiers The modifiers for this field.
     */
    public void setModifiers(ModifiersNode modifiers);

    /**
     * Gets the type of this field.
     * @return The type of this field.
     */
    public TypeNode getType();

    /**
     * Changes the type of this field.
     * @param type The type of this field.
     */
    public void setType(TypeNode type);

    /**
     * Gets the name of this field.
     * @return The name of this field.
     */
    public IdentifierNode getName();

    /**
     * Changes the name of this field.
     * @param name The name of this field.
     */
    public void setName(IdentifierNode name);

    /**
     * Gets the initializer to use.
     * @return The initializer to use.
     */
    public ExpressionNode getInitializer();

    /**
     * Changes the initializer to use.
     * @param initializer The initializer to use.
     */
    public void setInitializer(ExpressionNode initializer);

}
