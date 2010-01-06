package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents the declaration of an interface, as in:
 * <pre>
 * <i>modifiers<i> interface <i>name</i>&lt;<i>typeParam...</i>&gt; extends <i>type...</i>
 * {
 *     <i>member</i>
 *     <i>...</i>
 * }
 * </pre>
 */
public interface InterfaceDeclarationNode extends NamedTypeDeclarationNode
{
    /**
     * Gets the extends clause.
     * @return The extends clause.
     */
    public ListNode<? extends TypeNode> getExtendsClause();

    /**
     * Changes the extends clause.
     * @param extendsClause The extends clause.
     */
    public void setExtendsClause(ListNode<? extends TypeNode> extendsClause);

    /**
     * Gets this interface's body.
     * @return This interface's body.
     */
    public InterfaceBodyNode getBody();

    /**
     * Changes this interface's body.
     * @param body This interface's body.
     */
    public void setBody(InterfaceBodyNode body);

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
