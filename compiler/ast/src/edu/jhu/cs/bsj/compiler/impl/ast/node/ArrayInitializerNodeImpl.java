package edu.jhu.cs.bsj.compiler.impl.ast.node;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableInitializerNode;

public class ArrayInitializerNodeImpl extends NodeImpl implements ArrayInitializerNode
{
    /** The initializers for the array. */
    private ListNode<? extends VariableInitializerNode> initializers;

    /** General constructor. */
    public ArrayInitializerNodeImpl(
            ListNode<? extends VariableInitializerNode> initializers)
    {
        super();
        this.initializers = initializers;
    }

    /**
     * Gets the initializers for the array.
     * @return The initializers for the array.
     */
    public ListNode<? extends VariableInitializerNode> getInitializers()
    {
        return this.initializers;
    }

    /**
     * Changes the initializers for the array.
     * @param initializers The initializers for the array.
     */
    public void setInitializers(ListNode<? extends VariableInitializerNode> initializers)
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
}
