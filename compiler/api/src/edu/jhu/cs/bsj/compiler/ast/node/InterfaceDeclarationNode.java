package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.DeclaredTypeListNode;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;

/**
 * Represents the declaration of an interface, as in:
 * <pre>
 * <i>modifiers</i> interface <i>name</i>&lt;<i>typeParam...</i>&gt; extends <i>type...</i>
 * {
 *     <i>member</i>
 *     <i>...</i>
 * }
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InterfaceDeclarationNode extends Node, NamedTypeDeclarationNode<InterfaceMemberNode>, ModifiedNode<InterfaceModifiersNode>, ParameterizableTypeDeclarationNode
{
    /**
     * Gets the modifiers for this type.
     * @return The modifiers for this type.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public InterfaceModifiersNode getModifiers() throws ClassCastException;
    
    /**
     * Gets the union object for the modifiers for this type.
     * @return A union object representing The modifiers for this type.
     */
    public NodeUnion<? extends InterfaceModifiersNode> getUnionForModifiers();
    
    /**
     * Changes the modifiers for this type.
     * @param modifiers The modifiers for this type.
     */
    public void setModifiers(InterfaceModifiersNode modifiers);
    
    /**
     * Changes the modifiers for this type.
     * @param modifiers The modifiers for this type.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForModifiers(NodeUnion<? extends InterfaceModifiersNode> modifiers) throws NullPointerException;
    
    /**
     * Gets the extends clause.
     * @return The extends clause.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public DeclaredTypeListNode getExtendsClause() throws ClassCastException;
    
    /**
     * Gets the union object for the extends clause.
     * @return A union object representing The extends clause.
     */
    public NodeUnion<? extends DeclaredTypeListNode> getUnionForExtendsClause();
    
    /**
     * Changes the extends clause.
     * @param extendsClause The extends clause.
     */
    public void setExtendsClause(DeclaredTypeListNode extendsClause);
    
    /**
     * Changes the extends clause.
     * @param extendsClause The extends clause.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForExtendsClause(NodeUnion<? extends DeclaredTypeListNode> extendsClause) throws NullPointerException;
    
    /**
     * Gets this interface's body.
     * @return This interface's body.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public InterfaceBodyNode getBody() throws ClassCastException;
    
    /**
     * Gets the union object for this interface's body.
     * @return A union object representing This interface's body.
     */
    public NodeUnion<? extends InterfaceBodyNode> getUnionForBody();
    
    /**
     * Changes this interface's body.
     * @param body This interface's body.
     */
    public void setBody(InterfaceBodyNode body);
    
    /**
     * Changes this interface's body.
     * @param body This interface's body.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForBody(NodeUnion<? extends InterfaceBodyNode> body) throws NullPointerException;
    
    /**
     * Gets this class's type parameters.
     * @return This class's type parameters.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public TypeParameterListNode getTypeParameters() throws ClassCastException;
    
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
    public InterfaceDeclarationNode deepCopy(BsjNodeFactory factory);
    
}
