package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.ExpressionListNode;

/**
 * A node representing an enum constant.  While enum constants typically consist of a single name, many optional
 * extensions exist.  In the likely case that this constant is not an anonymous subclass, <tt>body</tt> is
 * <tt>null</tt>.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface EnumConstantDeclarationNode extends Node, DeclarationNode, VariableNameBindingNode, ModifiedNode<EnumConstantModifiersNode>
{
    /**
     * Gets the modifiers for this enum constant.
     * @return The modifiers for this enum constant.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public EnumConstantModifiersNode getModifiers()throws ClassCastException;
    
    /**
     * Gets the union object for the modifiers for this enum constant.
     * @return A union object representing The modifiers for this enum constant.
     */
    public NodeUnion<? extends EnumConstantModifiersNode> getUnionForModifiers();
    
    /**
     * Changes the modifiers for this enum constant.
     * @param modifiers The modifiers for this enum constant.
     */
    public void setModifiers(EnumConstantModifiersNode modifiers);
    
    /**
     * Changes the modifiers for this enum constant.
     * @param modifiers The modifiers for this enum constant.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForModifiers(NodeUnion<? extends EnumConstantModifiersNode> modifiers) throws NullPointerException;
    
    /**
     * Gets the name of this constant.
     * @return The name of this constant.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public IdentifierNode getIdentifier()throws ClassCastException;
    
    /**
     * Gets the union object for the name of this constant.
     * @return A union object representing The name of this constant.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForIdentifier();
    
    /**
     * Changes the name of this constant.
     * @param identifier The name of this constant.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Changes the name of this constant.
     * @param identifier The name of this constant.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier) throws NullPointerException;
    
    /**
     * Gets the arguments to the enum constructor.
     * @return The arguments to the enum constructor.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ExpressionListNode getArguments()throws ClassCastException;
    
    /**
     * Gets the union object for the arguments to the enum constructor.
     * @return A union object representing The arguments to the enum constructor.
     */
    public NodeUnion<? extends ExpressionListNode> getUnionForArguments();
    
    /**
     * Changes the arguments to the enum constructor.
     * @param arguments The arguments to the enum constructor.
     */
    public void setArguments(ExpressionListNode arguments);
    
    /**
     * Changes the arguments to the enum constructor.
     * @param arguments The arguments to the enum constructor.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForArguments(NodeUnion<? extends ExpressionListNode> arguments) throws NullPointerException;
    
    /**
     * Gets the body used to anonymously subclass the constant.
     * @return The body used to anonymously subclass the constant.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public AnonymousClassBodyNode getBody()throws ClassCastException;
    
    /**
     * Gets the union object for the body used to anonymously subclass the constant.
     * @return A union object representing The body used to anonymously subclass the constant.
     */
    public NodeUnion<? extends AnonymousClassBodyNode> getUnionForBody();
    
    /**
     * Changes the body used to anonymously subclass the constant.
     * @param body The body used to anonymously subclass the constant.
     */
    public void setBody(AnonymousClassBodyNode body);
    
    /**
     * Changes the body used to anonymously subclass the constant.
     * @param body The body used to anonymously subclass the constant.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForBody(NodeUnion<? extends AnonymousClassBodyNode> body) throws NullPointerException;
    
    /**
     * Gets the associated javadoc comment for this node.
     * @return The associated javadoc comment for this node.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public JavadocNode getJavadoc()throws ClassCastException;
    
    /**
     * Gets the union object for the associated javadoc comment for this node.
     * @return A union object representing The associated javadoc comment for this node.
     */
    public NodeUnion<? extends JavadocNode> getUnionForJavadoc();
    
    /**
     * Changes the associated javadoc comment for this node.
     * @param javadoc The associated javadoc comment for this node.
     */
    public void setJavadoc(JavadocNode javadoc);
    
    /**
     * Changes the associated javadoc comment for this node.
     * @param javadoc The associated javadoc comment for this node.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForJavadoc(NodeUnion<? extends JavadocNode> javadoc) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public EnumConstantDeclarationNode deepCopy(BsjNodeFactory factory);
    
}
