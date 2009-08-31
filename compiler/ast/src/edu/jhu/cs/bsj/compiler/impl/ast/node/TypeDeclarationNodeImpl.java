package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeDeclarationNode;

public abstract class TypeDeclarationNodeImpl extends NodeImpl implements TypeDeclarationNode
{
    /** The name of this declared type. */
    private IdentifierNode simpleName;

    /** The modifiers for this declared type. */
    private ModifiersNode modifiers;

    /** General constructor. */
    protected TypeDeclarationNodeImpl(
            IdentifierNode simpleName,
            ModifiersNode modifiers)
    {
        super();
        this.simpleName = simpleName;
        this.modifiers = modifiers;
    }

    /**
     * Gets the name of this declared type.
     * @return The name of this declared type.
     */
    public IdentifierNode getSimpleName()
    {
        return this.simpleName;
    }

    /**
     * Changes the name of this declared type.
     * @param simpleName The name of this declared type.
     */
    public void setSimpleName(IdentifierNode simpleName)
    {
        if (this.simpleName instanceof NodeImpl)
        {
            ((NodeImpl)this.simpleName).setParent(null);
        }
        this.simpleName = simpleName;
        if (this.simpleName instanceof NodeImpl)
        {
            ((NodeImpl)this.simpleName).setParent(this);
        }
    }

    /**
     * Gets the modifiers for this declared type.
     * @return The modifiers for this declared type.
     */
    public ModifiersNode getModifiers()
    {
        return this.modifiers;
    }

    /**
     * Changes the modifiers for this declared type.
     * @param modifiers The modifiers for this declared type.
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
     * Performs visitation for this node's children.
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        
    }
}
