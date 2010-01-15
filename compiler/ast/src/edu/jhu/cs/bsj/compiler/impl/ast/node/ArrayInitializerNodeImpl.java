package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableInitializerNode;

public class ArrayInitializerNodeImpl extends NodeImpl implements ArrayInitializerNode
{
    /** The initializers for the array. */
    private ListNode<VariableInitializerNode> initializers;

    /** General constructor. */
    public ArrayInitializerNodeImpl(
            ListNode<VariableInitializerNode> initializers)
    {
        super();
        this.initializers = initializers;
    }

    /**
     * Gets the initializers for the array.
     * @return The initializers for the array.
     */
    public ListNode<VariableInitializerNode> getInitializers()
    {
        return this.initializers;
    }

    /**
     * Changes the initializers for the array.
     * @param initializers The initializers for the array.
     */
    public void setInitializers(ListNode<VariableInitializerNode> initializers)
    {
        if (this.initializers instanceof NodeImpl)
        {
            ((NodeImpl)this.initializers).setParent(null);
        }
        this.initializers = initializers;
        if (this.initializers instanceof NodeImpl)
        {
            ((NodeImpl)this.initializers).setParent(this);
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
        this.initializers.receive(visitor);
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
        list.add(this.initializers);
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
        sb.append("initializers=");
        sb.append(this.initializers == null? "null" : this.initializers.getClass().getSimpleName());
        return sb.toString();
    }
}
