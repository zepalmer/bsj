package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents the declaration of a normal class, such as in the context of another type's member or as in
 * a top-level type.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ClassDeclarationNode extends AbstractlyUnmodifiedClassDeclarationNode<ClassModifiersNode>
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ClassDeclarationNode deepCopy(BsjNodeFactory factory);
    
}
