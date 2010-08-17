package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A common supertype for all nodes which declare a single variable.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface VariableNameBindingNode extends Node
{
    /**
     * Gets the identifier naming the variable being declared.
     * @return The identifier naming the variable being declared.
     */
    public IdentifierNode getIdentifier();
    
    /**
     * Changes the identifier naming the variable being declared.
     * @param identifier The identifier naming the variable being declared.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public VariableNameBindingNode deepCopy(BsjNodeFactory factory);
    
}
