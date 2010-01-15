package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInstantiatorCreationNode;
import edu.jhu.cs.bsj.compiler.ast.node.BaseTypeNode;
import edu.jhu.cs.bsj.compiler.ast.node.ExpressionNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;

public class ArrayInstantiatorCreationNodeImpl extends ArrayCreationNodeImpl implements ArrayInstantiatorCreationNode
{
    /** The dimension expressions for this array. */
    private ListNode<ExpressionNode> dimExpressions;

    /** General constructor. */
    public ArrayInstantiatorCreationNodeImpl(
            ListNode<ExpressionNode> dimExpressions,
            BaseTypeNode baseType,
            int arrayLevels)
    {
        super(baseType, arrayLevels);
        this.dimExpressions = dimExpressions;
    }

    /**
     * Gets the dimension expressions for this array.
     * @return The dimension expressions for this array.
     */
    public ListNode<ExpressionNode> getDimExpressions()
    {
        return this.dimExpressions;
    }

    /**
     * Changes the dimension expressions for this array.
     * @param dimExpressions The dimension expressions for this array.
     */
    public void setDimExpressions(ListNode<ExpressionNode> dimExpressions)
    {
        if (this.dimExpressions instanceof NodeImpl)
        {
            ((NodeImpl)this.dimExpressions).setParent(null);
        }
        this.dimExpressions = dimExpressions;
        if (this.dimExpressions instanceof NodeImpl)
        {
            ((NodeImpl)this.dimExpressions).setParent(this);
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
        this.dimExpressions.receive(visitor);
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
        list.add(this.dimExpressions);
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
        sb.append("dimExpressions=");
        sb.append(this.dimExpressions == null? "null" : this.dimExpressions.getClass().getSimpleName());
        sb.append(']');
        return sb.toString();
    }
}
