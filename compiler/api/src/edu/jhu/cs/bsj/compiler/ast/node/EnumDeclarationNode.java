package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * Represents the declaration of a class, as in:
 * <pre>
 * <i>modifiers<i> enum <i>name</i> implements <i>type...</i>
 * {
 *     <i>member</i>
 *     <i>...</i>
 * }
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface EnumDeclarationNode extends NamedTypeDeclarationNode, InlineTypeDeclarableNode
{
    /**
     * Gets the modifiers for this type.
     * @return The modifiers for this type.
     */
    public EnumModifiersNode getModifiers();

    /**
     * Changes the modifiers for this type.
     * @param modifiers The modifiers for this type.
     */
    public void setModifiers(EnumModifiersNode modifiers);

    /**
     * Gets the implements clause.
     * @return The implements clause.
     */
    public ListNode<TypeNode> getImplementsClause();

    /**
     * Changes the implements clause.
     * @param implementsClause The implements clause.
     */
    public void setImplementsClause(ListNode<TypeNode> implementsClause);

    /**
     * Gets this enum's body.
     * @return This enum's body.
     */
    public EnumBodyNode getBody();

    /**
     * Changes this enum's body.
     * @param body This enum's body.
     */
    public void setBody(EnumBodyNode body);

}
