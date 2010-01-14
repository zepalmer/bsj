package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.RawTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeArgumentNode;

public class ParameterizedTypeNodeImpl extends NodeImpl implements ParameterizedTypeNode
{
    /** The raw type being parameterized. */
    private RawTypeNode rawType;

    /** The type arguments for this node. */
    private ListNode<TypeArgumentNode> typeArguments;

    /** General constructor. */
    public ParameterizedTypeNodeImpl(
            RawTypeNode rawType,
            ListNode<TypeArgumentNode> typeArguments)
    {
        super();
        this.rawType = rawType;
        this.typeArguments = typeArguments;
    }

    /**
     * Gets the raw type being parameterized.
     * @return The raw type being parameterized.
     */
    public RawTypeNode getRawType()
    {
        return this.rawType;
    }

    /**
     * Changes the raw type being parameterized.
     * @param rawType The raw type being parameterized.
     */
    public void setRawType(RawTypeNode rawType)
    {
        if (this.rawType instanceof NodeImpl)
        {
            ((NodeImpl)this.rawType).setParent(null);
        }
        this.rawType = rawType;
        if (this.rawType instanceof NodeImpl)
        {
            ((NodeImpl)this.rawType).setParent(this);
        }
    }

    /**
     * Gets the type arguments for this node.
     * @return The type arguments for this node.
     */
    public ListNode<TypeArgumentNode> getTypeArguments()
    {
        return this.typeArguments;
    }

    /**
     * Changes the type arguments for this node.
     * @param typeArguments The type arguments for this node.
     */
    public void setTypeArguments(ListNode<TypeArgumentNode> typeArguments)
    {
        if (this.typeArguments instanceof NodeImpl)
        {
            ((NodeImpl)this.typeArguments).setParent(null);
        }
        this.typeArguments = typeArguments;
        if (this.typeArguments instanceof NodeImpl)
        {
            ((NodeImpl)this.typeArguments).setParent(this);
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
        this.rawType.receive(visitor);
        this.typeArguments.receive(visitor);
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
        list.add(this.rawType);
        list.add(this.typeArguments);
        return list;
    }
}
