package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.list.TypeParameterListNode;

/**
 * This tagging interface describes type declarations which may include type parameters.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ParameterizableTypeDeclarationNode extends Node, TypeDeclarationNode, TypeNameBindingNode
{
    /**
     * Gets the name of this type.
     * @return The name of this type.
     */
    public IdentifierNode getIdentifier();
    
    /**
     * Changes the name of this type.
     * @param identifier The name of this type.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Gets this type's type parameters.
     * @return This type's type parameters.
     */
    public TypeParameterListNode getTypeParameters();
    
    /**
     * Changes this type's type parameters.
     * @param typeParameters This type's type parameters.
     */
    public void setTypeParameters(TypeParameterListNode typeParameters);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ParameterizableTypeDeclarationNode deepCopy(BsjNodeFactory factory);
    
}
