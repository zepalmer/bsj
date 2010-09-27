package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;
import edu.jhu.cs.bsj.compiler.ast.NodeUnion;

/**
 * A common supertype for all nodes which declare a single variable.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface VariableNameBindingNode extends Node
{
    /**
     * Gets the identifier naming the variable being declared.
     * @return The identifier naming the variable being declared.
     * @throws ClassCastException If the value of this property is a special node.
     */
    public IdentifierNode getIdentifier() throws ClassCastException;
    
    /**
     * Gets the union object for the identifier naming the variable being declared.
     * @return A union object representing The identifier naming the variable being declared.
     */
    public NodeUnion<? extends IdentifierNode> getUnionForIdentifier();
    
    /**
     * Changes the identifier naming the variable being declared.
     * @param identifier The identifier naming the variable being declared.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Changes the identifier naming the variable being declared.
     * @param identifier The identifier naming the variable being declared.
     * @throws NullPointerException If the provided value is <code>null</code>.
     *                              Node union values may have <code>null</code>
     *                              contents but are never <code>null</code>
     *                              themselves.
     */
    public void setUnionForIdentifier(NodeUnion<? extends IdentifierNode> identifier) throws NullPointerException;
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public VariableNameBindingNode deepCopy(BsjNodeFactory factory);
    
}
