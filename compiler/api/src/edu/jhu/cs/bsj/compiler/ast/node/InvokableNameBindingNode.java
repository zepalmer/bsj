package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * This interface is implemented by invokable nodes which occupy positions in the method namespace.
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface InvokableNameBindingNode extends Node
{
    /**
     * Gets the identifier naming the invokable which is declared.
     * @return The identifier naming the invokable which is declared.
     */
    public IdentifierNode getIdentifier();
    
    /**
     * Changes the identifier naming the invokable which is declared.
     * @param identifier The identifier naming the invokable which is declared.
     */
    public void setIdentifier(IdentifierNode identifier);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public InvokableNameBindingNode deepCopy(BsjNodeFactory factory);
    
}
