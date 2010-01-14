package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.TypeArgumentNode;
import edu.jhu.cs.bsj.compiler.ast.node.UnparameterizedTypeNode;

public class ParameterizedTypeNodeImpl extends NodeImpl implements ParameterizedTypeNode
{
    /** The base type being parameterized. */
    private UnparameterizedTypeNode baseType;

    /** The type arguments for this node. */
    private ListNode<TypeArgumentNode> typeArguments;

    /** General constructor. */
    public ParameterizedTypeNodeImpl(
            UnparameterizedTypeNode baseType,
            ListNode<TypeArgumentNode> typeArguments)
    {
        super();
        this.baseType = baseType;
        this.typeArguments = typeArguments;
    }

    /**
     * Gets the base type being parameterized.
     * @return The base type being parameterized.
     */
    public UnparameterizedTypeNode getBaseType()
    {
        return this.baseType;
    }

    /**
     * Changes the base type being parameterized.
     * @param baseType The base type being parameterized.
     */
    public void setBaseType(UnparameterizedTypeNode baseType)
    {
        if (this.baseType instanceof NodeImpl)
        {
            ((NodeImpl)this.baseType).setParent(null);
        }
        this.baseType = baseType;
        if (this.baseType instanceof NodeImpl)
        {
            ((NodeImpl)this.baseType).setParent(this);
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
        this.baseType.receive(visitor);
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
        list.add(this.baseType);
        list.add(this.typeArguments);
        return list;
    }
}
