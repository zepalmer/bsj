package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents the declaration of a class, as in:
 * <pre>
 * <i>modifiers</i> enum <i>name</i> implements <i>type...</i>
 * {
 *     <i>member</i>
 *     <i>...</i>
 * }
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface EnumDeclarationNode extends Node, NamedTypeDeclarationNode<ClassMemberNode>, InlineTypeDeclarableNode
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
    public DeclaredTypeListNode getImplementsClause();

    /**
     * Changes the implements clause.
     * @param implementsClause The implements clause.
     */
    public void setImplementsClause(DeclaredTypeListNode implementsClause);

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

    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public EnumDeclarationNode deepCopy(BsjNodeFactory factory);
}
