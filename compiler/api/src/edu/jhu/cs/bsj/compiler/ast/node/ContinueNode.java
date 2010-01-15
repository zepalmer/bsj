package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * A node representing continue statements, as in:
 * <pre>
 *     continue <i>label</i>;
 * </pre>
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
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

}
