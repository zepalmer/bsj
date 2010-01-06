package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * A node representing an enum constant.  While enum constants typically consist of a single name, many optional
 * extensions exist.  In the likely case that this constant is not an anonymous subclass, <tt>body</tt> is
 * <tt>null</tt>.
 */
public interface EnumConstantDeclarationNode extends Node
{
    /**
     * Gets the annotations on this constant.
     * @return The annotations on this constant.
     */
    public ListNode<? extends AnnotationNode> getAnnotations();

    /**
     * Changes the annotations on this constant.
     * @param annotations The annotations on this constant.
     */
    public void setAnnotations(ListNode<? extends AnnotationNode> annotations);

    /**
     * Gets the name of this constant.
     * @return The name of this constant.
     */
    public IdentifierNode getIdentifier();

    /**
     * Changes the name of this constant.
     * @param identifier The name of this constant.
     */
    public void setIdentifier(IdentifierNode identifier);

    /**
     * Gets the arguments to the enum constructor.
     * @return The arguments to the enum constructor.
     */
    public ListNode<? extends ExpressionNode> getArguments();

    /**
     * Changes the arguments to the enum constructor.
     * @param arguments The arguments to the enum constructor.
     */
    public void setArguments(ListNode<? extends ExpressionNode> arguments);

    /**
     * Gets the body used to anonymously subclass the constant.
     * @return The body used to anonymously subclass the constant.
     */
    public AnonymousClassBodyNode getBody();

    /**
     * Changes the body used to anonymously subclass the constant.
     * @param body The body used to anonymously subclass the constant.
     */
    public void setBody(AnonymousClassBodyNode body);

}
