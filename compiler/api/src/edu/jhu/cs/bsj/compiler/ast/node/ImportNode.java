package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * This tagging interface is used to denote AST nodes which represent import statements.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ImportNode extends Node
{
    /**
     * Gets the name of the entity to be imported.
     * @return The name of the entity to be imported.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public NameNode getName() throws ClassCastException;
    
    /**
     * Gets the union object for the name of the entity to be imported.
     * @return A union object representing The name of the entity to be imported.
     */
    public NodeUnion<? extends NameNode> getUnionForName();
    
    /**
     * Changes the name of the entity to be imported.
     * @param name The name of the entity to be imported.
     */
    public void setName(NameNode name);
    
    /**
     * Changes the name of the entity to be imported.
     * @param name The name of the entity to be imported.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForName(NodeUnion<? extends NameNode> name) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ImportNode deepCopy(BsjNodeFactory factory);
    
}
