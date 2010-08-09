package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * This tagging interface is used to denoate AST nodes which declare types.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface TypeDeclarationNode extends Node, ClassMemberNode, InterfaceMemberNode, AnnotationMemberNode, AnonymousClassMemberNode, DeclarationNode
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public TypeDeclarationNode deepCopy(BsjNodeFactory factory);
    
}
