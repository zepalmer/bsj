package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;

/**
 * Represents the declaration of a class, as in:
 * <pre>
 * <i>modifiers</i> class <i>name</i>&lt;<i>typeParam...</i>&gt; extends <i>type</i> implements <i>type...</i>
 * {
 *     <i>member</i>
 *     <i>...</i>
 * }
 * </pre>
 * This abstract class is defined in order to permit subclasses to dictate which modifiers are legal on a
 * class declaration (as different types of class declarations may permit different modifier sets).
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface AbstractlyUnmodifiedClassDeclarationNode<T extends ModifiersNode> extends Node, NamedTypeDeclarationNode<ClassMemberNode>, ModifiedNode<T>, ParameterizableTypeDeclarationNode
{
    /**
     * Gets the modifiers for this type.
     * @return The modifiers for this type.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public T getModifiers()throws ClassCastException;
    
    /**
     * Gets the union object for the modifiers for this type.
     * @return A union object representing The modifiers for this type.
     */
    public NodeUnion<? extends T> getUnionForModifiers();
    
    /**
     * Changes the modifiers for this type.
     * @param modifiers The modifiers for this type.
     */
    public void setModifiers(T modifiers);
    
    /**
     * Changes the modifiers for this type.
     * @param modifiers The modifiers for this type.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForModifiers(NodeUnion<? extends T> modifiers) throws NullPointerException;
    
    /**
     * Gets the extends clause.
     * @return The extends clause.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public DeclaredTypeNode getExtendsClause()throws ClassCastException;
    
    /**
     * Gets the union object for the extends clause.
     * @return A union object representing The extends clause.
     */
    public NodeUnion<? extends DeclaredTypeNode> getUnionForExtendsClause();
    
    /**
     * Changes the extends clause.
     * @param extendsClause The extends clause.
     */
    public void setExtendsClause(DeclaredTypeNode extendsClause);
    
    /**
     * Changes the extends clause.
     * @param extendsClause The extends clause.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForExtendsClause(NodeUnion<? extends DeclaredTypeNode> extendsClause) throws NullPointerException;
    
    /**
     * Gets the implements clause.
     * @return The implements clause.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public DeclaredTypeListNode getImplementsClause()throws ClassCastException;
    
    /**
     * Gets the union object for the implements clause.
     * @return A union object representing The implements clause.
     */
    public NodeUnion<? extends DeclaredTypeListNode> getUnionForImplementsClause();
    
    /**
     * Changes the implements clause.
     * @param implementsClause The implements clause.
     */
    public void setImplementsClause(DeclaredTypeListNode implementsClause);
    
    /**
     * Changes the implements clause.
     * @param implementsClause The implements clause.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForImplementsClause(NodeUnion<? extends DeclaredTypeListNode> implementsClause) throws NullPointerException;
    
    /**
     * Gets the body of this class.
     * @return The body of this class.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public ClassBodyNode getBody()throws ClassCastException;
    
    /**
     * Gets the union object for the body of this class.
     * @return A union object representing The body of this class.
     */
    public NodeUnion<? extends ClassBodyNode> getUnionForBody();
    
    /**
     * Changes the body of this class.
     * @param body The body of this class.
     */
    public void setBody(ClassBodyNode body);
    
    /**
     * Changes the body of this class.
     * @param body The body of this class.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForBody(NodeUnion<? extends ClassBodyNode> body) throws NullPointerException;
    
    /**
     * Gets this class's type parameters.
     * @return This class's type parameters.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public TypeParameterListNode getTypeParameters()throws ClassCastException;
    
    /**
     * Gets the union object for this class's type parameters.
     * @return A union object representing This class's type parameters.
     */
    public NodeUnion<? extends TypeParameterListNode> getUnionForTypeParameters();
    
    /**
     * Changes this class's type parameters.
     * @param typeParameters This class's type parameters.
     */
    public void setTypeParameters(TypeParameterListNode typeParameters);
    
    /**
     * Changes this class's type parameters.
     * @param typeParameters This class's type parameters.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForTypeParameters(NodeUnion<? extends TypeParameterListNode> typeParameters) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public AbstractlyUnmodifiedClassDeclarationNode<T> deepCopy(BsjNodeFactory factory);
    
}
