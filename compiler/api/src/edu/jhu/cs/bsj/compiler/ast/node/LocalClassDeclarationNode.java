package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * Represents the declaration of an inline class as a block statement.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface LocalClassDeclarationNode extends AbstractlyUnmodifiedClassDeclarationNode<LocalClassModifiersNode>, BlockStatementNode
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public LocalClassDeclarationNode deepCopy(BsjNodeFactory factory);
    
}
