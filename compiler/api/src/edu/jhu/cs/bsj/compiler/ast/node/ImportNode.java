package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * This tagging interface is used to denote AST nodes which represent import statements.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ImportNode extends Node
{
    /**
     * Gets the name of the entity to be imported.
     * @return The name of the entity to be imported.
     */
    public NameNode getName();
    
    /**
     * Changes the name of the entity to be imported.
     * @param name The name of the entity to be imported.
     */
    public void setName(NameNode name);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ImportNode deepCopy(BsjNodeFactory factory);
    
}
