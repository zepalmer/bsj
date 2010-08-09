package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A node representing a no-op, as in
 * <pre>
 * ;
 * </pre>
 * This node may appear as a type declaration (in the top level of a compilation unit or as a type member)
 * or as a statement.  Either way, it has no effect.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface NoOperationNode extends Node, StatementNode, TypeDeclarationNode
{
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public NoOperationNode deepCopy(BsjNodeFactory factory);
    
}
