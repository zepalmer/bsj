package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;
import edu.jhu.cs.bsj.compiler.ast.node.list.DeclaredTypeListNode;

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
public interface EnumDeclarationNode extends Node, NamedTypeDeclarationNode<ClassMemberNode>, ModifiedNode<EnumModifiersNode>
{
    /**
     * Gets the modifiers for this type.
     * @return The modifiers for this type.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public EnumModifiersNode getModifiers() throws ClassCastException;
    
    /**
     * Gets the union object for the modifiers for this type.
     * @return A union object representing The modifiers for this type.
     */
    public NodeUnion<? extends EnumModifiersNode> getUnionForModifiers();
    
    /**
     * Changes the modifiers for this type.
     * @param modifiers The modifiers for this type.
     */
    public void setModifiers(EnumModifiersNode modifiers);
    
    /**
     * Changes the modifiers for this type.
     * @param modifiers The modifiers for this type.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForModifiers(NodeUnion<? extends EnumModifiersNode> modifiers) throws NullPointerException;
    
    /**
     * Gets the implements clause.
     * @return The implements clause.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public DeclaredTypeListNode getImplementsClause() throws ClassCastException;
    
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
     * Gets this enum's body.
     * @return This enum's body.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public EnumBodyNode getBody() throws ClassCastException;
    
    /**
     * Gets the union object for this enum's body.
     * @return A union object representing This enum's body.
     */
    public NodeUnion<? extends EnumBodyNode> getUnionForBody();
    
    /**
     * Changes this enum's body.
     * @param body This enum's body.
     */
    public void setBody(EnumBodyNode body);
    
    /**
     * Changes this enum's body.
     * @param body This enum's body.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForBody(NodeUnion<? extends EnumBodyNode> body) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public EnumDeclarationNode deepCopy(BsjNodeFactory factory);
    
}
