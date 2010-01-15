package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.IdentifierNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableDeclaratorNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableInitializerNode;

public class VariableDeclaratorNodeImpl extends NodeImpl implements VariableDeclaratorNode
{
    /** The type of this variable. */
    private TypeNode type;

    /** The name of this variable. */
    private IdentifierNode name;

    /** The initializer to use. */
    private VariableInitializerNode initializer;

    /** General constructor. */
    public VariableDeclaratorNodeImpl(
            TypeNode type,
            IdentifierNode name,
            VariableInitializerNode initializer)
    {
        super();
        this.type = type;
        this.name = name;
        this.initializer = initializer;
    }

    /**
     * Gets the type of this variable.
     * @return The type of this variable.
     */
    public TypeNode getType()
    {
        return this.type;
    }

    /**
     * Changes the type of this variable.
     * @param type The type of this variable.
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
     * Gets the name of this variable.
     * @return The name of this variable.
     */
    public IdentifierNode getName()
    {
        return this.name;
    }

    /**
     * Changes the name of this variable.
     * @param name The name of this variable.
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
    public VariableInitializerNode getInitializer()
    {
        return this.initializer;
    }

    /**
     * Changes the initializer to use.
     * @param initializer The initializer to use.
     */
    public void setInitializer(VariableInitializerNode initializer)
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
        this.type.receive(visitor);
        this.name.receive(visitor);
        this.initializer.receive(visitor);
    }

    /**
     * Produces a mutable list of this node's children.  Modifying this list will have no
     * effect on this node.
     * @return A list of this node's children.
     */
    @Override
    public List<Object> getChildObjects()
    {
        List<Object> list = super.getChildObjects();
        list.add(this.type);
        list.add(this.name);
        list.add(this.initializer);
        return list;
    }

    /**
     * Obtains a human-readable description of this node.
     * @return A human-readable description of this node.
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getClass().getSimpleName());
        sb.append('[');
        sb.append("type=");
        sb.append(this.type == null? "null" : this.type.getClass().getSimpleName());
        sb.append(',');
        sb.append("name=");
        sb.append(this.name == null? "null" : this.name.getClass().getSimpleName());
        sb.append(',');
        sb.append("initializer=");
        sb.append(this.initializer == null? "null" : this.initializer.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
