package edu.jhu.cs.bsj.compiler.ast.node;

import javax.annotation.Generated;

/**
 * A node for the declaration of a variable, as in:
 *     <pre>
 *     <i>type identifier</i>;
 *     </pre>
 * or
 *     <pre>
 *     <i>type identifier</i> = <i>expression</i>;
 *     </pre>
 * or
 *     <pre>
 *     <i>type identifier</i> = <i>expression</i>, <i>identifier</i> = <i>expression</i>, ...;
 */
@Generated(value={"edu.jhu.cs.bsj.compiler.utils.generator.SourceGenerator"})
public interface VariableDeclarationNode extends Node, StatementNode
{
    /**
     * Gets the modifiers for this variable.
     * @return The modifiers for this variable.
     */
    public VariableModifiersNode getModifiers();

    /**
     * Changes the modifiers for this variable.
     * @param modifiers The modifiers for this variable.
     */
    public void setModifiers(VariableModifiersNode modifiers);

    /**
     * Gets the variable declarators for this node.
     * @return The variable declarators for this node.
     */
    public ListNode<VariableDeclaratorNode> getDeclarators();

    /**
     * Changes the variable declarators for this node.
     * @param declarators The variable declarators for this node.
     */
    public void setDeclarators(ListNode<VariableDeclaratorNode> declarators);

}
