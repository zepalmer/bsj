package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableNode;

public class VariableNodeImpl extends NodeImpl implements VariableNode
{
    /** The type of the variable. */
    private TypeNode type;

    /** The name of the variable. */
    private IdentifierNode name;

    /** General constructor. */
    public VariableNodeImpl(
            TypeNode type,
            IdentifierNode name)
    {
        super();
        this.type = type;
        this.name = name;
    }

    /**
     * Gets the type of the variable.
     * @return The type of the variable.
     */
    public TypeNode getType()
    {
        return this.type;
    }

    /**
     * Changes the type of the variable.
     * @param type The type of the variable.
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
     * Gets the name of the variable.
     * @return The name of the variable.
     */
    public IdentifierNode getName()
    {
        return this.name;
    }

    /**
     * Changes the name of the variable.
     * @param name The name of the variable.
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
     * Performs visitation for this node's children.
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveToChildren(BsjNodeVisitor visitor)
    {
        
    }
}
