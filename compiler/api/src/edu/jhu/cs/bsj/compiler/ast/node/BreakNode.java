package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeFactory;

/**
 * A node representing break statements, as in:
 * <pre>
 *     break <i>label</i>;
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface BreakNode extends Node, StatementNode
{
    /**
     * Gets the break label.
     * @return The break label.
     */
    public IdentifierNode getLabel();
    
    /**
     * Changes the break label.
     * @param label The break label.
     */
    public void setLabel(IdentifierNode label);
    
    /**
     * Generates a deep copy of this node.
     * @param factory The node factory to use to create the deep copy.
     * @return The resulting deep copy node.
     */
    @Override
    public BreakNode deepCopy(BsjNodeFactory factory);
}
