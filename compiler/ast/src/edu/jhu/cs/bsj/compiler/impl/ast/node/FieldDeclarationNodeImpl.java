package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;

public class FieldDeclarationNodeImpl extends NodeImpl implements FieldDeclarationNode
{
    /** The modifiers for this field. */
    private ModifiersNode modifiers;

    /** The variable declarators for this node. */
    private ListNode<VariableDeclaratorNode> declarators;

    /** General constructor. */
    public FieldDeclarationNodeImpl(
            ModifiersNode modifiers,
            ListNode<VariableDeclaratorNode> declarators)
    {
        super();
        this.modifiers = modifiers;
        this.declarators = declarators;
    }

    /**
     * Gets the modifiers for this field.
     * @return The modifiers for this field.
     */
    public ModifiersNode getModifiers()
    {
        return this.modifiers;
    }

    /**
     * Changes the modifiers for this field.
     * @param modifiers The modifiers for this field.
     */
    public void setModifiers(ModifiersNode modifiers)
    {
        if (this.modifiers instanceof NodeImpl)
        {
            ((NodeImpl)this.modifiers).setParent(null);
        }
        this.modifiers = modifiers;
        if (this.modifiers instanceof NodeImpl)
        {
            ((NodeImpl)this.modifiers).setParent(this);
        }
    }

    /**
     * Gets the variable declarators for this node.
     * @return The variable declarators for this node.
     */
    public ListNode<VariableDeclaratorNode> getDeclarators()
    {
        return this.declarators;
    }

    /**
     * Changes the variable declarators for this node.
     * @param declarators The variable declarators for this node.
     */
    public void setDeclarators(ListNode<VariableDeclaratorNode> declarators)
    {
        if (this.declarators instanceof NodeImpl)
        {
            ((NodeImpl)this.declarators).setParent(null);
        }
        this.declarators = declarators;
        if (this.declarators instanceof NodeImpl)
        {
            ((NodeImpl)this.declarators).setParent(this);
        }
    }

    /**
     * Handles the visitation of this node's children for the provided visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        super.receiveToChildren(visitor);
        this.modifiers.receive(visitor);
        this.declarators.receive(visitor);
    }
}
