package edu.jhu.cs.bsj.compiler.ast.node;


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
public interface EnumDeclarationNode extends NamedTypeDeclarationNode, InlineTypeDeclarableNode
{
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
