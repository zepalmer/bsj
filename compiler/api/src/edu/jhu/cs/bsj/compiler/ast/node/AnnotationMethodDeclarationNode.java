package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing an annotation method declaration, as in:
 * <pre>
 *     <i>modifiers type identifier</i> () default <i>defaultValue</i>;
 * </pre>
 */
public interface AnnotationMethodDeclarationNode extends Node, AnnotationMemberNode
{
    /**
     * Gets the modifiers for this annotation method.
     * @return The modifiers for this annotation method.
     */
    public ModifiersNode getModifiers();

    /**
     * Changes the modifiers for this annotation method.
     * @param modifiers The modifiers for this annotation method.
     */
    public void setModifiers(ModifiersNode modifiers);

    /**
     * Gets the return type of this annotation method.
     * @return The return type of this annotation method.
     */
    public TypeNode getType();

    /**
     * Changes the return type of this annotation method.
     * @param type The return type of this annotation method.
     */
    public void setType(TypeNode type);

    /**
     * Gets this annotation method's name.
     * @return This annotation method's name.
     */
    public IdentifierNode getIdentifier();

    /**
     * Changes this annotation method's name.
     * @param identifier This annotation method's name.
     */
    public void setIdentifier(IdentifierNode identifier);

    /**
     * Gets the default value for this method.
     * @return The default value for this method.
     */
    public ExpressionNode getDefaultValue();

    /**
     * Changes the default value for this method.
     * @param defaultValue The default value for this method.
     */
    public void setDefaultValue(ExpressionNode defaultValue);

}
