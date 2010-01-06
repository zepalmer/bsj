package edu.jhu.cs.bsj.compiler.ast.node;

import edu.jhu.cs.bsj.compiler.ast.tags.InlineTypeDeclarable;

/**
 * Represents the declaration of a class, as in:
 * <pre>
 * <i>modifiers<i> class <i>name</i>&lt;<i>typeParam...</i>&gt; extends <i>type</i> implements <i>type...</i>
 * {
 *     <i>member</i>
 *     <i>...</i>
 * }
 * </pre>
 */
public interface ClassDeclarationNode extends NamedTypeDeclarationNode, InlineTypeDeclarable
{
    /**
     * Gets the extends clause.
     * @return The extends clause.
     */
    public TypeNode getExtendsClause();

    /**
     * Changes the extends clause.
     * @param extendsClause The extends clause.
     */
    public void setExtendsClause(TypeNode extendsClause);

    /**
     * Gets the implements clause.
     * @return The implements clause.
     */
    public ListNode<? extends TypeNode> getImplementsClause();

    /**
     * Changes the implements clause.
     * @param implementsClause The implements clause.
     */
    public void setImplementsClause(ListNode<? extends TypeNode> implementsClause);

    /**
     * Gets the body of this class.
     * @return The body of this class.
     */
    public ClassBodyNode getBody();

    /**
     * Changes the body of this class.
     * @param body The body of this class.
     */
    public void setBody(ClassBodyNode body);

    /**
     * Gets this class's type parameters.
     * @return This class's type parameters.
     */
    public ListNode<? extends TypeParameterNode> getTypeParameters();

    /**
     * Changes this class's type parameters.
     * @param typeParameters This class's type parameters.
     */
    public void setTypeParameters(ListNode<? extends TypeParameterNode> typeParameters);

}
