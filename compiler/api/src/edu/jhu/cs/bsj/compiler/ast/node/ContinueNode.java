package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A node representing continue statements, as in:
 * <pre>
 *     continue <i>label</i>;
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface ContinueNode extends Node, StatementNode
{
    /**
     * Gets the continue label.
     * @return The continue label.
     */
    public IdentifierNode getLabel();
    
    /**
     * Changes the continue label.
     * @param label The continue label.
     */
    public void setLabel(IdentifierNode label);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public ContinueNode deepCopy(BsjNodeFactory factory);
    
}
