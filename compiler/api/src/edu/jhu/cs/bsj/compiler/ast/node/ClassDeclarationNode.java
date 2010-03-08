package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents the declaration of a class, as in:
 * <pre>
 * <i>modifiers</i> class <i>name</i>&lt;<i>typeParam...</i>&gt; extends <i>type</i> implements <i>type...</i>
 * {
 *     <i>member</i>
 *     <i>...</i>
 * }
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ClassDeclarationNode extends Node, NamedTypeDeclarationNode<ClassMemberNode>, InlineTypeDeclarableNode
{
    /**
     * Gets the modifiers for this type.
     * @return The modifiers for this type.
     */
    public ClassModifiersNode getModifiers();
    
    /**
     * Changes the modifiers for this type.
     * @param modifiers The modifiers for this type.
     */
    public void setModifiers(ClassModifiersNode modifiers);
    
    /**
     * Gets the extends clause.
     * @return The extends clause.
     */
    public DeclaredTypeNode getExtendsClause();
    
    /**
     * Changes the extends clause.
     * @param extendsClause The extends clause.
     */
    public void setExtendsClause(DeclaredTypeNode extendsClause);
    
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
    public TypeParameterListNode getTypeParameters();
    
    /**
     * Changes this class's type parameters.
     * @param typeParameters This class's type parameters.
     */
    public void setTypeParameters(TypeParameterListNode typeParameters);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ClassDeclarationNode deepCopy(BsjNodeFactory factory);
}
