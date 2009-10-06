package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.FieldDeclarationNode;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.ModifiersNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;

public class FieldDeclarationNodeImpl extends NodeImpl implements FieldDeclarationNode
{
    /** The modifiers for this field. */
    private ModifiersNode modifiers;

    /** The type of this field. */
    private TypeNode type;

    /** The name of this field. */
    private IdentifierNode name;

    /** The initializer to use. */
    private ExpressionNode initializer;

    /** General constructor. */
    public FieldDeclarationNodeImpl(
            ModifiersNode modifiers,
            TypeNode type,
            IdentifierNode name,
            ExpressionNode initializer)
    {
        super();
        this.modifiers = modifiers;
        this.type = type;
        this.name = name;
        this.initializer = initializer;
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
     * Gets the type of this field.
     * @return The type of this field.
     */
    public TypeNode getType()
    {
        return this.type;
    }

    /**
     * Changes the type of this field.
     * @param type The type of this field.
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
     * Gets the name of this field.
     * @return The name of this field.
     */
    public IdentifierNode getName()
    {
        return this.name;
    }

    /**
     * Changes the name of this field.
     * @param name The name of this field.
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
     * Gets the initializer to use.
     * @return The initializer to use.
     */
    public ExpressionNode getInitializer()
    {
        return this.initializer;
    }

    /**
     * Changes the initializer to use.
     * @param initializer The initializer to use.
     */
    public void setInitializer(ExpressionNode initializer)
    {
        if (this.initializer instanceof NodeImpl)
        {
            ((NodeImpl)this.initializer).setParent(null);
        }
        this.initializer = initializer;
        if (this.initializer instanceof NodeImpl)
        {
            ((NodeImpl)this.initializer).setParent(this);
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
        this.initializer.receive(visitor);
    }
}
