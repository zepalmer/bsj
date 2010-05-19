package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A common supertype for all nodes which use variable declarators to declare a set of variables.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface VariableDeclaratorOwnerNode extends Node
{
    /**
     * Gets the type of the declared variables.
     * @return The type of the declared variables.
     */
    public TypeNode getType();
    
    /**
     * Changes the type of the declared variables.
     * @param type The type of the declared variables.
     */
    public void setType(TypeNode type);
    
    /**
     * Gets the variable declarators for this node.
     * @return The variable declarators for this node.
     */
    public VariableDeclaratorListNode getDeclarators();
    
    /**
     * Changes the variable declarators for this node.
     * @param declarators The variable declarators for this node.
     */
    public void setDeclarators(VariableDeclaratorListNode declarators);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public VariableDeclaratorOwnerNode deepCopy(BsjNodeFactory factory);
}
