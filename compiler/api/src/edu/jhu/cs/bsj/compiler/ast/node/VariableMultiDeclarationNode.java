package edu.jhu.cs.bsj.compiler.ast.node;


/**
 * Represents a variable multi-declaration, as in:
 * <pre>int x = 5, y;</pre>
 */
public interface VariableMultiDeclarationNode extends StatementNode
{
    /**
     * Gets the modifiers for these variables.
     * @return The modifiers for these variables.
     */
    public ModifiersNode getModifiers();

    /**
     * Changes the modifiers for these variables.
     * @param modifiers The modifiers for these variables.
     */
    public void setModifiers(ModifiersNode modifiers);

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
