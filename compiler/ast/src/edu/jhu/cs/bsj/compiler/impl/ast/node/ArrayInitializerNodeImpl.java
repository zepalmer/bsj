package edu.jhu.cs.bsj.compiler.impl.ast.node;

import java.util.List;

import javax.annotation.Generated;

import edu.jhu.cs.bsj.compiler.ast.BsjNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.BsjTypedNodeVisitor;
import edu.jhu.cs.bsj.compiler.ast.node.ArrayInitializerNode;
import edu.jhu.cs.bsj.compiler.ast.node.ListNode;
import edu.jhu.cs.bsj.compiler.ast.node.VariableInitializerNode;

@Generated(value={"edu.jhu.cs.bsj.compiler.utils.SourceGenerator"})
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
     * Handles the visitation of this node's children for the provided typed visitor.  Each
     * subclass should override this method, having the subclass implementation call this
     * method first and then visit its subclass-specific children.
     *
     * @param visitor The visitor to visit this node's children.
     */
    @Override
    protected void receiveTypedToChildren(BsjTypedNodeVisitor visitor)
    {
        super.receiveTypedToChildren(visitor);
        this.initializers.receiveTyped(visitor);
    }

    @Override
    public void receiveTyped(BsjTypedNodeVisitor visitor)
    {
        visitor.visitStartBegin(this);
        visitor.visitArrayInitializerNodeStart(this, true);
        visitor.visitNodeStart(this);
        visitor.visitVariableInitializerNodeStart(this);
        visitor.visitStartEnd(this);
        receiveTypedToChildren(visitor);
        visitor.visitStopBegin(this);
        visitor.visitVariableInitializerNodeStop(this);
        visitor.visitNodeStart(this);
        visitor.visitArrayInitializerNodeStart(this, true);
        visitor.visitStopEnd(this);
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
        sb.append(']');
        return sb.toString();
    }
}
