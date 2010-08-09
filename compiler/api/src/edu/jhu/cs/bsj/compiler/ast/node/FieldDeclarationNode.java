package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A node representing a field declaration.  Interface constants are not represented by this node.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface FieldDeclarationNode extends AbstractMemberVariableDeclarationNode<FieldModifiersNode>, ClassMemberNode, AnonymousClassMemberNode
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public FieldDeclarationNode deepCopy(BsjNodeFactory factory);
    
}
