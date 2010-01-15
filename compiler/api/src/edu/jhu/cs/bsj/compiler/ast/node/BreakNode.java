package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * A node representing break statements, as in:
 * <pre>
 *     break <i>label</i>;
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
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

}
