package edu.jhu.cs.bsj.compiler.ast.node.meta;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.node.BsjSpecificNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;

/**
 * A node representing a metaprogram found at the top level of a source file.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface TypeDeclarationMetaprogramAnchorNode extends ExplicitMetaprogramAnchorNode<TypeDeclarationNode>, TypeDeclarationNode, BsjSpecificNode
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public TypeDeclarationMetaprogramAnchorNode deepCopy(BsjNodeFactory factory);
    
}
