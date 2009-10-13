package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.ParameterizedTypeNode;
import edu.jhu.cs.bsj.compiler.ast.tags.ParameterizableType;
import edu.jhu.cs.bsj.compiler.ast.tags.TypeArgument;

public class ParameterizedTypeNodeImpl extends TypeNodeImpl implements ParameterizedTypeNode
{
    /** The base to parameterize. */
    private ParameterizableType baseType;

    /** The parameterized type arguments. */
    private ListNode<? extends TypeArgument> typeArguments;

    /** General constructor. */
    public ParameterizedTypeNodeImpl(
            ParameterizableType baseType,
            ListNode<? extends TypeArgument> typeArguments)
    {
        super();
        this.baseType = baseType;
        this.typeArguments = typeArguments;
    }

    /**
     * Gets the base to parameterize.
     * @return The base to parameterize.
     */
    public ParameterizableType getBaseType()
    {
        return this.baseType;
    }

    /**
     * Changes the base to parameterize.
     * @param baseType The base to parameterize.
     */
    public void setBaseType(ParameterizableType baseType)
    {
        this.baseType = baseType;
    }

    /**
     * Gets the parameterized type arguments.
     * @return The parameterized type arguments.
     */
    public ListNode<? extends TypeArgument> getTypeArguments()
    {
        return this.typeArguments;
    }

    /**
     * Changes the parameterized type arguments.
     * @param typeArguments The parameterized type arguments.
     */
    public void setTypeArguments(ListNode<? extends TypeArgument> typeArguments)
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
        this.typeArguments.receive(visitor);
    }
}
