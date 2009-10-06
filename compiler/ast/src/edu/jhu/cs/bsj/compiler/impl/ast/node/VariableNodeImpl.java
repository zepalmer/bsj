package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;

public class VariableNodeImpl extends NodeImpl implements VariableNode
{
    /** The modifiers of this parameter. */
    private ModifiersNode modifiers;

    /** The type of the parameter. */
    private TypeNode type;

    /** The name of the parameter. */
    private IdentifierNode name;

    /** General constructor. */
    public VariableNodeImpl(
            ModifiersNode modifiers,
            TypeNode type,
            IdentifierNode name)
    {
        super();
        this.modifiers = modifiers;
        this.type = type;
        this.name = name;
    }

    /**
     * Gets the modifiers of this parameter.
     * @return The modifiers of this parameter.
     */
    public ModifiersNode getModifiers()
    {
        return this.modifiers;
    }

    /**
     * Changes the modifiers of this parameter.
     * @param modifiers The modifiers of this parameter.
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
     * Gets the type of the parameter.
     * @return The type of the parameter.
     */
    public TypeNode getType()
    {
        return this.type;
    }

    /**
     * Changes the type of the parameter.
     * @param type The type of the parameter.
     */
    public void setType(TypeNode type)
    {
        if (this.type instanceof NodeImpl)
        {
            ((NodeImpl)this.type).setParent(null);
        }
        this.type = type;
        if (this.type instanceof NodeImpl)
        {
            ((NodeImpl)this.type).setParent(this);
        }
    }

    /**
     * Gets the name of the parameter.
     * @return The name of the parameter.
     */
    public IdentifierNode getName()
    {
        return this.name;
    }

    /**
     * Changes the name of the parameter.
     * @param name The name of the parameter.
     */
    public void setName(IdentifierNode name)
    {
        if (this.name instanceof NodeImpl)
        {
            ((NodeImpl)this.name).setParent(null);
        }
        this.name = name;
        if (this.name instanceof NodeImpl)
        {
            ((NodeImpl)this.name).setParent(this);
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
        this.type.receive(visitor);
        this.name.receive(visitor);
    }
}
